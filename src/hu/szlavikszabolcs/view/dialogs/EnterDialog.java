package hu.szlavikszabolcs.view.dialogs;

import hu.szlavikszabolcs.view.PlantBreedingGUI;
import org.apache.commons.codec.digest.DigestUtils;
import hu.szlavikszabolcs.view.bean.Labels;
import hu.szlavikszabolcs.view.bean.Salt;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnterDialog extends JDialog implements ActionListener {
    private String passwordCode;
    private String title;
    private char[] password;
    GridLayout grid1 = new GridLayout(2,1);
    JPanel pane1 = new JPanel();
    JPanel pane2 = new JPanel();
    GridLayout grid = new GridLayout(1,2,20,20);
    JPasswordField inputPassword = new JPasswordField(10);
    JButton okButton = new JButton("OK");
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();


    public EnterDialog(String passwordCode, String title){
        this.passwordCode = passwordCode;
        this.title = title;
        setLayout(grid1);
        setTitle(title);
        pane1.setLayout(grid);
        pane1.add(new JLabel(Labels.passWord));
        pane1.add(inputPassword);
        add(pane1);
        pane2.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane2.add(okButton);
        okButton.addActionListener(this);
        add(pane2);
        this.setModal(true);

        setIconImage(PlantBreedingGUI.getIcon());
        pack();
        setLocation((dim.width/2 - this.getWidth()/2),(dim.height/2 - this.getHeight()/2));
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }

    public Insets getInsets(){
        return new Insets(40,10,20,10);
    }

    //get the salt for password from the shifted bytes

    public static String getSalt(){
        byte[] codedArray;
        String string = null;
        Salt codes = new Salt();

        codedArray = codes.getBytes();
        byte[] newArray = new byte[codedArray.length];

        for (int i = 0; i < codedArray.length; i++) {
            newArray[i] = (byte) (codedArray[i]^codes.getByteShift()[0]);
        }

        string = new String(newArray);

        return string;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "OK"){

            password = (inputPassword.getPassword());
            String passwordString = new String(password);

            //System.out.println("Password length: " + password.length);

            if (password.length != 0){

                String hashPassword = DigestUtils.sha256Hex(getSalt()+passwordString);
                //System.out.println("Titkosított jelszó: " + hashPassword);

                if (hashPassword.equals(passwordCode)){
                    setVisible(false);
                } else {
                  JOptionPane.showMessageDialog(this,Labels.loginError,Labels.failToPass,JOptionPane.ERROR_MESSAGE);
                  System.exit(0);
                }

            } else {
                JOptionPane.showMessageDialog(this,Labels.emptyField,Labels.failToPass,JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }


        }
    }


}

package hu.szlavikszabolcs.view.dialogs;

import hu.szlavikszabolcs.view.MenuPoints;
import hu.szlavikszabolcs.view.PlantBreedingGUI;
import org.apache.commons.codec.digest.DigestUtils;
import hu.szlavikszabolcs.view.bean.Labels;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ConfigDialog extends JDialog implements ActionListener {
    private String passWord;
    private String dataBaseLink;
    private String dataBaseUser;
    private String dataBasePassword;
    private char[] pwChars;

    JPanel jPanel1 = new JPanel();
    JPasswordField passWordTextField = new JPasswordField(15);
    JTextField dataBaseLinkTextField = new JTextField(20);

    JTextField dataBaseUserTextField = new JTextField(15);
    JTextField dataBasePassWordTextField = new JTextField(15);


    JPanel jPanel2 = new JPanel();

    GridLayout gridPanel1 = new GridLayout(6, 2,20,20);
    JButton saveButton = new JButton(Labels.saveConfig);
    JButton cancelButton = new JButton(Labels.cancel);
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    JLabel userEnt = new JLabel(Labels.userEntrance);
    JLabel dataBaseDetails = new JLabel(Labels.databaseDetails);


    public ConfigDialog(){
        setTitle(Labels.configDialogTitle);
        setLayout(new BorderLayout());

        jPanel1.setLayout(gridPanel1);
        jPanel1.setBorder(BorderFactory.createEtchedBorder());
        userEnt.setFont(new Font("Verdana",Font.PLAIN,16));
        jPanel1.add(userEnt);
        jPanel1.add(new JLabel(""));

        jPanel1.add(new JLabel(Labels.passWord));
        jPanel1.add(passWordTextField);
        dataBaseDetails.setFont(new Font("Verdana",Font.PLAIN,16));
        jPanel1.add(dataBaseDetails);
        jPanel1.add(new JLabel(""));
        jPanel1.add(new JLabel(Labels.databaseLink));
        dataBaseLinkTextField.setText(PlantBreedingGUI.getDatabaseLink());
        jPanel1.add(dataBaseLinkTextField);

        jPanel1.add(new JLabel(Labels.databaseUser));
        dataBaseUserTextField.setText(PlantBreedingGUI.getDatabaseUser());
        jPanel1.add(dataBaseUserTextField);

        jPanel1.add(new JLabel(Labels.databasePassWord));
        dataBasePassWordTextField.setText(PlantBreedingGUI.getDataBasePassword());
        jPanel1.add(dataBasePassWordTextField);

        add(jPanel1,BorderLayout.CENTER);

        saveButton.addActionListener(this);
        cancelButton.addActionListener(this);
        jPanel2.add(saveButton);
        jPanel2.add(cancelButton);

        add(jPanel2,BorderLayout.PAGE_END);

        setIconImage(PlantBreedingGUI.getIcon());

        setModal(true);

        pack();
        setLocation((dim.width/2 - this.getWidth()/2),(dim.height/2 - this.getHeight()/2));
        setVisible(true);
    }


    public Insets getInsets(){
        return new Insets(40,40,40,40);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton){

            pwChars = passWordTextField.getPassword();
            passWord = new String(pwChars);
            dataBaseLink = dataBaseLinkTextField.getText();

            dataBaseUser = dataBaseUserTextField.getText();

            dataBasePassword = dataBasePassWordTextField.getText();

            //System.out.println("Password length: " + password.length);
            // before test - We have asked database password. We have to allow empty password, if there is no password
            //if (!passWord.isEmpty() && !dataBaseLink.isEmpty() && !dataBaseUser.isEmpty() && !dataBasePassword.isEmpty()){

            //after test:
            if (!passWord.isEmpty() && !dataBaseLink.isEmpty() && !dataBaseUser.isEmpty()){

                String hashPassword = DigestUtils.sha256Hex(EnterDialog.getSalt()+passWord);

                try {

                    PrintWriter printWriter = new PrintWriter(new File("config.hex"));
                    printWriter.println(hashPassword);
                    printWriter.println(dataBaseLink);
                    printWriter.println(dataBaseUser);
                    if (!dataBasePassword.isEmpty()){
                        printWriter.println(dataBasePassword);
                    } else {
                        //if the database password field is empty, write new line in the file
                        printWriter.print('\n');
                    }
                    printWriter.close();
                    PlantBreedingGUI.setDatabaseLink(dataBaseLink);
                    PlantBreedingGUI.setDatabaseUser(dataBaseUser);
                    PlantBreedingGUI.setDataBasePassword(dataBasePassword);

                } catch (FileNotFoundException exception){
                    JOptionPane.showMessageDialog(this, Labels.configFileNotFound + "\n" + exception.getMessage(),Labels.error,JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(this,Labels.emptyConfigFields,Labels.warning,JOptionPane.WARNING_MESSAGE);
                //System.exit(0); before test

                //after test - clear the variables for the next try
                passWord = "";
                dataBaseLink = "";
                dataBaseUser = "";
                dataBasePassword = "";
                return;//let's allow the user to fill the fields
            }
            this.setVisible(false);
        }

        if (e.getSource() == cancelButton){
            this.setVisible(false);
        }

    }


}

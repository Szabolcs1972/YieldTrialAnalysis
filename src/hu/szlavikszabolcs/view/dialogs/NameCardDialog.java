package hu.szlavikszabolcs.view.dialogs;

import hu.szlavikszabolcs.view.PlantBreedingGUI;
import hu.szlavikszabolcs.view.bean.Labels;
import org.apache.commons.codec.digest.DigestUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;

public class NameCardDialog extends JDialog implements ActionListener, MouseListener {

    JLabel mail = new JLabel(Labels.mail,JLabel.CENTER);
    JLabel urlSzabolcs = new JLabel(Labels.urlSzabolcs,JLabel.CENTER);
    JLabel urlWebler = new JLabel(Labels.urlWebler,JLabel.CENTER);
    Desktop desktop = null;
    URI uriMailTo = null;
    URI uri = null;
    Cursor hand = new Cursor(12);

    JPanel jPanel1 = new JPanel();
    GridLayout gridPanel1 = new GridLayout(6, 1,10,10);
    GridLayout gridPanel2 = new GridLayout(3, 1,10,10);


    JPanel jPanel2 = new JPanel();
    JPanel jPanel3 = new JPanel();


    JButton okButton = new JButton(Labels.ok);

    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();



    public NameCardDialog(){
        setTitle(Labels.menuItem7);
        setLayout(new BorderLayout());

        jPanel1.setLayout(gridPanel1);
        jPanel1.setBorder(BorderFactory.createEtchedBorder());

        jPanel1.add(new JLabel(Labels.aboutOKJ,JLabel.CENTER));
        jPanel1.add(new JLabel(Labels.aboutSzabolcs,JLabel.CENTER));
        mail.setForeground(Color.BLUE);
        mail.addMouseListener(this);
        jPanel1.add(mail);

        jPanel1.add(new JLabel(Labels.aboutSzeged,JLabel.CENTER));

        urlSzabolcs.setForeground(Color.BLUE);
        urlSzabolcs.addMouseListener(this);
        jPanel1.add(urlSzabolcs);

        jPanel1.add(new JLabel(Labels.spacer,JLabel.CENTER));

        jPanel2.setLayout(gridPanel2);
        jPanel2.setBorder(BorderFactory.createEtchedBorder());

        jPanel2.add(new JLabel(Labels.aboutWebler,JLabel.CENTER));


        urlWebler.setForeground(Color.BLUE);
        urlWebler.addMouseListener(this);

        jPanel2.add(urlWebler);
        jPanel2.add(new JLabel(Labels.spacer,JLabel.CENTER));


        add(jPanel1,BorderLayout.NORTH);
        add(jPanel2,BorderLayout.CENTER);

        okButton.addActionListener(this);

        jPanel3.add(okButton);

        add(jPanel3,BorderLayout.PAGE_END);

        setIconImage(PlantBreedingGUI.getIcon());
        setVisible(true);

        pack();
        setLocation((dim.width/2 - this.getWidth()/2),(dim.height/2 - this.getHeight()/2));
        setVisible(true);
    }


    public Insets getInsets(){
        return new Insets(40,40,40,40);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okButton){

            this.setVisible(false);
        }

    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == mail){
            if (Desktop.isDesktopSupported()) desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.MAIL)) {

                try {

                    uriMailTo = new URI("mailto", "szabolcsszlavik@gmail.com", null);
                    desktop.mail(uriMailTo);

                } catch (IOException ioe) {
                    ioe.printStackTrace();
                } catch (URISyntaxException use) {
                    use.printStackTrace();
                }
            }
        }

        if (e.getSource() == urlSzabolcs){
            if (Desktop.isDesktopSupported()) desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.BROWSE)) {

                try {

                    uri = new URI(Labels.urlSzabolcs);
                    desktop.browse(uri);

                } catch (IOException ioe) {
                    ioe.printStackTrace();
                } catch (URISyntaxException use) {
                    use.printStackTrace();
                }
            }
        }

        if (e.getSource() == urlWebler){
            if (Desktop.isDesktopSupported()) desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.BROWSE)) {

                try {

                    uri = new URI(Labels.urlWebler);
                    desktop.browse(uri);

                } catch (IOException ioe) {
                    ioe.printStackTrace();
                } catch (URISyntaxException use) {
                    use.printStackTrace();
                }
            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        mail.setCursor(hand);
        urlSzabolcs.setCursor(hand);
        urlSzabolcs.setText(Labels.urlSzabolcsUnderLine);
        urlWebler.setCursor(hand);
        urlWebler.setText(Labels.urlWeblerUnderLine);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        urlSzabolcs.setText(Labels.urlSzabolcs);
        urlWebler.setText(Labels.urlWebler);
    }
}

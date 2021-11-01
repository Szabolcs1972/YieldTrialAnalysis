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
    JLabel urlCC0 = new JLabel(Labels.urlCC0,JLabel.CENTER);
    JLabel urlPOI = new JLabel(Labels.urlPOI,JLabel.CENTER);
    JLabel urlFOSS = new JLabel(Labels.urlFOSS,JLabel.CENTER);
    JLabel urlGPL = new JLabel(Labels.urlGPL,JLabel.CENTER);
    JLabel urlBSD3 = new JLabel(Labels.urlBSD3,JLabel.CENTER);
    JLabel urlMIT = new JLabel(Labels.urlMIT,JLabel.CENTER);
    Desktop desktop = null;
    URI uriMailTo = null;
    URI uri = null;
    Cursor hand = new Cursor(12);

    JPanel jPanel1 = new JPanel();
    GridLayout gridPanel1 = new GridLayout(17, 1,10,10);
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

        jPanel1.add(new JLabel(Labels.aboutCC0,JLabel.CENTER));

        urlCC0.setForeground(Color.BLUE);
        urlCC0.addMouseListener(this);
        jPanel1.add(urlCC0);

        //2
        jPanel1.add(new JLabel(Labels.aboutPOI,JLabel.CENTER));

        urlPOI.setForeground(Color.BLUE);
        urlPOI.addMouseListener(this);
        jPanel1.add(urlPOI);

        //3
        jPanel1.add(new JLabel(Labels.aboutMySQLConnector,JLabel.CENTER));

        urlFOSS.setForeground(Color.BLUE);
        urlFOSS.addMouseListener(this);
        jPanel1.add(urlFOSS);

        urlGPL.setForeground(Color.BLUE);
        urlGPL.addMouseListener(this);
        jPanel1.add(urlGPL);

        //4
        jPanel1.add(new JLabel(Labels.aboutLaunch4j,JLabel.CENTER));

        urlBSD3.setForeground(Color.BLUE);
        urlBSD3.addMouseListener(this);
        jPanel1.add(urlBSD3);

        urlMIT.setForeground(Color.BLUE);
        urlMIT.addMouseListener(this);
        jPanel1.add(urlMIT);


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
                    JOptionPane.showMessageDialog(this, Labels.IOError,Labels.error, JOptionPane.ERROR_MESSAGE);
                } catch (URISyntaxException use) {
                    JOptionPane.showMessageDialog(this, Labels.urlSyntaxError,Labels.error, JOptionPane.ERROR_MESSAGE);
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
                    JOptionPane.showMessageDialog(this, Labels.IOError,Labels.error, JOptionPane.ERROR_MESSAGE);
                } catch (URISyntaxException use) {
                    JOptionPane.showMessageDialog(this, Labels.urlSyntaxError,Labels.error, JOptionPane.ERROR_MESSAGE);
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
                    JOptionPane.showMessageDialog(this, Labels.IOError,Labels.error, JOptionPane.ERROR_MESSAGE);
                } catch (URISyntaxException use) {
                    JOptionPane.showMessageDialog(this, Labels.urlSyntaxError,Labels.error, JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (e.getSource() == urlCC0){
            if (Desktop.isDesktopSupported()) desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.BROWSE)) {

                try {

                    uri = new URI(Labels.urlCC0);
                    desktop.browse(uri);

                } catch (IOException ioe) {
                    JOptionPane.showMessageDialog(this, Labels.IOError,Labels.error, JOptionPane.ERROR_MESSAGE);
                } catch (URISyntaxException use) {
                    JOptionPane.showMessageDialog(this, Labels.urlSyntaxError,Labels.error, JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        if (e.getSource() == urlPOI){
            if (Desktop.isDesktopSupported()) desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.BROWSE)) {

                try {

                    uri = new URI(Labels.urlPOI);
                    desktop.browse(uri);

                } catch (IOException ioe) {
                    JOptionPane.showMessageDialog(this, Labels.IOError,Labels.error, JOptionPane.ERROR_MESSAGE);
                } catch (URISyntaxException use) {
                    JOptionPane.showMessageDialog(this, Labels.urlSyntaxError,Labels.error, JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        if (e.getSource() == urlFOSS){
            if (Desktop.isDesktopSupported()) desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.BROWSE)) {

                try {

                    uri = new URI(Labels.urlFOSS);
                    desktop.browse(uri);

                } catch (IOException ioe) {
                    JOptionPane.showMessageDialog(this, Labels.IOError,Labels.error, JOptionPane.ERROR_MESSAGE);
                } catch (URISyntaxException use) {
                    JOptionPane.showMessageDialog(this, Labels.urlSyntaxError,Labels.error, JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        if (e.getSource() == urlGPL){
            if (Desktop.isDesktopSupported()) desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.BROWSE)) {

                try {

                    uri = new URI(Labels.urlGPL);
                    desktop.browse(uri);

                } catch (IOException ioe) {
                    JOptionPane.showMessageDialog(this, Labels.IOError,Labels.error, JOptionPane.ERROR_MESSAGE);
                } catch (URISyntaxException use) {
                    JOptionPane.showMessageDialog(this, Labels.urlSyntaxError,Labels.error, JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        if (e.getSource() == urlBSD3){
            if (Desktop.isDesktopSupported()) desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.BROWSE)) {

                try {

                    uri = new URI(Labels.urlBSD3);
                    desktop.browse(uri);

                } catch (IOException ioe) {
                    JOptionPane.showMessageDialog(this, Labels.IOError,Labels.error, JOptionPane.ERROR_MESSAGE);
                } catch (URISyntaxException use) {
                    JOptionPane.showMessageDialog(this, Labels.urlSyntaxError,Labels.error, JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        if (e.getSource() == urlMIT){
            if (Desktop.isDesktopSupported()) desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.BROWSE)) {

                try {

                    uri = new URI(Labels.urlMIT);
                    desktop.browse(uri);

                } catch (IOException ioe) {
                    JOptionPane.showMessageDialog(this, Labels.IOError,Labels.error, JOptionPane.ERROR_MESSAGE);
                } catch (URISyntaxException use) {
                    JOptionPane.showMessageDialog(this, Labels.urlSyntaxError,Labels.error, JOptionPane.ERROR_MESSAGE);
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

        urlCC0.setCursor(hand);

        urlPOI.setCursor(hand);

        urlFOSS.setCursor(hand);

        urlGPL.setCursor(hand);

        urlBSD3.setCursor(hand);

        urlMIT.setCursor(hand);

    }

    @Override
    public void mouseExited(MouseEvent e) {
        urlSzabolcs.setText(Labels.urlSzabolcs);
        urlWebler.setText(Labels.urlWebler);
    }
}

package hu.szlavikszabolcs.view;

import hu.szlavikszabolcs.controller.PlantBreedingController;
import hu.szlavikszabolcs.view.bean.Labels;
import hu.szlavikszabolcs.view.dialogs.EnterDialog;
import hu.szlavikszabolcs.view.panels.InformationPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class PlantBreedingGUI extends JFrame {
    private JFrame window;
    public PlantBreedingController controller;
    public MenuPoints mp;
    private static String userNamePassword;
    private static String databaseLink;
    private static String databaseUser;
    private static String dataBasePassword;
    private static Image icon;

    public PlantBreedingGUI(PlantBreedingController controller){
        this.controller = controller;
        mp = new MenuPoints(this);
    }

    public void startGUI(){

        javax.swing.SwingUtilities.invokeLater(this::createAndShowGUI);

    }

    public void createAndShowGUI(){
        try {
            Scanner scanner = new Scanner(new File("config.hex"));
            while(scanner.hasNextLine()){
                userNamePassword = scanner.nextLine();
                //System.out.println("Username pw = " + userNamePassword);
                databaseLink = scanner.nextLine();
                //System.out.println("Database link : " + databaseLink);
                databaseUser = scanner.nextLine();
                //System.out.println("Database User = " + databaseUser);
                dataBasePassword = scanner.nextLine();
                //System.out.println("Database password = " + dataBasePassword);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, Labels.configFileNotFound + "\n" + e.getMessage(),Labels.error,JOptionPane.ERROR_MESSAGE);
        }
        //set icon for the JFrame
        //source of code: https://www.tabnine.com/code/java/methods/javax.swing.JFrame/setIconImage
        try {
            icon = ImageIO.read(new File("harvester.gif"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, Labels.noImageIcon + "\n" + e.getMessage(),Labels.error,JOptionPane.ERROR_MESSAGE);
        }
        EnterDialog enterDialog = new EnterDialog(userNamePassword, Labels.enter);
        window = new JFrame("Yield Trial Analysis");

        //get the size of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        //put the frame in the middle of the screen
        window.setLocation((dim.width/2-this.getSize().width/2)-400, (dim.height/2-this.getSize().height/2)-300);

        window.setSize(800,600);//in case somebody is using old monitor
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);

        window.setIconImage(icon);
        window.setJMenuBar(mp);
        window.setContentPane(new InformationPanel());
        window.setVisible(true);

    }

    public void setActualContent(Container container){

        window.setContentPane(container);
        window.setVisible(true);

    }

    public JFrame getWindow() {
        return window;
    }

    public PlantBreedingController getController() {
        return controller;
    }

    public static String getDatabaseLink() {
        return databaseLink;
    }

    public static String getDatabaseUser() {
        return databaseUser;
    }

    public static String getDataBasePassword() {
        return dataBasePassword;
    }

    public static Image getIcon() {
        return icon;
    }

    public static void setDatabaseLink(String databaseLink) {
        PlantBreedingGUI.databaseLink = databaseLink;
    }

    public static void setDatabaseUser(String databaseUser) {
        PlantBreedingGUI.databaseUser = databaseUser;
    }

    public static void setDataBasePassword(String dataBasePassword) {
        PlantBreedingGUI.dataBasePassword = dataBasePassword;
    }

}

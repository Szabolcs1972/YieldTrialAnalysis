package hu.szlavikszabolcs.model;

import hu.szlavikszabolcs.view.bean.Labels;
import hu.szlavikszabolcs.view.PlantBreedingGUI;
import hu.szlavikszabolcs.view.bean.RawData;
import hu.szlavikszabolcs.view.bean.Salt;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlantBreedingDAOImpl implements PlantBreedingDAO {
    private PlantBreedingGUI gui;
    List<RawData> rawDataList = new ArrayList<>();
    List<RawData> showDataList = new ArrayList<>();
    Salt codes = new Salt();

    //private static final String DATABASE_FILE_SQLITE = "jdbc:sqlite://home//szlavik//Letöltések//sqlite//sqlite-tools-linux-x86-3360000//NovenyFajta.db";
    //private static final String DATABASE_FILE_MySQL_URL = PlantBreedingGUI.getDatabaseLink();
    private static final String DATABASE_QUERY = "SELECT * FROM `datapoints`;";
    private static final String ADD_NEW_DATAPOINT = "INSERT INTO `datapoints` (plotNumber,entryNumber,standard,name,repNumber,plotWeight,moisture,yield,year,locations) VALUES (?,?,?,?,?,?,?,?,?,?);";
    int countAffectedRows = 0;

    @Override
    public String addDataPoint(List<RawData> computedData) {

        String messageBack = "false";

        Connection conn = null;
        PreparedStatement pst = null;


        try {
            //Class.forName("org.sqlite.JDBC");
            //Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(PlantBreedingGUI.getDatabaseLink(),PlantBreedingGUI.getDatabaseUser(), PlantBreedingGUI.getDataBasePassword());

            for (RawData rawData: computedData) {


            pst = conn.prepareStatement(ADD_NEW_DATAPOINT);

            pst.setDouble(1, rawData.getPlot_Number());
            pst.setDouble(2, rawData.getEntry_Number());
            pst.setBoolean(3, rawData.isStandard());
            pst.setString(4, rawData.getName());
            pst.setDouble(5, rawData.getRep_Number());
            pst.setDouble(6, rawData.getPlotWeight());
            pst.setDouble(7, rawData.getMoisture());
            pst.setDouble(8, rawData.getYield());
            pst.setDouble(9, rawData.getYear());
            pst.setString(10, rawData.getLocation());


            // eltároljuk
            int affectedRows = pst.executeUpdate();
            //System.out.println("AffectedRow = " + affectedRows);
            if (affectedRows == 1) {
                countAffectedRows++;
            }
            }
            if (countAffectedRows == computedData.size()){
                messageBack = "true";
            }
            conn.close();
        } catch (SQLException throwables) {

            messageBack = Labels.error + "\n" + throwables.getMessage();
            //System.out.println("SQL error!" + throwables.getMessage());
        }

        return messageBack;
    }

    @Override
    public List<RawData> getDataPoint() {

        Connection conn = null;
        Statement st = null;
        this.rawDataList.clear();

        try {
            //Class.forName("org.sqlite.JDBC");
            //Class.forName("com.mysql.jdbc.Driver");
            //System.out.println(PlantBreedingGUI.getDatabaseLink() + " " + PlantBreedingGUI.getDatabaseUser() + " " + PlantBreedingGUI.getDataBasePassword());

            conn = DriverManager.getConnection(PlantBreedingGUI.getDatabaseLink(),PlantBreedingGUI.getDatabaseUser(),PlantBreedingGUI.getDataBasePassword());
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(DATABASE_QUERY);
            //System.out.println("Result set" + rs.toString());
            while(rs.next()) {

                int int1 = rs.getInt("plotNumber");
                int int2 = rs.getInt("entryNumber");
                boolean standard = rs.getBoolean("standard");
                String s = rs.getString("name");
                int int3 = rs.getInt("repNumber");

                Double d1 = rs.getDouble("plotWeight");
                Double d2 = rs.getDouble("moisture");
                Double d3 = rs.getDouble("yield");
                int int4 = rs.getInt("year");
                String s2 = rs.getString("locations");

                RawData rd = new RawData(int1,int2,standard,s,int3,d1,d2,d3,int4,s2);
                this.showDataList.add(rd);
            }
            conn.close();

        } catch (SQLException | NullPointerException throwables) {

            JOptionPane.showMessageDialog(gui,Labels.error + '\n' + throwables.getMessage(),Labels.error,JOptionPane.ERROR_MESSAGE );
            // System.out.println("Error! " + throwables.getMessage());

        }

        return showDataList;
    }

}

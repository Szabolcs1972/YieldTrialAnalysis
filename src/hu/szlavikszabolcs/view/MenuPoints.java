package hu.szlavikszabolcs.view;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.List;

import hu.szlavikszabolcs.view.dialogs.NameCardDialog;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import hu.szlavikszabolcs.view.bean.Labels;
import hu.szlavikszabolcs.view.bean.RawData;
import hu.szlavikszabolcs.view.bean.SummaryStatistics;
import hu.szlavikszabolcs.view.dialogs.ConfigDialog;
import hu.szlavikszabolcs.view.panels.*;
import hu.szlavikszabolcs.view.tablemodels.TableSchemaComputed;
import hu.szlavikszabolcs.view.tablemodels.TableSchemaInputData;
import hu.szlavikszabolcs.view.tablemodels.TableSummaryStatistics;
import sun.util.resources.hu.LocaleNames_hu;

public class MenuPoints extends JMenuBar implements ActionListener {
    private PlantBreedingGUI gui;
    public List<RawData> rawDataList = new ArrayList<>();
    public List<RawData> computedDataList;
    public List<RawData> showDataList = new ArrayList<>();
    JFileChooser jFileChooser;
    FileFilter filter = new FileNameExtensionFilter("Excel .xlsx file", "xlsx");
    File file;
    FileInputStream fis;
    JMenuItem loading = new JMenuItem(Labels.menuItem);
    JMenuItem exit = new JMenuItem(Labels.menuItem2);
    JMenu firstMenu = new JMenu(Labels.menuPoint);
    JMenuItem yieldCalculation = new JMenuItem(Labels.menuItem3);
    static JMenuItem summaryStatistics = new JMenuItem(Labels.menuItem5);
    JMenu secondMenu = new JMenu(Labels.menuPoint2);
    JMenuItem showDatabase = new JMenuItem(Labels.menuItem4);
    JMenu thirdMenu = new JMenu(Labels.menuPoint3);
    JMenuItem about = new JMenuItem(Labels.menuItem7);
    JMenuItem info = new JMenuItem(Labels.menuItem6);
    public static JMenu config = new JMenu(Labels.menuPoint4);
    JMenuItem configMenuItem = new JMenuItem(Labels.menuPoint4);
    JMenu help = new JMenu(Labels.menuPoint5);

    Object[][] content = null;
    int rowNumber = 0;
    int columnNumber = 0;
    String[] columnLabels = new String[9];

    public MenuPoints(PlantBreedingGUI gui) {
        super();
        this.gui = gui;

        firstMenu.add(loading);
        loading.addActionListener(this);
        firstMenu.add(exit);
        exit.addActionListener(this);
        add(firstMenu);

        secondMenu.add(yieldCalculation);
        yieldCalculation.addActionListener(this);
        yieldCalculation.setEnabled(false);
        secondMenu.add(summaryStatistics);
        summaryStatistics.addActionListener(this);
        summaryStatistics.setEnabled(false);
        add(secondMenu);

        thirdMenu.add(showDatabase);
        showDatabase.addActionListener(this);
        add(thirdMenu);

        config.add(configMenuItem);
        configMenuItem.addActionListener(this);
        add(config);

        help.add(info);
        help.add(about);
        info.addActionListener(this);
        about.addActionListener(this);
        add(help);

    }

      //switch on SummaryStatistics menuItem from SaveComputedDataPanel
      public static void setSummaryStatistics(Boolean status) {
        MenuPoints.summaryStatistics.setEnabled(status);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals(Labels.menuItem)) {

            jFileChooser = new JFileChooser();
            jFileChooser.setLocale(Locale.getDefault());
            jFileChooser.setApproveButtonText(Labels.open);
            jFileChooser.setApproveButtonToolTipText(Labels.approveButtonToolTipText);
            jFileChooser.setDialogTitle(Labels.open);

            jFileChooser.addChoosableFileFilter(filter);

            //remove all files option from the list
            jFileChooser.setAcceptAllFileFilterUsed(false);

            int returnVal = jFileChooser.showOpenDialog(gui);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                file = jFileChooser.getSelectedFile();

                //Source: https://www.javatpoint.com/how-to-read-excel-file-in-java
                //How to read Excel file in Java

                // this is for .xls files
                //HSSFWorkbook wb = null;

                // and this one for .xlsx files:
                XSSFWorkbook wb = null;

                try {
                    //obtaining input bytes from a file
                    fis = new FileInputStream(file);
                    //creating workbook instance that refers to .xlsx file
                    wb = new XSSFWorkbook(fis);

                    //creating a Sheet object to retrieve the object
                    XSSFSheet sheet = wb.getSheetAt(0);
                    //evaluating cell type
                    FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();


                    for (Row row : sheet)     //iteration over row using for each loop
                    {
                        if (rowNumber == 0) {
                            for (Cell cell : row)    //iteration over cell using for each loop
                            {
                                columnNumber++;
                            }
                        }
                        rowNumber++;
                    }
                    //System.out.println("Sorokszáma = " + rowNumber);
                    //System.out.println("Oszlopokszáma = " + columnNumber);

                    //if number of columns are not fit in the input file, we give a chance to choose the right file!
                    if (columnNumber == columnLabels.length) {
                        //if number of columns are fit we can create Object[][] to hold the data of the file
                        content = new Object[rowNumber][columnNumber];
                    } else {
                        JOptionPane.showMessageDialog(gui, Labels.columnNumberError, Labels.error, JOptionPane.ERROR_MESSAGE);
                        columnNumber = 0;
                        rowNumber = 0;
                        return;
                    }

                    for (Row row : sheet)     //iteration over row using for each loop
                    {

                        for (Cell cell : row)    //iteration over cell using for each loop
                        {

                            switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {
                                case NUMERIC:   //field that represents numeric cell type
                                    //getting the value of the cell as a number
                                    //System.out.print(cell.getNumericCellValue()+ "\t\t");
                                    //System.out.print(cell.+ "\t\t");
                                    //System.out.println("Cella típus Numeric");
                                    content[cell.getRowIndex()][cell.getColumnIndex()] = cell.getNumericCellValue();
                                    break;
                                case STRING:    //field that represents string cell type
                                    //getting the value of the cell as a string
                                    //System.out.print(cell.getStringCellValue()+ "\t\t");
                                    //System.out.println("Cella típus szöveges");
                                    content[cell.getRowIndex()][cell.getColumnIndex()] = cell.getStringCellValue();
                                    break;
                            }


                        }


                    }

                /*
                //print the content of the file to the terminal if necessary
                for (int i = 0; i < rowNumber; i++) {


                    for (int j = 0; j < columnNumber; j++) {

                        System.out.print(content[i][j] + " | ");

                    }
                    System.out.println();
                }

                 */
                    //check the data structure of the file, the column labels in the first row should be match
                    //the column labels in the firs row should be:

                    columnLabels[0] = "plot";
                    columnLabels[1] = "entry";
                    columnLabels[2] = "check";
                    columnLabels[3] = "name";
                    columnLabels[4] = "replication";
                    columnLabels[5] = "weight";
                    columnLabels[6] = "moisture";
                    columnLabels[7] = "year";
                    columnLabels[8] = "location";

                    //check the column labels of the input file

                    for (int j = 0; j < columnLabels.length; j++) {
                        if (!columnLabels[j].equals((String) content[0][j])) {
                            JOptionPane.showMessageDialog(gui, Labels.columnLabelError, Labels.error, JOptionPane.ERROR_MESSAGE);
                            columnNumber = 0;
                            rowNumber = 0;
                            return;
                        }
                        //print the first row, if you need
                        //System.out.print(content[0][j] + " | ");

                    }

                    //if column labels merged, we can process the data

                    int plot = 0;
                    int entry = 0;
                    int standardIntValue = 0;
                    boolean standard = true;
                    String name = "";
                    int rep = 0;
                    double plotWeight = 0.0;
                    double moisture = 0.0;
                    int year = 0;
                    String location = "";

                    for (int i = 1; i < rowNumber; i++) {

                        //System.out.print(content[i][0] + " | ");
                        //because Excel poi reads doubles we have to convert them to integer, we use wrapper
                        Double wrapper1 = (double) content[i][0];
                        plot = wrapper1.intValue();
                        //System.out.print(content[i][0] + " | ");
                        Double wrapper2 = (double) content[i][1];
                        entry = wrapper2.intValue();
                        //System.out.print(content[i][1] + " | ");
                        Double wrapper3 = (double) content[i][2];
                        if (wrapper3.intValue() == 1 || wrapper3.intValue() == 0) {
                            standardIntValue = wrapper3.intValue();
                            if (standardIntValue == 0) standard = false;
                            if (standardIntValue == 1) standard = true;
                            //System.out.print(standard + " | ");
                        } else {
                            fis.close();
                            JOptionPane.showMessageDialog(gui, Labels.standardValueError, Labels.error, JOptionPane.ERROR_MESSAGE);
                            loading.setEnabled(false);
                            return;
                        }
                        String preload = (String) content[i][3];
                        if (!preload.isEmpty()){
                        name = (String) content[i][3];
                        //System.out.print(content[i][3] + " | ");
                        } else {
                            fis.close();
                            JOptionPane.showMessageDialog(gui, Labels.nameValueError, Labels.error, JOptionPane.ERROR_MESSAGE);
                            loading.setEnabled(false);
                            return;
                        }


                        Double wrapper4 = (double) content[i][4];
                        rep = wrapper4.intValue();
                        //System.out.print(content[i][4] + " | ");
                        if ((double) content[i][5] > 0){
                            plotWeight = (double) content[i][5];
                            //System.out.print(content[i][5] + " | ");
                        }
                        else {
                            fis.close();
                            JOptionPane.showMessageDialog(gui, Labels.plotWeightValueError, Labels.error, JOptionPane.ERROR_MESSAGE);
                            loading.setEnabled(false);
                            return;
                        }
                        if ((double) content[i][6] > 0) {
                            moisture = (double) content[i][6];
                            //System.out.print(content[i][6] + " | ");
                        }
                        else {
                            fis.close();
                            JOptionPane.showMessageDialog(gui, Labels.moistureValueError, Labels.error, JOptionPane.ERROR_MESSAGE);
                            loading.setEnabled(false);
                            return;
                        }
                        Double wrapper5 = (double) content[i][7];
                        year = wrapper5.intValue();
                        //System.out.print(content[i][7] + " | ");
                        location = (String) content[i][8];
                        //System.out.print(content[i][8] + " | ");

                        //System.out.println();
                        RawData r = new RawData(plot, entry, standard,name, rep, plotWeight, moisture, 0, year, location);
                        //System.out.println(r);
                        rawDataList.add(r);
                    }
                    fis.close();


                    JOptionPane.showMessageDialog(gui, Labels.fileDataLoadSuccess, Labels.information, JOptionPane.INFORMATION_MESSAGE);
                    //data has been loaded, switch on yield calculation in the menu
                    yieldCalculation.setEnabled(true);
                    //switch off the menu of data load to avoid confusion
                    loading.setEnabled(false);
                } catch (Exception exception) {
                    try {
                        fis.close();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(gui, ex.getMessage() + '\n' + Labels.IOError, Labels.error, JOptionPane.ERROR_MESSAGE);
                    }
                    JOptionPane.showMessageDialog(gui, exception.getMessage() + '\n' + Labels.fileDataLoadFailure, Labels.error, JOptionPane.ERROR_MESSAGE);
                    loading.setEnabled(false);
                    return;
                }

                gui.setActualContent(new FileOpenPanel(new TableSchemaInputData(rawDataList)));


            }
            //to close JFileChooser, if 'Cancel' button has been selected
            if (returnVal == JFileChooser.CANCEL_OPTION) jFileChooser.setVisible(false);

        }
        if (e.getActionCommand().equals(Labels.menuItem2)) {
            System.exit(0);
        }
        if (e.getActionCommand().equals(Labels.menuItem3)) {


            gui.setActualContent(new GetPlotSizePanel(gui, rawDataList));
            yieldCalculation.setEnabled(false);

        }
        if (e.getActionCommand().equals(Labels.menuItem4)) {

            showDataList.clear();
            showDataList = gui.getController().dao.getDataPoint();
            gui.setActualContent(new ShowDatabase(new TableSchemaComputed(showDataList)));

        }
        if (e.getActionCommand().equals(Labels.menuItem5)) {

                computedDataList = GetPlotSizePanel.getComputedDataList();
                if (!computedDataList.isEmpty()) {
                Map<Double,String> averages = new TreeMap<>(Comparator.reverseOrder());
                Map<String,Double> deviation = new TreeMap<>();
                Map<String,Integer> repetitions = new TreeMap<>();
                Map<String,Double> coefficientOfVariation = new TreeMap<>();
                Map<String,Double> percentageOfStandards = new TreeMap<>();
                List<String> varietyNames = new ArrayList<>();
                List<SummaryStatistics> statistics = new ArrayList<>();


                for (RawData rd: computedDataList) {

                    //to have the first variety name
                    String varietyName = rd.getName();
                    varietyNames.add(varietyName);
                    break;

                }
                int index = 0;
                for (RawData rd: computedDataList) {
                    String varietyName = rd.getName();
                    if (!varietyName.equals(varietyNames.get(index))){
                        varietyNames.add(varietyName);
                        index++;
                    }

                }
                int counter = 0;
                int counterOfStandards = 0;

                double sumSquares = 0.0;
                double sumYields = 0.0;
                double sumYieldsofStandards = 0.0;
                double deviationS = 0.0;

                for (String s: varietyNames ) {
                    //System.out.println("A fajta neve = " + s);

                    for (RawData rawData : computedDataList) {


                        if (s.equals(rawData.getName())){
                            sumYields += rawData.getYield();
                            //System.out.println("A " + s + " termés összege = " + sumYields);
                            sumSquares += (Math.pow(rawData.getYield(),2));
                            //System.out.println("Négyzetösszeg = " + sumSquares);
                            counter++;
                            //System.out.println("A fajták száma" + counter);
                            if (rawData.isStandard()){
                                sumYieldsofStandards += rawData.getYield();
                                //System.out.println("Standardok termés összege: " + sumYieldsofStandards);
                                counterOfStandards++;
                                //System.out.println("Standardok száma:" + counterOfStandards);
                            }

                        }
                    }
                    //System.out.println("A termés négyzetre emelve: " + Math.pow(sumYields,2));
                    deviationS = Math.sqrt( (sumSquares- ( Math.pow(sumYields,2.0)  / counter) ) / (counter-1));
                    //System.out.println("A fajta szórása: " + deviationS);

                    //before test of the System:
                    //averages.put((double) (Math.round((sumYields/counter)*1000))/1000,s);
                    //deviation.put(s,( (double) (Math.round(deviationS*1000))/1000));

                    //after the test of the System, without round, it is more accurate
                    averages.put((double) sumYields/counter,s);
                    deviation.put(s,deviationS);

                    coefficientOfVariation.put(s,( (double) ((Math.round (((deviationS/(sumYields/counter))*100) * 10)))/10));
                    //coefficientOfVariation.put(s,( (double) (deviationS/(sumYields/counter))));
                    //bug fix: it is not good to calculate here, the results of standards were false, see line 419-429
                    //percentageOfStandards.put(s,( (double)  (Math.round ((((sumYields/counter)/(sumYieldsofStandards/counterOfStandards))*10000)))/10));
                    repetitions.put(s,counter);
                    counter = 0;
                    sumSquares = 0.0;
                    sumYields = 0.0;
                }

                    for (String s: varietyNames ) {

                        for (Double d: averages.keySet()) {
                            String variety = averages.get(d);
                            if (variety.equals(s)) {
                                percentageOfStandards.put(s,( (double)  (Math.round (((d/(sumYieldsofStandards/counterOfStandards))*1000)))/10));
                                //System.out.println("A fajta neve " + s + ": " + ( (double)  (Math.round (((d/(sumYieldsofStandards/counterOfStandards))*1000)))/10));
                            }
                        }

                    }

                for (Double d: averages.keySet()) {
                    int entryNumber = 0;
                    int repetition = 0;
                    boolean standard = false;
                    double variation = 0.0;
                    double cv = 0.0;
                    double percentStandards = 0.0;

                    String variety = averages.get(d);

                    for (RawData rw:computedDataList) {
                        if (variety.equals(rw.getName())){
                            entryNumber = rw.getEntry_Number();
                            standard = rw.isStandard();
                        }
                    }




                    for (String s: deviation.keySet()) {
                        if (s.equals(variety)){
                            variation = deviation.get(s);
                        }
                    }

                    for (String s: coefficientOfVariation.keySet()) {
                        if (s.equals(variety)){
                            cv = coefficientOfVariation.get(s);
                        }
                    }

                    for (String s: repetitions.keySet()) {
                        if (s.equals(variety)){
                            repetition = repetitions.get(s);
                        }
                    }

                    for (String s: percentageOfStandards.keySet()) {
                        if (s.equals(variety)){
                            percentStandards = percentageOfStandards.get(s);
                        }
                    }


                    //System.out.println("A fajta száma: " + entryNumber + ", " + standard + ", A fajta neve: " + variety + ", átlagtermése = " + d + ", ismétlések száma: " + repetition + ", szórása = " + variation + ", CV értéke = " + cv + ", Standard% " + percentStandards);
                    SummaryStatistics sumStat = new SummaryStatistics(entryNumber,standard,variety,d,repetition,variation,cv,percentStandards);
                    statistics.add(sumStat);
                }
                    gui.setActualContent(new SummaryStatisticsPanel(new TableSummaryStatistics(statistics),statistics));

                    //this menu switched off to avoid further confusion
                    summaryStatistics.setEnabled(false);

            } else {
                JOptionPane.showMessageDialog(gui, Labels.noDataError,Labels.error,JOptionPane.ERROR_MESSAGE);
                return;
            }

        }

        if (e.getActionCommand().equals(Labels.menuPoint4)) {
            ConfigDialog configDialog = new ConfigDialog();
        }

        if (e.getActionCommand().equals(Labels.menuItem6)) {
            gui.setActualContent(new InformationPanel());
        }

        if (e.getActionCommand().equals(Labels.menuItem7)) {
            NameCardDialog nameCardDialog = new NameCardDialog();
        }

    }

}

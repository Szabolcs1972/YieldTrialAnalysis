package hu.szlavikszabolcs.view.panels;

import hu.szlavikszabolcs.view.bean.SummaryStatistics;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import hu.szlavikszabolcs.view.bean.Labels;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.table.JTableHeader;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;


public class SummaryStatisticsPanel extends JPanel implements ActionListener, MouseListener {

    List<SummaryStatistics> statistics;
    JPanel jPanel = new JPanel();
    public AbstractTableModel abstractTableModel;
    NumberFormat nf = NumberFormat.getInstance(Locale.getDefault());
    JTable table;
    JScrollPane scrollPane;
    JButton buttonOk = new JButton(Labels.ok);
    JButton buttonSaveToExcel = new JButton(Labels.saveToExcel);
    double sumOfCV = 0.0;

    public SummaryStatisticsPanel(AbstractTableModel abstractTableModel, List<SummaryStatistics> statistics) {

        this.abstractTableModel = abstractTableModel;
        this.statistics = statistics;

        for (SummaryStatistics stat: statistics) {
            //System.out.println("CV érték : " + stat.getCv());
            sumOfCV += stat.getCv();
        }

        setLayout(new BorderLayout());

        table = new JTable(abstractTableModel){

            //Source: https://docs.oracle.com/javase/tutorial/uiswing/components/table.html
            //How to use tables
            public String getToolTipText(MouseEvent e) {//set the tooltiptext of the columns
                String tip = null;
                java.awt.Point p = e.getPoint();
                int colIndex = table.columnAtPoint(p);

                //int colIndex = table.columnAtPoint(p);

                tip = abstractTableModel.getColumnName(colIndex);
                //System.out.println("A tip az = " + tip);
                //System.out.println("A rowindex : " + rowIndex);
                //System.out.println("A colindex : " + colIndex);
                if (colIndex == 6) {//count the CV% of the trial and show the result on ToolTipText
                    tip = "A kísérlet CV% értéke = " + nf.format((double) Math.round((sumOfCV/abstractTableModel.getRowCount())*10)/10);
                }

                return tip;
            }

            protected JTableHeader createDefaultTableHeader() {
                return new JTableHeader(columnModel) {
                    public String getToolTipText(MouseEvent e) {
                        String tip = null;
                        java.awt.Point p = e.getPoint();
                        int index = columnModel.getColumnIndexAtX(p.x);
                        int realIndex = columnModel.getColumn(index).getModelIndex();
                        return abstractTableModel.getColumnName(realIndex);
                    }
                };
            }

        };
        table.setAutoCreateRowSorter(true);
        table.addMouseListener(this);


        scrollPane = new JScrollPane(table);


        add(scrollPane,BorderLayout.CENTER);

        jPanel.add(buttonSaveToExcel);
        jPanel.add(buttonOk);

        add(jPanel,BorderLayout.PAGE_END);

        buttonOk.addActionListener(this);
        buttonSaveToExcel.addActionListener(this);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttonOk) {
            this.setVisible(false);
            /*
            //clear the lists of data before new operations
            if (!rawDataList.isEmpty()) rawDataList.clear();
            computedDataList = GetPlotSizePanel.getComputedDataList();
            if (!computedDataList.isEmpty()) computedDataList.clear();
             */
        }

        if (e.getSource() == buttonSaveToExcel) {

            //Source: https://www.geeksforgeeks.org/reading-writing-data-excel-file-using-apache-poi/
            //Reading and Writing data to excel file using Apache POI

            // Blank workbook
            XSSFWorkbook workbook = new XSSFWorkbook();

            // Create a blank sheet
            XSSFSheet sheet = workbook.createSheet("ÖsszefoglalóStatisztika");


            //write the column names to the first row of the sheet
            int rowNum = 0;
            int cellnum = 0;
            Row row = sheet.createRow(rowNum++);

            for (int i = 0; i < abstractTableModel.getColumnCount(); i++) {
                String columnName = (String) abstractTableModel.getColumnName(i);

                    // this line creates a cell in the next column of that row
                    Cell cell = row.createCell(cellnum++);
                        cell.setCellValue(columnName);

            }

            //write data to the cells of the sheet
            for (SummaryStatistics stat: statistics ) {


                row = sheet.createRow(rowNum++);

                for (int j = 0; j < abstractTableModel.getColumnCount(); j++) {

                        // this line creates a cell in the next column of that row
                        Cell cell = row.createCell(j);

                        switch (j) {

                            case 0:
                            cell.setCellValue((Integer)stat.getEntryNumber());
                                break;
                            case 1:
                            cell.setCellValue((Boolean)stat.isStandard() ? "+" : "-");
                                break;
                            case 2:
                            cell.setCellValue((String)stat.getVarietyName());
                                break;
                            case 3:
                            cell.setCellValue((Double)stat.getAverageYield());
                                break;
                            case 4:
                            cell.setCellValue((Integer)stat.getRepetitions());
                                break;
                            case 5:
                            cell.setCellValue((Double)stat.getDeviation());
                                break;
                            case 6:
                            cell.setCellValue((Double)stat.getCv());
                                break;
                            case 7:
                            cell.setCellValue((Double)stat.getPercentageOfStandards());
                                break;

                        }

                }

            }

            try {
                // this Writes the workbook 'Statisztika'
                FileOutputStream out = new FileOutputStream(new File("Statisztika.xlsx"));
                workbook.write(out);
                out.close();
                //System.out.println("Statisztika.xlsx written successfully on disk.");
                JOptionPane.showMessageDialog(this,Labels.fileWriteToExcelSuccess,Labels.ok,JOptionPane.INFORMATION_MESSAGE);
                /*
                //clear the lists of data before new operations
                rawDataList.clear();
                computedDataList = GetPlotSizePanel.getComputedDataList();
                computedDataList.clear();

                 */
            }
            catch (Exception exception) {
                JOptionPane.showMessageDialog(this,Labels.writeIOException + '\n' + exception.getMessage(),Labels.error,JOptionPane.ERROR_MESSAGE);
            }

        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        /*
        java.awt.Point p = e.getPoint();
        System.out.println("This is the position of the mouse: " + p);
        getToolTipText(e);
        //renderer.setToolTipText(getToolTipText(e));
        //createDefaultTableHeader();
        table.setToolTipText(getToolTipText(e));

         */
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        table.setToolTipText(getToolTipText(e));

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

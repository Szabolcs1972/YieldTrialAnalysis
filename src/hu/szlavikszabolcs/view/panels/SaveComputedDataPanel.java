package hu.szlavikszabolcs.view.panels;

import hu.szlavikszabolcs.model.PlantBreedingDAOImpl;
import hu.szlavikszabolcs.view.bean.Labels;
import hu.szlavikszabolcs.view.bean.RawData;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.List;

public class SaveComputedDataPanel extends JPanel implements ActionListener {

    private PlantBreedingDAOImpl dao = new PlantBreedingDAOImpl();

    JPanel jPanel = new JPanel();
    public List<RawData> rawDataList;

    public AbstractTableModel abstractTableModel;
    JTable table;
    JScrollPane scrollPane;

    JButton button1 = new JButton(Labels.saveYieldsToDatabase);
    JButton button2 = new JButton(Labels.cancel);

    FlowLayout flowpane = new FlowLayout(FlowLayout.CENTER);

    public SaveComputedDataPanel(List<RawData> rawDataList, AbstractTableModel abstractTableModel){

        this.rawDataList = rawDataList;
        this.abstractTableModel = abstractTableModel;

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
        scrollPane = new JScrollPane(table);

        add(scrollPane,BorderLayout.CENTER);

        jPanel.setLayout(flowpane);
        jPanel.add(button1);
        jPanel.add(button2);

        button1.addActionListener(this);
        button2.addActionListener(this);

        add(jPanel,BorderLayout.PAGE_END);

        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1){
            /*System.out.println("Mentés gombot megnyomták!");
            for (RawData rawData: rawDataList) {
                System.out.println(rawData);

            }
            */
            String message = dao.addDataPoint(rawDataList);
            if (message.equals("true")) {
                JOptionPane.showMessageDialog(this, Labels.dataUploadSuccess, Labels.information, JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, message, Labels.error, JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == button2){
            this.setVisible(false);


        }
    }


}

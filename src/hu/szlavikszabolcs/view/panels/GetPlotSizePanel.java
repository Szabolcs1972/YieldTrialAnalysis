package hu.szlavikszabolcs.view.panels;

import hu.szlavikszabolcs.view.MenuPoints;
import hu.szlavikszabolcs.view.bean.Labels;
import hu.szlavikszabolcs.view.PlantBreedingGUI;
import hu.szlavikszabolcs.view.tablemodels.TableSchemaComputed;
import hu.szlavikszabolcs.view.bean.RawData;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GetPlotSizePanel extends JPanel implements ActionListener {
    public PlantBreedingGUI gui;


    JPanel contentPane = new JPanel();
    JPanel jPanel1 = new JPanel();
    JPanel jPanel2 = new JPanel();
    JTextField getPlotSize = new JTextField(10);
    JTextField getMoistureSetTo = new JTextField(10);
    BorderLayout border = new BorderLayout();
    GridLayout grid = new GridLayout(2,2,20,20);
    JButton button = new JButton(Labels.input);
    private double plotSize;
    private double setMoistureTo;

    private java.util.List<RawData> rawDataList;
    private static List<RawData> computedDataList = new ArrayList<>();
    FlowLayout flowButton = new FlowLayout(FlowLayout.CENTER);


    public GetPlotSizePanel(PlantBreedingGUI gui, List<RawData> rawDataList){
        this.gui = gui;
        this.rawDataList = rawDataList;

        contentPane.setLayout(border);
        contentPane.setBorder(new EmptyBorder(10,10,10,10));

        jPanel1.setLayout(grid);
        jPanel1.add(new JLabel(Labels.getPlotSize));
        jPanel1.add(getPlotSize);
        jPanel1.add(new JLabel(Labels.getMoistureToSet));
        jPanel1.add(getMoistureSetTo);

        jPanel2.setLayout(flowButton);
        jPanel2.add(button);

        button.addActionListener(this);

        contentPane.add(jPanel1, border.CENTER);
        contentPane.add(jPanel2, border.SOUTH);

        add(contentPane);

        setVisible(true);


    }


    public static List<RawData> getComputedDataList(){
        return computedDataList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button){

            if ((!getPlotSize.getText().isEmpty()) && (!getMoistureSetTo.getText().isEmpty())){
                try {
                    if (Double.parseDouble(getPlotSize.getText()) > 0 && Double.parseDouble(getMoistureSetTo.getText()) > 0 && Double.parseDouble(getMoistureSetTo.getText()) < 100) {
                        plotSize = Double.parseDouble(getPlotSize.getText());
                        setMoistureTo = Double.parseDouble(getMoistureSetTo.getText());
                        //System.out.println("A Parcella nagysága:" +  plotSize);
                        //System.out.println("A kívánt nedvesség:" +  setMoistureTo);
                    } else {
                        JOptionPane.showMessageDialog(this,Labels.numberValueError,Labels.error,JOptionPane.ERROR_MESSAGE);
                        return;
                    }


                } catch (NumberFormatException exception){
                    JOptionPane.showMessageDialog(this,Labels.numberFormatnoError,Labels.error,JOptionPane.ERROR_MESSAGE);
                    return;
                }

            } else {
                JOptionPane.showMessageDialog(this,Labels.emptyField,Labels.error,JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!rawDataList.isEmpty()) {
                for (RawData raw : rawDataList) {
                    //before test of the system:
                    //raw.setYield((double) (Math.round(((((raw.getPlotWeight() * ((100 - raw.getMoisture()) / 100)) / ((100 - setMoistureTo) / 100)) / plotSize) * 10)*1000))/1000);
                    //after test:
                    raw.setYield((double) ((((raw.getPlotWeight() * ((100 - raw.getMoisture()) / 100)) / ((100 - setMoistureTo) / 100)) / plotSize) * 10));
                    computedDataList.add(raw);
                }

                gui.setActualContent(new SaveComputedDataPanel(computedDataList, new TableSchemaComputed(computedDataList)));

                //according to the data of yields - Summary Statistics can be made
                JOptionPane.showMessageDialog(gui,Labels.informationCalculateSummaryStatistics, Labels.information,JOptionPane.INFORMATION_MESSAGE);
                //set the menuItem enabled
                MenuPoints.setSummaryStatistics(true);

            } else {
                JOptionPane.showMessageDialog(this,Labels.noDataError,Labels.error,JOptionPane.ERROR_MESSAGE);
                return;
            }

        }

    }
}

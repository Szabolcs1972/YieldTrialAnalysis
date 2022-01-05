package hu.szlavikszabolcs.view.tablemodels;

import hu.szlavikszabolcs.view.bean.RawData;

import javax.swing.table.AbstractTableModel;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class TableSchemaInputData extends AbstractTableModel {
    String[] columnNames = {"Plot","Entry","Check","Name","Replication","Weight (kg/plot)","Moisture (%)","Year","Location"};
    public List<RawData> rawDataList;
    NumberFormat nf = NumberFormat.getInstance(Locale.getDefault());

    public TableSchemaInputData(List<RawData> rawDataList) {
        this.rawDataList = rawDataList;

    }

    @Override
    public int getRowCount() {
        return rawDataList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        RawData rawData = rawDataList.get(rowIndex);

        String actualColumName = columnNames[columnIndex];

        switch (actualColumName) {
            case ("Plot"):
                return rawData.getPlot_Number();
            case ("Entry"):
                return rawData.getEntry_Number();
            case ("Check"):
                return rawData.isStandard() ? "+" : "-";
            case ("Name"):
                return rawData.getName();
            case ("Replication"):
                return rawData.getRep_Number();
            case ("Weight (kg/plot)"):
                return nf.format(rawData.getPlotWeight());
            case ("Moisture (%)"):
                return nf.format(rawData.getMoisture());
            case ("Year"):
                return rawData.getYear();
            case ("Location"):
                return rawData.getLocation();
            default:
                return "Unknown";
        }

    }
}

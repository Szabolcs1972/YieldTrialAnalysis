package hu.szlavikszabolcs.view.tablemodels;

import hu.szlavikszabolcs.view.bean.RawData;

import javax.swing.table.AbstractTableModel;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class TableSchemaInputData extends AbstractTableModel {
    String[] columnNames = {"Parcella szám","Fajta szám","Standard fajta","Fajta neve","Ismétlés szám","Tömeg (kg/parcella)","Nedvesség (%)","Év","Kísérlet helyszíne"};
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
            case ("Parcella szám"):
                return rawData.getPlot_Number();
            case ("Fajta szám"):
                return rawData.getEntry_Number();
            case ("Standard fajta"):
                return rawData.isStandard() ? "+" : "-";
            case ("Fajta neve"):
                return rawData.getName();
            case ("Ismétlés szám"):
                return rawData.getRep_Number();
            case ("Tömeg (kg/parcella)"):
                return nf.format(rawData.getPlotWeight());
            case ("Nedvesség (%)"):
                return nf.format(rawData.getMoisture());
            case ("Év"):
                return rawData.getYear();
            case ("Kísérlet helyszíne"):
                return rawData.getLocation();
            default:
                return "Unknown";
        }

    }
}

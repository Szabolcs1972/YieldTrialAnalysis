package hu.szlavikszabolcs.view.tablemodels;

import hu.szlavikszabolcs.view.bean.RawData;

import javax.swing.table.AbstractTableModel;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class TableSchemaComputed extends AbstractTableModel {
    String[] columnNames = {"Parcella szám", "Fajta szám", "Fajta neve", "Ismétlés szám", "Tömeg (kg/parcella)", "Nedvesség (%)", "Termés (t/ha)","Év","Kísérlet helyszíne"};
    public List<RawData> rawDataList;
    NumberFormat nf = NumberFormat.getInstance(Locale.getDefault());

    public TableSchemaComputed(List<RawData> rawDataList) {
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
            case ("Fajta neve"):
                return rawData.getName();
            case ("Ismétlés szám"):
                return rawData.getRep_Number();
            case ("Tömeg (kg/parcella)"):
                return nf.format(rawData.getPlotWeight());
            case ("Nedvesség (%)"):
                return nf.format(rawData.getMoisture());
            case ("Termés (t/ha)"):
                //return (double) (Math.round(rawData.getYield()*1000))/1000;
                return "<html><strong>" + nf.format(rawData.getYield()) + "</strong></html>";
            case ("Év"):
                return rawData.getYear();
            case ("Kísérlet helyszíne"):
                return rawData.getLocation();
            default:
                return "Unknown";
        }

    }
}

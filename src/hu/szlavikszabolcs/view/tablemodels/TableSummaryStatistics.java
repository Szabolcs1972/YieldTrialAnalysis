package hu.szlavikszabolcs.view.tablemodels;

import hu.szlavikszabolcs.view.bean.SummaryStatistics;

import javax.swing.table.AbstractTableModel;
import java.text.NumberFormat;
import java.util.*;

public class TableSummaryStatistics extends AbstractTableModel {
    String[] columnNames = {"Fajta száma","Standard","Fajta neve", "Átlag termés (t/ha)", "Ismétlés (n)","Szórás (s)", "CV (s%)","Standard (%)"};
    List<SummaryStatistics> statistics;
    NumberFormat nf = NumberFormat.getInstance(Locale.getDefault());

    public TableSummaryStatistics(List<SummaryStatistics> statistics) {
        this.statistics = statistics;


    }

    public List<SummaryStatistics> getStatistics(){
        return statistics;
    }

    @Override
    public int getRowCount() {
        return statistics.size();
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

        SummaryStatistics stat = statistics.get(rowIndex);

        String actualColumName = columnNames[columnIndex];

        switch (actualColumName) {
            case ("Fajta száma"):
                return stat.getEntryNumber();
            case ("Standard"):
                return stat.isStandard() ? "+" : "-";
            case ("Fajta neve"):
                return stat.getVarietyName();
            case ("Átlag termés (t/ha)"):
                return nf.format(stat.getAverageYield());
            case ("Ismétlés (n)"):
                return stat.getRepetitions();
            case ("Szórás (s)"):
                return nf.format(stat.getDeviation());
            case ("CV (s%)"):
                return nf.format(stat.getCv());
            case ("Standard (%)"):
                return nf.format(stat.getPercentageOfStandards());
            default:
                return "Unknown";
        }

    }
}

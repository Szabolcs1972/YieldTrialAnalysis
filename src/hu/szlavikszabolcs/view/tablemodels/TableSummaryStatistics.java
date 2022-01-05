package hu.szlavikszabolcs.view.tablemodels;

import hu.szlavikszabolcs.view.bean.SummaryStatistics;

import javax.swing.table.AbstractTableModel;
import java.text.NumberFormat;
import java.util.*;

public class TableSummaryStatistics extends AbstractTableModel {
    String[] columnNames = {"Entry","Check","Name", "Average yield (t/ha)", "Replication (n)","Standard deviation (s)", "CV (s%)","Check (%)"};
    List<SummaryStatistics> statistics;
    NumberFormat nf = NumberFormat.getInstance(Locale.getDefault());

    public TableSummaryStatistics(List<SummaryStatistics> statistics) {
        this.statistics = statistics;


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
            case ("Entry"):
                return stat.getEntryNumber();
            case ("Check"):
                return stat.isStandard() ? "+" : "-";
            case ("Name"):
                return stat.getVarietyName();
            case ("Average yield (t/ha)"):
                return nf.format(stat.getAverageYield());
            case ("Replication (n)"):
                return stat.getRepetitions();
            case ("Standard deviation (s)"):
                return nf.format(stat.getDeviation());
            case ("CV (s%)"):
                return nf.format(stat.getCv());
            case ("Check (%)"):
                return nf.format(stat.getPercentageOfStandards());
            default:
                return "Unknown";
        }

    }
}

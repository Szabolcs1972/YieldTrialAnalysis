package hu.szlavikszabolcs.view.bean;

public class SummaryStatistics {
    private int entryNumber;
    private boolean standard;
    private String varietyName;
    private double averageYield;
    private int repetitions;
    private double deviation;
    private double cv;
    private double percentageOfStandards;

    public SummaryStatistics(int entryNumber, boolean standard, String varietyName, double averageYield, int repetitions, double deviation, double cv, double percentageOfStandards) {
        this.entryNumber = entryNumber;
        this.standard = standard;
        this.varietyName = varietyName;
        this.averageYield = averageYield;
        this.repetitions = repetitions;
        this.deviation = deviation;
        this.cv = cv;
        this.percentageOfStandards = percentageOfStandards;
    }

    public int getEntryNumber() {
        return entryNumber;
    }

    public void setEntryNumber(int entryNumber) {
        this.entryNumber = entryNumber;
    }

    public boolean isStandard() {
        return standard;
    }

    public void setStandard(boolean standard) {
        this.standard = standard;
    }

    public String getVarietyName() {
        return varietyName;
    }

    public void setVarietyName(String varietyName) {
        this.varietyName = varietyName;
    }

    public double getAverageYield() {
        return averageYield;
    }

    public void setAverageYield(double averageYield) {
        this.averageYield = averageYield;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    public double getDeviation() {
        return deviation;
    }

    public void setDeviation(double deviation) {
        this.deviation = deviation;
    }

    public double getCv() {
        return cv;
    }

    public void setCv(double cv) {
        this.cv = cv;
    }

    public double getPercentageOfStandards() {
        return percentageOfStandards;
    }

    public void setPercentageOfStandards(double percentageOfStandards) {
        this.percentageOfStandards = percentageOfStandards;
    }

    @Override
    public String toString() {
        return "SummaryStatistics{" +
                "entryNumber=" + entryNumber +
                ", standard=" + standard +
                ", varietyName='" + varietyName + '\'' +
                ", averageYield=" + averageYield +
                ", repetitions=" + repetitions +
                ", deviation=" + deviation +
                ", cv=" + cv +
                ", percentageOfStandards=" + percentageOfStandards +
                '}';
    }
}

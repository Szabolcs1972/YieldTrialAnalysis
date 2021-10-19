package hu.szlavikszabolcs.view.bean;

public class RawData {
    private int plot_Number;
    private int entry_Number;
    private boolean standard;
    private String name;
    private int rep_Number;
    private double plotWeight;
    private double moisture;
    private double yield;
    private int year;
    private String location;

    public RawData(int plot_Number, int entry_Number, boolean standard, String name, int rep_Number, double plotWeight, double moisture, double yield, int year, String location) {
        this.plot_Number = plot_Number;
        this.entry_Number = entry_Number;
        this.standard = standard;
        this.name = name;
        this.rep_Number = rep_Number;
        this.plotWeight = plotWeight;
        this.moisture = moisture;
        this.yield = yield;
        this.year = year;
        this.location = location;
    }

    public int getPlot_Number() {
        return plot_Number;
    }

    public void setPlot_Number(int plot_Number) {
        this.plot_Number = plot_Number;
    }

    public int getEntry_Number() {
        return entry_Number;
    }

    public void setEntry_Number(int entry_Number) {
        this.entry_Number = entry_Number;
    }

    public boolean isStandard() {
        return standard;
    }

    public void setStandard(boolean standard) {
        this.standard = standard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRep_Number() {
        return rep_Number;
    }

    public void setRep_Number(int rep_Number) {
        this.rep_Number = rep_Number;
    }

    public double getPlotWeight() {
        return plotWeight;
    }

    public void setPlotWeight(double plotWeight) {
        this.plotWeight = plotWeight;
    }

    public double getMoisture() {
        return moisture;
    }

    public void setMoisture(double moisture) {
        this.moisture = moisture;
    }

    public double getYield() {
        return yield;
    }

    public void setYield(double yield) {
        this.yield = yield;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "RawData{" +
                "plot_Number=" + plot_Number +
                ", entry_Number=" + entry_Number +
                ", standard=" + standard +
                ", name='" + name + '\'' +
                ", rep_Number=" + rep_Number +
                ", plotWeight=" + plotWeight +
                ", moisture=" + moisture +
                ", yield=" + yield +
                ", year=" + year +
                ", location='" + location + '\'' +
                '}';
    }
}

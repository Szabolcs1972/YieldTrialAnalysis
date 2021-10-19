package hu.szlavikszabolcs.model;

import hu.szlavikszabolcs.view.bean.RawData;

import java.util.List;

public interface PlantBreedingDAO {
    public String addDataPoint(List<RawData> computedData);
    public List<RawData> getDataPoint();
}

package hu.szlavikszabolcs.model;

import hu.szlavikszabolcs.view.bean.RawData;

import java.util.List;

public interface PlantBreedingDAO {
    String addDataPoint(List<RawData> computedData);
    List<RawData> getDataPoint();
}

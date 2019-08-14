package com.sheygam.mongodb.data;

import com.sheygam.mongodb.data.documents.CarStatistic;

import java.util.List;
import java.util.Map;

public interface StatisticRepository {
    List<CarStatistic> aggregateCarByPersonId();
    List<Map> getModelStatistic();

    List<Map> testStatistic();
}

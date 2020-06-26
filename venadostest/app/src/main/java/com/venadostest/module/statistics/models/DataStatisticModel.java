package com.venadostest.module.statistics.models;



import java.util.List;

public class DataStatisticModel {
    private List<StatisticModel> statistics;
    private int code;

    public List<StatisticModel> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<StatisticModel> statistics) {
        this.statistics = statistics;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

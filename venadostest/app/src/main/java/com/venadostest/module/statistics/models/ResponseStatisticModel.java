package com.venadostest.module.statistics.models;

import com.venadostest.module.menu.models.DataGameResponseModel;

public class ResponseStatisticModel {
    private boolean success;
    private DataStatisticModel data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public DataStatisticModel getData() {
        return data;
    }

    public void setData(DataStatisticModel data) {
        this.data = data;
    }
}

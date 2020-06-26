package com.venadostest.module.menu.models;

public class ResponseGameModel {
    private boolean success;
    private DataGameResponseModel data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public DataGameResponseModel getData() {
        return data;
    }

    public void setData(DataGameResponseModel data) {
        this.data = data;
    }

}

package com.venadostest.module.menu.models;

public class ResponseGameModel {
    private boolean success;
    private DataGameResponse data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public DataGameResponse getData() {
        return data;
    }

    public void setData(DataGameResponse data) {
        this.data = data;
    }

}

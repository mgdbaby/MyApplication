package com.example.myapplication.entity;

/**
 * Created by vargo on 2017/1/18.
 */

public class DataBean {
    private String dataType;
    private String dataMoney;

    public DataBean(String dataType, String dataMoney) {
        this.dataType = dataType;
        this.dataMoney = dataMoney;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDataMoney() {
        return dataMoney;
    }

    public void setDataMoney(String dataMoney) {
        this.dataMoney = dataMoney;
    }

    @Override
    public String toString() {
        return "DataBean{" +
                "dataType='" + dataType + '\'' +
                ", dataMoney=" + dataMoney +
                '}';
    }
}

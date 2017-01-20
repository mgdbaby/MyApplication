package com.example.myapplication.entity;

/**
 * Created by vargo on 2017/1/18.
 */

public class DataListBean{
    private String data;
    private int money;
    private int type;

    public DataListBean(String data, int money, int type) {
        this.data = data;
        this.type = type;
        this.money = money;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "DataListBean{" +
                "data='" + data + '\'' +
                ", money=" + money +
                '}';
    }
}

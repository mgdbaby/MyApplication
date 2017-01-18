package com.example.myapplication.entity;

import android.graphics.drawable.Drawable;

/**
 * Created by vargo on 2017/1/18.
 */

public class SelectDataBean {
    private String context;
    private Drawable drawable;
    private int selectType;

    public SelectDataBean(String context, Drawable drawable, int selectType) {
        this.context = context;
        this.selectType = selectType;
        this.drawable = drawable;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public int getSelectType() {
        return selectType;
    }

    public void setSelectType(int selectType) {
        this.selectType = selectType;
    }

    @Override
    public String toString() {
        return "SelectDataBean{" +
                "context='" + context + '\'' +
                ", drawable=" + drawable +
                ", selectType=" + selectType +
                '}';
    }
}

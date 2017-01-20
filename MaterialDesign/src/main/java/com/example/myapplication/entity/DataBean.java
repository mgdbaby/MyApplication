package com.example.myapplication.entity;

import android.graphics.drawable.Drawable;

/**
 * Created by vargo on 2017/1/18.
 */

public class DataBean {
    private String context;
    private Drawable drawable;
    private int layoutType;

    public DataBean(String context, Drawable drawable, int selectType) {
        this.context = context;
        this.layoutType = selectType;
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

    public int getLayoutType() {
        return layoutType;
    }

    public void setLayoutType(int layoutType) {
        this.layoutType = layoutType;
    }

    @Override
    public String toString() {
        return "DataBean{" +
                "context='" + context + '\'' +
                ", drawable=" + drawable +
                ", layoutType=" + layoutType +
                '}';
    }
}

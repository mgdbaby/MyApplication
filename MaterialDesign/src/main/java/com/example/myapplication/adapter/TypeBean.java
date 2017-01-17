package com.example.myapplication.adapter;

import android.graphics.drawable.Drawable;

/**
 * Created by vargo on 2016/12/14.
 */

public class TypeBean {
    String content;
    Drawable drawable ;
    int type;

    public TypeBean(String content, Drawable drawable, int type) {
        this.content = content;
        this.drawable = drawable;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}

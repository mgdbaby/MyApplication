package com.example.myapplication.adapter;

import android.graphics.Bitmap;

/**
 * Created by vargo on 2016/12/14.
 */

public class TypeBean {
    String content;
    Bitmap bitmap ;
    int type;

    public TypeBean(String content, Bitmap bitmap, int type) {
        this.content = content;
        this.bitmap = bitmap;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}

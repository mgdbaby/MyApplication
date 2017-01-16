package com.example.myapplication.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;


public class BaseViewHolder extends RecyclerView.ViewHolder {

    private int viewType;

    public BaseViewHolder(View itemView, int viewType) {
        super(itemView);
        this.viewType = viewType;
    }

    public int getViewType(){
        return viewType;
    }
}

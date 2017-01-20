package com.example.myapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.LConfig;
import com.example.myapplication.R;
import com.example.myapplication.adapter.DataAdapter;
import com.example.myapplication.entity.DataBean;
import com.example.myapplication.widget.WrapHeightGridLayoutManager;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;


@ContentView(R.layout.dialog_select_num)
public class DialogSelectNum extends Activity {

    @ViewInject(R.id.recyclerViewSelect)
    private RecyclerView recyclerViewSelect;

    private List<DataBean> selectDataList = new ArrayList<DataBean>();;
    private DataAdapter dataAdapter;
    private WrapHeightGridLayoutManager gridViewManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        initView();
    }

    private void initView() {
        Intent intent = this.getIntent();
        int position = (int) intent.getExtras().get("type");

        switch(position){
            case 0:
                selectDataList = LConfig.getNumList(this);
                gridViewManager = new WrapHeightGridLayoutManager(this, 7);
                break;
            case 1:
                selectDataList = LConfig.getZodiacList(this);
                gridViewManager = new WrapHeightGridLayoutManager(this, 5);
                break;
            case 2:
                selectDataList = LConfig.getSingleOrDoubleList(this);
                gridViewManager = new WrapHeightGridLayoutManager(this, 2);
                break;
            case 3:
                selectDataList = LConfig.getBigOrSmallList(this);
                gridViewManager = new WrapHeightGridLayoutManager(this, 2);
                break;
            case 4:
                selectDataList = LConfig.getBallColorList(this);
                gridViewManager = new WrapHeightGridLayoutManager(this, 3);
                break;
            case 5:
                selectDataList = LConfig.getHalfBallColorList(this);
                gridViewManager = new WrapHeightGridLayoutManager(this, 6);
                break;
            case 6:
                selectDataList = LConfig.getHalfList(this);
                gridViewManager = new WrapHeightGridLayoutManager(this, 4);
                break;
            case 7:
                selectDataList = LConfig.getNumList(this);
                gridViewManager = new WrapHeightGridLayoutManager(this, 7);
                break;
            default:
                break;
        }

        dataAdapter = new DataAdapter(this, selectDataList);
        recyclerViewSelect.setHasFixedSize(true);
        recyclerViewSelect.setLayoutManager(gridViewManager);
        recyclerViewSelect.setAdapter(dataAdapter);
        recyclerViewSelect.setItemAnimator(new DefaultItemAnimator());
        dataAdapter.setOnItemClickListener(new DataAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent();
                intent.putExtra("type", selectDataList.get(position).getContext());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        finish();
        return true;
    }

}

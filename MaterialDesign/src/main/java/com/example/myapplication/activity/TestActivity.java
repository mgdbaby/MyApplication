package com.example.myapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapter.DataAdapter;
import com.example.myapplication.entity.DataBean;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;


@ContentView(R.layout.activity_test)
public class TestActivity extends Activity {

    @ViewInject(R.id.recyclerViewSelect)
    private RecyclerView recyclerViewSelect;

    private List<DataBean> numList;
    private DataAdapter dataAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);

        initRecycleView();
    }

    private void initRecycleView() {
        numList = new ArrayList<DataBean>();
        for(int i = 1; i <= 49; i++){
            if(i < 10){
                numList.add(new DataBean("0" + i, getResources().getDrawable(R.drawable.shape_green, null), 1));
            }else if(i % 7 == 0 || i % 8 == 0){
                numList.add(new DataBean("" + i, getResources().getDrawable(R.drawable.shape_red, null), 1));
            }else {
                numList.add(new DataBean("" + i, getResources().getDrawable(R.drawable.shape_blue, null), 1));
            }
        }


        GridLayoutManager gridViewManager = new GridLayoutManager(this, 7);
        dataAdapter = new DataAdapter(this, numList);

        recyclerViewSelect.setLayoutManager(gridViewManager);
        recyclerViewSelect.setAdapter(dataAdapter);

        recyclerViewSelect.setHasFixedSize(true);

    }
}

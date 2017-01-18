package com.example.myapplication.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.adapter.DataAdapter;
import com.example.myapplication.R;
import com.example.myapplication.adapter.TypeAdapter;
import com.example.myapplication.entity.DataBean;
import com.example.myapplication.entity.TypeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vargo on 2017/1/13.
 */

public class FirstFragment extends Fragment {
    //24.6

    private RecyclerView recyclerViewType;
    private List<TypeBean> typeBeanList;
    private TypeAdapter typeAdapter;

    private RecyclerView recyclerViewData;
    private List<DataBean> dataBeanList;
    private DataAdapter dataAdapter;

    private TextInputLayout textInputLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        recyclerViewType = (RecyclerView) view.findViewById(R.id.recyclerViewType);
        recyclerViewData = (RecyclerView) view.findViewById(R.id.recyclerViewData);
        textInputLayout = (TextInputLayout) view.findViewById(R.id.layoutMoneyNum);
        return view;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initTypeRecycleView();
        initDataRecycleView();

        textInputLayout.setHint("金额(元)");
    }

    private void initDataRecycleView() {
        dataBeanList = new ArrayList<DataBean>();

        for(int i = 0; i < 20; i++){
            dataBeanList.add(new DataBean("测试数据"+i, "2000" + i));
        }

        GridLayoutManager dataGM = new GridLayoutManager(getActivity(), 2);
        dataAdapter = new DataAdapter(getActivity(), dataBeanList);
        recyclerViewData.setLayoutManager(dataGM);
        recyclerViewData.setHasFixedSize(true);
        recyclerViewData.setAdapter(dataAdapter);
        recyclerViewData.setItemAnimator(new DefaultItemAnimator());

    }

    private void initTypeRecycleView() {
        typeBeanList = new ArrayList<TypeBean>();
        Resources resources = getActivity().getResources();
        typeBeanList.add(new TypeBean("号码", resources.getDrawable(R.drawable.icon_num, null), 0));
        typeBeanList.add(new TypeBean("生肖", resources.getDrawable(R.drawable.icon_shengxiao, null), 0));
        typeBeanList.add(new TypeBean("单/双", resources.getDrawable(R.drawable.icon_single, null), 0));
        typeBeanList.add(new TypeBean("大/小", resources.getDrawable(R.drawable.icon_small, null), 0));
        typeBeanList.add(new TypeBean("波色", resources.getDrawable(R.drawable.icon_bonson, null), 0));
        typeBeanList.add(new TypeBean("半波", resources.getDrawable(R.drawable.icon_half_bonson, null), 0));
        typeBeanList.add(new TypeBean("半大/半单", resources.getDrawable(R.drawable.icon_half, null), 0));
        typeBeanList.add(new TypeBean("号码", resources.getDrawable(R.drawable.icon_num, null), 0));
        typeBeanList.add(new TypeBean("你好+1", resources.getDrawable(R.drawable.icon_shengxiao, null), 0));
        typeBeanList.add(new TypeBean("单/双", resources.getDrawable(R.drawable.icon_single, null), 0));
        typeBeanList.add(new TypeBean("大/小", resources.getDrawable(R.drawable.icon_small, null), 0));
        typeBeanList.add(new TypeBean("号码", resources.getDrawable(R.drawable.icon_num, null), 0));
        typeBeanList.add(new TypeBean("你好+1", resources.getDrawable(R.drawable.icon_shengxiao, null), 0));
        typeBeanList.add(new TypeBean("单/双", resources.getDrawable(R.drawable.icon_single, null), 0));
        typeBeanList.add(new TypeBean("大/小", resources.getDrawable(R.drawable.icon_small, null), 0));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 5);
        recyclerViewType.setLayoutManager(gridLayoutManager);
        recyclerViewType.setHasFixedSize(true);
        typeAdapter = new TypeAdapter(getActivity(), typeBeanList);
        recyclerViewType.setAdapter(typeAdapter);
        recyclerViewType.setItemAnimator(new DefaultItemAnimator());

        typeAdapter.setOnRecyclerItemClickListener(new TypeAdapter.OnRecyclerItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(), typeBeanList.get(position).getContent(), Toast.LENGTH_SHORT).show();
            }
        });

    }


}

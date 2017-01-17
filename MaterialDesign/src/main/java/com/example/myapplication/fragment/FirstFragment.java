package com.example.myapplication.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.adapter.TypeAdapter;
import com.example.myapplication.adapter.TypeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vargo on 2017/1/13.
 */

public class FirstFragment extends Fragment {

    private RecyclerView recyclerViewType;
    private RecyclerView recyclerViewData;

    private List<TypeBean> typeBeanList;
    private TypeAdapter typeAdapter;
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

        typeBeanList = new ArrayList<TypeBean>();
        Resources resources = getActivity().getResources();
        typeBeanList.add(new TypeBean("号码", resources.getDrawable(R.drawable.icon_num, null), 0));
        typeBeanList.add(new TypeBean("你好+1", resources.getDrawable(R.drawable.icon_shengxiao, null), 0));
        typeBeanList.add(new TypeBean("单/双", resources.getDrawable(R.drawable.icon_single, null), 0));
        typeBeanList.add(new TypeBean("大/小", resources.getDrawable(R.drawable.icon_small, null), 0));
        typeBeanList.add(new TypeBean("号码", resources.getDrawable(R.drawable.icon_num, null), 0));
        typeBeanList.add(new TypeBean("波色", resources.getDrawable(R.drawable.icon_bonson, null), 0));
        typeBeanList.add(new TypeBean("单/双", resources.getDrawable(R.drawable.icon_single, null), 0));
        typeBeanList.add(new TypeBean("大/小", resources.getDrawable(R.drawable.icon_small, null), 0));
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


        typeAdapter.setOnRecyclerItemClickListener(new TypeAdapter.OnRecyclerItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

//                view.setBackgroundResource(R.drawable.recycle_bg);
                Toast.makeText(getActivity(), typeBeanList.get(position).getContent(), Toast.LENGTH_SHORT).show();
            }
        });

        textInputLayout.setHint("金额(元)");

        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(getActivity(), 2);
        recyclerViewData.setLayoutManager(gridLayoutManager2);
        recyclerViewData.setHasFixedSize(true);
        recyclerViewData.setAdapter(typeAdapter);
    }
}

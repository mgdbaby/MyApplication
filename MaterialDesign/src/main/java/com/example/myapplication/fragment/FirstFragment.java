package com.example.myapplication.fragment;

import android.os.Bundle;
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
    private List<TypeBean> typeBeanList;
    private TypeAdapter typeAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        recyclerViewType = (RecyclerView) view.findViewById(R.id.recyclerViewType);
        return view;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        typeBeanList = new ArrayList<TypeBean>();
        typeBeanList.add(new TypeBean("你好", null, 0));
        typeBeanList.add(new TypeBean("你好+1", null, 0));
        typeBeanList.add(new TypeBean("你好+2", null, 0));
        typeBeanList.add(new TypeBean("你好+3", null, 0));
        typeBeanList.add(new TypeBean("你好+4", null, 0));
        typeBeanList.add(new TypeBean("你好+5", null, 0));
        typeBeanList.add(new TypeBean("你好+6", null, 0));
        typeBeanList.add(new TypeBean("你好+7", null, 0));
        typeBeanList.add(new TypeBean("你好", null, 0));
        typeBeanList.add(new TypeBean("你好+1", null, 0));
        typeBeanList.add(new TypeBean("你好+2", null, 0));
        typeBeanList.add(new TypeBean("你好+3", null, 0));
        typeBeanList.add(new TypeBean("你好+4", null, 0));
        typeBeanList.add(new TypeBean("你好+5", null, 0));
        typeBeanList.add(new TypeBean("你好+6", null, 0));
        typeBeanList.add(new TypeBean("你好+7", null, 0));


        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 4);
        recyclerViewType.setLayoutManager(gridLayoutManager);
        recyclerViewType.setHasFixedSize(true);
        typeAdapter = new TypeAdapter(recyclerViewType.getContext(), typeBeanList);
        recyclerViewType.setAdapter(typeAdapter);


        typeAdapter.setOnRecyclerItemClickListener(new TypeAdapter.OnRecyclerItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(), typeBeanList.get(position).getContent(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

package com.example.myapplication.fragment;

import android.app.Activity;
import android.content.Intent;
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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.activity.DialogSelectNum;
import com.example.myapplication.adapter.DataAdapter;
import com.example.myapplication.adapter.SelectAdapter;
import com.example.myapplication.entity.DataBean;
import com.example.myapplication.entity.SelectDataBean;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vargo on 2017/1/13.
 */

@ContentView(R.layout.fragment_first)
public class FirstFragment extends Fragment {
    //24.6
    @ViewInject(R.id.recyclerViewType)
    private RecyclerView recyclerViewType;
    private List<SelectDataBean> typeBeanList;
    private SelectAdapter typeAdapter;

    @ViewInject(R.id.recyclerViewData)
    private RecyclerView recyclerViewData;
    private List<DataBean> dataBeanList;
    private DataAdapter dataAdapter;

    @ViewInject(R.id.layoutMoneyNum)
    private TextInputLayout textInputLayout;

    @ViewInject(R.id.textTypeData)
    private TextView textTypeData;

    @ViewInject(R.id.editMoneyCount)
    private EditText editMoneyCount;

    private int reCode = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_first, container, false);
//        recyclerViewType = (RecyclerView) view.findViewById(R.id.recyclerViewType);
//        recyclerViewData = (RecyclerView) view.findViewById(R.id.recyclerViewData);
//        textInputLayout = (TextInputLayout) view.findViewById(R.id.layoutMoneyNum);
//        return view;
        return x.view().inject(this, inflater, container);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initTypeRecycleView();
//        initDataRecycleView();

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
        typeBeanList = new ArrayList<SelectDataBean>();
//        typeBeanList = SelectConfig.getTypeList(getActivity());

        Resources resources = getActivity().getResources();
        typeBeanList.add(new SelectDataBean("特码", resources.getDrawable(R.drawable.icon_num, null), 1));
        typeBeanList.add(new SelectDataBean("生肖", resources.getDrawable(R.drawable.icon_shengxiao, null), 1));
        typeBeanList.add(new SelectDataBean("单/双", resources.getDrawable(R.drawable.icon_single, null), 1));
        typeBeanList.add(new SelectDataBean("大/小", resources.getDrawable(R.drawable.icon_big_yellow, null), 1));
        typeBeanList.add(new SelectDataBean("波色", resources.getDrawable(R.drawable.icon_bonson, null), 1));
        typeBeanList.add(new SelectDataBean("半波", resources.getDrawable(R.drawable.icon_half_bonson, null), 1));
        typeBeanList.add(new SelectDataBean("半大/半单", resources.getDrawable(R.drawable.icon_half, null), 1));
        typeBeanList.add(new SelectDataBean("平码", resources.getDrawable(R.drawable.icon_common_num, null), 1));


        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 5);
        recyclerViewType.setLayoutManager(gridLayoutManager);
        recyclerViewType.setHasFixedSize(true);
        typeAdapter = new SelectAdapter(getActivity(), typeBeanList);
        recyclerViewType.setAdapter(typeAdapter);
        recyclerViewType.setItemAnimator(new DefaultItemAnimator());

        typeAdapter.setOnItemClickListener(new SelectAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //交给DialogSelectNum处理，根据不同的请求码返回对应的结果
                Intent intent = new Intent(getActivity(), DialogSelectNum.class);
                intent.putExtra("type", position);
                startActivityForResult(intent, position);
            }
        });

    }

    @Event(R.id.textTypeData)
    private void onClickData(View view){
        if(reCode != -1){
            Intent intent = new Intent(getActivity(), DialogSelectNum.class);
            intent.putExtra("type", reCode);
            startActivityForResult(intent, reCode);
        }
    }

    @Event(R.id.btnAddData)
    private void onClickAddData(View view){
        String dataContent = (String) textTypeData.getText();
        int moneyCount = Integer.parseInt(editMoneyCount.getText().toString());

        Toast.makeText(getActivity(), dataContent + moneyCount, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode != Activity.RESULT_OK){
            return;
        }
        reCode = requestCode;
        String dataString = data.getExtras().getString("type");
        if (requestCode == 7){
            dataString = dataString + "(平)";
        }

        textTypeData.setText(dataString);
    }
}

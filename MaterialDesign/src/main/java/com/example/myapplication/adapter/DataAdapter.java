package com.example.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.entity.DataBean;
import com.example.myapplication.viewholder.BaseViewHolder;

import java.util.List;

/**
 * Created by vargo on 2016/12/14.
 */

public class DataAdapter extends RecyclerView.Adapter<BaseViewHolder> implements View.OnClickListener {
    private List<DataBean> dataBeanList;
    private LayoutInflater inflater;

    private OnRecyclerItemClickListener itemClickListener;

    public DataAdapter(Context context, List<DataBean> dataBeanList) {
        this.dataBeanList = dataBeanList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemCount() {
        return dataBeanList.size();
    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lhc_data_item, parent, false);
        BaseViewHolder holder = new DataInfoViewHolder(view, viewType);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int position) {
        DataInfoViewHolder holder = (DataInfoViewHolder) baseViewHolder;
        holder.dataType.setText(dataBeanList.get(position).getDataType());
        holder.dataMoney.setText(dataBeanList.get(position).getDataMoney());
        holder.itemView.setTag(position);
    }

    class DataInfoViewHolder extends BaseViewHolder {
        TextView dataType;
        TextView dataMoney;

        public DataInfoViewHolder(View view, int viewType) {
            super(view, viewType);
            dataType = (TextView) view.findViewById(R.id.dataType);
            dataMoney = (TextView) view.findViewById(R.id.dataMoney);
        }
    }


    @Override
    public void onClick(View view) {
        if (itemClickListener != null) {
            //注意这里使用getTag方法获取数据
            itemClickListener.onItemClick(view, (Integer) view.getTag());
        }
    }

    //暴露给外面的一个点击接口
    public void setOnRecyclerItemClickListener(OnRecyclerItemClickListener listener) {
        this.itemClickListener = listener;
    }

    public interface OnRecyclerItemClickListener {
        void onItemClick(View view, int position);
    }
}

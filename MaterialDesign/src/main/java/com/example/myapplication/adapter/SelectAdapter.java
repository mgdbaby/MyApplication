package com.example.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.entity.SelectDataBean;
import com.example.myapplication.viewholder.BaseViewHolder;

import java.util.List;

/**
 * Created by vargo on 2016/12/14.
 */

public class SelectAdapter extends RecyclerView.Adapter<BaseViewHolder> implements View.OnClickListener {
    private List<SelectDataBean> selectDataBeenList;
    private LayoutInflater inflater;

    private OnRecyclerItemClickListener itemClickListener;

    public SelectAdapter(Context context, List<SelectDataBean> selectDataBeenList) {
        this.selectDataBeenList = selectDataBeenList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemCount() {
        return selectDataBeenList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return selectDataBeenList.get(position).getSelectType();
    }

    public SelectDataBean getChatBean(int position) {
        SelectDataBean chatBean = null;
        if (selectDataBeenList != null && position < selectDataBeenList.size()) {
            chatBean = selectDataBeenList.get(position);
        }
        return chatBean;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.select_type, parent, false);
        BaseViewHolder holder = new TypeSelectViewHolder(view, viewType);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int position) {
        TypeSelectViewHolder holder = (TypeSelectViewHolder) baseViewHolder;
        holder.typeText.setText(selectDataBeenList.get(position).getContext());
        holder.typeText.setBackground(selectDataBeenList.get(position).getDrawable());
        holder.itemView.setTag(position);
    }

    class TypeSelectViewHolder extends BaseViewHolder {
        TextView typeText;

        public TypeSelectViewHolder(View view, int viewType) {
            super(view, viewType);
            typeText = (TextView) view.findViewById(R.id.itemText);
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

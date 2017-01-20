package com.example.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.entity.DataBean;
import com.example.myapplication.viewholder.BaseViewHolder;

import java.util.List;

/**
 * Created by vargo on 2016/12/14.
 */

public class DataAdapter extends RecyclerView.Adapter<BaseViewHolder> implements View.OnClickListener {
    private List<DataBean> selectDataBeenList;
    private LayoutInflater inflater;

    private OnItemClickListener itemClickListener;

    public DataAdapter(Context context, List<DataBean> selectDataBeenList) {
        this.selectDataBeenList = selectDataBeenList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemCount() {
        return selectDataBeenList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return selectDataBeenList.get(position).getLayoutType();
    }

    public DataBean getChatBean(int position) {
        DataBean chatBean = null;
        if (selectDataBeenList != null && position < selectDataBeenList.size()) {
            chatBean = selectDataBeenList.get(position);
        }
        return chatBean;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        BaseViewHolder holder = null;
        if (viewType == 0){
            view = inflater.inflate(R.layout.select_type, parent, false);
            holder = new SelectNumViewHolder(view, viewType);
        }else if(viewType == 1){
            view = inflater.inflate(R.layout.lhc_type_item, parent, false);
            holder = new SelectOtherViewHolder(view, viewType);
        }
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int position) {
        int viewType = (baseViewHolder == null ? -1 : baseViewHolder.getViewType());

        if(viewType == 0){
            SelectNumViewHolder holder = (SelectNumViewHolder) baseViewHolder;
            holder.typeText.setText(selectDataBeenList.get(position).getContext());
            holder.typeText.setBackground(selectDataBeenList.get(position).getDrawable());
            holder.itemView.setTag(position);
        }else if(viewType == 1){
            SelectOtherViewHolder holder = (SelectOtherViewHolder) baseViewHolder;
            holder.typeText.setText(selectDataBeenList.get(position).getContext());
            holder.typeImage.setImageDrawable(selectDataBeenList.get(position).getDrawable());
            holder.itemView.setTag(position);
        }




    }

    //文字加背景
    public class SelectNumViewHolder extends BaseViewHolder {
        TextView typeText;

        public SelectNumViewHolder(View view, int viewType) {
            super(view, viewType);
            typeText = (TextView) view.findViewById(R.id.itemText);
        }
    }

    //图案加文字
    public class SelectOtherViewHolder extends BaseViewHolder {
        TextView typeText;
        ImageView typeImage;

        public SelectOtherViewHolder(View view, int viewType) {
            super(view, viewType);
            typeText = (TextView) view.findViewById(R.id.itemText);
            typeImage = (ImageView) view.findViewById(R.id.itemImage);
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
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.itemClickListener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}

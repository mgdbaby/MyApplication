package com.example.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.List;

/**
 * Created by vargo on 2016/12/14.
 */

public class TypeAdapter extends RecyclerView.Adapter<BaseViewHolder> implements View.OnClickListener {
    private List<TypeBean> typeBeanList;
    private LayoutInflater inflater;

    private OnRecyclerItemClickListener itemClickListener;

    public TypeAdapter(Context context, List<TypeBean> typeBeanList) {
        this.typeBeanList = typeBeanList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemCount() {
        return typeBeanList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return typeBeanList.get(position).getType();
    }

    public TypeBean getChatBean(int position) {
        TypeBean chatBean = null;
        if (typeBeanList != null && position < typeBeanList.size()) {
            chatBean = typeBeanList.get(position);
        }
        return chatBean;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lhc_type_item, parent, false);
        BaseViewHolder holder = new TypeSelectViewHolder(view, viewType);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int position) {
        TypeSelectViewHolder holder = (TypeSelectViewHolder) baseViewHolder;
        holder.typeText.setText(typeBeanList.get(position).getContent());
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

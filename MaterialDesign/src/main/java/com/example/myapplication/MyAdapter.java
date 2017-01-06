package com.example.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.activity.BaseViewHolder;

import java.util.List;


/**
 * Created by vargo on 2017/1/5.
 */

public class MyAdapter extends RecyclerView.Adapter<BaseViewHolder> implements View.OnClickListener{

    private List<Book> bookList;
    private LayoutInflater inflater;

    private OnRecyclerItemClickListener mItemClickListener;

    public MyAdapter(Context context, List<Book> chatBeenList) {
        this.bookList = chatBeenList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycleview_item, parent, false);

        BaseViewHolder holder = new ChatLeftViewHolder(view);
        view.setOnClickListener(this);

        return holder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int position) {
        ChatLeftViewHolder holder = (ChatLeftViewHolder) baseViewHolder;
        holder.tvTitle.setText(bookList.get(position).getTitle());
        holder.tvContext.setText(bookList.get(position).getContext());
        holder.itemView.setTag(position);
    }

    class ChatLeftViewHolder extends BaseViewHolder {
        TextView tvTitle;
        TextView tvContext;

        public ChatLeftViewHolder(View view) {
            super(view, 0);
            tvTitle = (TextView) view.findViewById(R.id.title);
            tvContext = (TextView) view.findViewById(R.id.context);
        }
    }


    @Override
    public void onClick(View view) {
        if (mItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mItemClickListener.onItemClick(view, (Integer) view.getTag());
        }
    }
    /**
     * 暴露给外面的一个点击接口
     */
    public void setOnRecyclerItemClickListener(OnRecyclerItemClickListener listener) {
        this.mItemClickListener = listener;
    }

    public interface OnRecyclerItemClickListener {
        void onItemClick(View view, int position);
    }
}

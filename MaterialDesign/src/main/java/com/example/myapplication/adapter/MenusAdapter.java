//package com.example.myapplication.adapter;
//
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import com.example.myapplication.R;
//import com.example.myapplication.entity.DataListBean;
//import com.yanzhenjie.recyclerview.swipe.SwipeMenuAdapter;
//
//import java.util.List;
//
///**
// * Created by vargo on 2017/1/20.
// */
//
//public class MenusAdapter extends SwipeMenuAdapter<MenusAdapter.DataInfoViewHolder>{
//    private List<DataListBean> dataBeanList;
//    private OnItemClickListener onItemClickListener;
//
//    public MenusAdapter(List<DataListBean> dataBeanList) {
//        this.dataBeanList = dataBeanList;
//    }
//
//    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
//        this.onItemClickListener = onItemClickListener;
//    }
//    @Override
//    public View onCreateContentView(ViewGroup parent, int viewType) {
//        return LayoutInflater.from(parent.getContext()).inflate(R.layout.lhc_data_item, parent, false);
//    }
//
//    @Override
//    public DataInfoViewHolder onCompatCreateViewHolder(View realContentView, int viewType) {
//        return new DataInfoViewHolder(realContentView);
//    }
//
//    @Override
//    public void onBindViewHolder(DataInfoViewHolder holder, int position) {
//        holder.setTextData(dataBeanList.get(position).getData());
//        holder.setTextMoney(String.valueOf(dataBeanList.get(position).getMoney()));
//        holder.setOnItemClickListener(onItemClickListener);
//    }
//
//    @Override
//    public int getItemCount() {
//        return dataBeanList == null ? 0 : dataBeanList.size();
//    }
//
//
//    public class DataInfoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
//        TextView textData;
//        TextView textMoney;
//        OnItemClickListener onItemClickListener;
//
//        public DataInfoViewHolder(View view) {
//            super(view);
//            view.setOnClickListener(this);
//            textData = (TextView) view.findViewById(R.id.textData);
//            textMoney = (TextView) view.findViewById(R.id.textMoney);
//        }
//
//        public void setTextData(String textData) {
//            this.textData.setText(textData);
//        }
//
//        public void setTextMoney(String textMoney) {
//            this.textMoney.setText(textMoney);
//        }
//
//        @Override
//        public void onClick(View view) {
//            if(onItemClickListener != null){
//                onItemClickListener.onItemClick(getAdapterPosition());
//            }
//        }
//
//        public void setOnItemClickListener(OnItemClickListener onItemClickListener){
//            this.onItemClickListener = onItemClickListener;
//        }
//    }
//
//    public interface OnItemClickListener {
//
//        void onItemClick(int position);
//
//    }
//}

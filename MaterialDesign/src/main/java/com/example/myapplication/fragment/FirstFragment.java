package com.example.myapplication.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.LConfig;
import com.example.myapplication.R;
import com.example.myapplication.activity.DialogSelectNum;
import com.example.myapplication.adapter.DataAdapter;
import com.example.myapplication.adapter.DataListAdapter;
import com.example.myapplication.entity.DataBean;
import com.example.myapplication.entity.DataListBean;
import com.example.myapplication.widget.ItemRemoveRecyclerView;
import com.example.myapplication.widget.OnItemClickListener;

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
    private List<DataBean> dataList;
    private DataAdapter dataAdapter;

    @ViewInject(R.id.recyclerViewData)
    private ItemRemoveRecyclerView recyclerViewData;
    private List<DataListBean> dataBeanList;
    private DataListAdapter dataListAdapter;

    @ViewInject(R.id.layoutMoneyNum)
    private TextInputLayout textInputLayout;

    @ViewInject(R.id.textTypeData)
    private TextView textTypeData;

    @ViewInject(R.id.editMoneyCount)
    private EditText editMoneyCount;

    @ViewInject(R.id.textSubtotal)
    private TextView textSubtotal;

    private int reCode = -1;

//    private MenusAdapter menuAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return x.view().inject(this, inflater, container);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initTypeRecycleView();
        initDataRecycleView();

        textInputLayout.setHint(LConfig.TIP_MONEY);
    }

    private void initDataRecycleView() {
        dataBeanList = new ArrayList<DataListBean>();
        dataBeanList.add(new DataListBean("fdsf", 60, 7));
        dataBeanList.add(new DataListBean("fdsf", 80, 7));

        recyclerViewData.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        dataListAdapter = new DataListAdapter(getActivity(), dataBeanList);
        recyclerViewData.setHasFixedSize(true);
        recyclerViewData.setAdapter(dataListAdapter);
        recyclerViewData.setItemAnimator(new DefaultItemAnimator());

        recyclerViewData.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(), position + "", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDeleteClick(int position) {
                Toast.makeText(getActivity(), position + "", Toast.LENGTH_SHORT).show();
            }
        });

//        dataListAdapter.setOnItemClickListener(new DataListAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                Toast.makeText(getActivity(), position + "", Toast.LENGTH_SHORT).show();
//                textTypeData.setText(dataBeanList.get(position).getData());
//                editMoneyCount.setText(dataBeanList.get(position).getMoney()+"");
//                reCode = dataBeanList.get(position).getType();
//            }
//        });

        // 为SwipeRecyclerView的Item创建菜单就两句话，不错就是这么简单：
        // 设置菜单创建器。
//        recyclerViewData.setSwipeMenuCreator(swipeMenuCreator);
//        // 设置菜单Item点击监听。
//        recyclerViewData.setSwipeMenuItemClickListener(menuItemClickListener);
//
//        menuAdapter = new MenusAdapter( dataBeanList);
//        menuAdapter.setOnItemClickListener(new MenusAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(int position) {
//                Toast.makeText(getActivity(), position, Toast.LENGTH_SHORT).show();
//            }
//        });
//        recyclerViewData.setAdapter(menuAdapter);
//
//        recyclerViewData.setLongPressDragEnabled(true);// 开启拖拽，就这么简单一句话。
//        recyclerViewData.setOnItemMoveListener(onItemMoveListener);// 监听拖拽，更新UI。

    }

    private void initTypeRecycleView() {
        dataList = new ArrayList<DataBean>();

        Resources resources = getActivity().getResources();
        dataList.add(new DataBean(LConfig.TYPE_SPECIAL_NUM, resources.getDrawable(R.drawable.icon_num, null), 1));
        dataList.add(new DataBean(LConfig.TYPE_ZODIAC, resources.getDrawable(R.drawable.icon_shengxiao, null), 1));
        dataList.add(new DataBean(LConfig.TYPE_SINGLE_DOUBLE, resources.getDrawable(R.drawable.icon_single, null), 1));
        dataList.add(new DataBean(LConfig.TYPE_BIG_SMALL, resources.getDrawable(R.drawable.icon_big_yellow, null), 1));
        dataList.add(new DataBean(LConfig.TYPE_BALL_COLOR, resources.getDrawable(R.drawable.icon_bonson, null), 1));
        dataList.add(new DataBean(LConfig.TYPE_HALF_BALL, resources.getDrawable(R.drawable.icon_half_bonson, null), 1));
        dataList.add(new DataBean(LConfig.TYPE_HALF_BIG, resources.getDrawable(R.drawable.icon_half, null), 1));
        dataList.add(new DataBean(LConfig.TYPE_COMMON_NUM, resources.getDrawable(R.drawable.icon_common_num, null), 1));


        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 5);
        recyclerViewType.setLayoutManager(gridLayoutManager);
        recyclerViewType.setHasFixedSize(true);
        dataAdapter = new DataAdapter(getActivity(), dataList);
        recyclerViewType.setAdapter(dataAdapter);
        recyclerViewType.setItemAnimator(new DefaultItemAnimator());

        dataAdapter.setOnItemClickListener(new DataAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //交给DialogSelectNum处理，根据不同的请求码返回对应的结果
                Intent intent = new Intent(getActivity(), DialogSelectNum.class);
                intent.putExtra("type", position);
                startActivityForResult(intent, position);
            }
        });

    }

    //类型框
    @Event(R.id.textTypeData)
    private void onClickData(View view){
        if(reCode != -1){
            Intent intent = new Intent(getActivity(), DialogSelectNum.class);
            intent.putExtra("type", reCode);
            startActivityForResult(intent, reCode);
        }
    }

    //添加
    @Event(R.id.btnAddData)
    private void onClickAddData(View view){
        String dataContent = textTypeData.getText().toString();
        String moneyCount = editMoneyCount.getText().toString();

        if(TextUtils.isEmpty(dataContent)){
            Toast.makeText(getActivity(), LConfig.TIP_TYPE_NOTNULL, Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(moneyCount)){
            Toast.makeText(getActivity(), LConfig.TIP_MONEY_NOTNULL, Toast.LENGTH_SHORT).show();
            return;
        }
        textTypeData.setText("");
        editMoneyCount.clearFocus();
        closeInputMethod();

        dataBeanList.add(new DataListBean(dataContent, Integer.parseInt(moneyCount), reCode));
        addContent();

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
            dataString = dataString + LConfig.TIP_PING;
        }

        textTypeData.setText(dataString);
    }

//    notifyItemChanged(int position) 更新列表position位置上的数据可以调用
//    notifyItemInserted(int position) 列表position位置添加一条数据时可以调用，伴有动画效果
//    notifyItemRemoved(int position) 列表position位置移除一条数据时调用，伴有动画效果
//    notifyItemMoved(int fromPosition, int toPosition) 列表fromPosition位置的数据移到toPosition位置时调用，伴有动画效果
//    notifyItemRangeChanged(int positionStart, int itemCount) 列表从positionStart位置到itemCount数量的列表项进行数据刷新
//    notifyItemRangeInserted(int positionStart, int itemCount) 列表从positionStart位置到itemCount数量的列表项批量添加数据时调用，伴有动画效果
//    notifyItemRangeRemoved(int positionStart, int itemCount) 列表从positionStart位置到itemCount数量的列表项批量删除数据时调用，伴有动画效果

    //添加数据
    private void addContent(){
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                dataListAdapter.notifyItemInserted(dataBeanList.size() - 1);
                int pos = (dataBeanList == null ? -1 : dataBeanList.size() - 1);
                if (pos % 2 == 0) {
                    recyclerViewData.scrollToPosition(pos);
                }else {
                    recyclerViewData.scrollToPosition(pos - 1);
                }
                textSubtotal.setText(LConfig.TIP_SUBTOTAL + getSubtotal(dataBeanList));
            }
        });
    }


    //隐藏输入法的方法
    private void closeInputMethod() {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        boolean isOpen = imm.isActive();
        if (isOpen) {
            // imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);//没有显示则显示
            imm.hideSoftInputFromWindow(editMoneyCount.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    //小计
    private int getSubtotal(List<DataListBean> list){
        int count = 0 ;

        if(list == null){
            return  0;
        }else {
            for(int i = 0; i < list.size(); i++){
                count = count + list.get(i).getMoney();
            }
        }
        return count;
    }

//    /**
//     * 当Item移动的时候。
//     */
//    private OnItemMoveListener onItemMoveListener = new OnItemMoveListener() {
//        @Override
//        public boolean onItemMove(int fromPosition, int toPosition) {
//            Collections.swap(dataBeanList, fromPosition, toPosition);
//            menuAdapter.notifyItemMoved(fromPosition, toPosition);
//            return true;// 返回true表示处理了，返回false表示你没有处理。
//        }
//
//        @Override
//        public void onItemDismiss(int position) {
//            // 当Item被滑动删除掉的时候，在这里是无效的，因为这里没有启用这个功能。
//            // 使用Menu时就不用使用这个侧滑删除啦，两个是冲突的。
//        }
//    };
//
//
//    /**
//     * 菜单创建器。
//     */
//    private SwipeMenuCreator swipeMenuCreator = new SwipeMenuCreator() {
//        @Override
//        public void onCreateMenu(SwipeMenu swipeLeftMenu, SwipeMenu swipeRightMenu, int viewType) {
//            int width = 200;
//
//            // MATCH_PARENT 自适应高度，保持和内容一样高；也可以指定菜单具体高度，也可以用WRAP_CONTENT。
//            int height = ViewGroup.LayoutParams.MATCH_PARENT;
//
//            // 添加右侧的，如果不添加，则右侧不会出现菜单。
//            {
//                SwipeMenuItem deleteItem = new SwipeMenuItem(getActivity())
//                        .setBackgroundDrawable(R.drawable.selector_red)
//                        .setText("删除") // 文字，还可以设置文字颜色，大小等。。
//                        .setTextColor(Color.WHITE)
//                        .setWidth(width)
//                        .setHeight(height);
//                swipeRightMenu.addMenuItem(deleteItem);// 添加一个按钮到右侧侧菜单。
//            }
//        }
//    };
//
//
//    /**
//     * 菜单点击监听。
//     */
//    private OnSwipeMenuItemClickListener menuItemClickListener = new OnSwipeMenuItemClickListener() {
//
//        @Override
//        public void onItemClick(Closeable closeable, int adapterPosition, int menuPosition, int direction) {
//            closeable.smoothCloseMenu();// 关闭被点击的菜单。
//
//            if (direction == SwipeMenuRecyclerView.RIGHT_DIRECTION) {
//                Toast.makeText(getActivity(), "list第" + adapterPosition + "; 右侧菜单第" + menuPosition, Toast.LENGTH_SHORT).show();
//            } else if (direction == SwipeMenuRecyclerView.LEFT_DIRECTION) {
//                Toast.makeText(getActivity(), "list第" + adapterPosition + "; 左侧菜单第" + menuPosition, Toast.LENGTH_SHORT).show();
//            }
//        }
//    };

}

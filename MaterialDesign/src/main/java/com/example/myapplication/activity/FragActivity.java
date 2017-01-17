package com.example.myapplication.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.fragment.FirstFragment;
import com.example.myapplication.fragment.SecondFragment;
import com.example.myapplication.fragment.ThirdFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;


/**
 * Created by vargo on 2017/1/15.
 */

@ContentView(R.layout.fragment_main)
public class FragActivity extends FragmentActivity {
    @ViewInject(R.id.firstImage)
    private ImageView firstImage;

    @ViewInject(R.id.secondImage)
    private ImageView secondImage;

    @ViewInject(R.id.thirdImage)
    private ImageView thirdImage;

    @ViewInject(R.id.textFirst)
    private TextView textFirst;

    @ViewInject(R.id.textSecond)
    private TextView textSecond;

    @ViewInject(R.id.textThird)
    private TextView textThird;

    @ViewInject(R.id.currentTime)
    private TextView currentTime;

    private Fragment fragmentFirst;
    private Fragment fragmentSecond;
    private Fragment fragmentThird;

    @ViewInject(R.id.id_drawer_layout)
    private DrawerLayout drawerLayout;

    @ViewInject(R.id.id_nv_menu)
    private NavigationView navigationView;

    private long sysTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        //第一种
//        StatusBarUtil.setColorForDrawerLayout(this, drawerLayout, 133);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);// 透明导航栏
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        //第二种
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
//            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
//            if(Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP){
//                //将侧边栏顶部延伸至status bar
//                drawerLayout.setFitsSystemWindows(true);
//                //将主页面顶部延伸至status bar;虽默认为false,但经测试,DrawerLayout需显示设置
//                drawerLayout.setClipToPadding(false);
//            }
//        }
        initDrawer();
        setSelect(0);

        setCurrentTime();
        new TimeThread().start(); //启动新的线程
    }


    @Event(R.id.firstTab)
    private void onFirstTab(View view) {
        setSelect(0);
    }

    @Event(R.id.secondTab)
    private void onSecondTab(View view) {
        setSelect(1);
    }

    @Event(R.id.thirdTab)
    private void onThirdTab(View view) {
        setSelect(2);
    }

    private void initDrawer() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            private MenuItem mPreMenuItem;
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                if (mPreMenuItem != null) mPreMenuItem.setChecked(false);
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                mPreMenuItem = menuItem;
                return true;
            }
        });
    }

    //切换fragment的方法
    private void setSelect(int position) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragment(transaction);
        resetImg();

        switch (position) {
            case 0:
                if(fragmentFirst != null){
                    transaction.show(fragmentFirst);
                }else {
                    fragmentFirst = new FirstFragment();
                    transaction.add(R.id.frameLayout, fragmentFirst);
                }
                firstImage.setImageResource(R.drawable.bottom_add_green);
                textFirst.setTextColor(ContextCompat.getColor(this, R.color.primaryColor));
                break;
            case 1:
                if(fragmentSecond != null){
                    transaction.show(fragmentSecond);
                }else {
                    fragmentSecond = new SecondFragment();
                    transaction.add(R.id.frameLayout, fragmentSecond);
                }
                secondImage.setImageResource(R.drawable.bottom_form_green);
                textSecond.setTextColor(ContextCompat.getColor(this, R.color.primaryColor));
                break;
            case 2:
                if(fragmentThird != null){
                    transaction.show(fragmentThird);
                }else {
                    fragmentThird = new ThirdFragment();
                    transaction.add(R.id.frameLayout, fragmentThird);
                }
                thirdImage.setImageResource(R.drawable.bottom_forecast_green);
                textThird.setTextColor(ContextCompat.getColor(this, R.color.primaryColor));
                break;
            default:
                break;
        }
        transaction.commit();
    }


    //将所有图片切换成非选择色
    private void resetImg() {
        firstImage.setImageResource(R.drawable.bottom_add_gray);
        secondImage.setImageResource(R.drawable.bottom_form_gray);
        thirdImage.setImageResource(R.drawable.bottom_forecast_gray);

        textFirst.setTextColor(ContextCompat.getColor(this, R.color.tab_gray));
        textSecond.setTextColor(ContextCompat.getColor(this, R.color.tab_gray));
        textThird.setTextColor(ContextCompat.getColor(this, R.color.tab_gray));
    }

    //隐藏fragment
    private void hideFragment(FragmentTransaction transaction) {
        if (fragmentFirst != null) {
            transaction.hide(fragmentFirst);
        }
        if (fragmentSecond != null) {
            transaction.hide(fragmentSecond);
        }
        if (fragmentThird != null) {
            transaction.hide(fragmentThird);
        }
    }


    class TimeThread extends Thread {
        @Override
        public void run() {
            do {
                try {
                    Thread.sleep(60000);
                    Message msg = new Message();
                    msg.what = 1;  //消息(一个整型值)
                    mHandler.sendMessage(msg);// 每隔1秒发送一个msg给mHandler
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (true);
        }
    }

    //在主线程里面处理消息并更新UI界面
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    setCurrentTime();
                    break;
                default:
                    break;
            }
        }
    };

    private void setCurrentTime(){
        sysTime = System.currentTimeMillis();
        CharSequence sysTimeStr = DateFormat.format("yyyy-MM-dd HH:mm", sysTime);
        currentTime.setText(sysTimeStr); //更新时间
    }
}

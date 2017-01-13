package com.example.myapplication.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.fragment.FirstFragment;
import com.example.myapplication.fragment.SecondFragment;
import com.example.myapplication.fragment.ThirdFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.drawerlayout_test)
public class MainActivity extends FragmentActivity {
    @ViewInject(R.id.firstImage)
    private ImageView firstImage;

    @ViewInject(R.id.secondImage)
    private ImageView secondImage;

    @ViewInject(R.id.thirdImage)
    private ImageView thirdImage;

    @ViewInject(R.id.firstImageSelect)
    private ImageView firstImageSelect;

    @ViewInject(R.id.secondImageSelect)
    private ImageView secondImageSelect;

    @ViewInject(R.id.thirdImageSelect)
    private ImageView thirdImageSelect;

    @ViewInject(R.id.textFirst)
    private TextView textFirst;

    @ViewInject(R.id.textSecond)
    private TextView textSecond;

    @ViewInject(R.id.textThird)
    private TextView textThird;

    @ViewInject(R.id.textFirstSelect)
    private TextView textFirstSelect;

    @ViewInject(R.id.textSecondSelect)
    private TextView textSecondSelect;

    @ViewInject(R.id.textThirdSelect)
    private TextView textThirdSelect;

    @ViewInject(R.id.viewPager)
    private ViewPager viewPager;
    private FragmentPagerAdapter fragmentPagerAdapter;

    private List<Fragment> fragmentList;
    private List<ImageView> imageViewList;
    private List<TextView> textViewList;

    private int cutIndex;   //当前菜单索引

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        initView();
//        setSelect(0);

        initDrawer();
    }

    private void initDrawer() {
        drawerLayout = (DrawerLayout) findViewById(R.id.id_drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.id_nv_menu);
        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.content_relative);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, null, R.string.open, R.string.close){
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                WindowManager windowManager= (WindowManager) getSystemService(getApplicationContext().WINDOW_SERVICE);
                Display display=windowManager.getDefaultDisplay();
                linearLayout.layout(navigationView.getRight(), 0, display.getWidth()+navigationView.getRight(), display.getHeight());
                super.onDrawerSlide(drawerView, slideOffset);
            }
        };
        drawerLayout.setDrawerListener(drawerToggle);

        navigationView = (NavigationView) findViewById(R.id.id_nv_menu);

        setupDrawerContent(navigationView);
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

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        drawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    private void initView() {
        fragmentList = new ArrayList<Fragment>();
        imageViewList = new ArrayList<ImageView>();
        textViewList = new ArrayList<TextView>();

        Fragment firstFragment = new FirstFragment();
        Fragment secondFragment = new SecondFragment();
        Fragment thirdFragment = new ThirdFragment();

        fragmentList.add(firstFragment);
        fragmentList.add(secondFragment);
        fragmentList.add(thirdFragment);

        imageViewList.add(firstImage);
        imageViewList.add(firstImageSelect);
        imageViewList.add(secondImage);
        imageViewList.add(secondImageSelect);
        imageViewList.add(thirdImage);
        imageViewList.add(thirdImageSelect);

        textViewList.add(textFirst);
        textViewList.add(textFirstSelect);
        textViewList.add(textSecond);
        textViewList.add(textSecondSelect);
        textViewList.add(textThird);
        textViewList.add(textThirdSelect);

        fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        };
        viewPager.setAdapter(fragmentPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(positionOffset > 0){
                    colorChange(position, position + 1, positionOffset);
                }
            }

            @Override
            public void onPageSelected(int position) {
                cutIndex = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        firstImage.setAlpha(0f);
        textFirst.setAlpha(0f);
        secondImageSelect.setAlpha(0f);
        textSecondSelect.setAlpha(0f);
        thirdImageSelect.setAlpha(0f);
        textThirdSelect.setAlpha(0f);
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

    public void setSelect(int position) {
        if(cutIndex != position){
            colorChange(position, cutIndex, 0);
            viewPager.setCurrentItem(position, false);
        }
    }

    /**
     *
     * @param srcIndex 失去焦点的索引
     * @param destIndex 选中的索引
     * @param ratio 透明的比例
     */
    private void colorChange(int srcIndex, int destIndex, float ratio) {
        imageViewList.get(srcIndex * 2).setAlpha(ratio);
        imageViewList.get(srcIndex * 2 + 1).setAlpha(1 - ratio);
        imageViewList.get(destIndex * 2).setAlpha(1 - ratio);
        imageViewList.get(destIndex * 2 + 1).setAlpha(ratio);

        textViewList.get(srcIndex * 2).setAlpha(ratio);
        textViewList.get(srcIndex * 2 + 1).setAlpha(1 - ratio);
        textViewList.get(destIndex * 2).setAlpha(1 - ratio);
        textViewList.get(destIndex * 2 + 1).setAlpha(ratio);
    }


//    public void setSelect(int i) {
//        setTab(i);
//        viewPager.setCurrentItem(i);
//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                //首先拿到界面，在判断是第几个界面
//                int currentItem = viewPager.getCurrentItem();
//                setTab(currentItem);
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//            }
//        });
//    }
//
//    //切换Tab颜色
//    private void setTab(int position) {
//        firstImage.setImageResource(R.drawable.ic_tab_msg);
//        secondImage.setImageResource(R.drawable.ic_tab_contact);
//        thirdImage.setImageResource(R.drawable.ic_tab_moments);
//
//        switch (position) {
//            case 0:
//                firstImage.setImageResource(R.drawable.ic_tab_msg_h);
//                break;
//            case 1:
//                secondImage.setImageResource(R.drawable.ic_tab_contact_h);
//                break;
//            case 2:
//                thirdImage.setImageResource(R.drawable.ic_tab_moments_h);
//                break;
//            default:
//                break;
//        }
//    }

}

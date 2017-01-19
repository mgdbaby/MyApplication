package com.example.myapplication;

import android.content.Context;
import android.content.res.Resources;

import com.example.myapplication.entity.SelectDataBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vargo on 2017/1/19.
 */

public class SelectConfig {

    public static List<SelectDataBean> selectDataBeanList = new ArrayList<>();

    //首页获取类型list
    public static List<SelectDataBean> getTypeList(Context context){
        if(selectDataBeanList != null && selectDataBeanList.size() > 0){
            selectDataBeanList.clear();
        }
        Resources resources = context.getResources();
        selectDataBeanList.add(new SelectDataBean("特码", resources.getDrawable(R.drawable.icon_num, null), 1));
        selectDataBeanList.add(new SelectDataBean("生肖", resources.getDrawable(R.drawable.icon_shengxiao, null), 1));
        selectDataBeanList.add(new SelectDataBean("单/双", resources.getDrawable(R.drawable.icon_single, null), 1));
        selectDataBeanList.add(new SelectDataBean("大/小", resources.getDrawable(R.drawable.icon_big_yellow, null), 1));
        selectDataBeanList.add(new SelectDataBean("波色", resources.getDrawable(R.drawable.icon_bonson, null), 1));
        selectDataBeanList.add(new SelectDataBean("半波", resources.getDrawable(R.drawable.icon_half_bonson, null), 1));
        selectDataBeanList.add(new SelectDataBean("半大/半单", resources.getDrawable(R.drawable.icon_half, null), 1));
        selectDataBeanList.add(new SelectDataBean("平码", resources.getDrawable(R.drawable.icon_common_num, null), 1));

        return selectDataBeanList;
    }



    //数字列表
    public static List<SelectDataBean> getNumList(Context context){
        if(selectDataBeanList != null && selectDataBeanList.size() > 0){
            selectDataBeanList.clear();
        }
        String num = null;
        int color;
        for (int i = 1; i <= 49; i++) {
            if (i < 10) {
                num = "0" + i;
            } else {
                num = "" + i;
            }
            if (i == 1 || i == 2 || i == 7 || i == 8 || i == 12 || i == 13 || i == 18 || i == 19 || i == 23 || i == 24 || i == 29 || i == 30 || i == 34 || i == 35 || i == 40 || i == 45 || i == 46) {
                color = R.drawable.shape_red;
            } else if (i == 3 || i == 4 || i == 9 || i == 10 || i == 14 || i == 15 || i == 20 || i == 25 || i == 26 || i == 31 || i == 36 || i == 37 || i == 41 || i == 42 || i == 47 || i == 48) {
                color = R.drawable.shape_blue;
            } else {
                color = R.drawable.shape_green;
            }
            selectDataBeanList.add(new SelectDataBean(num, context.getResources().getDrawable(color, null), 0));
        }
        return selectDataBeanList;
    }

    //生肖
    public static List<SelectDataBean> getZodiacList(Context context){
        if(selectDataBeanList != null && selectDataBeanList.size() > 0){
            selectDataBeanList.clear();
        }
        Resources resources = context.getResources();
        selectDataBeanList.add(new SelectDataBean("鼠", resources.getDrawable(R.drawable.icon_num, null), 1));
        selectDataBeanList.add(new SelectDataBean("牛", resources.getDrawable(R.drawable.icon_shengxiao, null), 1));
        selectDataBeanList.add(new SelectDataBean("虎", resources.getDrawable(R.drawable.icon_single, null), 1));
        selectDataBeanList.add(new SelectDataBean("兔", resources.getDrawable(R.drawable.icon_big_yellow, null), 1));
        selectDataBeanList.add(new SelectDataBean("龙", resources.getDrawable(R.drawable.icon_bonson, null), 1));
        selectDataBeanList.add(new SelectDataBean("蛇", resources.getDrawable(R.drawable.icon_half_bonson, null), 1));
        selectDataBeanList.add(new SelectDataBean("马", resources.getDrawable(R.drawable.icon_num, null), 1));
        selectDataBeanList.add(new SelectDataBean("羊", resources.getDrawable(R.drawable.icon_shengxiao, null), 1));
        selectDataBeanList.add(new SelectDataBean("猴", resources.getDrawable(R.drawable.icon_single, null), 1));
        selectDataBeanList.add(new SelectDataBean("鸡", resources.getDrawable(R.drawable.icon_big_yellow, null), 1));
        selectDataBeanList.add(new SelectDataBean("狗", resources.getDrawable(R.drawable.icon_bonson, null), 1));
        selectDataBeanList.add(new SelectDataBean("猪", resources.getDrawable(R.drawable.icon_half_bonson, null), 1));

        return  selectDataBeanList;
    }

    //单双
    public static List<SelectDataBean> getSingleOrDoubleList(Context context){
        if(selectDataBeanList != null && selectDataBeanList.size() > 0){
            selectDataBeanList.clear();
        }
        Resources resources = context.getResources();
        selectDataBeanList.add(new SelectDataBean("单", resources.getDrawable(R.drawable.icon_single_blue, null), 1));
        selectDataBeanList.add(new SelectDataBean("双", resources.getDrawable(R.drawable.icon_double_blue, null), 1));

        return  selectDataBeanList;
    }

    //大小
    public static List<SelectDataBean> getBigOrSmallList(Context context){
        if(selectDataBeanList != null && selectDataBeanList.size() > 0){
            selectDataBeanList.clear();
        }
        Resources resources = context.getResources();
        selectDataBeanList.add(new SelectDataBean("大", resources.getDrawable(R.drawable.icon_big_red, null), 1));
        selectDataBeanList.add(new SelectDataBean("小", resources.getDrawable(R.drawable.icon_small, null), 1));

        return  selectDataBeanList;
    }

    //波色
    public static List<SelectDataBean> getBallColorList(Context context){
        if(selectDataBeanList != null && selectDataBeanList.size() > 0){
            selectDataBeanList.clear();
        }
        Resources resources = context.getResources();
        selectDataBeanList.add(new SelectDataBean("红波", resources.getDrawable(R.drawable.icon_red_ball, null), 1));
        selectDataBeanList.add(new SelectDataBean("蓝波", resources.getDrawable(R.drawable.icon_blue_ball, null), 1));
        selectDataBeanList.add(new SelectDataBean("绿波", resources.getDrawable(R.drawable.icon_green_ball, null), 1));

        return  selectDataBeanList;
    }

    //半波色
    public static List<SelectDataBean> getHalfBallColorList(Context context){
        if(selectDataBeanList != null && selectDataBeanList.size() > 0){
            selectDataBeanList.clear();
        }
        Resources resources = context.getResources();
        selectDataBeanList.add(new SelectDataBean("红单", resources.getDrawable(R.drawable.icon_num, null), 1));
        selectDataBeanList.add(new SelectDataBean("红双", resources.getDrawable(R.drawable.icon_shengxiao, null), 1));
        selectDataBeanList.add(new SelectDataBean("蓝单", resources.getDrawable(R.drawable.icon_shengxiao, null), 1));
        selectDataBeanList.add(new SelectDataBean("蓝双", resources.getDrawable(R.drawable.icon_num, null), 1));
        selectDataBeanList.add(new SelectDataBean("绿单", resources.getDrawable(R.drawable.icon_shengxiao, null), 1));
        selectDataBeanList.add(new SelectDataBean("绿双", resources.getDrawable(R.drawable.icon_shengxiao, null), 1));

        return  selectDataBeanList;
    }

    //半大小、半单双
    public static List<SelectDataBean> getHalfList(Context context){
        if(selectDataBeanList != null && selectDataBeanList.size() > 0){
            selectDataBeanList.clear();
        }
        Resources resources = context.getResources();
        selectDataBeanList.add(new SelectDataBean("大单", resources.getDrawable(R.drawable.icon_num, null), 1));
        selectDataBeanList.add(new SelectDataBean("大双", resources.getDrawable(R.drawable.icon_shengxiao, null), 1));
        selectDataBeanList.add(new SelectDataBean("小单", resources.getDrawable(R.drawable.icon_shengxiao, null), 1));
        selectDataBeanList.add(new SelectDataBean("小双", resources.getDrawable(R.drawable.icon_num, null), 1));
        return  selectDataBeanList;
    }


}

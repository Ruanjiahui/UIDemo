package com.example.administrator.ui_sdk.MyBaseActivity;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.ui_sdk.DensityUtil;
import com.example.administrator.ui_sdk.R;

/**
 * Created by Administrator on 2016/3/10.
 * <p/>
 * 这个是一个拥有导航栏的Activity这个是继承BaseActivity
 * 不但拥有最基础的标题栏还有拥有自己的导航栏
 */
public abstract class NavActivity extends BaseActivity {

    private Activity activity = null;
    private Context context = null;

    private View view = null;
    private LinearLayout nav_nav = null;
    private LinearLayout nav_contentView = null;
    private View NavView = null;

    //以下就是默认导航的组件
    private RelativeLayout nav1, nav2, nav3, nav4 = null;
    private ImageView nav_1_image, nav_2_image, nav_3_image, nav_4_image = null;
    private TextView nav_1_text, nav_2_text, nav_3_text, nav_4_text = null;
    private LinearLayout nav_origin1_linear1, nav_origin2_linear2, nav_origin3_linear3, nav_origin4_linear4 = null;
    private LinearLayout nav_main = null;


    /**
     * 这个方式实现将导航的布局文件添加到指定的布局当中
     *
     * @param resid
     */
    public void setNav(int resid) {
        if (resid != 0) {
            //将标题栏的布局显示出来
            nav_nav.setVisibility(View.VISIBLE);
            //移除nav_nav的所有组件
            nav_nav.removeAllViews();
            //设置默认高度
            setNavHeight(nav_nav, BaseActivity.height / 12);
            //获取nav这个布局
            NavView = LayoutInflater.from(context).inflate(R.layout.nav, null);

            //判断是不是默认的导航栏
            if (resid == R.layout.nav) {
                setNavColor(android.R.color.transparent);

                nav1 = (RelativeLayout) NavView.findViewById(R.id.nav1);
                nav2 = (RelativeLayout) NavView.findViewById(R.id.nav2);
                nav3 = (RelativeLayout) NavView.findViewById(R.id.nav3);
                nav4 = (RelativeLayout) NavView.findViewById(R.id.nav4);
                nav_1_image = (ImageView) NavView.findViewById(R.id.nav_1_image);
                nav_2_image = (ImageView) NavView.findViewById(R.id.nav_2_image);
                nav_3_image = (ImageView) NavView.findViewById(R.id.nav_3_image);
                nav_4_image = (ImageView) NavView.findViewById(R.id.nav_4_image);
                nav_1_text = (TextView) NavView.findViewById(R.id.nav_1_text);
                nav_2_text = (TextView) NavView.findViewById(R.id.nav_2_text);
                nav_3_text = (TextView) NavView.findViewById(R.id.nav_3_text);
                nav_4_text = (TextView) NavView.findViewById(R.id.nav_4_text);
                nav_origin1_linear1 = (LinearLayout) NavView.findViewById(R.id.nav_origin1_linear1);
                nav_origin2_linear2 = (LinearLayout) NavView.findViewById(R.id.nav_origin2_linear2);
                nav_origin3_linear3 = (LinearLayout) NavView.findViewById(R.id.nav_origin3_linear3);
                nav_origin4_linear4 = (LinearLayout) NavView.findViewById(R.id.nav_origin4_linear4);
                nav_main = (LinearLayout) NavView.findViewById(R.id.nav_main);


                nav1.setOnClickListener(this);
                nav2.setOnClickListener(this);
                nav3.setOnClickListener(this);
                nav4.setOnClickListener(this);
                //这个是设置导航的宽高度
                DensityUtil.setLinearSize(nav_main, BaseActivity.width, BaseActivity.height / 12);

            }

            nav_nav.addView(NavView);
        }
    }

    @Override
    public void Click(View v) {
        NavClick(v);
    }


    /**
     * 这个是四个导航的点击事件
     * 这个是抽象方法不需要在主类实现
     *
     * @param v
     */
    public abstract void NavClick(View v);

    /**
     * 这个也是一个抽象的方法不需要主类实现
     * 这个是程序的初始化的方法
     */
    public abstract void Nav();

    /**
     * 这个方法是实现BaseActivity的 抽象方法
     * 有点类似Activity的onCreate是这个程序的开始
     */
    @Override
    public void inti() {
        context = this;
        activity = (Activity) context;
        //将布局文件获取
        view = LayoutInflater.from(context).inflate(R.layout.nav_main, null);


        nav_nav = (LinearLayout) view.findViewById(R.id.nav_nav);
        nav_contentView = (LinearLayout) view.findViewById(R.id.nav_contentView);

        setNav(R.layout.nav);

        setContent(view);
        //这里调用方法的实现
        Nav();
    }

    /**
     * 这个是将布局文件添加都指定位置
     *
     * @param view
     */
    public void setNavContent(View view) {
        //将这个布局组件清空一下
        nav_contentView.removeAllViews();
        //将组件添加到文件当中
        nav_contentView.addView(view);
    }

    /**
     * 设置导航的高度
     *
     * @param height
     */
    public void setNavHeight(View v, int height) {
        //设置标题的高度
        DensityUtil.setRelHeight(v, height);
    }

    /**
     * 设置导航颜色
     *
     * @param resid
     */
    public void setNavColor(int resid) {
        NavView.setBackgroundResource(resid);
    }

    /**
     * 标题栏1的字体
     *
     * @param msg
     */
    public void setNav1(String msg) {
        nav_1_text.setText(msg);
    }

    /**
     * 标题栏1的字体颜色
     *
     * @param resid
     */
    public void setNav1Color(int resid) {
        nav_1_text.setTextColor(resid);
    }

    /**
     * 标题栏1的照片
     *
     * @param resid
     */
    public void setNav1Image(int resid) {
        nav_1_image.setImageResource(resid);
    }


    /**
     * 标题栏2的字体
     *
     * @param msg
     */
    public void setNav2(String msg) {
        nav_2_text.setText(msg);
    }

    /**
     * 标题栏2的字体颜色
     *
     * @param resid
     */
    public void setNav2Color(int resid) {
        nav_2_text.setTextColor(resid);
    }

    /**
     * 标题栏2的照片
     *
     * @param resid
     */
    public void setNav2Image(int resid) {
        nav_2_image.setImageResource(resid);
    }


    /**
     * 标题栏3的字体
     *
     * @param msg
     */
    public void setNav3(String msg) {
        nav_3_text.setText(msg);
    }

    /**
     * 标题栏3的字体颜色
     *
     * @param resid
     */
    public void setNav3Color(int resid) {
        nav_3_text.setTextColor(resid);
    }

    /**
     * 标题栏3的照片
     *
     * @param resid
     */
    public void setNav3Image(int resid) {
        nav_3_image.setImageResource(resid);
    }


    /**
     * 标题栏4的字体
     *
     * @param msg
     */
    public void setNav4(String msg) {
        nav_4_text.setText(msg);
    }

    /**
     * 标题栏4的字体颜色
     *
     * @param resid
     */
    public void setNav4Color(int resid) {
        nav_4_text.setTextColor(resid);
    }

    /**
     * 标题栏4的照片
     *
     * @param resid
     */
    public void setNav4Image(int resid) {
        nav_4_image.setImageResource(resid);
    }

}

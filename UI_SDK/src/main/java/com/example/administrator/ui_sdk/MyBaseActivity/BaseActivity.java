package com.example.administrator.ui_sdk.MyBaseActivity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.ui_sdk.Applications;
import com.example.administrator.ui_sdk.DensityUtil;
import com.example.administrator.ui_sdk.R;
import com.example.administrator.ui_sdk.View.SystemManager;

/**
 * Created by Administrator on 2016/2/25.
 *
 * 这个类是自己封装组件的最基础的Activity仅仅拥有一个标题
 * 标题的所有属性基本都实现只要直接调用接口就可以使用了
 */
public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener {

    public Context context = null;
    public Activity activity = null;


    public static int width, height = 0;
    //记录标题栏的高度
    private int w, h = 0;

    //标题的布局
    private LinearLayout titlebar = null;
    //内容的布局
    public LinearLayout contentView = null;
    //BaseActivity的整个布局
    private LinearLayout base_main = null;


    private RelativeLayout base_top_relative = null;
    private ImageView base_top_image = null;
    private TextView base_top_text = null;
    private TextView base_top_title = null;
    private TextView base_top_text1 = null;
    private ImageView base_top_image1 = null;

    private View TopView = null;


    //进行初始化的操作方法
    //这个是留给子类进行实现

    /**
     * 这个是程序的开始
     */
    public abstract void inti();

    //自定义标题

    /**
     * 判断条件如果resouse为0则默认去掉系统默认的标题
     * 如果resouse不为0则分为两种情况
     * 1.如果resouse为系统默认的布局文件base_top之后获取组件的ID之后进行事件的点击事件
     * 2.如果resouse不是系统默认的布局文件则是自定义标题只能将自定义的布局文件添加到系统默认的布局里面进行显示，之后的将重写点击事件进行实现点击
     * <p/>
     * 还有就是获取沉寂式状态栏分两种情况
     * 1.如果去掉标题栏，则沉寂式状态栏则自动获取contentView的背景颜色
     * 2.如果用有标题栏，则沉寂式状态栏则自动获取titlebar的背景颜色
     *
     * @param resid
     */
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public Activity setTileBar(int resid) {
        if (resid != 0) {
            //将标题显示出来
            titlebar.setVisibility(View.VISIBLE);
            //移除titlebar的所有组件
            titlebar.removeAllViews();
            TopView = LayoutInflater.from(context).inflate(resid, null);
            //设置默认高度
            setTitleHeight(TopView , BaseActivity.height / 12);

            //判断是不是默认的标题栏
            if (resid == R.layout.base_top) {
                //将默认的标题栏设置为透明
                setTopColor(android.R.color.transparent);

                base_top_relative = (RelativeLayout) TopView.findViewById(R.id.base_top_relative);
                base_top_image = (ImageView) TopView.findViewById(R.id.base_top_image);
                base_top_image1 = (ImageView) TopView.findViewById(R.id.base_top_image1);
                base_top_text = (TextView) TopView.findViewById(R.id.base_top_text);
                base_top_title = (TextView) TopView.findViewById(R.id.base_top_title);
                base_top_text1 = (TextView) TopView.findViewById(R.id.base_top_text1);

                //按钮的返回事件操作
                base_top_relative.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });

                //标题右边文字的点击事件操作
                base_top_text1.setOnClickListener(this);
                //标题右边图片的点击事件操作
                base_top_image1.setOnClickListener(this);
                //整个标题栏的点击事件操作
                titlebar.setOnClickListener(this);
            }

            //设置沉寂式状态栏
            SystemManager.setWindowColor(TopView, activity);

            //将布局文件添加进标题文件里
            titlebar.addView(TopView);
        } else {
            //将标题隐藏出来
            titlebar.setVisibility(View.GONE);
            //如果去掉标题栏则将整个屏幕开始变成状态栏开始
            base_main.setFitsSystemWindows(false);
        }
        return null;
    }

    /**
     * 开放设置屏幕的开始
     * @param visiable
     */
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public void setFitWindows(boolean visiable){
        base_main.setFitsSystemWindows(visiable);
    }

    /**
     * 点击事件就是在这个方法里面实现
     * 这个点击事件是单击 不包括 item点击 长按 等等
     *
     * @param v
     */
    public void Click(View v) {
    }

    /**
     * 将布局文件添加到主布局当中
     *
     * @param view
     */
    public void setContent(View view) {
        //将这个布局组件清空一下
//        contentView.removeAllViews();
        //将组件添加到文件当中
        contentView.addView(view);
        //这个就是显示布局文件
        contentView.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.base_main);

        // 将每个activity存进application类
        Applications.getInstance().addActivity(this);

        context = this;
        activity = (Activity) context;
        //获取屏幕的宽高
        getPhone();

        //获取标题和主布局内容的ID
        titlebar = (LinearLayout) findViewById(R.id.titlebar);
        contentView = (LinearLayout) findViewById(R.id.contentView);
        base_main = (LinearLayout) findViewById(R.id.base_main);

        //设置默认主内容布局的颜色
//        setContentColor(R.color.White);

        //设置系统默认标题
        //这个仅仅是拥有一个标题
        setTileBar(R.layout.base_top);

        inti();
    }


    /*************************************************************************
     下面是配置标题的各种方法
     *************************************************************************/


    /**
     * 设置标题的高度
     *
     * @param height
     */
    public void setTitleHeight(View v , int height) {
        //设置标题的高度
        DensityUtil.setHeight(v, height);
    }

    /**
     * 设置系统标题的颜色
     *
     * @param resid
     */
    public void setTopColor(int resid) {
        //将标题栏设置颜色
        TopView.setBackgroundResource(resid);
        //设置沉寂式状态栏
        SystemManager.setWindowColor(TopView, activity);
    }

    /**
     * 设置主内容的颜色
     *
     * @param resid
     */
    public void setContentColor(int resid) {
        //将主布局设置颜色
        contentView.setBackgroundResource(resid);
    }

    /**
     * 设置背景图片
     *
     * @param resid
     */
    public void setContentDrawable(int resid) {
        //将主布局设置为图片背景
        contentView.setBackgroundResource(resid);
        //将状态栏设置透明
        SystemManager.setTitleBarColor(android.R.color.transparent, this);
    }

    public void setContentDrawable(Drawable drawable) {
        //将主布局设置为图片背景
        contentView.setBackgroundDrawable(drawable);
        //上面的设置方法可以写成 setBackground不过这个版本是最低兼容 android 16版本所以就不用

        //将状态栏设置透明
        SystemManager.setTitleBarColor(android.R.color.transparent, this);
    }

    /**
     * 设置右边的文字
     *
     * @param msg
     */
    public void setRightTitle(String msg) {
        base_top_text1.setVisibility(View.VISIBLE);
        base_top_text1.setText(msg);
    }

    /**
     * 设置右边文字的颜色
     * @param resid
     */
    public void setRightTitleColor(int resid) {
        base_top_text1.setTextColor(resid);
    }


    /**
     * 设置右边标题的文字是否隐藏
     *
     * @param visiable
     */
    public void setRightTitleVisiable(boolean visiable) {
        setVisiable(base_top_text1, visiable);
    }


    /**
     * 设置标题
     *
     * @param msg
     */
    public void setTitle(String msg) {
        base_top_title.setText(msg);
    }


    /**
     * 设置标题是否隐藏
     *
     * @param visiable
     */
    public void setTitleVisiable(boolean visiable) {
        setVisiable(base_top_title, visiable);
    }

    /**
     * 设置标题的颜色
     * @param resid
     */
    public void setTopTitleColor(int resid){
        base_top_title.setTextColor(resid);
    }

    /**
     * 设置右边图片
     *
     * @param resid
     */
    public void setRightImage(int resid) {
        base_top_image1.setVisibility(View.VISIBLE);
        base_top_image1.setImageResource(resid);
    }

    /**
     * 设置右边图片是否显示
     *
     * @param visiable
     */
    public void setRightImageVisiable(boolean visiable) {
        setVisiable(base_top_image1, visiable);
    }

    /**
     * 设置左边文字
     *
     * @param msg
     */
    public void setLeftTitle(String msg) {
        base_top_text.setVisibility(View.VISIBLE);
        base_top_text.setText(msg);
    }

    /**
     * 设置左边的文字是否隐藏
     *
     * @param visiable
     */
    public void setLeftTitleVisiable(boolean visiable) {
        setVisiable(base_top_text, visiable);
    }

    /**
     * 设置左边文字的颜色
     * @param resid
     */
    public void setLeftTitleColor(int resid){
        base_top_text.setTextColor(resid);
    }

    /**
     * 设置左边的图片
     *
     * @param resid
     */
    public void setLeftImage(int resid) {
        //设置左边的图片显示
        base_top_image.setVisibility(View.VISIBLE);
        //设置左边的图片
        base_top_image.setImageResource(resid);
    }

    /**
     * 设置左边的图片是否显示
     *
     * @param visiable
     */
    public void setLeftImageVisiable(boolean visiable) {
        setVisiable(base_top_image, visiable);
    }

    /**
     * 该方法是实现组件是否隐藏
     *
     * @param v
     * @param visiable
     */
    public void setVisiable(View v, boolean visiable) {
        if (visiable)
            v.setVisibility(View.VISIBLE);
        else
            v.setVisibility(View.GONE);
    }

    /**
     * 获取手机屏幕大小
     */
    private void getPhone() {
        WindowManager wm = (WindowManager) this
                .getSystemService(Context.WINDOW_SERVICE);
        width = wm.getDefaultDisplay().getWidth();
        height = wm.getDefaultDisplay().getHeight();
    }


    @Override
    public void onClick(View v) {
        Click(v);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        Applications.getInstance().onTerminate();
    }
}

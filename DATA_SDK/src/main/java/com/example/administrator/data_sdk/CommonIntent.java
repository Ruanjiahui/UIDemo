package com.example.administrator.data_sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/1/12.
 */
public class CommonIntent {

    public static void IntentActivity(Context context, Class cls) {
        Intent intent = new Intent();
        intent.setClass(context, cls);
        context.startActivity(intent);
    }

    /**
     * 传输Serializable对象
     *
     * @param context
     * @param cls
     * @param data
     */
    public static void IntentActivity(Context context, Class cls, Serializable data) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", data);
        intent.putExtras(bundle);
        intent.setClass(context, cls);
        context.startActivity(intent);
    }

    /**
     * 传输Parcelable对象
     *
     * @param context
     * @param cls
     * @param data
     */
    public static void IntentActivity(Context context, Class cls, Parcelable data) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putParcelable("data", data);
        intent.putExtras(bundle);
        intent.setClass(context, cls);
        context.startActivity(intent);
    }

    /**
     * 传输Parcelable对象
     *
     * @param context
     * @param cls
     * @param data
     */
    public static void IntentActivity(Context context, Class cls, Parcelable data, Parcelable user) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putParcelable("data", data);
        bundle.putParcelable("user", user);
        intent.putExtras(bundle);
        intent.setClass(context, cls);
        context.startActivity(intent);
    }


    /**
     * 传输Parcelable对象附带返回值
     *
     * @param activity
     * @param cls
     * @param data
     * @param resultCode
     */
    public static void IntentActivity(Activity activity, Class cls, Parcelable data, int resultCode) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putParcelable("data", data);
        intent.putExtras(bundle);
        intent.setClass(activity, cls);
        activity.startActivityForResult(intent, resultCode);
    }

    /**
     * 跳转页面
     *
     * @param activity
     * @param cls
     * @param data
     * @param resultCode
     * @param user
     */
    public static void IntentActivity(Activity activity, Class cls, Parcelable data, int resultCode, Parcelable user) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putParcelable("data", data);
        bundle.putParcelable("user", user);
        intent.putExtras(bundle);
        intent.setClass(activity, cls);
        activity.startActivityForResult(intent, resultCode);
    }

    public static void SetActivity(Activity activity, Parcelable data, int resultCode) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putParcelable("data", data);
        intent.putExtras(bundle);
        activity.setResult(resultCode, intent);
    }

}

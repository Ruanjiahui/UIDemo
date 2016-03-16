package com.example.administrator.data_sdk.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/2/29.
 */
public class CreateTable {

    private static DatabaseHelper databaseHelper = null;
    private static SQLiteDatabase sqLiteDatabase = null;
    private static ArrayList<String> key = null;

    private static String sql = "";
    private static String content = "";

    public synchronized static DatabaseHelper getInstance(Context context, String db_name) {
        if (databaseHelper == null) {
            databaseHelper = new DatabaseHelper(context, db_name);
        }
        return databaseHelper;
    }

    /**
     * 创建表的方法
     *
     * @param context
     * @param db_name    数据库名字
     * @param Table_name 表的名字
     * @param establish  封装数据的对象
     * @param auto_key   自动增长的语句如果没有则为空
     */
    public static void TABLE(Context context, String db_name, String Table_name, Establish establish, String auto_key) {
        DatabaseHelper databaseHelper = getInstance(context, db_name);
        sqLiteDatabase = databaseHelper.getWritableDatabase();

        key = establish.getKey();

        content = getContent(key, establish, auto_key);

        sql = "CREATE TABLE " + Table_name + "(" + content + ")";

        try {
            sqLiteDatabase.execSQL(sql);
        } catch (Exception e) {
            Log.e("Activity", "创建表不成功");
        }
    }

    /**
     * 将封装在establish这个对象的数据解析出来
     *
     * @param list
     * @param establish
     * @return
     */
    private static String getContent(ArrayList<String> list, Establish establish, String auto_key) {
        for (int i = 0; i < list.size(); i++) {
            content += list.get(i) + " " + establish.get(list.get(i));
            if (list.get(i).equals(auto_key)) {
                content += " auto_increment";
            }
            if (i != list.size() - 1)
                content += ",";
        }
        return content;
    }
}

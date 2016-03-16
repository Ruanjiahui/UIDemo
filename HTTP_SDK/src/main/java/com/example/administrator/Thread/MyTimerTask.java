package com.example.administrator.Thread;

import android.os.Handler;
import android.os.Message;

import com.example.administrator.Interface.HttpInterface;

import java.util.TimerTask;

/**
 * Created by Administrator on 2016/2/29.
 */
public class MyTimerTask extends TimerTask{

    private HttpInterface.HttpHandler httpHandler = null;
    public MyTimerTask(HttpInterface.HttpHandler httpHandler){
        this.httpHandler = httpHandler;
    }


    @Override
    public void run() {
        Message msg = new Message();
        handler.sendMessage(msg);
    }

    private Handler handler = new Handler(){

        @Override
        public void dispatchMessage(Message msg) {
            super.dispatchMessage(msg);
            httpHandler.handler("");
        }
    };
}

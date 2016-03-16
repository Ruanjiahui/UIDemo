package com.example.administrator.uidemo;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


}
//public class MainActivity extends BaseActivity implements HttpInterface.HttpHandler {
//
//    private MyButton button, button1 = null;
//    private TextView textView = null;
//    private Drawable drawable = null;
//    private Bitmap bitmap = null;
//
//    private MyImageView imageView = null;
//
//    @Override
//    public void inti() {
//        LinearLayout linearLayout = new LinearLayout(this);
//        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//
//        button = new MyButton(this);
//        button.setLayoutParams(new ViewGroup.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//        button.setText("读取");
//        button.setClickable(true);
//        button.setOnClickListener(this);
//
//
//        button1 = new MyButton(this);
//        button1.setLayoutParams(new ViewGroup.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//        button1.setText("储存");
//        button1.setClickable(true);
//        button1.setOnClickListener(this);
//
//        imageView = new MyImageView(this);
//        imageView.setLayoutParams(new ViewGroup.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
////        imageView.setImageResource(R.mipmap.qqq);
//        textView = new TextView(this);
//        textView.setLayoutParams(new ViewGroup.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
////
//        linearLayout.setOrientation(LinearLayout.VERTICAL);
//        linearLayout.addView(button);
//        linearLayout.addView(button1);
//        linearLayout.addView(textView);
//
//
//        Log.e("Ruan", Configuration.getLocalPath(this));
//        setContent(linearLayout);
//    }
//
//    @Override
//    public void Click(View v) {
//        if (v == button) {
////            textView.setText(FileTool.readFileByte("table.txt", Environment.getExternalStorageDirectory() + "/image"));
////            bitmap = FileTool.readPictureByteBitmap("qqq.jpg", Environment.getExternalStorageDirectory() + "/image");
////            Log.e("Ruan" , drawable + "");
////            imageView.setImageDrawable(drawable);
////            Log.e("Ruan", "你已经点击");
////            new HTTP(this, "http://www.baidu.com");
//            return;
//        }
//        if (v == button1) {
//            InputStream is = getResources().openRawResource(R.raw.table);
//
//
//            FileTool.saveFileByte(is, "table.txt", Environment.getExternalStorageDirectory() + "/image");
//            return;
//        }
//    }
//
//    @Override
//    public void handler(String result) {
//        Log.e("Ruan", result);
//        textView.setText(result);
//    }
//}

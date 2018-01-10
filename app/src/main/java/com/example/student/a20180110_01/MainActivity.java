package com.example.student.a20180110_01;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Handler handler;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler();
        tv = findViewById(R.id.textView);
//        方法1，另創class跑
//        MyThread t = new MyThread();
//        t.start();
        handler.post(r);    //方法2
    }

//  方法1
//    class MyThread extends Thread {
//        public void run() {
//            super.run();
//            while (true) {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                handler.post(new Runnable() {
//                    public void run() {
//                        tv.setText(String.valueOf(Integer.valueOf(tv.getText().toString()) + 1));
//                    }
//                });
//            }
//        }
//    }

    //方法2
    Runnable r = new Runnable() {
        @Override
        public void run() {
            tv.setText(String.valueOf( Integer.valueOf(      tv.getText().toString()       )     +1       ));
            handler.postDelayed(r,1000);
        }
    };
}



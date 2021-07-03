package com.example.eva_3_7_handler_banner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView imgVwBanner;
    Thread tBanner;
    int iCont = 0;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg){
            super.handleMessage(msg);
            int image;
            if (iCont == 0){
                image = R.drawable.index;
                iCont++;
            } else if (iCont == 1){
                image = R.drawable.indexs;
                iCont++;
            } else {
                image = R.drawable.images;
                iCont = 0;
            }
            imgVwBanner.setImageResource(image);
            Log.wtf("UOPS", "UOPS");

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgVwBanner = findViewById(R.id.imageVwBanner);

        tBanner = new Thread(){
            @Override
            public void run(){
                super.run();
                while (true){
                    try {
                        Thread.sleep(1000);
                        Message message = handler.obtainMessage();
                        handler.sendMessage(message);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        tBanner.start();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        tBanner.interrupt();
    }
}
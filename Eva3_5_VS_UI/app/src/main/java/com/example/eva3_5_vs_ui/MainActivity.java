package com.example.eva3_5_vs_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView txtVwMensa;
Thread thread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwMensa = findViewById(R.id.txtVwMensa);
        //txtVwMensa.setText("Hola mundo cruel");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (true){
                    try {
                        Thread.sleep(1000);
                        String cade = "i = " + i;
                        i++;
                        txtVwMensa.append(cade + "\n");
                        Log.wtf("runnnable", cade);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
       Thread thread = new Thread(runnable);
        thread.start();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
    }
}
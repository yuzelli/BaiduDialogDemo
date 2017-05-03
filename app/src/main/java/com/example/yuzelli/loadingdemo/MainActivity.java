package com.example.yuzelli.loadingdemo;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class MainActivity extends Activity {
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context context;
        context = this;
        this.findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              BaiduLoading.onBeiginDialog(context);
               new Thread(new Runnable() {
                   @Override
                   public void run() {

                       try {
                           Thread.currentThread();
                           Thread.sleep(3000);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                       BaiduLoading.onStopDialog();
                   }
               }).start();
            }
        });
        this.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }



    private void showD(){
        dialog   = new Dialog(this,R.style.PhotoDialog);
        final View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.view_loading,null);
        dialog.setContentView(view);
        dialog.show();

    }


}

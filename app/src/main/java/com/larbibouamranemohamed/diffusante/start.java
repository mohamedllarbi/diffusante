package com.larbibouamranemohamed.diffusante;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.sql.Time;

public class start extends AppCompatActivity {
    private Handler sHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);



            sHandler.postDelayed(new Runnable() {
                public void run() {

                    Intent intent = new Intent(start.this, internet.class);
                    startActivity(intent);

                }
            }, 3000);


        }





}
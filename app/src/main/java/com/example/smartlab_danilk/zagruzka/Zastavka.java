package com.example.smartlab_danilk.zagruzka;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.smartlab_danilk.R;

public class Zastavka extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zapusk);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent onBoard = new Intent(Zastavka.this, ActPager.class);
                startActivity(onBoard);
                finish();
            }
        }, 1500);
    }
}
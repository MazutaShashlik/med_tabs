package com.example.smartlab_danilk.zagruzka;


import androidx.appcompat.app.AppCompatActivity;

import android.app.LauncherActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;

import com.example.smartlab_danilk.CheckPas;
import com.example.smartlab_danilk.Password;
import com.example.smartlab_danilk.R;
import com.example.smartlab_danilk.Vhod;
import com.example.smartlab_danilk.tabs.Tabs_A;

public class Zastavka extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zapusk);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(Zastavka.this);
                if (sharedPref.contains("token") && sharedPref.contains("pin")){
                    Intent main = new Intent(Zastavka.this, CheckPas.class);
                    startActivity(main);
                    finish();
                } else {
                    Intent onBoard = new Intent(Zastavka.this, Tabs_A.class);
                    startActivity(onBoard);
                    finish();
                }
            }
        }, 3000);
    }
}
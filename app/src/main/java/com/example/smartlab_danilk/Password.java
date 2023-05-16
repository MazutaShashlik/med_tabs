package com.example.smartlab_danilk;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smartlab_danilk.tabs.Tabs_A;

public class Password extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_password);

    }


    public void One(View view){
        Intent intent = new Intent(Password.this, Tabs_A.class);
        startActivity(intent);
    }



}
package com.example.smartlab_danilk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Vhod extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vhod_reg);
    }

    public void Dalee(View view){
        Intent intent = new Intent(Vhod.this, EmailPas.class);
        startActivity(intent);
    }
}

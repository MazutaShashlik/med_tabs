package com.example.smartlab_danilk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Karta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.karta_pac);
    }

    public void Podt(View view){
        Intent intent = new Intent(Karta.this, Password.class);
        startActivity(intent);
    }
}
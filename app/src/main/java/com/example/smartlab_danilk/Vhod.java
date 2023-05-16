package com.example.smartlab_danilk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Vhod extends AppCompatActivity {

    Button enter;
    Button enteryandex;
    EditText user_email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vhod_reg);

        enter = findViewById(R.id.enter);
        enteryandex = findViewById(R.id.enteryandex);
        user_email = findViewById(R.id.email);
        enter.setEnabled(false);
        user_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                enter.setEnabled(false);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                enter.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(user_email.getText())) {
                    enter.setEnabled(false);
                }

            }
        });
        enter.setOnClickListener(v -> {
            APIMed api = APIMed.retrofit.create(APIMed.class);
            Call<Void> call = api.sendCode(user_email.getText().toString());

            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {
                    if(response.isSuccessful()) {
                        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(Vhod.this);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("email", user_email.getText().toString());
                        editor.apply();
                        Intent code = new Intent(Vhod.this, EmailPas.class);
                        startActivity(code);
                    } else {
                        Log.d("qwe", ""+response.body());
                        Toast.makeText(Vhod.this, ""+response.body(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<Void> call, Throwable t) {
                    Log.d("Error_API", "Ошибка"+t.getMessage());
                    Toast.makeText(Vhod.this, "Ошибка"+t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });


        });
        enteryandex.setOnClickListener(v -> {

        });
    }
};




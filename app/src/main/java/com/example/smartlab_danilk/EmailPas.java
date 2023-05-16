package com.example.smartlab_danilk;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EmailPas extends AppCompatActivity {
    EditText code1, code2, code3, code4;
    TextView timeCode;



    private int resendTime = 4;



    //если правильно введен результат
    private boolean isCurrentCode = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kod_s_pochti);

        code1 = findViewById(R.id.k1);
        code2 = findViewById(R.id.k2);
        code3 = findViewById(R.id.k3);
        code4 = findViewById(R.id.k4);
        timeCode = findViewById(R.id.taimer);



        // обратный отсчет
        startCountDownTime();


    }

    private void startCountDownTime() {
        new CountDownTimer(resendTime * 1000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                timeCode.setText("Отправить код повторно можно \n будет через "+(millisUntilFinished/1000) +" секунд");
                String input_code = code1.getText().toString() + code2.getText().toString() + code3.getText().toString() + code4.getText().toString();

                Log.d("CodE", input_code);
                if (input_code.length()== 4){


                }




            }

            @Override
            public void onFinish() {
                timeCode.setText("Отправить код повторно");
                Next();
            }
        }.start();
    }


    private void Next(){
        Intent kart = new Intent(this,Karta.class);
        startActivity(kart);
        finish();
    }




}
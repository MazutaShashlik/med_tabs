package com.example.smartlab_danilk;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smartlab_danilk.tabs.Tabs_A;

public class Password extends AppCompatActivity {

    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnDel;
    private EditText vvodPas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_password);
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnDel = (Button) findViewById(R.id.btndelete);
        vvodPas =  (EditText) findViewById(R.id.pas);

        btn0.setOnClickListener(v -> onClick(btn0));
        btn1.setOnClickListener(v -> onClick(btn1));
        btn2.setOnClickListener(v -> onClick(btn2));
        btn3.setOnClickListener(v -> onClick(btn3));
        btn4.setOnClickListener(v -> onClick(btn4));
        btn5.setOnClickListener(v -> onClick(btn5));
        btn6.setOnClickListener(v -> onClick(btn6));
        btn7.setOnClickListener(v -> onClick(btn7));
        btn8.setOnClickListener(v -> onClick(btn8));
        btn9.setOnClickListener(v -> onClick(btn9));


        btnDel.setOnClickListener(v -> {
            int cursorPosition = vvodPas.getSelectionEnd();
            if (cursorPosition > 0) {
                vvodPas.getText().delete(cursorPosition - 1, cursorPosition);
            }
        });
        vvodPas.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String text = charSequence.toString();
                if (text.length() == 4) {
                    Log.d("ERROR!", ""+text);
                    SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(Password.this);
                    String pincode = sharedPref.getString("pas", "");
                    if(pincode.equals(text)) {
                        Intent intent = new Intent(Password.this, Tabs_A.class);
                        startActivity(intent);
                        finish();
                        return;
                    } else {
                        Toast.makeText(Password.this, "Пароль неверный", Toast.LENGTH_SHORT).show();
                    }

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void onClick(Button btn) {
        String number = btn.getText().toString();
        vvodPas.getText().insert(vvodPas.getSelectionStart(), number);
    }

}
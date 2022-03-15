package com.example.bai02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText et_f = findViewById(R.id.editText_F);
        EditText et_c = findViewById(R.id.editText_C);
        Button bt_convertC = findViewById(R.id.button_ConvertC);
        Button bt_convertF = findViewById(R.id.button_ConvertF);
        Button bt_Clear = findViewById(R.id.button_Clear);
        bt_convertC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float f = Float.parseFloat(et_f.getText().toString());
                float kQua = (f - 32) * 5 / 9;
                et_c.setText("" + kQua);
            }
        });
        bt_convertF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float c = Float.parseFloat(et_c.getText().toString());
                float kQua = c * 9/5 + 32;
                et_f.setText("" + kQua);
            }
        });
        bt_Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_c.setText("");
                et_f.setText("");
            }
        });
    }
}
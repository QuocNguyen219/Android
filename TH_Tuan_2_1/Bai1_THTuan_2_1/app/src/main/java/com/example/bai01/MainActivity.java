package com.example.bai01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt_Tong = findViewById(R.id.button_Tong);
        Button bt_Hieu = findViewById(R.id.button_Hieu);
        Button bt_Tich = findViewById(R.id.button_Tich);
        Button bt_Thuong = findViewById(R.id.button_Thuong);
        Button bt_UCLN = findViewById(R.id.button_UCLN);
        Button bt_Thoat = findViewById(R.id.button_Thoat);
        EditText et_a = findViewById(R.id.editText_heSoA);
        EditText et_b = findViewById(R.id.editText_heSoB);
        TextView tv_KetQua = findViewById(R.id.textView_KetQua);
        bt_Tong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(et_a.getText().toString());
                int b = Integer.parseInt(et_b.getText().toString());
                int ketQua = a + b;
                tv_KetQua.setText("" + ketQua);
            }
        });
        bt_Hieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(et_a.getText().toString());
                int b = Integer.parseInt(et_b.getText().toString());
                int ketQua = a - b;
                tv_KetQua.setText("" + ketQua);
            }
        });
        bt_Tich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(et_a.getText().toString());
                int b = Integer.parseInt(et_b.getText().toString());
                int ketQua = a * b;
                tv_KetQua.setText("" + ketQua);
            }
        });
        bt_Thuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(et_a.getText().toString());
                int b = Integer.parseInt(et_b.getText().toString());
                float ketQua = (float) a / b;
                tv_KetQua.setText("" + ketQua);
            }
        });
        bt_UCLN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(et_a.getText().toString());
                int b = Integer.parseInt(et_b.getText().toString());
                while (a != b) {
                    if(a > b) a = a - b;
                    else b = b - a;
                }
                tv_KetQua.setText("" + b);
            }
        });
        bt_Thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
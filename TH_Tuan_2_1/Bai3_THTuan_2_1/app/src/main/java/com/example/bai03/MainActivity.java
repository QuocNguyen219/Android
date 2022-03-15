package com.example.bai03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt = findViewById(R.id.buttonCD);
        EditText et_duongLich = findViewById(R.id.editText_duongLich);
        TextView tv_KQ = findViewById(R.id.textView_KQua);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] can = {"Canh", "Tân", "Nhâm", "Quý", "Giáp", "Ất", "Bính", "Đinh", "Mậu", "Kỷ"};
                String[] chi = {"Thân", "Dậu", "Tuất", "Hợi", "Tý", "Sửu", "Dần", "Mẹo", "Thìn", "Tỵ", "Ngọ", "Mùi"};
                int n = Integer.parseInt(et_duongLich.getText().toString());
                if(n >= 1900) {
                    String nCan = can[n % 10];
                    String nChi = chi[n % 12];
                    tv_KQ.setText(nCan + " " + nChi);
                }
                else {
                    Context context = getApplicationContext();
                    CharSequence text = "Vui lòng nhập số nguyên lớn hơn hoặc bằng 1900";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
    }
}
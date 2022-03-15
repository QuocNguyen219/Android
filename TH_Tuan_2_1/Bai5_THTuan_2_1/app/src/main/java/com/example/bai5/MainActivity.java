package com.example.bai5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText et_TenKH = findViewById(R.id.et_TenKH);
        EditText et_SLSach = findViewById(R.id.et_SLSach);

        EditText et_TongSoKH = findViewById(R.id.et_TongSoKH);
        EditText et_TongSoKHVip = findViewById(R.id.et_TongSoKHVip);
        EditText et_TongDT = findViewById(R.id.et_TongDT);

        TextView tv_ThanhTien = findViewById(R.id.tv_ThanhTien);

        Button btn_TinhTT = findViewById(R.id.btn_TinhTT);
        Button btn_Tiep = findViewById(R.id.btn_Tiep);
        Button btn_ThongKe = findViewById(R.id.btn_ThongKe);

        List<ThongTinKH> list = new ArrayList<ThongTinKH>();


        ImageButton btn_Thoat = findViewById(R.id.btn_Thoat);


        btn_Thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        CheckBox chk_KHVip = findViewById(R.id.chk_KHVip);
        btn_TinhTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String slSach = et_SLSach.getText().toString().trim();

                if (!slSach.matches("\\d+") || slSach.trim().equals("")) {
                    Toast toast = Toast.makeText(MainActivity.this, "Vui lòng nhập số nguyên lớn hơn 0", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    int soLuongSach = Integer.parseInt(slSach);
                    int tongTien = soLuongSach * 20000;
                    if (chk_KHVip.isChecked()) tongTien *= 0.9;
                    tv_ThanhTien.setText("" + tongTien);
                }
            }
        });
        btn_Tiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_TenKH.requestFocus();
                boolean vip = chk_KHVip.isChecked();
                int soLuongSach = Integer.parseInt(et_SLSach.getText().toString());
                double tongTien = soLuongSach * 20000;
                if (chk_KHVip.isChecked()) tongTien *= 0.9;
                String tenKh = et_TenKH.getText().toString();

                list.add(new ThongTinKH(tenKh, soLuongSach, vip, tongTien));
            }
        });
        btn_ThongKe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int soKHVip = 0;
                double tongDoanhThu = 0;
                for (ThongTinKH KH : list) {
                    if (KH.isVip())
                        soKHVip += 1;
                    tongDoanhThu += KH.getThanhTien();
                }
                et_TongSoKH.setText(list.size() + "");
                et_TongSoKHVip.setText(soKHVip + "");
                et_TongDT.setText(tongDoanhThu + "");
            }
        });


    }
}
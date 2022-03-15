package com.example.bai1_thtuan2_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_DangNhap = findViewById(R.id.btn_DangNhap);
        Button btn_Thoat = findViewById(R.id.btn_Thoat);

        EditText et_TK1 = findViewById(R.id.et_TK1);
        EditText et_TK2 = findViewById(R.id.et_TK2);

        CheckBox chk_Luu = findViewById(R.id.chk_Luu);

        btn_DangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_TK1 = et_TK1.getText().toString();
                if (str_TK1.trim().equals("")) {
                    Toast toast = Toast.makeText(MainActivity.this, "Tài khoản không được để trống", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }

                String str_TK2 = et_TK2.getText().toString();
                if (str_TK2.trim().equals("")) {
                    Toast toast = Toast.makeText(MainActivity.this, "Tài khoản không được để trống", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                if (chk_Luu.isChecked()) {
                    Toast toast = Toast.makeText(MainActivity.this, "Chào mừng bạn đăng \n" +
                            "nhập hệ thống, thông tin của bạn đã được lưu", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(MainActivity.this, "Chào mừng bạn \n" +
                            "đăng nhập hệ thống, thông tin của bạn không được lưu", Toast.LENGTH_SHORT);
                    toast.show();
                }


            }
        });
        btn_Thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn có muốn thoát không!");
//              builder.setIcon(android.R.drawable.ic dialog_alert);
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        finish();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


    }
}
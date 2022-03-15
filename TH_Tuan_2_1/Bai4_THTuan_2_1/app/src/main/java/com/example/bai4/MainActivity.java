package com.example.bai4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText et_hoten = findViewById(R.id.et_hoTen);
        EditText et_cmnd = findViewById(R.id.et_cmnd);
        EditText et_ttbosung = findViewById(R.id.et_thongtinbosung);

        RadioButton radio_TC = findViewById(R.id.radio_TC);
        RadioButton radio_CD = findViewById(R.id.radio_CD);
        RadioButton radio_DH = findViewById(R.id.radio_DH);

        CheckBox chk_docBao = findViewById(R.id.checkbox_docbao);
        CheckBox chk_docSach = findViewById(R.id.checkbox_docsach);
        CheckBox chk_docCoding = findViewById(R.id.checkbox_doccoding);



        Button btn_guiThongTin = findViewById(R.id.bt_guiTT);

        btn_guiThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_hoten = et_hoten.getText().toString().trim();
                String str_cmnd = et_cmnd.getText().toString().trim();

                AlertDialog.Builder mydialog = new AlertDialog.Builder(MainActivity.this);
                mydialog.setTitle("Thông báo");
                if (str_hoten.equals("") || !str_hoten.matches("\\w{3,}")) {
                    mydialog.setTitle("Tên không được để trống và phải có ít nhất 3 ký tự");
                    AlertDialog dialog = mydialog.create();
                    dialog.show();
                    return;
                }

                if (!str_cmnd.matches("\\d{9}")) {
                    mydialog.setTitle("Chứng minh nhân dân chỉ được nhập kiểu số và phải có đúng 9 chữ số");
                    AlertDialog dialog = mydialog.create();
                    dialog.show();
                    return;
                }

                if (chk_docBao.isChecked() == false && chk_docSach.isChecked() == false && chk_docCoding.isChecked() == false) {
                    mydialog.setTitle("Sở thích phải chọn ít nhất 1 chọn lựa");
                    AlertDialog dialog = mydialog.create();
                    dialog.show();
                    return;
                }

                String bangCap = "";
                bangCap = radio_TC.isChecked() == true ? radio_TC.getText().toString() : "";
                bangCap = radio_CD.isChecked() == true ? radio_CD.getText().toString() : "";
                bangCap = radio_DH.isChecked() == true ? radio_DH.getText().toString() : "";

                String soThich = "";
                soThich += chk_docBao.isChecked() == true ? chk_docBao.getText().toString() +" ": "";
                soThich += chk_docSach.isChecked() == true ? chk_docSach.getText().toString()+" " : "";
                soThich += chk_docCoding.isChecked() == true ? chk_docCoding.getText().toString() +" ": "";

                mydialog.setTitle(str_hoten + " " + str_cmnd + " " + bangCap + " " +soThich+" "+et_ttbosung.getText());
                AlertDialog dialog = mydialog.create();
                dialog.show();
            }
        });
    }
}
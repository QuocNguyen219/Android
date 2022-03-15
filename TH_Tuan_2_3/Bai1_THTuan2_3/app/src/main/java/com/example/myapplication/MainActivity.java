package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<NhanVien> arrNhanVien = null;
    MyArrayAdapter adapter = null;
    ListView lvNhanVien = null;
    Button btnNhap;
    ImageButton btnRemoveAll;
    EditText txtMa, txtTen;
    RadioGroup genderGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNhap = findViewById(R.id.btn_Nhap);
        btnRemoveAll = findViewById(R.id.imgButton);
        txtMa = findViewById(R.id.et_MaNV);
        txtTen = findViewById(R.id.et_TenNV);
        genderGroup = findViewById(R.id.genderGroup);
        lvNhanVien = findViewById(R.id.lv_listview);
        arrNhanVien = new ArrayList<NhanVien>();
        adapter = new MyArrayAdapter(this, R.layout.my_item_layout, arrNhanVien);
        lvNhanVien.setAdapter(adapter);

        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyNhap();
            }
        });
        btnRemoveAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyXoa();
            }
        });


    }

    public void xuLyNhap() {
        String ma = txtMa.getText() + "";
        String ten = txtTen.getText() + "";
        boolean gioiTinh = false;

        if (genderGroup.getCheckedRadioButtonId() == R.id.rad_Nu)
            gioiTinh = true;

        NhanVien nv = new NhanVien();
        nv.setId(ma);
        nv.setName(ten);
        nv.setGender(gioiTinh);
        arrNhanVien.add(nv);


        adapter.notifyDataSetChanged();


        txtMa.setText("");
        txtTen.setText("");
        txtMa.requestFocus();
    }

    public void xuLyXoa() {
        for (int i = lvNhanVien.getChildCount() - 1; i >= 0; i--) {
            View v = lvNhanVien.getChildAt(i);
            CheckBox chkh = v.findViewById(R.id.chk_item);
            if (chkh.isChecked())
                arrNhanVien.remove(i);

        }
        adapter.notifyDataSetChanged();
    }

}
package com.example.bai3_thtuan2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private ArrayList<String> myList;
    private ArrayAdapter<String> adapter;
    private ListView listView;
    private Button btnNhap;
    private TextView tvNhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNhap = findViewById(R.id.et_Nhap);
        myList = new ArrayList<String>();
        listView = findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myList);
        listView.setAdapter(adapter);

        btnNhap = findViewById(R.id.btn_Nhap);
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myList.add(tvNhap.getText() + "");
                adapter.notifyDataSetChanged();
            }
        });

        TextView textView_PhanTuDuocChon = findViewById(R.id.tv_PhanTuDuocChon);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                textView_PhanTuDuocChon.setText("position: " + i + " value: " + listView.getItemAtPosition(i));
            }
        });
    }


}
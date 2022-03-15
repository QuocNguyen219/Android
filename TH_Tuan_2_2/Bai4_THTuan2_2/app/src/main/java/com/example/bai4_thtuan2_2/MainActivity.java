package com.example.bai4_thtuan2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends ListActivity {

    private ArrayList<String> myList;
    private ArrayAdapter<String> adapter;
    private ListView listView;
    private Button btnNhap;
    private TextView etNhap;
    private TextView textView_PhanTuDuocChon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etNhap = findViewById(R.id.et_Nhap);

        textView_PhanTuDuocChon = findViewById(R.id.tv_PhanTuDuocChon);

        myList = new ArrayList<String>();

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myList);
        setListAdapter(adapter);

        btnNhap = findViewById(R.id.btn_Nhap);
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myList.add(etNhap.getText() + "");
                adapter.notifyDataSetChanged();
            }
        });



    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String item = (String) getListAdapter().getItem(position);
        textView_PhanTuDuocChon.setText("position: " + position + "; value: " + item+"");


    }
}
package com.example.bai3_thtuan2_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Button btnTrang2 = findViewById(R.id.btn_Trang2)    ;

        btnTrang2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent trave = new Intent();
//                trave.putExtra("","");
                setResult(RESULT_OK, trave);
                finish();
            }
        });



    }
}
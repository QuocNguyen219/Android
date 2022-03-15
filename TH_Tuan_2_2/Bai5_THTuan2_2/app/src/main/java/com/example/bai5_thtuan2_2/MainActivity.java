package com.example.bai5_thtuan2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.number.Notation;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etID, etName;
    Button btnNhap;
    RadioGroup radioGroup;
    ListView listTT;
    ArrayList<Employee> arrEmployee = new ArrayList<Employee>();
    ArrayAdapter<Employee> arrayAdapter = null;
    Employee employee = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etID = findViewById(R.id.etMa);
        etName = findViewById(R.id.etTen);
        btnNhap = findViewById(R.id.btnNhap);
        radioGroup = findViewById(R.id.radGroup);
        listTT = findViewById(R.id.lv_listTT);
        arrayAdapter = new ArrayAdapter<Employee>(this, android.R.layout.simple_list_item_1, arrEmployee);
        listTT.setAdapter(arrayAdapter);
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nhap();
            }
        });

    }

    public void nhap() {
        int radID = radioGroup.getCheckedRadioButtonId();
        String id = etID.getText() + "";
        String name = etName.getText() + "";
        if (radID == R.id.radChinhThuc)
            employee = new EmployeeFullTime();
        else
            employee = new EmployeePartTime();
        employee.setId(id);
        employee.setName(name);
        arrEmployee.add(employee);
        arrayAdapter.notifyDataSetChanged();
    }
}
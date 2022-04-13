package com.example.bai3_thtuan3_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CreateAuthorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_author);
        final Button btnInsert = findViewById(R.id.buttonInsert);
        final EditText txtFirstname = findViewById(R.id.editTextFirstName);
        final EditText txtLastname = findViewById(R.id.editTextLastName);
        final Intent intent = getIntent();
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("firstname", txtFirstname.getText().toString());
                bundle.putString("lastname", txtLastname.getText().toString());
                intent.putExtra("DATA_AUTHOR", bundle);
                setResult(MainActivity.SEND_DATA_FROM_AUTHOR_ACTIVITY, intent);
                CreateAuthorActivity.this.finish();
            }
        });
        final Button btnClear=(Button) findViewById(R.id.buttonClear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtFirstname.setText("");
                txtLastname.setText("");
                txtFirstname.requestFocus();
            }
        });

        Bundle bundle = intent.getBundleExtra("DATA");
        if(bundle != null && bundle.getInt("KEY") == 1)
        {
            String f2 = bundle.getString("getField2");
            String f3 = bundle.getString("getField3");
            txtFirstname.setText(f2);
            txtLastname.setText(f3);
            btnInsert.setText("Update");
            this.setTitle("View Detail");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_create_author, menu);
        return true;
    }
}
package com.example.demosqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityAuthor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);

        EditText et_Id = findViewById(R.id.et_Id);
        EditText et_name = findViewById(R.id.et_Name);
        EditText et_address = findViewById(R.id.et_Address);
        EditText et_email = findViewById(R.id.et_Email);

        GridView gv_Display = findViewById(R.id.gridview_AuthorList);
        DBHelper dbHelper = new DBHelper(this);

        //------------------Save----------------------
        Button btn_Save = findViewById(R.id.btn_Save);
        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Author author = new Author();
                author.setIdAuthor(Integer.parseInt(et_Id.getText().toString()));
                author.setName(et_name.getText().toString());
                author.setAddress(et_address.getText().toString());
                author.setEmail(et_email.getText().toString());

                if (dbHelper.insertAuthor(author) > 0)
                    Toast.makeText(getApplicationContext(), "Bạn đã lưu thành công", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Bạn lưu không thành công", Toast.LENGTH_SHORT).show();


            }
        });
        //------------------Select----------------------
        Button btn_Select = findViewById(R.id.btn_Select);
        btn_Select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Author> list_Author = new ArrayList<>();
                ArrayList<String> list_String = new ArrayList<>();

                if (et_Id.getText().toString().equals(""))
                    list_Author = dbHelper.getAllAuthors();
                else {

                    Author author = null;
                    author = dbHelper.getAuthorFromId(Integer.parseInt(et_Id.getText().toString()));
                    if (author == null) {
                        Toast.makeText(ActivityAuthor.this, "Không tìm thấy author", Toast.LENGTH_SHORT).show();
                        list_String.add("");
                    } else {
                        list_String.add(author.getIdAuthor() + "");
                        list_String.add(author.getName() + "");
                        list_String.add(author.getAddress() + "");
                        list_String.add(author.getEmail() + "");
                    }
                }

                for (Author author : list_Author) {
                    list_String.add(author.getIdAuthor() + "");
                    list_String.add(author.getName() + "");
                    list_String.add(author.getAddress() + "");
                    list_String.add(author.getEmail() + "");
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(ActivityAuthor.this, android.R.layout.simple_list_item_1, list_String);
                gv_Display.setAdapter(adapter);
            }
        });
        //------------------Delete----------------------
        Button btn_Delete = findViewById(R.id.btn_Delete);
        btn_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dbHelper.deleteAuthor(et_Id.getText().toString()) > 0)
                    Toast.makeText(ActivityAuthor.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(ActivityAuthor.this, "Không tìm thấy author", Toast.LENGTH_SHORT).show();

            }
        });

        //------------------Update----------------------
        Button btn_Update = findViewById(R.id.btn_Update);
        btn_Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String txt_Id=et_Id.getText().toString().trim();
                if(txt_Id.equals("") ||  !txt_Id.matches("\\d+")){
                    Toast.makeText(ActivityAuthor.this, "Id không được để trống và là số nguyên dương ", Toast.LENGTH_SHORT).show();
                    return;
                }
                Author author = new Author();
                author.setIdAuthor(Integer.parseInt(et_Id.getText().toString()));
                author.setName(et_name.getText().toString());
                author.setAddress(et_address.getText().toString());
                author.setEmail(et_email.getText().toString());

                if (dbHelper.updateAuthor(author) > 0)
                    Toast.makeText(ActivityAuthor.this, "Update thành công", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(ActivityAuthor.this, "Không tìm thấy author", Toast.LENGTH_SHORT).show();
            }
        });
        //---------------Xóa---------------------
        Button btn_Exit = findViewById(R.id.btn_Exit);
        btn_Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //-----------Load data khi click item-------------
        gv_Display.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                et_Id.setText(gv_Display.getItemAtPosition(i/4*4).toString()+"");
                et_name.setText(gv_Display.getItemAtPosition(i/4*4+1).toString()+"");
                et_address.setText(gv_Display.getItemAtPosition(i/4*4+2).toString()+"");
                et_email.setText(gv_Display.getItemAtPosition(i/4*4+3).toString()+"");

            }
        });
    }
}
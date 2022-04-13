package com.example.bai3_thtuan3_1;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button btnCreateDatabase = null;
    Button btnInsertAuthor = null;
    Button btnShowAuthorList = null;
    Button btnTransaction = null;
    Button btnShowDetail = null;
    Button btnInsertBook = null;
    public static final int OPEN_AUTHOR_DIALOG = 1;
    public static final int SEND_DATA_FROM_AUTHOR_ACTIVITY = 2;
    SQLiteDatabase database = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInsertAuthor = findViewById(R.id.buttonInsertAuthor);
        btnShowAuthorList = findViewById(R.id.buttonShowAuthorList);
        btnInsertBook = findViewById(R.id.buttonInsertBook);

        btnInsertAuthor.setOnClickListener(new MyEvent());
        btnShowAuthorList.setOnClickListener(new MyEvent());
        btnInsertBook.setOnClickListener(new MyEvent());

        getDatabase();
    }

    public boolean isTableExists(SQLiteDatabase database, String tableName) {
        Cursor cursor = database.rawQuery("select DISTINCT tbl_name from sqlite_master where tbl_name = '" + tableName + "'", null);
        if(cursor != null) {
            if(cursor.getCount() > 0) {
                cursor.close();
                return true;
            }
        }
        return false;
    }
    @SuppressLint("WrongConstant")
    public SQLiteDatabase getDatabase() {
        try {
            database = openOrCreateDatabase("mydata.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);
            if(database != null) {
                if(isTableExists(database, "tblAuthors"))
                    return database;
                database.setLocale(Locale.getDefault());
                database.setVersion(1);
                String sqlAuthor = "create table tblAuthors(id integer primary key autoincrement, firstname text, lastname text)";
                database.execSQL(sqlAuthor);
                String sqlBook = "create table tblBooks(id integer primary key autoincrement, title text, dateadded date, authorid integer not null constraint authorid references tblAuthors(id) on delete cascade)";
                database.execSQL(sqlBook);
                Toast.makeText(MainActivity.this, "OK OK", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "OK OK", Toast.LENGTH_SHORT).show();
        }
        return database;
    }
    public void createDatabaseAndTrigger() {
        if(database == null) {
            getDatabase();
            Toast.makeText(MainActivity.this, "OK OK", Toast.LENGTH_SHORT).show();
        }
    }
    public void showInsertAuthorDialog() {
        Intent intent = new Intent(MainActivity.this,CreateAuthorActivity.class);
        startActivityForResult(intent, OPEN_AUTHOR_DIALOG);
    }
    public void showAuthorList1() {
        Intent intent = new Intent(MainActivity.this, ShowListAuthorActivity.class);
        startActivity(intent);
    }
    public void interactDBWithTransaction() {
        if(database != null) {
            database.beginTransaction();
            try {
                ContentValues values = new ContentValues();
                values.put("firstname", "xx");
                values.put("lastname", "yyy");
                database.insert("tblAuthors", null, values);
                database.delete("tblAuthors", "ma=?",new String[]{"x"});
                database.setTransactionSuccessful();
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "OK OK", Toast.LENGTH_SHORT).show();
            } finally {
                database.endTransaction();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == SEND_DATA_FROM_AUTHOR_ACTIVITY) {
            Bundle bundle = data.getBundleExtra("DATA_AUTHOR");
            String firstname = bundle.getString("firstname");
            String lastname = bundle.getString("lastname");
            ContentValues content = new ContentValues();
            content.put("firstname", firstname);
            content.put("lastname", lastname);
            if(database != null) {
                long authorid = database.insert("tblAuthors", null, content);
                if(authorid == -1) {
                    Toast.makeText(MainActivity.this, authorid + "-" + firstname + "-" +lastname + " ==> insert error!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, authorid + "-" + firstname + "-" +lastname + " ==> insert OK!", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private class MyEvent implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if(view.getId() == R.id.buttonInsertAuthor) {
                showInsertAuthorDialog();
            } else if(view.getId() == R.id.buttonShowAuthorList) {
                showAuthorList1();
            } else if(view.getId() == R.id.buttonInsertBook) {
                Intent intent = new Intent(MainActivity.this, InsertBookActivity.class);
                startActivity(intent);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_simple_database_main, menu);
        return true;
    }
}

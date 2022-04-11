package com.example.demosqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {


//    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, "MYDB", null, 1);
//    }

    public DBHelper(ActivityAuthor context) {
        super(context, "MYDB", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE Authors(id integer primary key,name text, address text,email text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF  EXISTS Authors");
        onCreate(sqLiteDatabase);
    }


    public int insertAuthor(Author author) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("id", author.getIdAuthor() + "");
        content.put("name", author.getName() + "");
        content.put("address", author.getAddress() + "");
        content.put("email", author.getEmail() + "");

        int res = (int) db.insert("Authors", null, content);
        db.close();
        return res;
    }

    public ArrayList<Author> getAllAuthors() {
        ArrayList<Author> list = new ArrayList<>();
        String strsql = "select * from Authors";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(strsql, null);
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                list.add(new Author(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));
                cursor.moveToNext();
            }
            cursor.close();
            db.close();
        }
        return list;
    }

    public Author getAuthorFromId(int id) {
        Author author = null;
        String strsql = "select * from Authors where id=" + id;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(strsql, null);
        if ((cursor != null) && (cursor.getCount() > 0)){
            cursor.moveToFirst();
            author = new Author(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
            cursor.close();
            db.close();
        }
        return author;
    }

    public int deleteAuthor(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int res =  db.delete("Authors", "id=?", new String[] {id});
        db.close();
        return res;
    }
    public int updateAuthor(Author author) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("id", author.getIdAuthor() + "");
        content.put("name", author.getName() + "");
        content.put("address", author.getAddress() + "");
        content.put("email", author.getEmail() + "");

        int res= db.update("Authors", content, "id=?", new String[]{author.getIdAuthor()+""});
        db.close();
        return res;
    }
}

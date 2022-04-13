package com.example.bai1_thtuan3_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //--------------Cách 1----------------------
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.my_menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        int id = item.getItemId();
//        switch (id) {
//            case R.id.xemDSSSV:
//                break;
//            case R.id.DHTH1A:
//                break;
//            case R.id.DHTH1B:
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }


    //------------Cách 2------------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        int itemId = 113;
        menu.add(0, itemId, 0, "Menu 1");

        itemId = 114;
        menu.add(0, itemId, 1, "Menu 2");

        SubMenu sub3 = menu.addSubMenu("Menu 3");

        itemId = 115;
        sub3.add(0, itemId, 0, "File 1 Menu 3");

        itemId = 116;
        sub3.add(0, itemId, 1, "File 2 Menu 3");

        itemId = 117;
        sub3.add(0, itemId, 2,"File 3 Menu 3");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        switch (id) {
            case 113:
                break;
            case 114:
                break;
            case 115:
                break;
            case 116:
                break;
            case 117:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
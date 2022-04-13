package com.example.bai2_thtuan3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn_ShowContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_ShowContext = findViewById(R.id.btn_ShowContext);
        registerForContextMenu(btn_ShowContext);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.my_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.itemRed:
                btn_ShowContext.setTextColor(getResources().getColor(R.color.clrred));
                break;
            case R.id.itemGreen:
                btn_ShowContext.setTextColor(
                        getResources().getColor(R.color.clrgreen));
                break;
            case R.id.itemBlue:
                btn_ShowContext.setTextColor(
                        getResources().getColor(R.color.clrblue));
                break;
            default:
                btn_ShowContext.setTextColor(
                        getResources().getColor(R.color.clrred));
                break;
        }
        return super.onContextItemSelected(item);
    }
}
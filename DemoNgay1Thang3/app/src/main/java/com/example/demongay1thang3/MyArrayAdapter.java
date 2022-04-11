package com.example.demongay1thang3;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<SanPham> {
    Activity context = null;
    ArrayList<SanPham> myArray = null;
    int layoutID;

    public MyArrayAdapter(Activity context, int textViewResourceID, ArrayList<SanPham> objects) {
        super(context, textViewResourceID, objects);
        this.context = context;
        this.layoutID = textViewResourceID;
        this.myArray = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutID, null);
        if (myArray.size() >= 0 && position >= 0) {
            SanPham sp = myArray.get(position);

            ImageView imgitem = convertView.findViewById(R.id.imgView_AnhSP);
            imgitem.setImageResource(sp.getAnh());
//            if (convertView.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
//                imgitem.setLayoutParams(new LinearLayout.LayoutParams(20, 20));
//            }

            TextView txtTenSp = convertView.findViewById(R.id.tv_TenSp);
            txtTenSp.setText(sp.getTen());
            TextView txtGiaSP = convertView.findViewById(R.id.tv_GiaSP);
            txtGiaSP.setText(sp.getGia());

        }
        return convertView;
    }
}

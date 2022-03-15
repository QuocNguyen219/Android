package com.example.myapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<NhanVien> {
    Activity context = null;
    ArrayList<NhanVien> myArray = null;
    int layoutID;

    public MyArrayAdapter(Activity context, int textViewResourceID, ArrayList<NhanVien> objects) {
        super(context, textViewResourceID, objects);
        this.context = context;
        this.layoutID = textViewResourceID;
        this.myArray = objects;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView= inflater.inflate(layoutID,null);
        if (myArray.size()>=0 && position>=0){
            final TextView txtDisplay =  convertView.findViewById(R.id.tv_item);
            final NhanVien nv= myArray.get(position);

            txtDisplay.setText(nv.toString());
            final ImageView imgitem = convertView.findViewById(R.id.img_item);
            if(nv.isGender()){
                imgitem.setImageResource(R.drawable.nu);
            }
            else{
                imgitem.setImageResource(R.drawable.nam);
            }

        }




        return convertView;
    }
}

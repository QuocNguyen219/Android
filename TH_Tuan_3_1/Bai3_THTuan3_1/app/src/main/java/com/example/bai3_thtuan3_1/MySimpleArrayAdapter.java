package com.example.bai3_thtuan3_1;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MySimpleArrayAdapter extends ArrayAdapter<InforData> {
    private Activity context;
    private int layout;
    private List<InforData> list;
    public MySimpleArrayAdapter(Context context, int textViewResourceId, List<InforData> objects) {
        super(context, textViewResourceId, objects);
        this.context = (Activity) context;
        this.layout = textViewResourceId;
        this.list = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View row = inflater.inflate(layout, parent, false);
        TextView txt1 = row.findViewById(R.id.textView1);
        TextView txt2 = row.findViewById(R.id.textView2);
        TextView txt3 = row.findViewById(R.id.textView3);
        InforData data = list.get(position);
        txt1.setText(data.getField1()==null?"":data.getField1().toString());
        txt2.setText(data.getField2()==null?"":data.getField2().toString());
        txt3.setText(data.getField3()==null?"":data.getField3().toString());
        if(position == 0)
            row.setBackgroundColor(Color.RED);
        return row;
    }
}

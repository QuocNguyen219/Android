package com.example.demongay1thang3;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class Fragment_ChiTiet extends Fragment {


    private ImageView imgView_Anh;
    private TextView tv_Ten;
    private TextView tv_Gia;
    private TextView tv_ThuongHieu;
    private TextView tv_ThanhPhan;
    private TextView tv_QuyCach;
    private TextView tv_XuatXu;
    private TextView tv_GiaoHang;
    private Button bt_Mua;
    private Button bt_Back;

    public Fragment_ChiTiet() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment__chi_tiet, container, false);
        imgView_Anh = view.findViewById(R.id.imgView_Anh);

        tv_Ten = view.findViewById(R.id.tv_Ten);
        tv_Gia = view.findViewById(R.id.tv_Gia);
        tv_ThuongHieu = view.findViewById(R.id.tv_ThuongHieu);
        tv_ThanhPhan = view.findViewById(R.id.tv_ThanhPhan);
        tv_QuyCach = view.findViewById(R.id.tv_QuyCach);
        tv_XuatXu = view.findViewById(R.id.tv_XuatXu);
        tv_GiaoHang = view.findViewById(R.id.tv_GiaoHang);
        bt_Mua = view.findViewById(R.id.bt_MuaHang);
        bt_Back = view.findViewById(R.id.btn_Back);
        Bundle bundle = getArguments();
        if (bundle != null) {
            String data = bundle.getString("key");
            String[] sp = data.split(",");

            imgView_Anh.setImageResource(Integer.parseInt(sp[0]));
            tv_Ten.setText(sp[1] + "");
            tv_Gia.setText(sp[2] + "");
            tv_ThuongHieu.setText("Thương hiệu: " + sp[3]);
            tv_ThanhPhan.setText("Thành phần: " + sp[4]);
            tv_QuyCach.setText("Quy cách: " + sp[5]);
            tv_XuatXu.setText("Xuất xứ: " + sp[6]);
            tv_GiaoHang.setText("Giao hàng: " + sp[7]);
            bt_Mua.setVisibility(View.VISIBLE);
            if (getResources().getConfiguration().orientation != Configuration.ORIENTATION_LANDSCAPE) {

                imgView_Anh.setLayoutParams(new LinearLayout.LayoutParams( ViewGroup.LayoutParams.MATCH_PARENT, 800 ));
                bt_Back.setVisibility(View.VISIBLE);
            }
        }
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        bt_Mua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Mua thành công", Toast.LENGTH_SHORT).show();
            }
        });
        bt_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment_DanhSach fragment_danhSach = new Fragment_DanhSach();
                getFragmentManager().beginTransaction()
                        .replace(R.id.fragment_danhSach, fragment_danhSach)
                        .commit();
            }
        });

    }


}
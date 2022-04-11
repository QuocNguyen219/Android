package com.example.demongay1thang3;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;


public class Fragment_DanhSach extends Fragment {

    MyArrayAdapter myArrayAdapter = null;
    ArrayList<SanPham> dsSP = new ArrayList<SanPham>();
    GridView gridView_sanPham;


    public Fragment_DanhSach() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__danh_sach, container, false);
        gridView_sanPham = view.findViewById(R.id.grView_SanPham);
        prepareGridView();
        myArrayAdapter = new MyArrayAdapter(getActivity(), R.layout.mygridview, dsSP);
        gridView_sanPham.setAdapter(myArrayAdapter);


        gridView_sanPham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Bundle bundle = new Bundle();
                bundle.putString("key", dsSP.get(i).toString());
                Fragment_ChiTiet fragment_chiTiet = new Fragment_ChiTiet();
                fragment_chiTiet.setArguments(bundle);

                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    getFragmentManager().beginTransaction()
                            .replace(R.id.fragment_chiTiet, fragment_chiTiet)
                            .commit();
                } else {
                    getFragmentManager().beginTransaction()
                            .replace(R.id.fragment_danhSach, fragment_chiTiet)
                            .commit();
                }
            }
        });

        Button btn_Thoat = view.findViewById(R.id.bt_Thoat);
        btn_Thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    public void prepareGridView() {
        dsSP.add(new SanPham(R.drawable.bia, "Bia Budweiser", "280.000đ", "Budweiser", "Hoa bia,mạch nha", "Thùng  20 lon", "Việt Nam", "Giao hàng nhanh"));
        dsSP.add(new SanPham(R.drawable.dauan, "Dầu ăn Meizan", "2500.000đ", "Meizan", "Dầu đậu nành", "Can 5 lít", "Việt Nam", "Giao hàng nhanh"));
        dsSP.add(new SanPham(R.drawable.dauphong, "Đậu phộng", "19.000đ", "PMT ", "Đậu phộng 100%", "Bịch 250g", "Việt Nam", "Giao hàng nhanh"));
        dsSP.add(new SanPham(R.drawable.duong, "Đường trắng", "27.000đ", "Lam Sơn", "Mía", "Bịch 1kg", "Việt Nam", "Giao hàng nhanh"));
        dsSP.add(new SanPham(R.drawable.mi, "Mì Koreno", "5.000đ", "Koreno", "Bôt mì,dầu", "Ly 65g", "Việt Nam", "Giao hàng nhanh"));
        dsSP.add(new SanPham(R.drawable.mien, "Miến gà", "343.000đ", "Chin-su", "Miến", "Tô 129g", "Việt Nam", "Giao hàng nhanh"));
        dsSP.add(new SanPham(R.drawable.milo, "Sữa Milo", "13.600đ", "Milo", "Nước,sữa bột,đường", "Hộp", "Việt Nam", "Giao hàng nhanh"));
        dsSP.add(new SanPham(R.drawable.muoi, "Muối Bạc Liêu", "10.000đ", "Bạc Liêu", "Muối", "Bịch 1kg", "Việt Nam", "Giao hàng nhanh"));
        dsSP.add(new SanPham(R.drawable.pho, "Phở nghêu", "6.000đ", "Đệ Nhất", "Vắt phở,đường,muối", "Gói 64g", "Việt Nam", "Giao hàng nhanh"));
        dsSP.add(new SanPham(R.drawable.sua, "Sữa tươi", "335.000đ", "Vinamilk", "Sữa bò", "Thùng  48 hộp", "Việt Nam", "Giao hàng nhanh"));
        dsSP.add(new SanPham(R.drawable.trung, "Trứng vịt", "30.000đ", "Happy Egg", "Trứng", "Bịch 1kg", "Việt Nam", "Giao hàng nhanh"));
        dsSP.add(new SanPham(R.drawable.xucxich, "Xúc xích", "10.000đ", "C.P", "Thịt", "Cây 60g", "Việt Nam", "Giao hàng nhanh"));
    }


}
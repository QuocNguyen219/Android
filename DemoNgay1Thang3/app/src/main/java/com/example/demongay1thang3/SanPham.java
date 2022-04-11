package com.example.demongay1thang3;

import java.io.Serializable;

public class SanPham implements Serializable {
    private int anh;
    private String ten;
    private String gia;
    private String thuongHieu;
    private String thanhPhan;
    private String quyCach;
    private String xuatXu;
    private String giaoHang;

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public String getThanhPhan() {
        return thanhPhan;
    }

    public void setThanhPhan(String thanhPhan) {
        this.thanhPhan = thanhPhan;
    }

    public String getQuyCach() {
        return quyCach;
    }

    public void setQuyCach(String quyCach) {
        quyCach = quyCach;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        xuatXu = xuatXu;
    }

    public String getGiaoHang() {
        return giaoHang;
    }

    public void setGiaoHang(String giaoHang) {
        giaoHang = giaoHang;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public SanPham(int anh, String ten, String gia, String thuongHieu, String thanhPhan, String quyCach, String xuatXu, String giaoHang) {
        this.anh = anh;
        this.ten = ten;
        this.gia = gia;
        this.thuongHieu = thuongHieu;
        this.thanhPhan = thanhPhan;
        this.quyCach = quyCach;
        this.xuatXu = xuatXu;
        this.giaoHang = giaoHang;
    }

    @Override
    public String toString() {
        return anh + "," + ten + "," + gia + "," + thuongHieu + "," + thanhPhan + "," + quyCach + "," + xuatXu + "," + giaoHang;
    }
}

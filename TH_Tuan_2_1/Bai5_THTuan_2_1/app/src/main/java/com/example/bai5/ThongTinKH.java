package com.example.bai5;

public class ThongTinKH {


    private String tenKH;
    private int slSach;
    private boolean vip;
    private double thanhTien;

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public int getSlSach() {
        return slSach;
    }

    public void setSlSach(int slSach) {
        this.slSach = slSach;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public ThongTinKH(String tenKH, int slSach, boolean vip, double thanhTien) {
        this.tenKH = tenKH;
        this.slSach = slSach;
        this.vip = vip;
        this.thanhTien = thanhTien;
    }

    @Override
    public String toString() {
        return "ThongTinKH{" +
                "tenKH='" + tenKH + '\'' +
                ", slSach=" + slSach +
                ", vip=" + vip +
                ", thanhTien=" + thanhTien +
                '}';
    }
}

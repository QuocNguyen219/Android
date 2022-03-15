package com.example.bai5_thtuan2_2;

public class EmployeePartTime extends Employee {
    @Override
    public double tinhLuong() {
        return 150;
    }

    @Override
    public String toString() {
        return super.toString()+"--> Part time = "+tinhLuong();
    }
}

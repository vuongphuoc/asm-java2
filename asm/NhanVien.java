/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class NhanVien implements Serializable{
    private String maNhanVien ;
    private String hoVaTen ;
    private int tuoi ;
    private String email ;
    private double luong ;

    public NhanVien() {
    }

    public NhanVien(String maNhanVien, String hoVaTen, int tuoi, String email, double luong) {
        this.maNhanVien = maNhanVien;
        this.hoVaTen = hoVaTen;
        this.tuoi = tuoi;
        this.email = email;
        this.luong = luong;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }
    
    
}

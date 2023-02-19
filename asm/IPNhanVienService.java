/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface IPNhanVienService {

    public void insert(NhanVien p);

    public void update(int viTri, NhanVien p);

    public void delete(int viTri);

    public ArrayList<NhanVien> select();
    public void setList(ArrayList<NhanVien> ds); // dùng để cập nhật  cho dữ liệu luôn chính xác để ghi , đọc file 

}

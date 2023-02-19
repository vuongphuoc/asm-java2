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
public class NhanVienService implements IPNhanVienService {

    private ArrayList<NhanVien> list = new ArrayList<>();

    @Override
    public void insert(NhanVien p) {
        list.add(p);
    }

    @Override
    public void update(int viTri, NhanVien p) {
        list.set(viTri, p);

    }

    @Override
    public void delete(int viTri) {
        list.remove(viTri);
    }

    @Override
    public ArrayList<NhanVien> select() {
        return this.list;
    }

    @Override
    public void setList(ArrayList<NhanVien> ds) {
        this.list = ds;
    }

}

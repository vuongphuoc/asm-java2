/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package asm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.regex.Pattern;
import javax.lang.model.util.SimpleAnnotationValueVisitor14;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lad3FPT.Student;

/**
 *
 * @author Admin
 */
public class QLNhanVienForm extends javax.swing.JFrame implements Runnable {

    private IPNhanVienService serv;
    private DefaultTableModel defaultTableModel;
    private String filename = "asm.txt";

    /**
     * Creates new form QLNhanVienForm
     */
    public QLNhanVienForm() {
        this.serv = new NhanVienService();
        initComponents();
        setLocationRelativeTo(null);
        this.loadTable();
        Thread t = new Thread(this); // chạy tiến trình 
        t.start();

    }

    @Override
    public void run() { // nội dung luồng muốn thực thi và in ra 
        while (true) {
            try {
                // Chờ 1s trước khi thực hiện tiếp
                Thread.sleep(1000);// không ảnh hưởng đến hiện giờ phút giây trên swing nhưng in ra chuẩn thì vẫn tốt hơn  
            } catch (InterruptedException e) { // ngoại lệ khi luồng bị gián đoạn
                e.printStackTrace();
            }

            String t = this.getTime();
            System.out.println(t); // in ra màn hình output
            this.lblDongHo.setText(t); // in ra trong bảng swing 
        }
    }

    private void loadTable() {
        defaultTableModel = (DefaultTableModel) tblNhanVienForm.getModel();
        defaultTableModel.setRowCount(0);
        for (NhanVien p : serv.select()) {
            defaultTableModel.addRow(new Object[]{
                p.getMaNhanVien(), p.getHoVaTen(), p.getTuoi(), p.getEmail(), p.getLuong()
            });
        }
    }

    public String getTime() {
        Calendar c = Calendar.getInstance(); // lấy giờ phút giây từ hệ thống máy tính rồi lưu vào biến c
        int h = c.get(Calendar.HOUR_OF_DAY); // lấy giờ hiện tại 
        int m = c.get(Calendar.MINUTE); // lấy phút hiện tại 
        int s = c.get(Calendar.SECOND); // lấy giây hiện tại 
        return h + ":" + m + ":" + s;
    }

    private NhanVien getForm() {
        String ma = txtMaNhanVien.getText();
        String hoten = txtHoVaTen.getText();
        String tuoi = txtTuoi.getText();
        String email = txtEmail.getText();
        String luong = txtLuong.getText();
        if (ma.trim().equals("") || hoten.trim().equals("") || tuoi.trim().equals("") || email.trim().equals("") || luong.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để trống");
            return null;
        }

        try { // tuổi
            int tuoi1 = Integer.parseInt(txtTuoi.getText());
            if (tuoi1 < 16 || tuoi1 > 55) {
                JOptionPane.showMessageDialog(this, "Tuổi phải trong khoảng 16 đến 55");
                return null;
            }
        } catch (NumberFormatException e) { // ngoại lệ chuỗi cố gắng chuyển thành số
            JOptionPane.showMessageDialog(this, "Tuổi phải là số");
            e.printStackTrace();
            return null;
        }
        try { // lương
            double luong1 = Double.parseDouble(txtLuong.getText());
            if (luong1 <= 5000000) {
                JOptionPane.showMessageDialog(this, "Lương phải > 5 triệu");
                return null;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Lương phải là số");
            e.printStackTrace();
            return null;
        }
        NhanVien p = new NhanVien();
        p.setMaNhanVien(ma);
        p.setHoVaTen(hoten);

        String regex = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+"
                + "@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])"
                + "|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        Pattern pattern = Pattern.compile(regex);
        if (pattern.matcher(email).matches() == false) {
            JOptionPane.showMessageDialog(this, "email không đúng định dạng");
            return null;
        } else {
            p.setEmail(email);
        }

        p.setTuoi(Integer.parseInt(txtTuoi.getText()));
        p.setLuong(Double.parseDouble(txtLuong.getText()));
        return p;
    }

    private void Clean() {
        txtMaNhanVien.setText("");
        txtHoVaTen.setText("");
        txtTuoi.setText("");
        txtLuong.setText("");
        txtEmail.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblDongHo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtMaNhanVien = new javax.swing.JTextField();
        txtHoVaTen = new javax.swing.JTextField();
        txtTuoi = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtLuong = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        btnOpen = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVienForm = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("QUẢN LÍ NHÂN VIÊN");

        lblDongHo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDongHo.setForeground(new java.awt.Color(255, 51, 51));
        lblDongHo.setText("00:00:00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(101, 101, 101)
                .addComponent(lblDongHo)
                .addGap(56, 56, 56))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblDongHo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setText("MÃ NHÂN VIÊN");

        jLabel9.setText("HỌ VÀ TÊN");

        jLabel10.setText("TUỔI");

        jLabel11.setText("EMAIL");

        jLabel12.setText("LƯƠNG");

        txtHoVaTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoVaTenActionPerformed(evt);
            }
        });

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        txtLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLuongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaNhanVien)
                    .addComponent(txtHoVaTen)
                    .addComponent(txtTuoi)
                    .addComponent(txtEmail)
                    .addComponent(txtLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txtHoVaTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        btnOpen.setText("Open");
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNew)
                    .addComponent(btnSave)
                    .addComponent(btnDelete)
                    .addComponent(btnFind)
                    .addComponent(btnOpen)
                    .addComponent(btnExit))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btnNew)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFind)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnOpen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExit)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        tblNhanVienForm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "MÃ", "HỌ VÀ TÊN", "TUỔI", "EMAIL", "LƯƠNG"
            }
        ));
        tblNhanVienForm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienFormMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVienForm);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtHoVaTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoVaTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoVaTenActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLuongActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        Clean();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        ArrayList<NhanVien> list = new ArrayList<>();// khởi tạo 1 list chứa các thông tin của Student
        for (NhanVien p : serv.select()) { // duyệt qua tất cả hs trong Student
            if (p.getMaNhanVien().equalsIgnoreCase(txtMaNhanVien.getText())) {
                JOptionPane.showMessageDialog(this, "Đã trùng ID");
                return;
            }
        }
        int row = tblNhanVienForm.getSelectedRow();
        if (row == -1) {
            NhanVien p = this.getForm();  // them
            if (p == null) {
                return;
            }

            this.serv.insert(p);
            JOptionPane.showMessageDialog(this, "Đã thêm");
            loadTable();
            Clean();
        } else {
            NhanVien p = getForm(); // cap nhat
            if (p == null) {
                return;
            }

            serv.update(row, p);
            JOptionPane.showMessageDialog(this, "Cập nhật thành công");
            loadTable();
            Clean();
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void tblNhanVienFormMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienFormMouseClicked
        int row = tblNhanVienForm.getSelectedRow();
        if (row == -1) {
            return;
        }
        String ma = tblNhanVienForm.getValueAt(row, 0).toString();
        String hoten = tblNhanVienForm.getValueAt(row, 1).toString();
        String tuoi = tblNhanVienForm.getValueAt(row, 2).toString();
        String email = tblNhanVienForm.getValueAt(row, 3).toString();
        String luong = tblNhanVienForm.getValueAt(row, 4).toString();
        txtMaNhanVien.setText(ma);
        txtHoVaTen.setText(hoten);
        txtTuoi.setText(tuoi);
        txtEmail.setText(email);
        txtLuong.setText(luong);
    }//GEN-LAST:event_tblNhanVienFormMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int row = tblNhanVienForm.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng để xoá");
            return;
        } else {
            serv.delete(row);
            JOptionPane.showMessageDialog(this, "Đã xoá");
        }
        loadTable();
        Clean();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        String search = JOptionPane.showInputDialog(this, "Nhập mã", "Tìm kiếm", JOptionPane.YES_OPTION);
        ArrayList<NhanVien> list = new ArrayList<>();// khởi tạo 1 list chứa các thông tin của Student
        for (NhanVien p : serv.select()) { // duyệt qua tất cả hs trong Student
            if (p.getMaNhanVien().equalsIgnoreCase(search)) {
                list.add(p); // nếu tìm được thì thêm vào list tìm thấy 
            }
        }

        if (list.isEmpty()) { // check rỗng
            JOptionPane.showMessageDialog(this, "Không có nhân viên nào");
        } else {
            defaultTableModel = (DefaultTableModel) tblNhanVienForm.getModel(); // duyệt lên table 
            defaultTableModel.setRowCount(0);
            for (NhanVien p : list) {
                defaultTableModel.addRow(new Object[]{
                    p.getMaNhanVien(), p.getHoVaTen(), p.getTuoi(), p.getEmail(), p.getLuong()

                });
            }
        }
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        File f = new File(filename);
        // Kiểm tra file tồn tại trước khi xử lý
        if (f.exists() == false) {
            JOptionPane.showMessageDialog(this, "File không tồn tại");
            return;
        }

        try {
            // Mở luồng để đọc file
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<NhanVien> ds = (ArrayList<NhanVien>) ois.readObject();
            ois.close();
            JOptionPane.showMessageDialog(this, "Đọc file thành công");
            this.serv.setList(ds);
            this.loadTable();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "File không tồn tại");
            e.printStackTrace();
            return;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Lỗi luồng đọc");
            e.printStackTrace();
            return;
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Lỗi luồng đọc");
            e.printStackTrace();
            return;
        }
    }//GEN-LAST:event_btnOpenActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        File f = new File(filename);
        // Kiểm tra file tồn tại trước khi xử lý
        if (f.exists() == false) {
            JOptionPane.showMessageDialog(this, "File không tồn tại");
            return;
        }

        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            ArrayList<NhanVien> ds = this.serv.select();
            oos.writeObject(ds);
            oos.close();
            JOptionPane.showMessageDialog(this, "Ghi file thành công và thoát");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "File không tồn tại");
            e.printStackTrace();
            return;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Lỗi luồng ghi");
            e.printStackTrace();
            return;
        }
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QLNhanVienForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLNhanVienForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLNhanVienForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLNhanVienForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLNhanVienForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDongHo;
    private javax.swing.JTable tblNhanVienForm;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoVaTen;
    private javax.swing.JTextField txtLuong;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtTuoi;
    // End of variables declaration//GEN-END:variables
}

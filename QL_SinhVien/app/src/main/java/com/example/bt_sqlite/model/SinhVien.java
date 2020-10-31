package com.example.bt_sqlite.model;

public class SinhVien {

    public int ID;
    public String Ten;
    public String Sdt;
    public String Email;
    public String KhoaHoc;
    public byte[] Anh;

    public SinhVien() {
    }

    public SinhVien(int ID, String ten, String sdt, String email, String khoaHoc, byte[] anh) {
        this.ID = ID;
        Ten = ten;
        Sdt = sdt;
        Email = email;
        KhoaHoc = khoaHoc;
        Anh = anh;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String sdt) {
        Sdt = sdt;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getKhoaHoc() {
        return KhoaHoc;
    }

    public void setKhoaHoc(String khoaHoc) {
        KhoaHoc = khoaHoc;
    }

    public byte[] getAnh() {
        return Anh;
    }

    public void setAnh(byte[] anh) {
        Anh = anh;
    }
}

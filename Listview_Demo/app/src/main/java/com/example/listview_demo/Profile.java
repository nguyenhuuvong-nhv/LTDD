package com.example.listview_demo;

public class Profile {
    private String Ten;
    private String Mota;
    private int img;

    public Profile(String ten, String mota, int img) {
        Ten = ten;
        Mota = mota;
        this.img = img;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String mota) {
        Mota = mota;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}

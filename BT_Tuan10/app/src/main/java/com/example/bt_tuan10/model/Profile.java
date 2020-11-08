package com.example.bt_tuan10.model;

public class Profile {

    public String Ten;
    public String Address;
    public String Phone;
    public int Image;

    public Profile() {
    }

    public Profile(String ten, String address, String phone, int image) {
        Ten = ten;
        Address = address;
        Phone = phone;
        Image = image;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}

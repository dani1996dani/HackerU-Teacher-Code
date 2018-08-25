package com.example.hackeru.lesson30listview;

public class Country {
    private String name;
    private String code;
    private String dialCode;
    private int image;

    public Country(String name, String code, String dialCode, int image) {
        this.name = name;
        this.code = code;
        this.dialCode = dialCode;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDialCode() {
        return dialCode;
    }

    public void setDialCode(String dialCode) {
        this.dialCode = dialCode;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

package com.example.myfirstproject;

public class Product {
    private int id;
    private  String name;
    private  int price;
    private  int img;

    public Product(int id, String name, int price, int img) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.img = img;
    }

    public Product(){}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getImg() {
        return img;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setImg(int img) {
        this.img = img;
    }

}

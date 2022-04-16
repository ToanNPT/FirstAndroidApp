package com.example.sqlite;

public class ProductModel {
    private int id;
    private  String name;
    private  int inStock;

    public ProductModel(){}

    public ProductModel(int id, String name, int inStock){
        this.id = id;
        this.name = name;
        this.inStock = inStock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }
}

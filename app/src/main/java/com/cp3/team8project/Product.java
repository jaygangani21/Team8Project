package com.cp3.team8project;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "product_table")
public class Product {
    @PrimaryKey
    private int id;
    private int category_id;
    private String name;
    private float price;
    private String description;
    private String specifications;
    private String img1;
    private String img2;


    public Product() { }

    public Product(int id, int category_id, String name, float price, String description, String specifications, String img1, String img2) {
        this.id = id;
        this.category_id = category_id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.specifications = specifications;
        this.img1 = img1;
        this.img2 = img2;
    }

    public void setCategory_id(int category_id) { this.category_id = category_id; }

    public int getCategory_id() { return category_id; }

    public void setId(int id) { this.id = id; }

    public int getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public float getPrice() { return price;}

    public void setPrice(float price) { this.price = price; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }
}

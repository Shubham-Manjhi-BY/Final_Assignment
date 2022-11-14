package com.Assignment_Shop_Service.Entity;


import javax.persistence.*;

@Entity
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    private String Category_type;

    public Category() {
    }

    public Category(int id, String category_type) {
        id = id;
        Category_type = category_type;
    }

    public int getCategory_id() {
        return id;
    }

    public void setCategory_id(int category_id) {
        id = category_id;
    }

    public String getCategory_type() {
        return Category_type;
    }

    public void setCategory_type(String category_type) {
        Category_type = category_type;
    }

    @Override
    public String toString() {
        return "Category{" +
                "Category_id=" + id +
                ", Category_type='" + Category_type + '\'' +
                '}';
    }
}

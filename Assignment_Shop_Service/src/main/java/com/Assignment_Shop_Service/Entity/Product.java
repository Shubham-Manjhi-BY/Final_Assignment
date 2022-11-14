package com.Assignment_Shop_Service.Entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product
{

    // ########################################## Product Implementation ###############################################
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    private String product_name;

    private String product_price;

    private String product_description;

    public Product() {
    }

    public Product(int id, String product_name, String product_price, String product_description) {
        this.id = id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_description = product_description;
    }

    public int getProduct_id() {
        return id;
    }

    public void setProduct_id(int product_id) {
        this.id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + id +
                ", product_name='" + product_name + '\'' +
                ", product_price='" + product_price + '\'' +
                ", product_description='" + product_description + '\'' +
                '}';
    }

    // #################################################################################################################

    // ############################################# Product - Category ################################################

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="categoryid", referencedColumnName = "id")
    private List<Category> categories = new ArrayList<>();

    public void addCategory(Category category)
    {
        categories.add(category);
    }

    public void deleteCategory(Category category)
    {
        if(!categories.isEmpty()) categories.remove(category);
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    // #################################################################################################################

}

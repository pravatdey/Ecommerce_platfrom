 
package com.mycompany.e_commerce_project.entites;
import javax.persistence.*;
import java.util.*;
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int categoryId;
    private String categoryTitle;
    private String categotyDescription;
    @OneToMany(mappedBy="category")
    private List<Product>products= new ArrayList<>();

    public Category(int categoryId, String categoryTitle, String categotyDescription) {
        this.categoryId = categoryId;
        this.categoryTitle = categoryTitle;
        this.categotyDescription = categotyDescription;
    }

    public Category(String categoryTitle, String categotyDescription,List<Product>products) {
        this.categoryTitle = categoryTitle;
        this.categotyDescription = categotyDescription;
        this.products=products;
    }
    
    
    public Category() {
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public String getCategotyDescription() {
        return categotyDescription;
    }

    public void setCategotyDescription(String categotyDescription) {
        this.categotyDescription = categotyDescription;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
    @Override
    public String toString() {
        return "Category{" + "categoryId=" + categoryId + ", categoryTitle=" + categoryTitle + ", categotyDescription=" + categotyDescription + '}';
    }
    
    
    
}

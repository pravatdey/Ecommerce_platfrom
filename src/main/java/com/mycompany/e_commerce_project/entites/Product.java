 
package com.mycompany.e_commerce_project.entites;
import javax.persistence.*;
 @Entity
public class Product {
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     private int pid;
     private String pName;
     @Column(length=4000)
     private String pDescription;
     private String pPhoto;
     private  int pPrice;
     private int pDiscount;
     private int pQuantity;
     @ManyToOne
     private Category category;
    public Product() {
    }

    public Product(String pName, String pDescription, String pPhoto, int pPrice, int pDiscount, int pQuantity, Category category) {
        this.pName = pName;
        this.pDescription = pDescription;
        this.pPhoto = pPhoto;
        this.pPrice = pPrice;
        this.pDiscount = pDiscount;
        this.pQuantity = pQuantity;
        this.category=category;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpDescription() {
        return pDescription;
    }

    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }

    public String getpPhoto() {
        return pPhoto;
    }

    public void setpPhoto(String pPhoto) {
        this.pPhoto = pPhoto;
    }

    public int getpPrice() {
        return pPrice;
    }

    public void setpPrice(int pPrice) {
        this.pPrice = pPrice;
    }

    public int getpDiscount() {
        return pDiscount;
    }

    public void setpDiscount(int pDiscount) {
        this.pDiscount = pDiscount;
    }

    public int getpQuantity() {
        return pQuantity;
    }

    public void setpQuantity(int pQuantity) {
        this.pQuantity = pQuantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    @Override
    public String toString() {
        return "Product{" + "pid=" + pid + ", pName=" + pName + ", pDescription=" + pDescription + ", pPhoto=" + pPhoto + ", pPrice=" + pPrice + ", pDiscount=" + pDiscount + ", pQuantity=" + pQuantity + '}';
    }
     
    
    //calculate priceafter discount
    public int getPriceAfterDiscount(){
        int dis=(int) (this.getpDiscount()/100.0)*this.getpPrice();
        return this.getpPrice()-dis;
//        int d=(int)(this.getpDiscount()/100.0)*this.getpPrice();
//        return this.getpPrice()-d;
    }
}

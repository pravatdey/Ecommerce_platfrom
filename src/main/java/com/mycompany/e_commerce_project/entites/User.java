package com.mycompany.e_commerce_project.entites;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10, name = "User_id")
    private int User_id;
    @Column(length = 100, name = "User_name")
    private String User_name;
    @Column(length = 100, name = "User_email")
    private String User_Email;

    @Column(length = 100, name = "User_password")
    private String User_Password;
    @Column(length = 12, name = "User_phone")
    private String User_Phone;
    @Column(length = 1200, name = "User_adharpic")
    private String User_adhar_pic;
    @Column(length = 1200, name = "User_address")
    private String User_Address;
    @Column(name="User_type")
    private String User_Type;
    
    public User(int User_id, String User_name, String User_Email, String User_Password, String User_Phone, String User_adhar_pic, String User_Address, String User_Type) {
        this.User_id = User_id;
        this.User_name = User_name;
        this.User_Email = User_Email;

        this.User_Password = User_Password;
        this.User_Phone = User_Phone;
        this.User_adhar_pic = User_adhar_pic;
        this.User_Address = User_Address;
        this.User_Type=User_Type;
    }

    public User(String User_name, String User_Email, String User_Password, String User_Phone, String User_adhar_pic, String User_Address,String User_Type) {
        this.User_name = User_name;
        this.User_Email = User_Email;

        this.User_Password = User_Password;
        this.User_Phone = User_Phone;
        this.User_adhar_pic = User_adhar_pic;
        this.User_Address = User_Address;
        this.User_Type = User_Type;
    }

    public User() {
    }

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int User_id) {
        this.User_id = User_id;
    }

    public String getUser_name() {
        return User_name;
    }

    public void setUser_name(String User_name) {
        this.User_name = User_name;
    }

    public String getUser_Email() {
        return User_Email;
    }

    public void setUser_Email(String User_Email) {
        this.User_Email = User_Email;
    }

    public String getUser_Password() {
        return User_Password;
    }

    public void setUser_Password(String User_Password) {
        this.User_Password = User_Password;
    }

    public String getUser_Phone() {
        return User_Phone;
    }

    public void setUser_Phone(String User_Phone) {
        this.User_Phone = User_Phone;
    }

    public String getUser_adhar_pic() {
        return User_adhar_pic;
    }

    public void setUser_adhar_pic(String User_adhar_pic) {
        this.User_adhar_pic = User_adhar_pic;
    }

    public String getUser_Address() {
        return User_Address;
    }

    public void setUser_Address(String User_Address) {
        this.User_Address = User_Address;
    }

    public void setUser_Type(String User_Type) {
        this.User_Type = User_Type;
    }

    public String getUser_Type() {
        return User_Type;
    }
    

    @Override
    public String toString() {
        return "User{" + "User_id=" + User_id + ", User_name=" + User_name + ", User_Email=" + User_Email
                + ", User_Password=" + User_Password + ", User_Phone=" + User_Phone + ", User_adhar_pic=" + User_adhar_pic + ", User_Address=" + User_Address + '}';
    }

}

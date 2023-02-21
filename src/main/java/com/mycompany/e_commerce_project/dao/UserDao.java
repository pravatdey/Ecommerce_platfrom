package com.mycompany.e_commerce_project.dao;

import com.mycompany.e_commerce_project.entites.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserDao {

    private SessionFactory factory;

    public UserDao(SessionFactory factory) {
        this.factory = factory;
    }

    public User getUserbyEmailandPassword(String email, String password) {
        User us = null;
        try {

            String query = "from User where User_Email =: e and User_Password =: p";
            Session session = this.factory.openSession();
            Query q = session.createQuery(query);
            q.setParameter("e", email);
            q.setParameter("p", password);

            us= (User) q.uniqueResult();

            session.close();
        } catch (Exception e) {

        }
        return us;

    }

}

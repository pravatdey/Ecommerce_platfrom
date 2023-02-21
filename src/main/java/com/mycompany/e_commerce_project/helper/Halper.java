 
package com.mycompany.e_commerce_project.helper;


import com.mysql.cj.Query;
import com.mysql.cj.Session;
import org.hibernate.SessionFactory;

import java.util.HashMap;
import java.util.Map;

public class Halper {

    public static String get10words(String Discription) {
        String[] str = Discription.split(" ");
        if (str.length > 10) {
            String res = "";
            for (int i = 0; i < 10; i++) {
                res = res + str[i] + " ";
            }
            return (res + "...");
        } else {
            return (Discription + "...");
        }
    }

    public static Map<String, Long> getCount(SessionFactory factory) {
        Session session = (Session) factory.openSession();
        String q1 = "Select count(*)from User";
        String q2 = "Select count(*)from Product";

        Query query = session.createQuery(q1);
        Query query2 = session.createQuery(q2);
        Long usercount = (Long) query.list().get(0);
        Long Productcount = (Long) query2.list().get(0);

        Map<String, Long> map = new HashMap<>();
        map.put("usrCount", usercount);
        map.put("ProductCount", Productcount);

        session.close();
        return map;
    }

}

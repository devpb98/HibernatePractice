package com.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myhibernate","root","2728");
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
        System.out.println("Project Started....");
        
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(Student.class);
        cfg.configure("hibernate.cfg.xml");
        
        SessionFactory factory= cfg.buildSessionFactory();
        
        System.out.println(factory);
        Student st = new Student();
        st.setId(102);
        st.setName("Krati");
        st.setCity("Jaipur");
        
        System.out.println(st);
        Session session = factory.openSession();
        
        session.beginTransaction();
        
        session.save(st);
        session.getTransaction().commit();
        try{
            
        }finally{
            factory.close();
        }
	}

}

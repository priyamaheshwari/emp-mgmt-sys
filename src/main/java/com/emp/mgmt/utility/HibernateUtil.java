package com.emp.mgmt.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
@SuppressWarnings("deprecation")
public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    static {
        try {
            sessionFactory = new Configuration().configure()
                    .buildSessionFactory();
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("SessionFactory creation failed" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static Session getSession()
    {
    	Session hibernateSession = sessionFactory.getCurrentSession();
    	return hibernateSession;
    }
    
    public static Session beginTransaction()
    {
    	Session hibernatSession = HibernateUtil.getSession();
    	hibernatSession.beginTransaction();
    	return hibernatSession;
    }
    
    public static void commitTransaction()
    {
    	HibernateUtil.getSession().getTransaction().commit();
    }
    
    public static void rollbackTransaction()
    {
    	HibernateUtil.getSession().getTransaction().rollback();
    }
    
    public static void closeTransaction()
    {
    	HibernateUtil.getSession().close();
    }
}

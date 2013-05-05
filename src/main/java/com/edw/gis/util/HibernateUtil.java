package com.edw.gis.util;

import org.apache.log4j.Logger;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author edwin < edwinkun at gmail dot com >
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private static final Logger logger = Logger.getLogger(HibernateUtil.class);
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            logger.error("Initial SessionFactory creation failed." + ex, ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

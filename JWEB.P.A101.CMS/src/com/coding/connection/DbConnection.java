package com.coding.connection;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbConnection {
    
    private static String path = "D:\\workspace-it\\code\\workspace\\path to fullstack\\fsoft trainning\\assignment\\JWEB.P.A101.CMS\\src\\hibernate.cfg.xml";
    private static SessionFactory sessionFactory;

    private DbConnection() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                File configFile = new File(path);
                Configuration configuration = new Configuration();
                sessionFactory = configuration.configure(configFile)
                		.buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Lỗi khi tạo SessionFactory!");
            }
        }
        return sessionFactory;
    }
}

package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import spring.model.Department;

import java.io.IOException;
import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static Session session;

    public static Session getSession() throws IOException {
        if(sessionFactory == null){
            //no session factory set up yet
            Configuration config = new Configuration();
            Properties props = new Properties();
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            props.load(loader.getResourceAsStream("hibernate.properties"));


            //add our properties to the configuration
            config.setProperties(props);
            //we need to include our mapped objects!!!!!

            /*here*/
            config.addAnnotatedClass(Department.class);

            ServiceRegistry serviceRegistry= new StandardServiceRegistryBuilder()
                    .applySettings(config.getProperties()).build();
            sessionFactory = config.buildSessionFactory(serviceRegistry);



        }

        return sessionFactory.openSession();
    }

    public static void closeSession() {
        session.close();
        session = null;
    }

}

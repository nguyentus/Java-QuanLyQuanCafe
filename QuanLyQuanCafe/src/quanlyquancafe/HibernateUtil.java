package quanlyquancafe;

import quanlyquancafe.pojo.Account;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import quanlyquancafe.pojo.Drink;
import quanlyquancafe.pojo.DrinkCategory;

public class HibernateUtil {
    private static SessionFactory factory;
    static {
        try {
            Configuration configure = new Configuration();
            configure.addAnnotatedClass(Account.class);
            configure.addAnnotatedClass(DrinkCategory.class);
            configure.addAnnotatedClass(Drink.class);
            configure.configure("hibernate.cfg.xml");
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configure.getProperties());
            factory = configure.buildSessionFactory(builder.build());
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory(){
        return factory;
    }
}

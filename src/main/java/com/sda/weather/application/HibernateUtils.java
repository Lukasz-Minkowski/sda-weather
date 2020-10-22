package com.sda.weather.application;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {

    private static SessionFactory sessionFactory;

    //nawiązanie połączenia z bazą danych powinno być tylko jedno na początku odpalenia aplikacji, dlatego,
    //trzymamy to w odrębnej klasie: HibernateUtils
    //poniżej implementujemy singleton, aby tylko raz utworzyć obiekt typu session factory

    static {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}

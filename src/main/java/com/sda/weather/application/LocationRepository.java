package com.sda.weather.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class LocationRepository { //warstwa danych

    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    public Location saveNewLocation(Location location) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(location);

        transaction.commit();
        session.close();

        return location;
    }

    public List<Location> readAllLocations() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Location> result = session.createQuery("FROM Location").getResultList();

        transaction.commit();
        session.close();

        return result;
    }
}

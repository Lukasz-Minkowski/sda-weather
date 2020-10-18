package com.sda.weather.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class EntryRepository {
    private final SessionFactory sessionFactory;

    public EntryRepository() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();

        sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
    }

    public Entry saveNewEntry(Entry entry) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(entry);

        transaction.commit();
        session.close();

        return entry;
    }

    public List<Entry> readAllEntries() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Entry> result = session.createQuery("FROM Entry").getResultList();

        transaction.commit();
        session.close();

        return result;
    }
}

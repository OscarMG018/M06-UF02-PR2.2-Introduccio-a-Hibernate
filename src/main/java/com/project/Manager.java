package com.project;

import java.util.Collection;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Manager {

    private static SessionFactory factory;

    public static void init() {
        factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .buildSessionFactory();
    }

    public static Ciutat addCiutat(String nom, String pais, int codipostal) {
        Session session = factory.openSession();
        Ciutat c = new Ciutat();
        c.setNom(nom);
        c.setPais(pais);
        c.setCodiPostal(codipostal);
        try {
            session.beginTransaction();
            session.persist(c);
            session.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return c;
    }

    public static void updateCiutat(long ciutatId, String nom, String pais, Set<Ciutada> ciutadans) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Ciutat c = session.get(Ciutat.class, ciutatId);
            if (c == null) {
                System.out.println("Ciutat with ID " + ciutatId + " not found.");
                return;
            }

            c.setNom(nom);
            c.setPais(pais);
            c.setCiutadans(ciutadans);

            session.merge(c);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public static Ciutada addCiutada(String nom, String cognom, int edat) {
        Session session = factory.openSession();
        Ciutada c = new Ciutada();
        c.setNom(nom);
        c.setCognom(cognom);
        c.setEdat(edat);
        try {
            session.beginTransaction();
            session.persist(c);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return c;
    }

    public static void updateCiutada(long ciutadaId, String nom, String cognom, int edat) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Ciutada c = session.get(Ciutada.class, ciutadaId);
            if (c == null) {
                System.out.println("Ciutat with ID " + ciutadaId + " not found.");
                return;
            }

            c.setNom(nom);
            c.setCognom(cognom);
            c.setEdat(edat);

            session.merge(c);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public static void delete(Class<?> clazz, long id) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Object c = session.get(clazz, id);
            if (c == null) {
                System.out.println("entitiy with name:"+ clazz.getName() +" with ID " + id + " not found.");
                return;
            }
            session.remove(c);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public static <T> Collection<T> listCollection(Class<T> clazz, String hql) {
        if (hql == null || hql.trim().isEmpty()) {
            hql = "FROM " + clazz.getName();
        }
        Session session = factory.openSession();
        try {
            Query<T> query = session.createQuery(hql, clazz);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public static <T> String collectionToString(Class<T> clazz, Collection<T> list) {
        if (list == null || list.isEmpty()) {
            return "No data available";
        }
        StringBuilder sb = new StringBuilder();
        for (T item : list) {
            sb.append(item.toString()).append("\n");
        }
        return sb.toString().trim();
    }

    public static void close() {
        if (factory != null)
            factory.close();
    }

    public static Ciutat getCiutatWithCiutadans(long ciutatId) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Ciutat c = session.get(Ciutat.class, ciutatId);
            c.getCiutadans().size();
            session.getTransaction().commit();
            return c;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }
}
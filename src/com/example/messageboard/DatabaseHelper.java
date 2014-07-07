package com.example.messageboard;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class DatabaseHelper {

    private static SessionFactory factory;
    private static boolean isRunning = false;

    public static void runManager() {
        try {
            Configuration configuration = new Configuration().configure();
            StandardServiceRegistryBuilder builder =
                    new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            factory = configuration.buildSessionFactory(builder.build());
            isRunning = true;
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static void addTopic(String title, String createdBy) {
        if (!isRunning)
            runManager();
        Session session = factory.openSession();
        Transaction tx = null;
        Integer id = null;
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        try {
            tx = session.beginTransaction();
            Topic topicEntry = new Topic(title, cal, createdBy);
            id = (Integer) session.save(topicEntry);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void addMessage(String title, String createdBy, String text) {
        if (!isRunning)
            runManager();
        Session session = factory.openSession();
        Transaction tx = null;
        Integer id = null;
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        try {
            tx = session.beginTransaction();
            Message messageEntry = new Message(title, cal, createdBy, text);
            updateRecentMessage(title, cal);
            id = (Integer) session.save(messageEntry);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void updateRecentMessage(String title, Calendar timestamp) {
        if(!isRunning)
            runManager();
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            //NOTE: database does not account for duplicate titles
            List topics = session.createQuery("FROM Topic WHERE title = '" + title + "'").list();
            Topic topic = (Topic) topics.get(0);
            topic.setRecentMessage(timestamp);
            session.update(topic);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public static Message getMostRecentMessage(String title) {
        if (!isRunning)
            runManager();
        Session session = factory.openSession();
        Transaction tx = null;
        Message outMessage = null;
        try {
            tx = session.beginTransaction();
            List messages = session.createQuery("FROM Message m WHERE m.title = '" + title + "'" +
                    "ORDER BY m.timestamp ASC").list();
            outMessage = (Message) messages.get(messages.size()-1);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return outMessage;
    }

    public static List<Topic> getTopicList() {
        if (!isRunning)
            runManager();
        Session session = factory.openSession();
        Transaction tx = null;
        List<Topic> output = new ArrayList<Topic>();
        try {
            tx = session.beginTransaction();
            List topics = session.createQuery("FROM Topic t ORDER BY t.recentMessage DESC").list();
            for (Iterator iterator = topics.iterator(); iterator.hasNext();) {
                Topic t = (Topic) iterator.next();
                output.add(t);
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return output;
    }

    public static List<Message> getMessageList(String title) {
        if (!isRunning)
            runManager();
        Session session = factory.openSession();
        Transaction tx = null;
        List<Message> output = new ArrayList<Message>();
        try {
            tx = session.beginTransaction();
            List messages = session.createQuery("FROM Message m WHERE m.title = '" + title + "'" +
                    "ORDER BY m.timestamp ASC").list();
            for (Iterator iterator = messages.iterator(); iterator.hasNext();) {
                Message m = (Message) iterator.next();
                output.add(m);
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return output;
    }
}

package hibernate;


import hibernate.entities.Courses;
import hibernate.entities.Instructor;
import hibernate.entities.InstructorDetails;
import hibernate.entities.Students;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

public class HibernateUtil {
    public Session getSession() {
        Session session = null;
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Courses.class).addAnnotatedClass(Students.class).buildSessionFactory();
        session = sessionFactory.openSession();
        return session;
    }
    public void closeSession(Session session) {
        session.close();
    }
}

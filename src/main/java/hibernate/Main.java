package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.sql.Connection;
import java.sql.SQLException;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;


public class Main {
    public static void addInstructorWithDetails(){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        System.out.println("Session Built Successfully !!");
        //Create a new user object
        try {
            UUID newId = gen_random_uuid();
            InstructorDetails instructorDetails = new InstructorDetails(newId,"www.MostafaCoding.com", "Swimming");
            Instructor instructor = new Instructor(newId, "Mostafa","Hisham","Mostafa.hisham@giza.com","01150000695","Data Scientist");
            System.out.println("Objects Created Successfully !!");

            instructor.setInstructorDetails(instructorDetails);
            //Start Transaction
            session.beginTransaction();
            // Save the user object to the database
            session.save(instructorDetails);
            session.save(instructor);
            //Commit
            session.getTransaction().commit();
            System.out.println("Done");
        }finally {
            //Close the session
            session.close();
            sessionFactory.close();
        }
    }
    public static void getStudentCourses(){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Courses.class).addAnnotatedClass(Students.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        System.out.println("Session Built Successfully !!");

        try{
            Students student = session.get(Students.class,UUID.fromString("28275ab2-233b-431c-8f36-8817187de9dd"));
            System.out.println(student);
            System.out.println(student.getCoursesSet());
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
    private static UUID gen_random_uuid() {
        return UUID.randomUUID();
    }
    public static void main(String[] args) throws SQLException {
        getStudentCourses();
    }
}
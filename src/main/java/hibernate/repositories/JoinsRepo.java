package hibernate.repositories;

import hibernate.HibernateUtil;
import hibernate.entities.Courses;
import hibernate.entities.Students;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class JoinsRepo {
    public static void getInstructorsCourses(){
        HibernateUtil hibernateUtil = new HibernateUtil();
        Session session = hibernateUtil.getSession();
        try {
            session.beginTransaction();
            // Save the user object to the database
            String hql = "SELECT c.course_name,(i.first_name || i.last_name) " + "FROM Courses c " + "LEFT JOIN c.instructor i";

            Query<Object[]> query = session.createQuery(hql);
            List<Object[]> results = query.list();

            for (Object[] result : results) {
                String courseName = (String) result[0];
                String instructorFirstName = (String) result[1];

                System.out.println("Course Name: " + courseName);
                System.out.println("Instructor Name: " + instructorFirstName);
            }
            //System.out.println(results);
        }finally {
            hibernateUtil.closeSession(session);
        }
    }
    public static void getStudentsCourses(){
        HibernateUtil hibernateUtil = new HibernateUtil();
        Session session = hibernateUtil.getSession();
        try {
            session.beginTransaction();
            // Save the user object to the database
            String hql = "SELECT c.course_name, c.start_date, s " + "FROM Courses c " + "LEFT JOIN c.studentsSet s where c.level = 'Medium'";

            Query<Object[]> query = session.createQuery(hql);
            List<Object[]> results = query.list();

            for (Object[] result : results) {
                String courseName = (String) result[0];
                Date startDate = (Date) result[1];
                Students students = (Students) result[2];

                System.out.println("Course Name: " + courseName);
                System.out.println("Start Date: " + startDate);
                System.out.println("Students: " + students);
            }
        }finally {
            hibernateUtil.closeSession(session);
        }
    }
    public void StudentsCourses(){
        HibernateUtil hibernateUtil = new HibernateUtil();
        Session session = hibernateUtil.getSession();
        try{
            Courses courses = new Courses();
            Students students = new Students();
            session.beginTransaction();
            // Save the user object to the database
            Query query = session.createQuery("SELECT c FROM Courses c JOIN c.studentsSet s", Courses.class);
            List<Courses> coursesList = query.getResultList();
            System.out.println(coursesList);
            //Commit
            session.getTransaction().commit();
        }finally {
            hibernateUtil.closeSession(session);
        }
    }
    public static void getStudentsCoursesInstructors(){
        HibernateUtil hibernateUtil = new HibernateUtil();
        Session session = hibernateUtil.getSession();
        try {
            session.beginTransaction();
            // Save the user object to the database
            String hql = "select i.first_name || ' ' || i.last_name as instructorName, s.firstName || ' ' || s.lastName as studentName, c.course_id  from  Instructor i left join i.courses c join c.studentsSet as s";

            Query<Object[]> query = session.createQuery(hql);
            List<Object[]> results = query.list();

            for (Object[] result : results) {
                String instructorName = (String) result[0];
                String studentName = (String) result[1];
                UUID courseId = (UUID) result[2];

                System.out.println("Instructor Name: " + instructorName);
                System.out.println("Student Name: " + studentName);
                System.out.println("Coursen ID: " + courseId);
            }
        }finally {
            hibernateUtil.closeSession(session);
        }
    }



}

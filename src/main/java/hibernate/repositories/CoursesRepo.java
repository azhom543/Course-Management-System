package hibernate.repositories;

import hibernate.HibernateUtil;
import hibernate.entities.Courses;
import hibernate.entities.Instructor;
import hibernate.entities.Students;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CoursesRepo {
    private static UUID gen_random_uuid() {
        return UUID.randomUUID();
    }
    public void addCourse() throws ParseException {
        HibernateUtil hibernateUtil = new HibernateUtil();
        Session session = hibernateUtil.getSession();

        try{
            UUID newId = gen_random_uuid();
            Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse("2023-09-18");
            Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse("2023-10-12");
            Courses courses = new Courses(newId,"Physics",startDate,endDate,"Beginner", true);
            session.beginTransaction();
            // Save the user object to the database
            session.save(courses);
            //Commit
            session.getTransaction().commit();
        }finally {
            hibernateUtil.closeSession(session);
        }
    }
    public void deleteCourse(UUID courseID){
        HibernateUtil hibernateUtil = new HibernateUtil();
        Session session = hibernateUtil.getSession();
        try{
            session.beginTransaction();
            // Remove the object
            session.remove(session.get(Courses.class,courseID));
            //Commit
            session.getTransaction().commit();
        }finally {
            hibernateUtil.closeSession(session);
        }
    }
    public Courses getCourseById(UUID courseID){
        HibernateUtil hibernateUtil = new HibernateUtil();
        Session session = hibernateUtil.getSession();
        try{
            session.beginTransaction();
            // Save the user object to the database
            Courses courses = session.get(Courses.class,courseID);
            System.out.println(courses.toString());
            return courses;
        }finally {
            hibernateUtil.closeSession(session);
        }
    }
    public void updateCourse(Courses courses){
        HibernateUtil hibernateUtil = new HibernateUtil();
        Session session = hibernateUtil.getSession();
        try{
            session.beginTransaction();
            // Save the user object to the database
            session.update(courses);
            //Commit
            session.getTransaction().commit();
        }finally {
            hibernateUtil.closeSession(session);
        }
    }

    public Courses getCourseByName(String courseName){
        HibernateUtil hibernateUtil = new HibernateUtil();
        Session session = hibernateUtil.getSession();
        try{
            session.beginTransaction();
            // Save the user object to the database
            Query query = session.createQuery("from Courses where course_name = :courseName",Courses.class);
            query.setParameter("courseName", courseName);
            Courses courses = (Courses) query.getSingleResult();
            System.out.println(courses.toString());
            return courses;
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
}

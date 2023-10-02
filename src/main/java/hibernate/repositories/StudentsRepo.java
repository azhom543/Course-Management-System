package hibernate.repositories;

import hibernate.HibernateUtil;
import hibernate.entities.Courses;
import hibernate.entities.Instructor;
import hibernate.entities.Students;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class StudentsRepo {
    private static UUID gen_random_uuid() {
        return UUID.randomUUID();
    }
    public void addStudentToCourse(){
        HibernateUtil hibernateUtil = new HibernateUtil();
        Session session = hibernateUtil.getSession();
        try {
            UUID newId = gen_random_uuid();
            UUID courseID = UUID.fromString("289fe002-0d40-4ef8-b032-49f4d2cd5a28");
            Courses courses = session.get(Courses.class,courseID);
            //Add new Student
            Students students = new Students(newId,"mostafa","atef","98491916",30,"mo.atef@ymail.com","Male","651516198");
            //Add Student to the Course
            courses.addStudent(students);
            //Add Course to the Student
            students.addCourse(courses);
            session.beginTransaction();
            session.save(courses);
            session.save(students);
            session.getTransaction().commit();
        }finally {
            hibernateUtil.closeSession(session);
        }
    }
    public void deleteStudent(UUID StudentID){
        HibernateUtil hibernateUtil = new HibernateUtil();
        Session session = hibernateUtil.getSession();
        try{
            session.beginTransaction();
            // Save the user object to the database
            session.remove(session.get(Students.class,StudentID));
            //Commit
            session.getTransaction().commit();
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
}

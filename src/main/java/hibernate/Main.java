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

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

public class Main {

//    public static Connection connectToPostgreSQL() {
//        Connection connection = null;
//        String url = "jdbc:postgresql://localhost:5432/School";
//        String username = "postgres";
//        String password = "1234";
//        DB_Connection c = new DB_Connection();
//        connection = c.DB_Connection(url, username, password);
//        return connection;
//    }
    private static UUID gen_random_uuid() {
        return UUID.randomUUID();
    }
    public static void main(String[] args) throws SQLException {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(Courses.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        System.out.println("Configuration Read");
        //Create a new user object
        try {
//            UUID newId = gen_random_uuid();
//            Instructor user = new Instructor(newId, "eslam","Hisham","eslam.hisham@giza.com","0115483695","Data Engineer");
//            System.out.println("Created");
            //Start Transaction
            session.beginTransaction();
            UUID instId = UUID.fromString("3810c06a-3614-4090-a5d3-b8bb4c27284c");
            System.out.println("ana hennaaaaaaaaaaaaaaaaaaa");
            // Save the user object to the database
            Instructor instructor = session.get(Instructor.class,instId);
            System.out.println("ana esh henaaaa");
            //Commit
            System.out.println(instructor.getCourses());
            //Close the session
            session.close();
        }finally {
            session.close();

            sessionFactory.close();
        }
        //Connect the DB with the Credentials
//        Connection connection = connectToPostgreSQL();
//        //if not connected close with error message
//        if (connection == null) {
//            System.out.println("Error with the Connection");
//            return;
//        }
//
////        Instructor ins = new Instructor();
////        Courses cs = new Courses();
////        Students st = new Students();
////        String whereClause = "email = 'adham.azzam2000@gmail.com'";
////        String Ins = ins.ViewInstructorDetails(connection,whereClause);
////        String corses = cs.ViewCourseDetails(connection,null);
////        String students = st.ViewStudentDetails(connection,null);
////        System.out.println(students);
//
//        CRUD_Operations crd = new CRUD_Operations();
//        String ViewName = "instructor_student_courses";
//        crd.ReadEntry(connection,ViewName,null);
//            UUID id = UUID.fromString(resultset.getString(1));
//            String first_name = resultset.getString(2);
//            String last_name = resultset.getString(3);
//            String email = resultset.getString(4);
//            String phone = resultset.getString(5);
//            String gender = resultset.getString(6);
//            String national_id = resultset.getString(7);
//
//            Students student = new Students(id, first_name, last_name, phone, Integer.parseInt(age), email, gender, national_id);
//            System.out.println(student.toString());
//
//            UUID courseId = UUID.fromString(resultset.getString(1));
//            String courseName = resultset.getString(2);
//            Timestamp startDate = resultset.getTimestamp(3);
//            Timestamp endDate = resultset.getTimestamp(4);
//            String courseLevel = resultset.getString(5);
//            boolean isStarted = resultset.getBoolean(6);
//            UUID instructorId = UUID.fromString(resultset.getString(7));
//
//            Courses course = new Courses(courseId, courseName, startDate, endDate, courseLevel, isStarted, instructorId);
//            System.out.println(course.toString());

    }
}
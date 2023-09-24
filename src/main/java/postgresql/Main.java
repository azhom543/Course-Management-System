package postgresql;

import java.sql.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

public class Main {

    public static Connection connectToPostgreSQL() {
        Connection connection = null;
        String url = "jdbc:postgresql://localhost:5432/School";
        String username = "postgres";
        String password = "1234";
        DB_Connection c = new DB_Connection();
        connection = c.DB_Connection(url, username, password);
        return connection;
    }

    public static void main(String[] args) throws SQLException {

        //Connect the DB with the Credentials
        Connection connection = connectToPostgreSQL();
        //if not connected close with error message
        if (connection == null) {
            System.out.println("Error with the Connection");
            return;
        }

//        Instructor ins = new Instructor();
//        Courses cs = new Courses();
//        Students st = new Students();
//        String whereClause = "email = 'adham.azzam2000@gmail.com'";
//        String Ins = ins.ViewInstructorDetails(connection,whereClause);
//        String corses = cs.ViewCourseDetails(connection,null);
//        String students = st.ViewStudentDetails(connection,null);
//        System.out.println(students);

        CRUD_Operations crd = new CRUD_Operations();
        String ViewName = "instructor_student_courses";
        crd.ReadEntry(connection,ViewName,null);
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
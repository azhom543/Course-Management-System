package hibernate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class Students {
    private UUID studentId;
    private String firstName;
    private String lastName;
    private String studentPhone;
    private int studentAge;
    private String studentEmail;
    private String studentGender;
    private String nationalId;
    private String tableName = "Students";

    public Students() {
    }

    public Students(UUID studentId, String firstName, String lastName, String studentPhone, int studentAge, String studentEmail, String studentGender, String nationalId) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentPhone = studentPhone;
        this.studentAge = studentAge;
        this.studentEmail = studentEmail;
        this.studentGender = studentGender;
        this.nationalId = nationalId;
    }

    @Override
    public String toString() {
        return "Students{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentPhone='" + studentPhone + '\'' +
                ", studentAge=" + studentAge +
                ", studentEmail='" + studentEmail + '\'' +
                ", studentGender='" + studentGender + '\'' +
                ", nationalId='" + nationalId + '\'' +
                '}';
    }


    public String ViewStudentDetails(Connection c, String where_clause) throws SQLException {
        String generatedResults = " ";
        Statement statement = c.createStatement();
        String Query = "SELECT * FROM " + tableName;
        if (where_clause != null){
            Query = Query + " Where " + where_clause + ";";
        }
        System.out.println(Query);
        ResultSet resultset = statement.executeQuery(Query);
        while (resultset.next()) {
            this.studentId = UUID.fromString(resultset.getString(1));
            this.firstName = resultset.getString(2);
            this.lastName = resultset.getString(3);
            this.studentPhone = resultset.getString(4);
            this.studentAge = resultset.getInt(5);
            this.studentEmail = resultset.getString(6);
            this.studentGender = resultset.getString(7);
            this.nationalId = resultset.getString(8);
            generatedResults = generatedResults + "\n" + this.toString();
        }
        return generatedResults;
    }

    public void RemoveStudent(Connection c, String where_clause){
        String Query = "DELETE FROM " + tableName;
        if (where_clause != null){
            Query = Query + " Where " + where_clause + ";";
        }
        System.out.println(Query);
        try {
            Statement statement = c.createStatement();
            statement.executeQuery(Query);
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public void AddStudent(Connection c, String columns, String values){
        String Query = "Insert into " + tableName + " ( " + columns + " ) VALUES " + " ( " + values + " );";
        System.out.println(Query);
        try {
            Statement statement = c.createStatement();
            statement.executeQuery(Query);
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public void UpdateStudentDetails(Connection c, String SetColumns, String where_clause){
        String Query = "UPDATE " + tableName + " SET " + SetColumns;
        if (where_clause != null){
            Query = Query + " Where " + where_clause + ";";
        }
        System.out.println(Query);
        try {
            Statement statement = c.createStatement();
            statement.executeQuery(Query);
        }catch (SQLException e){
            System.out.println(e);
        }
    }
}

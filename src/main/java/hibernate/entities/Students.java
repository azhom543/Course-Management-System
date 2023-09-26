package hibernate.entities;

import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "students")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "student_id")
    private UUID studentId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "student_phone")
    private String studentPhone;
    @Column(name = "student_age")
    private int studentAge;
    @Column(name = "student_email")
    private String studentEmail;
    @Column(name = "student_gender")
    private String studentGender;
    @Column(name = "national_id")
    private String nationalId;
    @ManyToMany
    @JoinTable(
            name = "students_courses",
            joinColumns = @JoinColumn (name = "student_id"),
            inverseJoinColumns = @JoinColumn (name = "course_id")
    )
    private Set<Courses> coursesSet;
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

    public UUID getStudentId() {
        return studentId;
    }

    public void setStudentId(UUID studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getCoursesSet() {
        return coursesSet.toString();
    }

    public void setCoursesSet(Set<Courses> coursesSet) {
        this.coursesSet = coursesSet;
    }

    @Override
    public String toString() {
        return "Students{" +
                "studentId=" + studentId + '\n' +
                ", firstName='" + firstName + '\'' + '\n' +
                ", lastName='" + lastName + '\'' + '\n' +
                ", studentPhone='" + studentPhone + '\'' + '\n' +
                ", studentAge=" + studentAge + '\n' +
                ", studentEmail='" + studentEmail + '\'' + '\n' +
                ", studentGender='" + studentGender + '\'' + '\n' +
                ", nationalId='" + nationalId + '\'' + '\n' +
                '}';
    }


//    public String ViewStudentDetails(Connection c, String where_clause) throws SQLException {
//        String generatedResults = " ";
//        Statement statement = c.createStatement();
//        String Query = "SELECT * FROM " + tableName;
//        if (where_clause != null){
//            Query = Query + " Where " + where_clause + ";";
//        }
//        System.out.println(Query);
//        ResultSet resultset = statement.executeQuery(Query);
//        while (resultset.next()) {
//            this.studentId = UUID.fromString(resultset.getString(1));
//            this.firstName = resultset.getString(2);
//            this.lastName = resultset.getString(3);
//            this.studentPhone = resultset.getString(4);
//            this.studentAge = resultset.getInt(5);
//            this.studentEmail = resultset.getString(6);
//            this.studentGender = resultset.getString(7);
//            this.nationalId = resultset.getString(8);
//            generatedResults = generatedResults + "\n" + this.toString();
//        }
//        return generatedResults;
//    }
//
//    public void RemoveStudent(Connection c, String where_clause){
//        String Query = "DELETE FROM " + tableName;
//        if (where_clause != null){
//            Query = Query + " Where " + where_clause + ";";
//        }
//        System.out.println(Query);
//        try {
//            Statement statement = c.createStatement();
//            statement.executeQuery(Query);
//        }catch (SQLException e){
//            System.out.println(e);
//        }
//    }
//
//    public void AddStudent(Connection c, String columns, String values){
//        String Query = "Insert into " + tableName + " ( " + columns + " ) VALUES " + " ( " + values + " );";
//        System.out.println(Query);
//        try {
//            Statement statement = c.createStatement();
//            statement.executeQuery(Query);
//        }catch (SQLException e){
//            System.out.println(e);
//        }
//    }
//
//    public void UpdateStudentDetails(Connection c, String SetColumns, String where_clause){
//        String Query = "UPDATE " + tableName + " SET " + SetColumns;
//        if (where_clause != null){
//            Query = Query + " Where " + where_clause + ";";
//        }
//        System.out.println(Query);
//        try {
//            Statement statement = c.createStatement();
//            statement.executeQuery(Query);
//        }catch (SQLException e){
//            System.out.println(e);
//        }
//    }
}

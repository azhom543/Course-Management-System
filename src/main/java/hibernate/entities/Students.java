package hibernate.entities;

import jakarta.persistence.*;

import java.util.HashSet;
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
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(
            name = "students_courses",
            joinColumns = @JoinColumn (name = "student_id"),
            inverseJoinColumns = @JoinColumn (name = "course_id")
    )
    private Set<Courses> coursesSet = new HashSet<>();
    public Students() {
    }
    public void addCourse(Courses course) {
        if (coursesSet == null) {
            coursesSet = new HashSet<>();
        }
        coursesSet.add(course);
        course.getStudentsSet().add(this);
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

    public Set<Courses> getCoursesSet() {
        return coursesSet;
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
}

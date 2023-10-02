package hibernate.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "instructor")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "instructor_id")
    private UUID id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phone;
    @Column(name = "title")
    private String title;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_details_id")
    private InstructorDetails instructorDetails;
    @OneToMany(mappedBy = "instructor",
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.LAZY)
    private List<Courses> courses;

    public List<Courses> getCourses() {
        this.id.toString();
        return courses;
    }
    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }

    public Instructor(UUID id, String first_name, String last_name, String email, String phone, String title, InstructorDetails instructorDetails) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
        this.title = title;
        this.instructorDetails = instructorDetails;
    }

    public void add(Courses tempCourse){
        if (courses == null){
            courses = new ArrayList<Courses>();
        }
        courses.add(tempCourse);
        tempCourse.setInstructor(this);
    }

    public InstructorDetails getInstructorDetails() {
        return instructorDetails;
    }

    public void setInstructorDetails(InstructorDetails instructorDetails) {
        this.instructorDetails = instructorDetails;
    }

    public Instructor(UUID id, String first_name, String last_name, String email, String phone, String title, InstructorDetails instructorDetails, List<Courses> courses) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
        this.title = title;
        this.instructorDetails = instructorDetails;
        this.courses = courses;
    }

    //private String tableName = "Instructor";
    public Instructor(UUID id, String first_name, String last_name, String email, String phone, String title){
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
        this.title = title;
    }

    public UUID getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getTitle() {
        return title;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public void setTableName(String tableName) {
//        this.tableName = tableName;
//    }

    public Instructor() {
    }

    @Override
    public String toString() {
        return "Instructor{" + '\n' +
                "id=" + id + '\n' +
                ", first_name='" + first_name + '\'' + '\n' +
                ", last_name='" + last_name + '\'' + '\n' +
                ", email='" + email + '\'' + '\n' +
                ", phone='" + phone + '\'' + '\n' +
                ", title='" + title + '\'' + '\n' +
                '}';
    }
}

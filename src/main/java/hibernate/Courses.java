package hibernate;
import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "courses")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Use an appropriate strategy for your database
    @Column(name = "course_id")
    private UUID course_id;

    @Column(name = "course_name")
    private String course_name;

    @Column(name = "start_date")
    private Date start_date;

    @Column(name = "end_date")
    private Date end_date;

    @Column(name = "course_level")
    private String level;

    @Column(name = "is_started")
    private boolean is_started;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    public Courses(UUID course_id, String course_name, Date start_date, Date end_date, String level, boolean is_started, Instructor instructor) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.level = level;
        this.is_started = is_started;
        this.instructor = instructor;
    }

    public Courses() {
    }

    // Getter and Setter methods for all fields

    public UUID getCourse_id() {
        return course_id;
    }

    public void setCourse_id(UUID course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public boolean isIs_started() {
        return is_started;
    }

    public void setIs_started(boolean is_started) {
        this.is_started = is_started;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "course_id=" + course_id +
                ", course_name='" + course_name + '\'' +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", level='" + level + '\'' +
                ", is_started=" + is_started +
                ", instructor_id=" + instructor.getId() +
                '}';
    }
}

package hibernate.dtos;

import hibernate.entities.Instructor;
import hibernate.entities.Students;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.Set;
import java.util.UUID;
public class CoursesDTO {
    private UUID course_id;
    private String course_name;
    private Date start_date;
    private Date end_date;
    private String level;
    private boolean is_started;
    private Instructor instructor;
    private Set<Students> studentsSet;

    public CoursesDTO(UUID course_id, String course_name, Date start_date, Date end_date, String level, boolean is_started, Instructor instructor, Set<Students> studentsSet) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.level = level;
        this.is_started = is_started;
        this.instructor = instructor;
        this.studentsSet = studentsSet;
    }

    @Override
    public String toString() {
        return "CoursesDTO{" +
                "course_id=" + course_id +
                ", course_name='" + course_name + '\'' +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", level='" + level + '\'' +
                ", is_started=" + is_started +
                '}';
    }

    public CoursesDTO() {
    }

    public CoursesDTO(UUID course_id, String course_name, Date start_date, Date end_date, String level, boolean is_started) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.level = level;
        this.is_started = is_started;
    }
    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Set<Students> getStudentsSet() {
        return studentsSet;
    }

    public void setStudentsSet(Set<Students> studentsSet) {
        this.studentsSet = studentsSet;
    }
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
}

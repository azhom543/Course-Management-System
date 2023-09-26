package hibernate.dtos;

import jakarta.persistence.Column;

import java.util.UUID;

public class StudentsDTO {
    private UUID studentId;
    private String firstName;
    private String lastName;
    private String studentPhone;
    private int studentAge;
    private String studentEmail;
    private String studentGender;
    private String nationalId;

    public StudentsDTO() {
    }

    @Override
    public String toString() {
        return "StudentsDTO{" +
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

    public StudentsDTO(UUID studentId, String firstName, String lastName, String studentPhone, int studentAge, String studentEmail, String studentGender, String nationalId) {
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
}

package hibernate.mappers;

import hibernate.dtos.CoursesDTO;
import hibernate.entities.Courses;
public class CoursesMapper {
    public static CoursesDTO mapToDTO(Courses courses){
        return new CoursesDTO(courses.getCourse_id(),courses.getCourse_name(),courses.getStart_date(),courses.getEnd_date(),courses.getLevel(),courses.isIs_started(),courses.getInstructor(),courses.getStudentsSet());
    }
    public static Courses mapToEntity(CoursesDTO coursesDTO){
        if (coursesDTO == null){
            return null;
        }else return new Courses(coursesDTO.getCourse_id(),coursesDTO.getCourse_name(),coursesDTO.getStart_date(),coursesDTO.getEnd_date(),coursesDTO.getLevel(),coursesDTO.isIs_started(),coursesDTO.getInstructor(),coursesDTO.getStudentsSet());
    }
}

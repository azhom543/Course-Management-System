package hibernate.repositories;

import hibernate.HibernateUtil;
import hibernate.entities.Courses;
import hibernate.entities.Instructor;
import hibernate.entities.InstructorDetails;
import org.hibernate.Session;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class InstructorDetailsRepo {
    private static UUID gen_random_uuid() {
        return UUID.randomUUID();
    }
    public InstructorDetails addInstructorDetails(){
        HibernateUtil hibernateUtil = new HibernateUtil();
        Session session = hibernateUtil.getSession();
        try{
            UUID newId = gen_random_uuid();
            InstructorDetails instructorDetails = new InstructorDetails(newId,"www.youtube.com","Football");
            session.beginTransaction();
            // Save the user object to the database
            session.persist(instructorDetails);
            //Commit
            session.getTransaction().commit();
            return instructorDetails;
        }finally {
            hibernateUtil.closeSession(session);
        }
    }
    public void deleteInstructorDetails(UUID InstructorDetailsID){
        HibernateUtil hibernateUtil = new HibernateUtil();
        Session session = hibernateUtil.getSession();
        try{
            session.beginTransaction();
            // Save the user object to the database
            session.remove(session.get(InstructorDetails.class,InstructorDetailsID));
            //Commit
            session.getTransaction().commit();
        }finally {
            hibernateUtil.closeSession(session);
        }
    }

    public InstructorDetails getInstructorDetailsById(UUID InstructorDetailsID){
        HibernateUtil hibernateUtil = new HibernateUtil();
        Session session = hibernateUtil.getSession();
        try{
            session.beginTransaction();
            // Save the user object to the database
            InstructorDetails instructorDetails = session.get(InstructorDetails.class,InstructorDetailsID);
            System.out.println(instructorDetails.toString());
            return instructorDetails;
        }finally {
            hibernateUtil.closeSession(session);
        }
    }

    public void updateInstructorDetails(InstructorDetails instructorDetails){
        HibernateUtil hibernateUtil = new HibernateUtil();
        Session session = hibernateUtil.getSession();
        try{
            session.beginTransaction();
            // Save the user object to the database
            session.update(instructorDetails);
            //Commit
            session.getTransaction().commit();
        }finally {
            hibernateUtil.closeSession(session);
        }
    }
}

package hibernate.repositories;

import hibernate.HibernateUtil;
import hibernate.entities.Instructor;
import hibernate.entities.InstructorDetails;
import org.hibernate.Session;

import java.util.UUID;

public class InstructorRepo {
    private static UUID gen_random_uuid() {
        return UUID.randomUUID();
    }

    public void addInstructor(){
        HibernateUtil hibernateUtil = new HibernateUtil();
        Session session = hibernateUtil.getSession();
        try {
            UUID newId = gen_random_uuid();
            InstructorDetailsRepo instructorDetailsRepo = new InstructorDetailsRepo();
            InstructorDetails instructorDetails = instructorDetailsRepo.addInstructorDetails();
            Instructor instructor = new Instructor(newId,"Ahmed","Samy","Ahmed@gmail.com","015338865","Software Engineer",instructorDetails);
            session.beginTransaction();
            // Save the user object to the database
            session.persist(instructorDetails);
            //Commit
            session.getTransaction().commit();
        }finally {
            hibernateUtil.closeSession(session);
        }
    }

    public void deleteInstructor(UUID InstructorID){
        HibernateUtil hibernateUtil = new HibernateUtil();
        Session session = hibernateUtil.getSession();
        try{
            session.beginTransaction();
            // Save the user object to the database
            session.remove(session.get(Instructor.class,InstructorID));
            //Commit
            session.getTransaction().commit();
        }finally {
            hibernateUtil.closeSession(session);
        }
    }
    public Instructor getInstructorById(UUID InstructorID){
        HibernateUtil hibernateUtil = new HibernateUtil();
        Session session = hibernateUtil.getSession();
        try{
            session.beginTransaction();
            // Save the user object to the database
            Instructor instructor = session.get(Instructor.class,InstructorID);
            System.out.println(instructor.toString());
            return instructor;
        }finally {
            hibernateUtil.closeSession(session);
        }
    }

    public void updateInstructor(Instructor instructor){
        HibernateUtil hibernateUtil = new HibernateUtil();
        Session session = hibernateUtil.getSession();
        try{
            session.beginTransaction();
            // Save the user object to the database
            session.update(instructor);
            //Commit
            session.getTransaction().commit();
        }finally {
            hibernateUtil.closeSession(session);
        }
    }
}

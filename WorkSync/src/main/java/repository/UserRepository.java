package repository;

import java.util.List;

import org.hibernate.Session;

import org.hibernate.Transaction;
import model.Userdb;

public class UserRepository {

    public static void saveUser(Userdb user) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(user);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public static Userdb getUserByUsername(String username) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "FROM Userdb U WHERE U.name = :username", Userdb.class)
                    .setParameter("username", username)
                    .uniqueResult();
        }
    }
    
    public static List<Userdb> getAllUsers(){
    	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "FROM Userdb", Userdb.class)
                   .getResultList();
        }
    	
    
    }
    
    public static String getPassword(String password) {
    	
    	 try (Session session = HibernateUtil.getSessionFactory().openSession()) {
             return session.createQuery(
                     "FROM Userdb U WHERE U.password = :password", Userdb.class)
                     .setParameter("password", password)
                     .uniqueResult().getPassword();
         }
    	
        }
        
    public static void deleteUserById(int id) {
    	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
    		Transaction tx=session.beginTransaction();
    		Userdb user=session.get(Userdb.class, id);
    		if(user!=null)
    			session.remove(user);
    		tx.commit();
        }
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}

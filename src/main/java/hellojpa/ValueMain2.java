package hellojpa;

import hellojpa.prac2.Address;
import hellojpa.prac2.Member;
import hellojpa.prac2.Period;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class ValueMain2 {
    public static void main(String[] args) {
        /*EntityManagerFactory를 만든다.*/
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        /*EntityManager만들기*/
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Member member = new Member();
            member.setName("LEE");
            member.setHomeAddress(new Address("Gunpo", "sanbon", "15802"));
            member.setWorkPeriod(new Period(LocalDateTime.now(), LocalDateTime.now()));

            em.persist(member);

            tx.commit();
        }catch(Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally{
            em.close();
        }
        emf.close();
    }
}

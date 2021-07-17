package hellojpa;

import hellojpa.prac2.Address;
import hellojpa.prac2.Member;
import hellojpa.prac2.Period;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class ValueMain3 {
    public static void main(String[] args) {
        /*EntityManagerFactory를 만든다.*/
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        /*EntityManager만들기*/
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
//            Address address = new Address("Gunpo", "sanbon", "15802");
//            Member member1 = new Member();
//            member1.setName("LEE");
//            member1.setHomeAddress(address);
//            em.persist(member1);
//
//            /*Address를 통으로 바꾼다.*/
//            Address newAddress = new Address("Seoul", address.getStreet(), address.getZipcode());
//            member1.setHomeAddress(newAddress);

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

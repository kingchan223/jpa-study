package hellojpa;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMainObjectEntity {
    public static void main(String[] args) {
        /*EntityManagerFactory를 만든다.*/
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        /*EntityManager만들기*/
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

//            Member member = new Member();
////            member.setId("ID_A");
//            member.setUsername("C");
//
//            em.persist(member);
            tx.commit();

        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();
        }
        emf.close();
    }
}

package hellojpa;

import javax.persistence.*;

public class JpaMain {
    public static void main(String[] args) {
        /*EntityManagerFactory를 만든다.*/
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        /*EntityManager만들기*/
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
            //--비영속 상태--
//            Member member = new Member();
//            member.setId(100L);
//            member.setName("JPA");
//
//            // --영속 상태--  (아직 DB에 저장 X)
//            em.persist(member);

            // 트랜잭션을
            tx.commit();

        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();
        }
        emf.close();

    }
}


package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain3 {
    public static void main(String[] args) {
        /*EntityManagerFactory를 만든다.*/
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        /*EntityManager만들기*/
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            //--비영속 상태--
            Member member = new Member();
            member.setId(101L);
            member.setName("JPA");

            // --영속 상태--  (아직 DB에 저장 X)
            em.persist(member);

            Member findMember = em.find(Member.class, 101L);
            System.out.println("findMember.getId = "+findMember.getId());
            System.out.println("findMember.getName = "+findMember.getName());

            //--준영속--
            em.detach(member);

            //--삭제--
            em.remove(member);

            //DB에 저장되는 시점
            tx.commit();

        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();
        }
        emf.close();
    }
}

package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMainFlush {
    public static void main(String[] args) {
        /*EntityManagerFactory를 만든다.*/
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        /*EntityManager만들기*/
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

//            Member member = new Member(105L, "member");
//            //member는 영속화 된다.
//
//            //member를 준영속화하기 -> 이제 JPA가 관리하지 않는 엔티티가 된다.
//            em.detach(member);

            tx.commit();

        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();
        }
        emf.close();
    }
}

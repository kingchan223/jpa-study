package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain4 {
    public static void main(String[] args) {
        /*EntityManagerFactory를 만든다.*/
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        /*EntityManager만들기*/
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            //엔티티 생성1
//            Member member1 = new Member();
//            member1.setId(1001L);
//            member1.setName("member1");
//            //엔티티 생성2
//            Member member2 = new Member();
//            member2.setId(1002L);
//            member2.setName("member2");
//            // 1차 캐시에 member1과 member2를 저장한 후
//            // 쓰기 지연 저장소에 insert sql문을 저장해둔다.
//            em.persist(member1);
//            em.persist(member2);

            //이때 sql문이 실행되어 2개의 엔티티가 DB에 flush된다.
            tx.commit();

        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();
        }
        emf.close();
    }
}

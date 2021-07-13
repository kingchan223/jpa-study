package hellojpa;


import javax.persistence.*;

public class JpaMainFlush {
    public static void main(String[] args) {
        /*EntityManagerFactory를 만든다.*/
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        /*EntityManager만들기*/
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
//
//            Member member1 = new Member();
//            member1.setUsername("SE1");
//
//            Member member2 = new Member();
//            member2.setUsername("SE2");
//
//            Member member3 = new Member();
//            member3.setUsername("SE3");
//
//            System.out.println("==================");
//            em.persist(member1);
//            em.persist(member2);
//            em.persist(member3);
//            System.out.println("==================");

            tx.commit();

        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();
        }
        emf.close();
    }
}

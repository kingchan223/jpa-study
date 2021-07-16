package hellojpa;

import hellojpa.prac2.Member;
import hellojpa.prac2.Team;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMainProxy {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Member member1 = new Member();
            member1.setName("kim");

            Member member2 = new Member();
            member2.setName("kim");

            em.persist(member1);
            em.persist(member2);

            em.flush();
            em.clear();

            Member m1 = em.getReference(Member.class, member1.getId());//m1은 프록시 객체
            System.out.println("m1 : " + m1.getClass());
            
            m1.getClass().getName();

            System.out.println("isLoaded : "+emf.getPersistenceUnitUtil().isLoaded(m1));

            Hibernate.initialize(m1);

            tx.commit();
        }catch(Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally{
            em.close();
        }
        emf.close();
    }

    private static void printMember(Member member) {
        System.out.println("member = " + member.getName());
    }

    private static void printMemberAndTeam(Member member) {
        String username = member.getName();
        System.out.println("username = " + username);

        Team team = member.getTeam();
        System.out.println("team = " + team.getName());
    }
}

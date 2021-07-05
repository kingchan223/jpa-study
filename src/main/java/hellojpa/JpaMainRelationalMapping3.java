package hellojpa;

import hellojpa.Entity.Member;
import hellojpa.Entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMainRelationalMapping3 {
    public static void main(String[] args) {
        /*EntityManagerFactory를 만든다.*/
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        /*EntityManager만들기*/
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            Member findMember = em.find(Member.class, 2L);
            System.out.println("findMember = " + findMember.getUsername());
            Team team = em.find(Team.class, 3L);
            findMember.setTeam(team);
            System.out.println("findMember,TEAM = " + findMember.getTeam());

//            Team findTeam = em.find(Team.class, 1L);
//            /* 멤버가 어디 팀에 소속인지 찾기 */
//            findMember.setTeam(findTeam);
//            System.out.println("============================");
//            System.out.println("findMember.Team = " + findMember.getTeam().getName());
//            System.out.println("============================");

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

package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMainRelationalMapping1 {
    public static void main(String[] args) {
        /*EntityManagerFactory를 만든다.*/
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        /*EntityManager만들기*/
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            /* 팀을 추가하고 멤버 추가하기 */

            // 팀 insert
//            Team team = new Team();
//            team.setName("ManCity");
//            em.persist(team);

            //멤버 insert
//            Member member = new Member();
//            member.setUsername("KDB");
//            member.setTeamId(team.getId());
//            em.persist(member);


            /* 멤버가 어디 팀에 소속인지 찾기 */
//            Member findMember = em.find(Member.class, member.getId());
//            Long teamId = findMember.getTeamId();
//            Team findTeam = em.find(Team.class, teamId);

            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();
        }
        emf.close();
    }
}

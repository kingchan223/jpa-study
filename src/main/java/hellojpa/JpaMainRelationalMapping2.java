package hellojpa;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMainRelationalMapping2 {
    public static void main(String[] args) {
        /*EntityManagerFactory를 만든다.*/
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        /*EntityManager만들기*/
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            /* 팀을 추가하고 멤버 추가하기 */
//            Team team = new Team();
//            team.setName("ManCity");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("kevin-D");
//            member.setTeam(team);  /*이제 setTeam 가능*/
//            em.persist(member);
//
////            em.flush();
////            em.clear();
//
//            /* 멤버가 어디 팀에 소속인지 찾기 */
//            Member findMember = em.find(Member.class, member.getId());
//            Team findTeam = findMember.getTeam();
            System.out.println("============================");
//            System.out.println("findTeam = " + findTeam);
            System.out.println("============================");

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

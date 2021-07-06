package hellojpa;

import hellojpa.Entity.Member;
import hellojpa.Entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMainRelationalMapping5 {
    public static void main(String[] args) {
        /*EntityManagerFactory를 만든다.*/
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        /*EntityManager만들기*/
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Team team = new Team();
            team.setName("Lester");
//            team.getMembers().add(member);
            em.persist(team);

            Member member = new Member();
            member.setUsername("verdy");
//            member.setTeam(team);
            member.changeTeam(team);
            em.persist(member);


            //team.getMembers().add(member);

            //영속성 컨텍스트에 있는 sql을 DB로 날리기.
            //flush를 하면 내가 jpa로 구성한 데이터가 DB에 저장되지는 않지만 어떤식으로 실제 쿼리를 날리는지 확인할 수 있음.
            em.flush();
            //영속성 컨텍스트 비우기.persist로 영속성 컨텍스트에 데이터가 저장되었을때 clear를 하면 데이터가 지워지는 것이다.
            // 실제 DB에 저장된 데이터를 지우는게 아니다.
            em.clear();

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

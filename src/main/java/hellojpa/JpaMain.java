package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
            /*저장하기*/
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("helloB");
//            em.persist(member);

            /*찾기*/
            Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember.getId = " + findMember.getId());
            System.out.println("findMember.getName = " + findMember.getName());

            /*삭제*/
//            em.remove(findMember);

            /*수정*/
//            findMember.setName("hiA");

            /*JPQL: 전체 회원 검색*/
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                                                            .getResultList();


            /*JPQL:페이징하고 싶을 때*/
            List<Member> result2 = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(1)
                    .setMaxResults(10)
                    .getResultList();


            for (Member member : result2) {
                System.out.println("member = " + member.getName());
            }

            tx.commit();

        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();
        }
        emf.close();

    }
}

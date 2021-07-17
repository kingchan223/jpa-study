package hellojpa;

import hellojpa.prac2.Address;
import hellojpa.prac2.AddressEntity;
import hellojpa.prac2.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Set;

public class ValueMain4 {
    public static void main(String[] args) {
        /*EntityManagerFactory를 만든다.*/
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        /*EntityManager만들기*/
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Member member = new Member();
            member.setName("LEE");
            member.setHomeAddress(new Address("homecity", "street1", "123123"));

            member.getFavoriteFoods().add("타코");
            member.getFavoriteFoods().add("장어");
            member.getFavoriteFoods().add("삽겹살");


            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("============start==============");
            Member findMember = em.find(Member.class, member.getId());

            Set<String> favoriteFoods = findMember.getFavoriteFoods();
            for (String favoriteFood : favoriteFoods) {
                System.out.println("favoriteFood = " + favoriteFood);
            }



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

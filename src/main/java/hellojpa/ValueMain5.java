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

public class ValueMain5 {
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

            //side effect가 발생하는 방법. 사용 X
//            findMember.getHomeAddress().setCity("newCity");

//            Address oldAddress = findMember.getHomeAddress();
//            //값타입은 통으로 갈아 끼운다.
//            findMember.setHomeAddress(new Address("newCity", oldAddress.getStreet(), oldAddress.getZipcode()));
//
//
//            //치킨 -> 김치찌개
//            findMember.getFavoriteFoods().remove("치킨");
//            findMember.getFavoriteFoods().add("김치찌개");

            //HistoryAddress바꾸기
            // !! equals가 제대로 구현되어 있어야한다.
//            findMember.getAddressHistory().remove(new Address("old1", "oldSt1", "45435"));
//            findMember.getAddressHistory().add(new Address("newCity1", "oldSt1", "45435"));


            member.getAddressHistory().add(new AddressEntity("old1", "oldSt1", "45435"));
            member.getAddressHistory().add(new AddressEntity("old2", "oldSt2", "23454"));


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

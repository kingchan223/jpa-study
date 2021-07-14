package hellojpa.advancedMapping;

import hellojpa.advancedMapping.entity.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try{
            Movie movie =  new Movie("짐 자무시","맥아담드라이버");
            movie.setName("패터슨");
            movie.setPrice(10000);
            em.persist(movie);

            em.flush();
            em.clear();

            Movie findmovie = em.find(Movie.class, 1L);
            System.out.println("findmovie = " + findmovie);

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

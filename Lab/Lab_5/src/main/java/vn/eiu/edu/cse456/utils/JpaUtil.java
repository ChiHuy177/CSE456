package vn.eiu.edu.cse456.utils;

import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@Component
public class JpaUtil {
    private static final EntityManagerFactory emf;

    static {
        try{
            emf = Persistence.createEntityManagerFactory("pu1-mysql-lab-5");
        } catch (Exception e){
            System.out.println("Can't create entity manager factory");
            throw new RuntimeException(e);
        }
    }

    private JpaUtil() {}

    public EntityManager getEntityManagerFactory() {
        return emf.createEntityManager();
    }

}

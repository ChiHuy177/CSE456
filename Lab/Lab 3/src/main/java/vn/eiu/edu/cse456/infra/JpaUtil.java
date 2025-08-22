package vn.eiu.edu.cse456.infra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {

    private static final EntityManagerFactory emf;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("pu1-mysql-lab-3");
        } catch (Exception e) {
            System.out.println("Can not create EntityManagerFactory");
            throw new RuntimeException(e);
        }
    }

    private JpaUtil() {
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }


}

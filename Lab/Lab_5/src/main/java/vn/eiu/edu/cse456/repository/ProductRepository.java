package vn.eiu.edu.cse456.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import vn.eiu.edu.cse456.model.Product;
import vn.eiu.edu.cse456.utils.JpaUtil;

@Repository
public class ProductRepository{

    @Autowired
    private JpaUtil jpaUtil;

    public void save(Product product) {
        EntityManager em = jpaUtil.getEntityManagerFactory();
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
        em.close();
    }

    public List<Product> findAll() {
        EntityManager em = jpaUtil.getEntityManagerFactory();
        return em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

    public Product findById(int id) {
        EntityManager em = jpaUtil.getEntityManagerFactory();
        return em.find(Product.class, id);
    }

    public void update(Product product) {
        EntityManager em = jpaUtil.getEntityManagerFactory();
        em.getTransaction().begin();
        em.merge(product);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(int id) {
        EntityManager em = jpaUtil.getEntityManagerFactory();
        em.getTransaction().begin();
        em.remove(em.find(Product.class, id));
        em.getTransaction().commit();
        em.close();
    }
}

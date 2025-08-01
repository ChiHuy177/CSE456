package vn.eiu.edu.cse456.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import vn.eiu.edu.cse456.model.Customer;
import vn.eiu.edu.cse456.utils.JpaUtil;

@Repository
public class CustomerRepository {

    @Autowired
    private JpaUtil jpaUtil;

    public void save(Customer customer) {
        EntityManager em = jpaUtil.getEntityManagerFactory();
        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();
        em.close();
    }

    public List<Customer> findAll() {
        EntityManager em = jpaUtil.getEntityManagerFactory();
        return em.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
    }

    public Customer findById(int id) {
        EntityManager em = jpaUtil.getEntityManagerFactory();
        return em.find(Customer.class, id);
    }

    public void update(Customer customer) {
        EntityManager em = jpaUtil.getEntityManagerFactory();
        em.getTransaction().begin();
        em.merge(customer);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(int id) {
        EntityManager em = jpaUtil.getEntityManagerFactory();
        em.getTransaction().begin();
        em.remove(em.find(Customer.class, id));
        em.getTransaction().commit();
        em.close();
    }
}
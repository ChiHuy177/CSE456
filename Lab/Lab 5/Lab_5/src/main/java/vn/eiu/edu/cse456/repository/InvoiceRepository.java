package vn.eiu.edu.cse456.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import vn.eiu.edu.cse456.model.Invoice;
import vn.eiu.edu.cse456.utils.JpaUtil;

@Repository
public class InvoiceRepository {
    @Autowired
    private JpaUtil jpaUtil;

    public void save(Invoice invoice) {
        EntityManager em = jpaUtil.getEntityManagerFactory();
        em.getTransaction().begin();
        em.persist(invoice);
        em.getTransaction().commit();
        em.close();
    }

    public Invoice findById(int id) {
        EntityManager em = jpaUtil.getEntityManagerFactory();
        return em.find(Invoice.class, id);
    }

    public void update(Invoice invoice) {
        EntityManager em = jpaUtil.getEntityManagerFactory();
        em.getTransaction().begin();
        em.merge(invoice);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(int id) {
        EntityManager em = jpaUtil.getEntityManagerFactory();
        em.getTransaction().begin();
        em.remove(em.find(Invoice.class, id));
        em.getTransaction().commit();
    }

}

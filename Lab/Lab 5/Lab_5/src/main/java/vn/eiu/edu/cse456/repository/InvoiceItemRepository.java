package vn.eiu.edu.cse456.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import vn.eiu.edu.cse456.model.InvoiceItem;
import vn.eiu.edu.cse456.utils.JpaUtil;

import java.util.List;

@Repository
public class InvoiceItemRepository {
    @Autowired
    private JpaUtil jpaUtil;

    public void save(InvoiceItem invoiceItem) {
        EntityManager em = jpaUtil.getEntityManagerFactory();
        em.getTransaction().begin();
        em.persist(invoiceItem);
        em.getTransaction().commit();
        em.close();
    }

    public InvoiceItem findById(int id) {
        EntityManager em = jpaUtil.getEntityManagerFactory();
        return em.find(InvoiceItem.class, id);
    }

    public void update(InvoiceItem invoiceItem) {
        EntityManager em = jpaUtil.getEntityManagerFactory();
        em.getTransaction().begin();
        em.merge(invoiceItem);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(int id) {
        EntityManager em = jpaUtil.getEntityManagerFactory();
        em.getTransaction().begin();
        em.remove(em.find(InvoiceItem.class, id));
        em.getTransaction().commit();
        em.close();
    }

    public List<InvoiceItem> findByInvoiceId(int invoiceId) {
        EntityManager em = jpaUtil.getEntityManagerFactory();
        TypedQuery<InvoiceItem> query = em.createQuery(
                "SELECT s FROM InvoiceItem s WHERE s.invoice.id = :invoiceId",
                InvoiceItem.class);
        query.setParameter("invoiceId", invoiceId);
        return query.getResultList();
    }

    public List<InvoiceItem> findByProductId(int productId) {
        EntityManager em = jpaUtil.getEntityManagerFactory();
        TypedQuery<InvoiceItem> query = em.createQuery(
                "SELECT s FROM InvoiceItem s WHERE s.product.id = :productId",
                InvoiceItem.class);
        query.setParameter("productId", productId);
        return query.getResultList();
    }
}
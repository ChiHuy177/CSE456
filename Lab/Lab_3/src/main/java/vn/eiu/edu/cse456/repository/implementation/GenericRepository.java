package vn.eiu.edu.cse456.repository.implementation;

import jakarta.persistence.EntityManager;
import vn.eiu.edu.cse456.infra.JpaUtil;
import vn.eiu.edu.cse456.repository.interfaces.IGenericRepository;

import java.util.List;

public abstract class GenericRepository implements IGenericRepository {
    @Override
    public void save(Object entity) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Object entity) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Object entity) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        List list = em.createQuery("SELECT e FROM Student e").getResultList();
        em.close();
        return list;
    }
}

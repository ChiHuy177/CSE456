package vn.eiu.edu.cse456.repository.implementation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import vn.eiu.edu.cse456.entity.Major;
import vn.eiu.edu.cse456.entity.School;
import vn.eiu.edu.cse456.infra.JpaUtil;
import vn.eiu.edu.cse456.service.implement.MajorService;

import java.util.List;

public class SchoolRepository extends GenericRepository<School> {


    public SchoolRepository(Class<School> entityClass) {
        super(entityClass);
    }

    @Override
    public void delete(School entity) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            School school = em.find(School.class, entity.getSchoolId());
            if (school != null)
                em.remove(school);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            em.close();
        }
    }

    public List<School> findAllWithStudents() {
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<School> query = em.createQuery("SELECT s FROM School s JOIN FETCH s.students", School.class);
        return query.getResultList();
    }

    public List<School> getAllSchools() {
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<School> query = em.createQuery("SELECT s from School s", School.class);
        return query.getResultList();

    }
}

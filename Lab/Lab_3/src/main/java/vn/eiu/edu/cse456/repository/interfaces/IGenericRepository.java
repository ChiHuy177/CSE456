package vn.eiu.edu.cse456.repository.interfaces;

import java.util.List;

public interface IGenericRepository<T> {
    void save(T entity);
    void delete(T entity);
    void update(T entity);
    List<T> findAll();
}

package vn.eiu.edu.cse456.repository.implementation;

import vn.eiu.edu.cse456.entity.Student;

public class StudentRepository extends GenericRepository<Student> {
    public StudentRepository(Class<Student> entityClass) {
        super(entityClass);
    }
}

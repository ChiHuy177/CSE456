package vn.eiu.edu.cse456.repository.implementation;

import vn.eiu.edu.cse456.entity.Major;

public class MajorRepository extends GenericRepository<Major> {
    public MajorRepository(Class<Major> entityClass) {
        super(entityClass);
    }
}

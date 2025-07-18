package vn.eiu.edu.cse456.repository.implementation;

import vn.eiu.edu.cse456.entity.School;

public class SchoolRepository extends GenericRepository<School> {

    public SchoolRepository(Class<School> entityClass) {
        super(entityClass);
    }
}

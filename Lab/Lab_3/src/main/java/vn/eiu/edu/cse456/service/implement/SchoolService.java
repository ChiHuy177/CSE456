package vn.eiu.edu.cse456.service.implement;

import vn.eiu.edu.cse456.entity.School;
import vn.eiu.edu.cse456.repository.implementation.SchoolRepository;

public class SchoolService {
    private final SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public void save(School school) {
        schoolRepository.save(school);
    }

    public void delete(School school) {
        schoolRepository.delete(school);
    }

    public void update(School school) {
        schoolRepository.update(school);
    }
}

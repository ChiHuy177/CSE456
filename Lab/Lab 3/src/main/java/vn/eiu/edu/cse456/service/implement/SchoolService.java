package vn.eiu.edu.cse456.service.implement;

import jakarta.persistence.EntityManager;
import vn.eiu.edu.cse456.entity.School;
import vn.eiu.edu.cse456.entity.Student;
import vn.eiu.edu.cse456.infra.JpaUtil;
import vn.eiu.edu.cse456.repository.implementation.SchoolRepository;
import vn.eiu.edu.cse456.service.interfaces.ISchoolService;

import java.util.List;

public class SchoolService implements ISchoolService {
    private final SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public void save(School school) {
        schoolRepository.save(school);
    }

    public void delete(School school) {
        EntityManager em = JpaUtil.getEntityManager();
        schoolRepository.delete(school);
    }

    public void update(School school) {
        schoolRepository.update(school);
    }

    @Override
    public List<School> getAllStudents() {
        return schoolRepository.findAllWithStudents();
    }

    public void deleteById(String id){
        try {
            schoolRepository.deleteById(id);
            System.out.println("Delete school with id: " + id + " success!");
        } catch (Exception e) {
            System.out.println("Delete school with id: " + id + " failed!");
            throw new RuntimeException(e);
        }
    }
}

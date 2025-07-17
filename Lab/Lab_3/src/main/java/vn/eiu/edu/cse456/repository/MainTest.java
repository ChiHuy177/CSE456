package vn.eiu.edu.cse456.repository;

import vn.eiu.edu.cse456.entity.School;
import vn.eiu.edu.cse456.repository.implementation.SchoolRepository;
import vn.eiu.edu.cse456.service.implement.SchoolService;

public class MainTest {
    public static void main(String[] args) {
        School school = new School();
        school.setSchoolId("123");
        school.setSchoolName("School 1");
        school.setLocation("Location 1");

        SchoolRepository schoolRepository = new SchoolRepository();
        SchoolService schoolService = new SchoolService(schoolRepository);
        schoolService.update(school);
    }
}

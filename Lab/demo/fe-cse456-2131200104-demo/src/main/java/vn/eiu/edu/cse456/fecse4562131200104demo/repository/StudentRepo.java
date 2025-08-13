package vn.eiu.edu.cse456.fecse4562131200104demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.eiu.edu.cse456.fecse4562131200104demo.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
}

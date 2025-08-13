package vn.eiu.edu.cse456.fecse4562131200104demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.eiu.edu.cse456.fecse4562131200104demo.model.Major;

@Repository
public interface MajorRepo extends JpaRepository<Major, Long> {
}

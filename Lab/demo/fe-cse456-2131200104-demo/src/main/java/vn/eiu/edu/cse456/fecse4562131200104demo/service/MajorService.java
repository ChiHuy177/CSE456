package vn.eiu.edu.cse456.fecse4562131200104demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.eiu.edu.cse456.fecse4562131200104demo.model.Major;
import vn.eiu.edu.cse456.fecse4562131200104demo.repository.MajorRepo;

@Service
public class MajorService {
    @Autowired
    private MajorRepo majorRepo;

    public void save(Major major){
        majorRepo.save(major);
    }
}

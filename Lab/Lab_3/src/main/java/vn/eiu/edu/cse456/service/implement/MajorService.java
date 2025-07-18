package vn.eiu.edu.cse456.service.implement;

import vn.eiu.edu.cse456.entity.Major;
import vn.eiu.edu.cse456.repository.implementation.MajorRepository;
import vn.eiu.edu.cse456.service.interfaces.IMajorService;

public class MajorService implements IMajorService {
    MajorRepository majorRepository;

    public MajorService(MajorRepository majorRepository) {
        this.majorRepository = majorRepository;
    }

    public void save(Major major) {
        majorRepository.save(major);
    }

    public void delete(Major major) {
        majorRepository.delete(major);
    }

    public void update(Major major) {
        majorRepository.update(major);
    }

}

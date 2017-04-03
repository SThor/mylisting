package mylisting.service;

import mylisting.domain.Ecole;
import mylisting.repository.EcoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EcoleService {

    @Autowired
    private EcoleRepository ecoleRepository;

    public Ecole saveEcole(Ecole ecole) {
        return ecoleRepository.save(ecole);
    }

}

package mylisting.service;

import mylisting.domain.Classe;
import mylisting.domain.Eleve;
import mylisting.repository.EleveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by 21301646 on 03/04/2017.
 */
@Service
public class EleveService {
    @Autowired
    EleveRepository eleveRepository;

    public Eleve saveEleve(Eleve eleve){
        if(eleve == null){
            throw new IllegalArgumentException("Eleve must not be null");
        }
        return eleveRepository.save(eleve);
    }

    public ArrayList<Eleve> findAllEleveForClasse(Classe classe){
        Iterable<Eleve> eleves = eleveRepository.findByClasse(classe);
        ArrayList<Eleve> elevesList = new ArrayList<>();
        eleves.forEach(elevesList::add);
        return elevesList;
    }

}

package mylisting.service;

import mylisting.domain.Classe;
import mylisting.repository.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ClasseService {

    @Autowired
    ClasseRepository classeRepository;

    public Classe saveClasse(Classe classe) {
        if(classe == null){
            throw new IllegalArgumentException("Classe must not be null");
        }
        return classeRepository.save(classe);
    }

    public ArrayList<Classe> findAllClasses() {
        Iterable<Classe> classes = classeRepository.findAll();
        ArrayList<Classe> classesList = new ArrayList<>();
        classes.forEach(classesList::add);
        return classesList;
    }

    public Classe findOneClasse(Long id) {
        return classeRepository.findOne(id);
    }

}

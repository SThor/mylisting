package mylisting.repository;


import mylisting.domain.Classe;
import mylisting.domain.Eleve;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

/**
 * Created by 21301646 on 03/04/2017.
 */
public interface EleveRepository extends CrudRepository<Eleve,Long> {

    Iterable<Eleve> findByClasse(Classe classe);
}

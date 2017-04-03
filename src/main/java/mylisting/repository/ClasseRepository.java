package mylisting.repository;

import mylisting.domain.Classe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ClasseRepository extends CrudRepository<Classe, Long> {
    //pour la correction du n+1 select
    @Query("select classe from Classe classe join fetch classe.ecole")
    public Iterable<Classe> findAll();
}

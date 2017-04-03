package mylisting.repository;

import mylisting.domain.Ecole;
import org.springframework.data.repository.CrudRepository;

public interface EcoleRepository extends CrudRepository<Ecole, Long> {
}

package robertmora.rivamvc.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import robertmora.rivamvc.models.Apartment;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ApartmentDao extends CrudRepository<Apartment, Integer> {

}

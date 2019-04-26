package robertmora.rivamvc.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import robertmora.rivamvc.models.Offer;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface OfferDao extends CrudRepository<Offer, Integer> {
}

package robertmora.rivamvc.models.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import robertmora.rivamvc.models.Category;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CategeoryDao  extends JpaRepository<Category, Integer> {
}

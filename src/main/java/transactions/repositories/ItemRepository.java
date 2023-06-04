package transactions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import transactions.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long>, ItemRepositoryCustom {

}

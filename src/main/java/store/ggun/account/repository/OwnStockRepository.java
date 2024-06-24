package store.ggun.account.repository;

import store.ggun.account.domain.model.OwnStockModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnStockRepository extends JpaRepository<OwnStockModel,Long> {



}

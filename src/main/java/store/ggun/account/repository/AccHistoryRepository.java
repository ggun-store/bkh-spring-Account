package store.ggun.account.repository;

import store.ggun.account.domain.model.AccHistoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccHistoryRepository extends JpaRepository<AccHistoryModel,Long> {


}

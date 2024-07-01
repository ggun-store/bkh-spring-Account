package store.ggun.account.repository;


import store.ggun.account.domain.dto.AccHistoryDto;
import store.ggun.account.domain.model.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AccountRepository extends JpaRepository<AccountModel, Long> {

    List<AccountModel> findByUserId(Long userModel);

    Boolean existsByAcno(String acno);

}

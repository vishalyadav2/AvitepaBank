package avitepa.foundation.banks.AVITEPA_banks.repository;

import java.util.Optional;

//import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import avitepa.foundation.banks.AVITEPA_banks.model.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, String> {

	Optional<Account> findByAccountId(int accountid);
	
}
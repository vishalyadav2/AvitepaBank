package avitepa.foundation.banks.AVITEPA_banks.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import avitepa.foundation.banks.AVITEPA_banks.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {

    public Optional<Customer> findById(int id);
    
}

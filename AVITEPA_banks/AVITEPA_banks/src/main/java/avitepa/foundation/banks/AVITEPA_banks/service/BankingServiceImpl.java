package avitepa.foundation.banks.AVITEPA_banks.service;


import java.util.ArrayList;

//import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import avitepa.foundation.banks.AVITEPA_banks.repository.AccountRepository;


import avitepa.foundation.banks.AVITEPA_banks.model.Account;
import avitepa.foundation.banks.AVITEPA_banks.model.Customer;
import avitepa.foundation.banks.AVITEPA_banks.repository.CustomerRepository;
import avitepa.foundation.banks.AVITEPA_banks.service.handler.BankingServiceHandler;

@Service
@Transactional
public class BankingServiceImpl implements BankingService {

	@Autowired
    private CustomerRepository customerRepository;
	
    @Autowired
    private BankingServiceHandler bankingServiceHandler;
    
    @Autowired
    private AccountRepository accountRepository;

    public BankingServiceImpl(CustomerRepository repository) {
        this.customerRepository=repository;
    }
    
   
    

    
	public ResponseEntity<Object> addCustomer(Customer customerDetails) {
		
		Customer customer = bankingServiceHandler.convertToCustomerEntity(customerDetails);
		
		customerRepository.save(customer);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Customer created.");
	}

	public List<Customer> findAll() {
	    	
	    	List<Customer> allCustomerDetails = new ArrayList<>();
	
	        Iterable<Customer> customerList = customerRepository.findAll();
	
	        customerList.forEach(customer -> {
	        	allCustomerDetails.add(bankingServiceHandler.convertToCustomerDomain(customer));
	        });
	        
	        return allCustomerDetails;
	    }

	public Customer findById(int id) {
			
			Optional<Customer> customerEntityOpt = customerRepository.findById(id);
	
			if(customerEntityOpt.isPresent())
				return bankingServiceHandler.convertToCustomerDomain(customerEntityOpt.get());
			
			return null;
		}
	
	
	public ResponseEntity<Object> updateCustomer(Customer customerDetails, int id) {
		Optional<Customer> managedCustomerEntityOpt = customerRepository.findById(id);
		Customer unmanagedCustomerEntity = bankingServiceHandler.convertToCustomerEntity(customerDetails);
		if(managedCustomerEntityOpt.isPresent()) {
			Customer managedCustomerEntity = managedCustomerEntityOpt.get();
			managedCustomerEntity.setFirstName(unmanagedCustomerEntity.getFirstName());
			managedCustomerEntity.setLastName(unmanagedCustomerEntity.getLastName());
			managedCustomerEntity.setCustomerAddress(unmanagedCustomerEntity.getCustomerAddress());
			managedCustomerEntity.setContactDetails(unmanagedCustomerEntity.getContactDetails());
			
			
			
			
			customerRepository.save(managedCustomerEntity);
			
			return ResponseEntity.status(HttpStatus.OK).body("Customer updated.");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer Id " + id + " not found.");
		}
	}
	
	
	
	
	public ResponseEntity<Object> deleteAccount(int id) {
			
			Optional<Account> managedAccountEntityOpt = accountRepository.findByAccountId(id);
	
			if(managedAccountEntityOpt.isPresent()) {
				Account managedAccountEntity = managedAccountEntityOpt.get();
				accountRepository.delete(managedAccountEntity);
				return ResponseEntity.status(HttpStatus.OK).body("Account deleted.");
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Account does not exist.");
			}
			
	}
	
	public ResponseEntity<Object> addNewAccount(Account accountInformation) {
			
			
			
			Account account = bankingServiceHandler.convertToAccountEntity(accountInformation);
			
			accountRepository.save(account);
			
			return ResponseEntity.status(HttpStatus.CREATED).body("account created.");
		}
		
	
	
	public ResponseEntity<Object> findByAccountId(int accountid) {
		
		Optional<Account> accountEntityOpt = accountRepository.findByAccountId(accountid);
	
		if(accountEntityOpt.isPresent()) {
			return ResponseEntity.status(HttpStatus.FOUND).body(bankingServiceHandler.convertToAccountDomain(accountEntityOpt.get()));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account id " + accountid + " not found.");
		}
		
	}
	
	public List<Account> findAllAccount() {
    	
    	List<Account> allAccountDetails = new ArrayList<>();

        Iterable<Account> accountList = accountRepository.findAll();

        accountList.forEach(account -> {
        	allAccountDetails.add(bankingServiceHandler.convertToAccountDomain(account));
        });
        
        return allAccountDetails;
    }


	
	public String transferFunds(int from,int to,double amount) {
		if(accountRepository.findByAccountId(from).isPresent()&&accountRepository.findByAccountId(to).isPresent()) {
			if(accountRepository.findByAccountId(from).get().getBalance()<amount) {
				return "Money is less";
			}
			Account account1=accountRepository.findByAccountId(from).get();
			account1.setBalance(account1.getBalance()-amount);
			accountRepository.save(account1);
			Account account2=accountRepository.findByAccountId(to).get();
			account2.setBalance(account2.getBalance()+amount);
			accountRepository.save(account2);
			return "Money is transfer";
		}
		return "Account id not found";
	}



	







	


}
package avitepa.foundation.banks.AVITEPA_banks.service;



import java.util.List;

import org.springframework.http.ResponseEntity;

import avitepa.foundation.banks.AVITEPA_banks.model.Account;
import avitepa.foundation.banks.AVITEPA_banks.model.Customer;


public interface BankingService {

    
    
    public ResponseEntity<Object> addCustomer(Customer customerDetails);
    public List<Customer> findAll();
    public Customer findById(int id);
    public ResponseEntity<Object> updateCustomer(Customer customerDetails, int id);
  
   
    public ResponseEntity<Object> deleteAccount(int id) ;
    public ResponseEntity<Object> addNewAccount(Account accountInformation);
    public ResponseEntity<Object> findByAccountId(int accountid);
    public List<Account> findAllAccount();
    public String transferFunds(int accountid1,int accountid2,double amount);
    
}

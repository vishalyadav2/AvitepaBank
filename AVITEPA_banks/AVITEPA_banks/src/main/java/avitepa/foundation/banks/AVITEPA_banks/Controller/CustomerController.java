package avitepa.foundation.banks.AVITEPA_banks.Controller;

import java.util.List;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import avitepa.foundation.banks.AVITEPA_banks.service.BankingServiceImpl;
//import avitepa.foundation.bank.AVITEPA_bank.domain.CustomerDetails;
import avitepa.foundation.banks.AVITEPA_banks.model.Customer;






@RestController
@RequestMapping("customers")

public class CustomerController {

	
	@Autowired
	private BankingServiceImpl bankingService;

	
	
	
	@GetMapping(path = "/allcustomers")
	

	public List<Customer> getAllCustomers() {

		return bankingService.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public Customer getCustomer(@PathVariable int id) {

		return bankingService.findById(id);
	}
	
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Object> updateCustomer(@RequestBody Customer customerDetails,
			@PathVariable int id) {

		return bankingService.updateCustomer(customerDetails, id);
	}
	
	
	


	

}
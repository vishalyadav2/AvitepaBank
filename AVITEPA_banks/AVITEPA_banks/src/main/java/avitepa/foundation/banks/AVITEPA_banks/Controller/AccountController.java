package avitepa.foundation.banks.AVITEPA_banks.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import avitepa.foundation.banks.AVITEPA_banks.model.Account;

import avitepa.foundation.banks.AVITEPA_banks.service.BankingServiceImpl;

@RestController
@RequestMapping("accounts")

public class AccountController {
	
	@Autowired
	private BankingServiceImpl bankingService;
	
	@PostMapping(path = "/addaccount")

	public ResponseEntity<Object> addNewAccount(@RequestBody Account accountInformation) {

		return bankingService.addNewAccount(accountInformation);
	}
	
	@GetMapping(path = "/{accountid}")

	public ResponseEntity<Object> getByAccountId(@PathVariable int accountid) {

		return bankingService.findByAccountId(accountid);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> deleteAccount(@PathVariable int id) {

		return bankingService.deleteAccount(id);
	}
	
	@GetMapping(path = "/allaccount")
		
	
		public List<Account> getAllAccount() {
	
			return bankingService.findAllAccount();
		}
	
	
	
	
	@GetMapping("/transfer/{accountid1}/{accountid2}/{amount}")
		
		public ResponseEntity<String> transferFunds(@PathVariable int accountid1,@PathVariable int accountid2,@PathVariable double amount){
			return new ResponseEntity<String>(bankingService.transferFunds(accountid1, accountid2, amount),HttpStatus.OK);
		}
	}




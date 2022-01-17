package avitepa.foundation.banks.AVITEPA_banks.service.handler;



import org.springframework.stereotype.Component;


import avitepa.foundation.banks.AVITEPA_banks.model.Account;
import avitepa.foundation.banks.AVITEPA_banks.model.Customer;



@Component
public class BankingServiceHandler {

	
	
	public Customer convertToCustomerEntity(Customer customerDetails) {
		
		
		return Customer.builder()
				.firstName(customerDetails.getFirstName())
				.lastName(customerDetails.getLastName())
				.customerNumber(customerDetails.getCustomerNumber())
				.customerAddress(customerDetails.getCustomerAddress())
				.contactDetails(customerDetails.getContactDetails())
				
				.build();
	}
	
	public Customer convertToCustomerDomain(Customer customer) {
			
			return Customer.builder()
					.id(customer.getId())
					.firstName(customer.getFirstName())
					.lastName(customer.getLastName())
					.customerNumber(customer.getCustomerNumber())
					.customerAddress(customer.getCustomerAddress())
					.contactDetails(customer.getContactDetails())
					
					.build();
		}
	

	
	
	public Account convertToAccountEntity(Account accInfo) {
			
			return Account.builder()
				
					.accountnumber(accInfo.getAccountnumber())
					.balance(accInfo.getBalance())
					.accountType(accInfo.getAccountType())
					.customer(convertToCustomerEntity(accInfo.getCustomer()))
					
					.build();
		}
	
	public Account convertToAccountDomain(Account account) {

		return Account.builder()
				.accountId(account.getAccountId())
				.accountnumber(account.getAccountnumber())
				.balance(account.getBalance())
				.accountType(account.getAccountType())
				.customer(convertToCustomerDomain(account.getCustomer()))
				.build();
	}
		
}

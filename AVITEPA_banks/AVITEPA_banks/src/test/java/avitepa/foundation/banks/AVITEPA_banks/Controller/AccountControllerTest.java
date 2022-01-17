
package avitepa.foundation.banks.AVITEPA_banks.Controller;

import static org.assertj.core.api.Assertions.assertThat;
//import org.assertj.core.api.Assertions;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.junit.jupiter.api.MethodOrderer;
// import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import avitepa.foundation.banks.AVITEPA_banks.model.Account;
import avitepa.foundation.banks.AVITEPA_banks.model.Customer;
import avitepa.foundation.banks.AVITEPA_banks.repository.AccountRepository;
import avitepa.foundation.banks.AVITEPA_banks.service.BankingService;
import avitepa.foundation.banks.AVITEPA_banks.service.BankingServiceImpl;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@DataJpaTest
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class AccountControllerTest {

	@Mock
	AccountRepository accRepo;

	@Mock
	private BankingServiceImpl bankingServiceImpl;

	@InjectMocks
	BankingServiceImpl accService;

	@MockBean
	private BankingService bankingService;

	@Autowired
	MockMvc mockMvc;

	private static ObjectMapper mapper = new ObjectMapper();
	Customer c = new Customer(2, "Vishal", "Yadav", 1010L, "andheri", "9819");

	@Test
	public void addCustomer() throws Exception {
		c.setId(1);
		Account account = new Account(1, 1010, 20, "saving", c);
		
		this.mockMvc.perform(post("/addaccount")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(mapper.writeValueAsString(account))).andExpect(status().isCreated()).andExpect(JsonPath("$.id", (account.getAccountId())))
		
//		account.setAccountId(1);
//		String json = mapper.writeValueAsString(account);
//		Mockito.when(bankingService.addNewAccount(ArgumentMatchers.any()));
//
//		mockMvc.perform(post("/addaccount").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
//				.content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
	}
	
	
}

//	@Test
//	public void testGetByIdReturnAccount() throws Exception {
//		c.setId(2);
//		Account account = new Account(1, 1010, 20, "saving", c);
//		account.setAccountId(1);
//		int id = account.getAccountId();
//
//		Mockito.when(bankingService.findByAccountId(1));
//		mockMvc.perform(get("/get/{id}", 1)).andExpect(status().isFound())
//				.andExpect(jsonPath("$.accountId", Matchers.equalTo(id)));
//	}
//
//	private ResultMatcher jsonPath(String string, Matcher<Integer> equalTo) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Test
//	public void testGetByIdReturnNull() throws Exception {
//		c.setId(2);
//		Account account = new Account(1, 1010, 20, "saving", c);
//		account.setAccountId(1);
//
//		Mockito.when(bankingService.findByAccountId(1));
//		mockMvc.perform(get("/get/{id}", 1)).andExpect(status().isNoContent());
//	}
//
//	@Test
//	public void deleteAccount() throws Exception {
//		Mockito.when(bankingService.deleteAccount(1));
//		mockMvc.perform(MockMvcRequestBuilders.delete("/{id}", 1)).andExpect(status().isOk());
//	}
//
//	@Test
//	public void testGetAllAccount() throws Exception {
//		c.setId(2);
//		Account account = new Account(1, 1010, 20, "saving", c);
//		account.setAccountId(1);
//		Customer c1 = new Customer(2, "Vishal", "Yadav", 1010L, "andheri", "9819");
//		c1.setId(3);
//		Account account1 = new Account(4, 1012, 200, "saving", c1);
//		account1.setAccountId(4);
//		List<Account> accountList = new ArrayList<>();
//		accountList.add(account);
//		accountList.add(account1);
//		Mockito.when(bankingService.findAllAccount()).thenReturn(accountList);
//		mockMvc.perform(get("/getAllAccount")).andExpect(status().isFound());
//	}
//
//	@Test
//
//	public void transferFundsSuccess() throws Exception {
//		Mockito.when(bankingService.transferFunds(1, 3, 1000)).thenReturn("Money transfered");
//		mockMvc.perform(
//				get("/tranferfunds/{accountid1}/{accountid2}/{amount}", 1, 3, 10).accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString().contentEquals("SUCCESS");
//		;
//	}
//
//	@Test
//	public void transferFundsIdMismatch() throws Exception {
//		Mockito.when(bankingService.transferFunds(1, 3, 1000)).thenReturn("ID Wrong");
//		mockMvc.perform(
//				get("/tranferfunds/{accountid1}/{accountid2}/{amount}", 1, 3, 1000).accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString().contentEquals("ID Wrong");
//	}
//
//}

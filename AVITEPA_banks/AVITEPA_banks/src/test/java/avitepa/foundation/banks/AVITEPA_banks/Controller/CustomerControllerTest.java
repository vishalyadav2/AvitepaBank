	package avitepa.foundation.banks.AVITEPA_banks.Controller;
	
	
	
	import com.fasterxml.jackson.databind.ObjectMapper;
	
	import avitepa.foundation.banks.AVITEPA_banks.AvitepaBanksApplication;
	import avitepa.foundation.banks.AVITEPA_banks.model.Customer;
	import avitepa.foundation.banks.AVITEPA_banks.service.BankingServiceImpl;
	
	import org.hamcrest.Matchers;
	import org.junit.jupiter.api.Test;
	import org.junit.jupiter.api.extension.ExtendWith;
	import org.mockito.Mockito;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
	import org.springframework.boot.test.mock.mockito.MockBean;
	import org.springframework.http.MediaType;
	import org.springframework.test.context.ContextConfiguration;
	import org.springframework.test.context.junit.jupiter.SpringExtension;
	import org.springframework.test.web.servlet.MockMvc;
	//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
	
	import java.util.ArrayList;
	import java.util.List;
	
	
	
	import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
	import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
	import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
	import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
	
	
	
	@ExtendWith(SpringExtension.class)
	@WebMvcTest(controllers= CustomerController.class)
	@ContextConfiguration(classes = AvitepaBanksApplication.class)
	public class CustomerControllerTest {
	@Autowired
	MockMvc mockMvc;
	
	
	@MockBean
	BankingServiceImpl bankingService;
	
	
		private static ObjectMapper mapper = new ObjectMapper();
		Customer c=new Customer(2,"Vishal", "Yadav",1010L,"andheri","9819");
		@Test
		public void testGetCustomer() throws Exception {
		c.setId(2);
	
	
		Mockito.when(bankingService.findById(2)).thenReturn(c);
		
		
			mockMvc.perform(get("/{id}")).andExpect(status().isFound())
			.andExpect(jsonPath("$.customerId", Matchers.equalTo(2)))
			.andExpect(jsonPath("$.firstname", Matchers.equalTo("Vishal")))
			.andExpect(jsonPath("$.lastname", Matchers.equalTo("Yadav")))
			.andExpect(jsonPath("$.customernumber", Matchers.equalTo(1010L)))
			.andExpect(jsonPath("$.customerAddress", Matchers.equalTo("andheri")))
			.andExpect(jsonPath("$.contactDetails", Matchers.equalTo("9819")));
		
		
		}
	
	
		@Test
		public void testGetCustomerNoCustomer() throws Exception {
		c.setId(8);
		mapper.writeValueAsString(c);
		Mockito.when(bankingService.findById(2)).thenReturn(null);
		mockMvc.perform(get("/{id}",2)).andExpect(status().isNoContent());
		}
		
		
	
	
		
		
		
		
		
		
	
	/*
	 * @Test public void testPutExample() throws Exception { c.setId(2);
	 * Mockito.when(bankingService.updateCustomer(c,2)); String json =
	 * mapper.writeValueAsString(c);
	 * Mockito.when(bankingService.findById(2)).thenReturn(c);
	 * mockMvc.perform(put("/{id}",2).contentType(MediaType.APPLICATION_JSON).
	 * characterEncoding("utf-8")
	 * .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
	 * ; }
	 */
		
		@Test
		public void testGetAllCustomer() throws Exception {
		//c.setId(2);
		Customer c1=new Customer(2,"Vishal", "Yadavs",1010L,"andheri","9819");
		c1.setId(2);
		List<Customer> customerList=new ArrayList<>();
		//customerList.add(c);
		customerList.add(c1);
		Mockito.when(bankingService.findAll()).thenReturn(customerList);
		mockMvc.perform(get("/allCustomers"))
		.andExpect(status().isFound()).
		andExpect(jsonPath("$[0].customerId", Matchers.equalTo(2)));
		}
	
	
	}
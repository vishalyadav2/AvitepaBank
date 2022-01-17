package avitepa.foundation.banks.AVITEPA_banks.model;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
	
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	   
	    private int accountId;
	    private int accountnumber;
	    private double balance;
	    private String accountType;
	    
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name="customer_id")
	    private Customer customer;

}

package avitepa.foundation.banks.AVITEPA_banks.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransferDetail {

	private int fromAccountid;
	
	private Long toAccountid;
	
	private Double transferAmount;
}
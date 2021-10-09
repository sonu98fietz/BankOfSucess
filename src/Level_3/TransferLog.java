package Level_3;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TransferLog {

	public HashMap<LocalDate,List<Transfer>>  tLog  = new HashMap<LocalDate,List<Transfer>>();
	
	public List<Transfer> getTransfers(Account account){
		List<Transfer> transfers =new ArrayList<Transfer>();

		transfers = tLog.get(LocalDate.now());
		
		if(transfers != null) {
			for(Transfer transfer:transfers) {
				if(account.getName().equalsIgnoreCase(transfer.getFromAccount().getName())) {
					transfers.add(transfer);
				}
			}
		}
		return transfers;
	}
	
	
	public void logTransfer(Transfer transfer) {
		if(tLog.containsKey(LocalDate.now())){
			tLog.get(LocalDate.now()).add(transfer);
//			System.out.println("here1");
//			List<Transfer> transfers =new ArrayList<Transfer>();
//			transfers = tLog.get(LocalDate.now());
//			transfers.add(transfer);
		}else {
			List<Transfer> transfers =new ArrayList<Transfer>();
			transfers.add(transfer);
			tLog.put(LocalDate.now(),transfers );
//			System.out.println("here2");
		}
		
//		for (LocalDate  name: tLog.keySet()) {
//		    String key = name.toString();
//		    String value = tLog.get(name).toString();
//		    System.out.println(key + " " + value);
//		}
	}
}

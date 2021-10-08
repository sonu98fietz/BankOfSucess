import java.util.HashMap;
import java.util.Map;

public class AccountPrivilegeManager {

	public static Map<privilege, Double> privileges = new HashMap<privilege, Double>();
	
	static {
		privileges.put(privilege.GOLD,(double) 100000);
		privileges.put(privilege.PREMIUM,(double) 50000);
		privileges.put(privilege.SILVER,(double) 25000);
	}
	public static double getPrivilegeLimit(privilege Privi) throws invalidPrivilegeException {
		double limit = 0.0;
		if(privileges.containsKey(Privi)) {
			limit = privileges.get(Privi);
		}else {
			throw new invalidPrivilegeException("Invalid Privilege");
		}
		
     return limit;	
	}
}

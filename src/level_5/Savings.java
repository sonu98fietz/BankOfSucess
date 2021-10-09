package level_5;
import java.time.LocalDate;

public class Savings extends Account {

	private LocalDate Date0fBirth;
	private String Gender;
	private int PhoneNUM;
	
	public LocalDate getDate0fBirth() {
		return Date0fBirth;
	}
	public void setDate0fBirth(LocalDate date0fBirth) {
		Date0fBirth = date0fBirth;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public int getPhoneNUM() {
		return PhoneNUM;
	}
	public void setPhoneNUM(int phoneNUM) {
		PhoneNUM = phoneNUM;
	}	
}

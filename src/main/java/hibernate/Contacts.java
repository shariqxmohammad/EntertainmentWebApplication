package hibernate;

public class Contacts {

	private String name;
	private String email;
	private String phone;
	private int contactKey;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getContactKey() {
		return contactKey;
	}
	public void setContactKey(int contactKey) {
		this.contactKey = contactKey;
	}

}
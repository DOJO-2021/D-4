package model;
import java.io.Serializable;

public class User implements Serializable {
	private String user_id; //USER_ID
	private String user_name; //USER_NAME
	private String password; //PASSWORD
	private String user_category; //USER_CATEGORY
	private String company; //COMPANY

	//引数のあるコンストラクタ
	public User(String user_id, String user_name, String password, String user_category, String company) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.password = password;
		this.user_category = user_category;
		this.company = company;
	}

	//引数がないコンストラクタ（デフォルトコンストラクタ）
	//String型の場合 ""、int型の場合 0、Date型の場合 newDate()
	public User() {
		super();
		this.user_id = "";
		this.user_name = "";
		this.password = "";
		this.user_category = "";
		this.company = "";
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser_category() {
		return user_category;
	}

	public void setUser_category(String user_category) {
		this.user_category = user_category;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
}

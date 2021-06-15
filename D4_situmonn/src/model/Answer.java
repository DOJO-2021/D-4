package model;

import java.io.Serializable;
import java.util.Date;

public class Answer implements Serializable {
	private int ans_id;
	private int q_id;
	private String ans_contents;
	private String user_id;
	private Date ans_date;
	private String user_name;

	public Answer(int ans_id, int q_id, String ans_contents,
			String user_id, Date ans_date, String user_name) {
		this.ans_id = ans_id;
		this.q_id = q_id;
		this.ans_contents = ans_contents;
		this.user_id = user_id;
		this.ans_date = ans_date;
		this.user_name = user_name;
	}

	public Answer() {
		ans_id = 0;
		q_id = 0;
		ans_contents = "";
		user_id = "";
		ans_date = new Date();
		user_name = "";
	}

	public Answer(String ans_contents, String user_name) {
		this.ans_contents = ans_contents;
		this.user_name = user_name;
	}

	public Answer(int q_id, String ans_contents,
			String user_id, Date ans_date, String user_name) {
		this.q_id = q_id;
		this.ans_contents = ans_contents;
		this.user_id = user_id;
		this.ans_date = ans_date;
		this.user_name = user_name;
	}

	public int getAns_id() {
		return ans_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public void setAns_id(int ans_id) {
		this.ans_id = ans_id;
	}

	public int getQ_id() {
		return q_id;
	}

	public void setQ_id(int q_id) {
		this.q_id = q_id;
	}

	public String getAns_contents() {
		return ans_contents;
	}

	public void setAns_contents(String ans_contents) {
		this.ans_contents = ans_contents;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Date getAns_date() {
		return ans_date;
	}

	public void setAns_date(Date ans_date) {
		this.ans_date = ans_date;
	}
}

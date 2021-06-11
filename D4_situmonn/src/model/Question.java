package model;
import java.util.Date;

public class Question {
	private int q_id; //Q_ID
	private String q_title; //Q_TITLE
	private String q_contents; //Q_CONTENTS
	private String q_tag01; //Q_TAG01
	private String q_tag02; //Q_TAG02
	private String q_tag03; //Q_TAG03
	private String q_tag04; //Q_TAG04
	private String q_tag05; //Q_TAG05
	private String user_id; //USER_ID
	private String q_file; //Q_FILE
	private Date q_date; //Q_DATE
	private int done_tag; //DONE_TAG
	private int counter; //COUNTER

	//引数のあるコンストラクタ
	public Question(int q_id, String q_title, String q_contents, String q_tag01, String q_tag02, String q_tag03,
			String q_tag04, String q_tag05, String user_id, String q_file, Date q_date, int done_tag, int counter) {
		super();
		this.q_id = q_id;
		this.q_title = q_title;
		this.q_contents = q_contents;
		this.q_tag01 = q_tag01;
		this.q_tag02 = q_tag02;
		this.q_tag03 = q_tag03;
		this.q_tag04 = q_tag04;
		this.q_tag05 = q_tag05;
		this.user_id = user_id;
		this.q_file = q_file;
		this.q_date = q_date;
		this.done_tag = done_tag;
		this.counter = counter;
	}

	//引数がないコンストラクタ（デフォルトコンストラクタ）
	//String型の場合 ""、int型の場合 0、Date型の場合 newDate()
	public Question() {
		super();
		this.q_id = 0;
		this.q_title = "";
		this.q_contents = "";
		this.q_tag01 = "";
		this.q_tag02 = "";
		this.q_tag03 = "";
		this.q_tag04 = "";
		this.q_tag05 = "";
		this.user_id = "";
		this.q_file = "";
		this.q_date = new Date();
		this.done_tag = 0;
		this.counter = 0;
	}

	public int getQ_id() {
		return q_id;
	}

	public void setQ_id(int q_id) {
		this.q_id = q_id;
	}

	public String getQ_title() {
		return q_title;
	}

	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}

	public String getQ_contents() {
		return q_contents;
	}

	public void setQ_contents(String q_contents) {
		this.q_contents = q_contents;
	}

	public String getQ_tag01() {
		return q_tag01;
	}

	public void setQ_tag01(String q_tag01) {
		this.q_tag01 = q_tag01;
	}

	public String getQ_tag02() {
		return q_tag02;
	}

	public void setQ_tag02(String q_tag02) {
		this.q_tag02 = q_tag02;
	}

	public String getQ_tag03() {
		return q_tag03;
	}

	public void setQ_tag03(String q_tag03) {
		this.q_tag03 = q_tag03;
	}

	public String getQ_tag04() {
		return q_tag04;
	}

	public void setQ_tag04(String q_tag04) {
		this.q_tag04 = q_tag04;
	}

	public String getQ_tag05() {
		return q_tag05;
	}

	public void setQ_tag05(String q_tag05) {
		this.q_tag05 = q_tag05;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getQ_file() {
		return q_file;
	}

	public void setQ_file(String q_file) {
		this.q_file = q_file;
	}

	public Date getQ_date() {
		return q_date;
	}

	public void setQ_date(Date q_date) {
		this.q_date = q_date;
	}

	public int getDone_tag() {
		return done_tag;
	}

	public void setDone_tag(int done_tag) {
		this.done_tag = done_tag;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
}

package model;
import java.io.Serializable;

public class QuestionList implements Serializable {

	private String q_tag1; //Q_TAG1
	private String q_tag2; //Q_TAG2
	private String q_tag3; //Q_TAG3
	private String q_tag4; //Q_TAG4
	private String q_tag5; //Q_TAG5
	private String q_tag6; //Q_TAG6
	private String q_tag7; //Q_TAG7
	private String q_tag8; //Q_TAG8
	private String q_tag9; //Q_TAG9
	private String q_tag10; //Q_TAG10
	private String q_tag11; //Q_TAG11
	private String q_contents; //Q_CONTENTS

	//引数のあるコンストラクタ
	public QuestionList(String q_tag1, String q_tag2, String q_tag3, String q_tag4, String q_tag5, String q_tag6,
			String q_tag7, String q_tag8, String q_tag9, String q_tag10, String q_tag11, String q_contents) {
		super();
		this.q_tag1 = q_tag1;
		this.q_tag2 = q_tag2;
		this.q_tag3 = q_tag3;
		this.q_tag4 = q_tag4;
		this.q_tag5 = q_tag5;
		this.q_tag6 = q_tag6;
		this.q_tag7 = q_tag7;
		this.q_tag8 = q_tag8;
		this.q_tag9 = q_tag9;
		this.q_tag10 = q_tag10;
		this.q_tag11 = q_tag11;
		this.q_contents = q_contents;
	}

	//引数がないコンストラクタ（デフォルトコンストラクタ）
	//String型の場合 ""、int型の場合 0、Date型の場合 null
	public QuestionList() {
		super();
		this.q_tag1 = "";
		this.q_tag2 = "";
		this.q_tag3 = "";
		this.q_tag4 = "";
		this.q_tag5 = "";
		this.q_tag6 = "";
		this.q_tag7 = "";
		this.q_tag8 = "";
		this.q_tag9 = "";
		this.q_tag10 = "";
		this.q_tag11 = "";
		this.q_contents = "";
	}

	public String getQ_tag1() {
		return q_tag1;
	}

	public void setQ_tag1(String q_tag1) {
		this.q_tag1 = q_tag1;
	}

	public String getQ_tag2() {
		return q_tag2;
	}

	public void setQ_tag2(String q_tag2) {
		this.q_tag2 = q_tag2;
	}

	public String getQ_tag3() {
		return q_tag3;
	}

	public void setQ_tag3(String q_tag3) {
		this.q_tag3 = q_tag3;
	}

	public String getQ_tag4() {
		return q_tag4;
	}

	public void setQ_tag4(String q_tag4) {
		this.q_tag4 = q_tag4;
	}

	public String getQ_tag5() {
		return q_tag5;
	}

	public void setQ_tag5(String q_tag5) {
		this.q_tag5 = q_tag5;
	}

	public String getQ_tag6() {
		return q_tag6;
	}

	public void setQ_tag6(String q_tag6) {
		this.q_tag6 = q_tag6;
	}

	public String getQ_tag7() {
		return q_tag7;
	}

	public void setQ_tag7(String q_tag7) {
		this.q_tag7 = q_tag7;
	}

	public String getQ_tag8() {
		return q_tag8;
	}

	public void setQ_tag8(String q_tag8) {
		this.q_tag8 = q_tag8;
	}

	public String getQ_tag9() {
		return q_tag9;
	}

	public void setQ_tag9(String q_tag9) {
		this.q_tag9 = q_tag9;
	}

	public String getQ_tag10() {
		return q_tag10;
	}

	public void setQ_tag10(String q_tag10) {
		this.q_tag10 = q_tag10;
	}

	public String getQ_tag11() {
		return q_tag11;
	}

	public void setQ_tag11(String q_tag11) {
		this.q_tag11 = q_tag11;
	}

	public String getQ_contents() {
		return q_contents;
	}

	public void setQ_contents(String q_contents) {
		this.q_contents = q_contents;
	}
}

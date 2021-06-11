package model;

import java.io.Serializable;

public class Answer implements Serializable{
	private int ANS_ID;
	private int Q_ID;
	private String ANS_CONTENTS;
	private String USER_ID;
	private String ANS_DATE;

	public Answer(int ANS_ID, int Q_ID, String ANS_CONTENTS,
			String USER_ID, String ANS_DATE) {
		this.ANS_ID = ANS_ID;
		this.Q_ID = Q_ID;
		this.ANS_CONTENTS = ANS_CONTENTS;
		this.USER_ID = USER_ID;
		this.ANS_DATE = ANS_DATE;
	}

	public int getANS_ID() {
		return ANS_ID;
	}

	public void setANS_ID(int aNS_ID) {
		ANS_ID = aNS_ID;
	}

	public int getQ_ID() {
		return Q_ID;
	}

	public void setQ_ID(int q_ID) {
		Q_ID = q_ID;
	}

	public String getANS_CONTENTS() {
		return ANS_CONTENTS;
	}

	public void setANS_CONTENTS(String aNS_CONTENTS) {
		ANS_CONTENTS = aNS_CONTENTS;
	}

	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getANS_DATE() {
		return ANS_DATE;
	}

	public void setANS_DATE(String aNS_DATE) {
		ANS_DATE = aNS_DATE;
	}
}

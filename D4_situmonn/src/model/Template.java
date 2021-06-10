package model;

import java.io.Serializable;

public class Template implements Serializable{
	private int TEMP_ID;
	private String TEMP_CONTENTS;

	public Template() {
		this.TEMP_ID = 0;
		this.TEMP_CONTENTS = "";
	}

	public int getTEMP_ID() {
		return TEMP_ID;
	}

	public void setTEMP_ID(int tEMP_ID) {
		TEMP_ID = tEMP_ID;
	}

	public String getTEMP_CONTENTS() {
		return TEMP_CONTENTS;
	}

	public void setTEMP_CONTENTS(String tEMP_CONTENTS) {
		TEMP_CONTENTS = tEMP_CONTENTS;
	}
}

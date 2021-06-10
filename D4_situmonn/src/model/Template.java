package model;

import java.io.Serializable;

public class Template implements Serializable{
	private int TEMP_ID;
	private String TEMP_CONTENTS;

	public Template(int TEMP_ID, String TEMP_CONTENTS) {
		this.TEMP_ID = TEMP_ID;
		this.TEMP_CONTENTS = TEMP_CONTENTS;
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

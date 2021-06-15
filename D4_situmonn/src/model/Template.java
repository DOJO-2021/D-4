package model;

import java.io.Serializable;

public class Template implements Serializable {
	private int temp_id;
	private String temp_contents;

	public Template(int temp_id, String temp_contents) {
		this.temp_id = temp_id;
		this.temp_contents = temp_contents;
	}

	public Template() {
		this.temp_id = 0;
		this.temp_contents = "";
	}

	public int getTemp_id() {
		return temp_id;
	}

	public void setTemp_id(int temp_id) {
		this.temp_id = temp_id;
	}

	public String getTemp_contents() {
		return temp_contents;
	}

	public void setTemp_contents(String temp_contents) {
		this.temp_contents = temp_contents;
	}
}

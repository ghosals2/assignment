package com.example.demo.userDetailsModel;

import java.util.HashMap;

public class User {
	public static HashMap<String,String> hashmap=new HashMap<String,String>();
	private String uid;
	private String password;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [Uid=" + uid + ", Password=" + password + "]";
	}
	

}

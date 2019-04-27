package com.jd.maintain.dto;

public class UserInfoDto {
	private int id;
	private String userName;
	private byte[] password;
	private String telephone;
	
	public UserInfoDto() {
		super();
		
	}
	
	public UserInfoDto(int id, String userName, byte[] password, String telephone) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.telephone = telephone;
	}

	public int getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public byte[] getPassword() {
		return password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	
}

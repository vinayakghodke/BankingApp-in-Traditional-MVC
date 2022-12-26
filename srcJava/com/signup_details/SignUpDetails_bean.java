package com.signup_details;

public class SignUpDetails_bean {
private String userName;
private String userPass;
private String userMail;
private String mobNo;
private int userAge;
private int deposit;
private int accNo;
public SignUpDetails_bean() {}  // default constructor

public int getAccNo() {
	return accNo;
}
public void setAccNo(int accNo) {
	this.accNo = accNo;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getUserPass() {
	return userPass;
}
public void setUserPass(String userPass) {
	this.userPass = userPass;
}
public String getUserMail() {
	return userMail;
}
public void setUserMail(String userMail) {
	this.userMail = userMail;
}
public String getMobNo() {
	return mobNo;
}
public void setMobNo(String mobNo) {
	this.mobNo = mobNo;
}
public int getUserAge() {
	return userAge;
}
public void setUserAge(int userAge) {
	this.userAge = userAge;
}
public int getDeposit() {
	return deposit;
}
public void setDeposit(int deposit) {
	this.deposit = deposit;
}



}

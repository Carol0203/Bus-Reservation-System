package com.jsu.rjxy.wyr.dao;

public class MngRecord {
    private String mngusername;
    private String mngpassword;
    
    public MngRecord() {}
	public MngRecord(String carnumber,String start,String destination,String time,int price,int ticket) {
		this.mngusername = mngusername;
		this.mngpassword = mngpassword;
	}
	public String getMngusername() {
		return mngusername;
	}
	public void setMngusername(String mngusername) {
		this.mngusername = mngusername;
	}
	public String getMngpassword() {
		return mngpassword;
	}
	public void setMngpassword(String mngpassword) {
		this.mngpassword = mngpassword;
	}
	
}


package com.jsu.rjxy.wyr.dao;

import org.junit.Test;

public class CarRecord {
    private String carnumber;
    private String start;
    private String destination;
    private String time;
    private int price;
    private int ticket;
    
    public CarRecord() {}
	public CarRecord(String carnumber,String start,String destination,String time,int price,int ticket) {
		this.carnumber = carnumber;
		this.start = start;
		this.destination = destination;
		this.time = time;
		this.price = price;
		this.ticket = ticket;
	}
	public String getCarnumber() {
		return carnumber;
	}
	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTicket() {
		return ticket;
	}
	public void setTicket(int ticket) {
		this.ticket = ticket;
	}
	
}

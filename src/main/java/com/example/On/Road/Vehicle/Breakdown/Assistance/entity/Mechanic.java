package com.example.On.Road.Vehicle.Breakdown.Assistance.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity

public class Mechanic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long mId;
	private String name;
	private String password;
	private String viewRequest;
	private String feedBack;
	private String address;
	@ManyToOne
	private Admin admin;
	
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public long getmId() {
		return mId;
	}
	public void setmId(long mId) {
		this.mId = mId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getViewRequest() {
		return viewRequest;
	}
	public void setViewRequest(String viewRequest) {
		this.viewRequest = viewRequest;
	}
	public String getFeedBack() {
		return feedBack;
	}
	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Mechanic(long mId, String name, String password, String viewRequest, String feedBack, String address) {
		super();
		this.mId = mId;
		this.name = name;
		this.password = password;
		this.viewRequest = viewRequest;
		this.feedBack = feedBack;
		this.address = address;
	}
	
	public Mechanic(Admin admin) {
		super();
		this.admin = admin;
	}
	public Mechanic() {
		super();
	}
	

}

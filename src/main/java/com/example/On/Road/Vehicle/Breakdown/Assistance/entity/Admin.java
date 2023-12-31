package com.example.On.Road.Vehicle.Breakdown.Assistance.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long adminId;
	private String password;
	private String viewMechnic;
	private String name;
	private String veiwUser;
	private String feedBack;
	@OneToMany
private List<Mechanic> mechnaic;
	@OneToMany
	private List<Users> user;
	public long getAdminId() {
		return adminId;
	}
	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getViewMechnic() {
		return viewMechnic;
	}
	public void setViewMechnic(String viewMechnic) {
		this.viewMechnic = viewMechnic;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVeiwUser() {
		return veiwUser;
	}
	public void setVeiwUser(String veiwUser) {
		this.veiwUser = veiwUser;
	}
	public String getFeedBack() {
		return feedBack;
	}
	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}
	public List<Mechanic> getMechnaic() {
		return mechnaic;
	}
	public void setMechnaic(List<Mechanic> mechnaic) {
		this.mechnaic = mechnaic;
	}
	public List<Users> getUser() {
		return user;
	}
	public void setUser(List<Users> user) {
		this.user = user;
	}
	public Admin(long adminId, String password, String viewMechnic, String name, String veiwUser, String feedBack,
			List<Mechanic> mechnaic, List<Users> user) {
		super();
		this.adminId = adminId;
		this.password = password;
		this.viewMechnic = viewMechnic;
		this.name = name;
		this.veiwUser = veiwUser;
		this.feedBack = feedBack;
		this.mechnaic = mechnaic;
		this.user = user;
	}
	public Admin() {
		super();
	}
		
	

}

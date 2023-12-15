package com.example.On.Road.Vehicle.Breakdown.Assistance.services;

import com.example.On.Road.Vehicle.Breakdown.Assistance.entity.Admin;
import com.example.On.Road.Vehicle.Breakdown.Assistance.exceptions.InvalidException;
import com.example.On.Road.Vehicle.Breakdown.Assistance.exceptions.ResourceNotFoundException;

public interface IAdminService {
	
public Admin insertAdmin(Admin admin) throws ResourceNotFoundException;

public Admin updateAdmin(Admin admin) throws ResourceNotFoundException;

public Admin deleteAdmin(long adminId) throws ResourceNotFoundException;

public Admin veiwMechnic(long mechnicId) throws InvalidException;

public Admin veiwUser(long userId) throws ResourceNotFoundException;

public Admin feedBack(Admin admin);



}

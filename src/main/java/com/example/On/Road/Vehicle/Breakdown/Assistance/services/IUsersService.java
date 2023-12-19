package com.example.On.Road.Vehicle.Breakdown.Assistance.services;

import com.example.On.Road.Vehicle.Breakdown.Assistance.entity.Users;
import com.example.On.Road.Vehicle.Breakdown.Assistance.exceptions.ResourceNotFoundException;
import com.example.On.Road.Vehicle.Breakdown.Assistance.exceptions.UserAlreadyExistsException;

public interface IUsersService {
	
	public Users insertUser(Users user) throws UserAlreadyExistsException; 

	public Users updateUser(Users user) throws ResourceNotFoundException; 

	public Users deleteUser(long userId) throws ResourceNotFoundException; 
	
	public Users searchMechanic(long mechanicId);
	
	public Users sendRequest(long mechanicId);
	
	public Users feedBack(Users user);

}

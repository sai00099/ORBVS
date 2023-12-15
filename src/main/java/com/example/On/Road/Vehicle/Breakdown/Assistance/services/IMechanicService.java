package com.example.On.Road.Vehicle.Breakdown.Assistance.services;

import com.example.On.Road.Vehicle.Breakdown.Assistance.entity.Mechanic;
import com.example.On.Road.Vehicle.Breakdown.Assistance.exceptions.InvalidException;
import com.example.On.Road.Vehicle.Breakdown.Assistance.exceptions.ResourceNotFoundException;

public interface IMechanicService {
	
	public Mechanic insertMechanic(Mechanic mechanic) throws ResourceNotFoundException;

	public Mechanic updateMechanic(Mechanic mechanic) throws ResourceNotFoundException;

	public Mechanic deleteMechanic(long mechanicId) throws InvalidException;

	public Mechanic veiwRequest(long mechanicId) throws ResourceNotFoundException;

	public Mechanic feedBack(Mechanic mechanic) throws ResourceNotFoundException;

	public Mechanic address(Mechanic mechanic) throws ResourceNotFoundException;

}

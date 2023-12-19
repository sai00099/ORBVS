package com.example.On.Road.Vehicle.Breakdown.Assistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.On.Road.Vehicle.Breakdown.Assistance.entity.Users;

	@Repository
	public interface IUsersRepository extends JpaRepository<Users, Long> 
	{

		
	}


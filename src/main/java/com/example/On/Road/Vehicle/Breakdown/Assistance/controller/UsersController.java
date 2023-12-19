package com.example.On.Road.Vehicle.Breakdown.Assistance.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.On.Road.Vehicle.Breakdown.Assistance.entity.Users;
import com.example.On.Road.Vehicle.Breakdown.Assistance.services.IUsersService;



@RestController
@RequestMapping("/api/user")
public class UsersController {

	@Autowired
	private IUsersService usersService;

	@PostMapping("/add-user")
	public ResponseEntity<Users> insertUser(@RequestBody Users user) throws Exception {
		if (user != null) {
			return new ResponseEntity<Users>(usersService.insertUser(user), HttpStatus.CREATED);
		}
		throw new Exception("User Object is null or empty");
	}
	
	@DeleteMapping("/delete-user/{userId}")
	public ResponseEntity<Users> deleteUser(@PathVariable Long userId) throws Exception {
		if (userId == 0) {
			throw new Exception("User Id is Invalid");
		}

		return new ResponseEntity<Users>(usersService.deleteUser(userId), HttpStatus.OK);
	}
	
	@PutMapping("/update-user")
	public ResponseEntity<Users> updateUser(@RequestBody Users user) throws Exception {
		if (user != null) {
			return new ResponseEntity<Users>(usersService.updateUser(user), HttpStatus.OK);
		}
		throw new Exception("User  Object is null or empty");
	}
}
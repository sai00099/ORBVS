package com.example.On.Road.Vehicle.Breakdown.Assistance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.On.Road.Vehicle.Breakdown.Assistance.entity.Mechanic;
import com.example.On.Road.Vehicle.Breakdown.Assistance.services.IMechanicService;
import com.sun.tools.sjavac.Log;

@RestController
@RequestMapping
public class MechanicController {
@Autowired
private IMechanicService ms;
@PostMapping("/add-mechanic")
public ResponseEntity<Mechanic> insertmechanic(@RequestBody Mechanic mechanic) throws Exception{
	if (mechanic==null) {
		Log.info("code running successfully");
		throw new Exception("mechanic id not found exception");
	}else {
		return new ResponseEntity<Mechanic> (ms.insertMechanic(mechanic),HttpStatus.ACCEPTED);
		
	}
	
}
@PutMapping("/update-mechanic")
public ResponseEntity<Mechanic>updatemechanic(@RequestBody Mechanic mechanic) throws Exception{
	if (mechanic==null) {
		Log.info("code running successfully");
		throw new Exception("id not found exception");
	}else {
		return new ResponseEntity<Mechanic>(ms.updateMechanic(mechanic),HttpStatus.CREATED);
	}
	
	
}
@DeleteMapping("/delete/{mechanicId}")
public ResponseEntity<Mechanic>deletemechanic(@PathVariable long mechanicId) throws Exception{
	if (mechanicId==0) {
		Log.info("code running successfully");
		throw new Exception("mechanic id not found");
	}else {
		return new ResponseEntity<Mechanic>(ms.deleteMechanic(mechanicId),HttpStatus.ACCEPTED);
	}
}
@GetMapping("/veiw-request-by-Id/{mechanicId")
public ResponseEntity<Mechanic>viewRequest(@PathVariable long mechanicId ) throws Exception{
	if (mechanicId==0) {
		Log.info("code running successfully");
		throw new Exception("request not found exception");
		
	}else {
		return new ResponseEntity<Mechanic>(ms.veiwRequest(mechanicId),HttpStatus.ACCEPTED);
	}
}
@PostMapping("/add-feedBack")
public ResponseEntity<Mechanic>feedBack(@RequestBody Mechanic mechanic) throws Exception{
	if (mechanic==null) {
		Log.info("code running successfully");
		throw new Exception("request not found exception");
		
	}else {
		return new ResponseEntity<Mechanic>(ms.feedBack(mechanic),HttpStatus.ACCEPTED);
	}
}
@PostMapping("/add-address")
public ResponseEntity<Mechanic>address(@RequestBody Mechanic mechanic) throws Exception{
	if (mechanic==null) {
		Log.info("code running successfully");
		throw new Exception("request not found exception");
		
	}else {
		return new ResponseEntity<Mechanic>(ms.address(mechanic),HttpStatus.ACCEPTED);
	}
}
}

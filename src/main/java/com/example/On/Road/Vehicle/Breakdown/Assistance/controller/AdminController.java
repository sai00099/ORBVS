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

import com.example.On.Road.Vehicle.Breakdown.Assistance.entity.Admin;
import com.example.On.Road.Vehicle.Breakdown.Assistance.services.IAdminService;
import com.sun.tools.sjavac.Log;

@RestController
@RequestMapping("api/admin")
public class AdminController {
	 @Autowired
	private IAdminService as;
	
	@PostMapping("/add-admin")
	public ResponseEntity<Admin> insertAdmin(@RequestBody Admin admin) throws Exception {
		if (admin == null) {
			Log.info("code running successfully");
			throw new Exception("adminId not found exception");
		} else {
			return new ResponseEntity<Admin>(as.insertAdmin(admin), HttpStatus.ACCEPTED);
		}
	}
	@PutMapping("/update-admin")
	public ResponseEntity<Admin> updteAdmin(@RequestBody Admin admin) throws Exception {
		if (admin == null) {
			Log.info("code running successfully");
			throw new Exception("admin details are not found exception");
		} else {
			return new ResponseEntity<Admin>(as.updateAdmin(admin), HttpStatus.CREATED);
		}
	}

	@DeleteMapping("/delete/{adminId}")
	public ResponseEntity<Admin> deleteAdmin(@PathVariable(name = "adminId") long adminId) throws Exception {
		if (adminId == 0) {
			Log.info("code running successfully");
			throw new Exception("adminId not found exception");
		} else {
			return new ResponseEntity<Admin>(as.deleteAdmin(adminId), HttpStatus.OK);
		}

	}

	@GetMapping("/veiw-mechnic-by-id/{mechnicId}")
	public ResponseEntity<Admin> veiwMechnic(@PathVariable long mechnicId) throws Exception {
		if (mechnicId == 0) {
			Log.info("code running successfully");
			throw new Exception("mechnic details not found exception");
		} else {
			return new ResponseEntity<Admin>(as.veiwMechnic(mechnicId), HttpStatus.OK);
		}
	}
@PutMapping("/veiw-user-/{userId}")
	public ResponseEntity<Admin> veiwUser(@PathVariable long UserId) throws Exception {
		if (UserId == 0) {
			Log.info("code running successfully");
			throw new Exception("userid not found exception");
		} else {
			return new ResponseEntity<Admin>(as.veiwUser(UserId), HttpStatus.ACCEPTED);

		}
	}
@PostMapping("/add-feedBack")
	public ResponseEntity<Admin> feedBack(@RequestBody Admin admin) throws Exception {
		if (admin == null) {
			Log.info("code running successfully");
			throw new Exception("feed back is not creatre exception");
		} else {
			return new ResponseEntity<Admin>(as.feedBack(admin), HttpStatus.ACCEPTED);
		}
	}
}

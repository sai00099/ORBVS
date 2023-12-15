package com.example.On.Road.Vehicle.Breakdown.Assistance.servicesImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.On.Road.Vehicle.Breakdown.Assistance.entity.Admin;
import com.example.On.Road.Vehicle.Breakdown.Assistance.exceptions.InvalidException;
import com.example.On.Road.Vehicle.Breakdown.Assistance.exceptions.ResourceNotFoundException;
import com.example.On.Road.Vehicle.Breakdown.Assistance.repository.IAdminRepository;
import com.example.On.Road.Vehicle.Breakdown.Assistance.services.IAdminService;
@Service
public class IAdminServicesImpl implements IAdminService {
@Autowired
	private IAdminRepository ar;

	@Override
	public Admin insertAdmin(Admin admin) throws ResourceNotFoundException{
		Optional<Admin> a = ar.findById(admin.getAdminId());
		Admin ad = null;
		if (a.isPresent()) {
			throw new ResourceNotFoundException("Admin allready exist" + admin.getAdminId());
		} else {
			ad = ar.save(admin);
		}
		return ad;
	}

	@Override
	public Admin updateAdmin(Admin admin) throws ResourceNotFoundException {
		Admin au = ar.findById(admin.getAdminId())
				.orElseThrow(() -> new ResourceNotFoundException("admin details are not found" + admin.getAdminId()));
		au.setAdminId(admin.getAdminId());
		au.setName(admin.getName());
		au.setPassword(admin.getPassword());
	
		return ar.save(au);
	
	}

	@Override
	public Admin veiwMechnic(long mechnicId) throws InvalidException {
Admin vm=ar.findById(mechnicId).orElseThrow(()-> new InvalidException("mechnic id not found"));
		return vm;
	}

	@Override
	public Admin veiwUser(long userId) throws ResourceNotFoundException {
Admin vu=ar.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user details are not found"));
		return vu;
	}

	@Override
	public Admin feedBack(Admin admin) {
		admin.setFeedBack("YourFeedbackHere");

	    Admin feedBack = ar.save(admin);

	    return feedBack;

	}

	@Override
	public Admin deleteAdmin(long adminId) throws ResourceNotFoundException {
		 Admin ad=ar.findById(adminId).orElseThrow(()->
		 new ResourceNotFoundException("admin details are not found"));
		 ar.delete(ad);
		return ad;
	}
}

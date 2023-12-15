package com.example.On.Road.Vehicle.Breakdown.Assistance.servicesImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.On.Road.Vehicle.Breakdown.Assistance.entity.Mechanic;
import com.example.On.Road.Vehicle.Breakdown.Assistance.exceptions.InvalidException;
import com.example.On.Road.Vehicle.Breakdown.Assistance.exceptions.ResourceNotFoundException;
import com.example.On.Road.Vehicle.Breakdown.Assistance.repository.IMechanicRepository;
import com.example.On.Road.Vehicle.Breakdown.Assistance.services.IMechanicService;

@Service
public class IMechanicServicesImpl implements IMechanicService {
	@Autowired
	private IMechanicRepository mr;

	@Override
	public Mechanic insertMechanic(Mechanic mechanic) throws ResourceNotFoundException {
		Optional<Mechanic> m = mr.findById(mechanic.getmId());
		Mechanic mid = null;
		if (m.isPresent()) {
			throw new ResourceNotFoundException("mechanic id not found exception" + mechanic.getmId());

		} else {
			mid = mr.save(mechanic);
		}
		return mid;
	}

	@Override
	public Mechanic updateMechanic(Mechanic mechanic) throws ResourceNotFoundException {
		Mechanic m = mr.findById(mechanic.getmId())
				.orElseThrow(() -> new ResourceNotFoundException("Mechnaic not fond"));
		m.setmId(mechanic.getmId());
		m.setName(mechanic.getName());
		m.setPassword(mechanic.getPassword());
		return mr.save(m);

	}

	@Override
	public Mechanic deleteMechanic(long mechanicId) throws InvalidException {
		Mechanic md = mr.findById(mechanicId).orElseThrow(() -> new InvalidException("mechanic id delete"));
		mr.delete(md);
		return md;
	}

	@Override
	public Mechanic veiwRequest(long mechanicId) throws ResourceNotFoundException {
		Mechanic vr = mr.findById(mechanicId).orElseThrow(() -> new ResourceNotFoundException("request not found"));
		return vr;
	}

	@Override
	public Mechanic feedBack(Mechanic mechanic) throws ResourceNotFoundException {
		Mechanic fb = mr.findById(mechanic.getmId())
				.orElseThrow(() -> new ResourceNotFoundException("mechanic 0d not found"));

		return fb;
	}

	@Override
	public Mechanic address(Mechanic mechanic) throws ResourceNotFoundException {
		Mechanic ma = mr.findById(mechanic.getmId())
				.orElseThrow(() -> new ResourceNotFoundException("mechanic id not found"));
		 ma.getAddress();
		return ma;
	}

}

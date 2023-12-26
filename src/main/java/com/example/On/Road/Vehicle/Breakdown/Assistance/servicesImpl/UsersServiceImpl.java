package com.example.On.Road.Vehicle.Breakdown.Assistance.servicesImpl;
import java.lang.StackWalker.Option;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.On.Road.Vehicle.Breakdown.Assistance.entity.Mechanic;
import com.example.On.Road.Vehicle.Breakdown.Assistance.entity.Users;
import com.example.On.Road.Vehicle.Breakdown.Assistance.exceptions.ResourceNotFoundException;
import com.example.On.Road.Vehicle.Breakdown.Assistance.exceptions.UserAlreadyExistsException;
import com.example.On.Road.Vehicle.Breakdown.Assistance.repository.IUsersRepository;
import com.example.On.Road.Vehicle.Breakdown.Assistance.services.IUsersService;
@Service
public class UsersServiceImpl implements IUsersService {
	
	@Autowired
	private IUsersRepository usersRepository;

	@Override
	public Users insertUser(Users user) throws UserAlreadyExistsException {
		Optional<Users> r = usersRepository.findById(user.getUserId());
		Users us = null;
		if (r.isPresent()) {
			throw new UserAlreadyExistsException("User already exists with user Id " + user.getUserId());
		} else {
			us = usersRepository.save(user);
		}

		return us;
	}

	@Override
	public Users updateUser(Users user) throws ResourceNotFoundException  {

		Users u = usersRepository.findById(user.getUserId())
				.orElseThrow(()->new ResourceNotFoundException("User Details are not found"));
		
		u.setAddress(user.getAddress());
		u.setUserId(user.getUserId());
		u.setEmail(user.getEmail());
		u.setMobileNumber(user.getMobileNumber());
		u.setUserName(user.getUserName());

		return usersRepository.save(u);
	}

	@Override
	public Users deleteUser(long userId) throws ResourceNotFoundException {
		Users ur = usersRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User Details are not found"));
		usersRepository.delete(ur);
		return ur;
	}



	@Override
	public Users searchMechanic(long mechanicId) throws ResourceNotFoundException {
Optional<Users> us=usersRepository.findById(mechanicId);
if (mechanicId==0) {
	throw new ResourceNotFoundException("mechanic id not found");

}
	if(us.isPresent()) {

return us.get();
	}else {
		throw new ResourceNotFoundException("mechanic is not found");
	}
	}

	@Override
	public Users sendRequest(long mechanicId) throws ResourceNotFoundException {
		if (mechanicId == 0) {
		}
Users sr=usersRepository.findById(mechanicId).orElseThrow(()-> new ResourceNotFoundException("request not found"));

		return sr ;
	}

	@Override
	public Users feedBack(Users user) throws ResourceNotFoundException {
		Users fb = usersRepository.findById(user.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException("mechanic 0d not found"));

		return fb;
	}

	
}

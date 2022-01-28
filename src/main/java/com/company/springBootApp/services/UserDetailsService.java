package com.company.springBootApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.company.springBootApp.controllers.UserDetails;
import com.company.springBootApp.objects.Users;
import com.company.springBootApp.services.repositories.UsersRepository;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
	
	@Autowired
	UsersRepository usersRepo;
	
	@Override
	public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = usersRepo.findByName(username);
		
		if (user == null) {
			throw(new UsernameNotFoundException("User does not exist"));
		}
		
		return new UserDetails(user);
	}

}

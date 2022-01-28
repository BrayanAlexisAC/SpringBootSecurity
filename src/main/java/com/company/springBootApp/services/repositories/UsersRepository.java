package com.company.springBootApp.services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.springBootApp.objects.Users;
import com.company.springBootApp.objects.classId.UsersId;

public interface UsersRepository extends JpaRepository<Users, UsersId> {

	public Users findByName(String userName);
	
}

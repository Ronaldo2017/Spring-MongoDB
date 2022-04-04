package com.rc.springmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rc.springmongo.domain.User;
import com.rc.springmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired // instancia o objeto, injeta a dependencia automatica
	private UserRepository userRepository;
	
	public List<User> findAll(){
		//traz todos os objetos do bd, do tipo usuario
		return userRepository.findAll();
		
	}

}

package com.rc.springmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rc.springmongo.domain.User;
import com.rc.springmongo.dto.UserDTO;
import com.rc.springmongo.repository.UserRepository;
import com.rc.springmongo.services.exception.ObjectNotFundException;

@Service
public class UserService {

	@Autowired // instancia o objeto, injeta a dependencia automatica
	private UserRepository userRepository;

	public List<User> findAll() {
		// traz todos os objetos do bd, do tipo usuario
		return userRepository.findAll();

	}

	public User findById(String id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFundException("Objeto não encontrao!"));

	}

	public User insert(User obj) {
		return userRepository.insert(obj);
	}
	
	public void delete(String id) {
		/*
		 * primeiro busca o id, se nao encontrar ja lanca a excessao
		 */
		findById(id);
		userRepository.deleteById(id);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
	

}

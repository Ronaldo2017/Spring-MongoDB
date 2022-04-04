package com.rc.springmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rc.springmongo.domain.User;
import com.rc.springmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	// retorna lista de usuarios
	// ResponseEntity = encapsula, retorna possiveis cabeçalhos, erros etc
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {

		// nova lista de usuario e adiciona e retorna a lista
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}

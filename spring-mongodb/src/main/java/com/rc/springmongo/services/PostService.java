package com.rc.springmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rc.springmongo.domain.Post;
import com.rc.springmongo.repository.PostRepository;
import com.rc.springmongo.services.exception.ObjectNotFundException;

@Service
public class PostService {

	@Autowired // instancia o objeto, injeta a dependencia automatica
	private PostRepository postRepository;

	public Post findById(String id) {
		Optional<Post> obj = postRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFundException("Objeto não encontrao!"));

	}
	
	public List<Post> findByTitle(String text){
		return postRepository.findByTitle(text);
	}

}

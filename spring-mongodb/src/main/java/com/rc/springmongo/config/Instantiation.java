package com.rc.springmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rc.springmongo.domain.Post;
import com.rc.springmongo.domain.User;
import com.rc.springmongo.dto.AuthorDTO;
import com.rc.springmongo.dto.CommentDTO;
import com.rc.springmongo.repository.PostRepository;
import com.rc.springmongo.repository.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();//limpa a coleção no mongodb
		
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2001"), "Partiu viagem",
				"Vou viajar para Curitiba", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("21/03/2001"),
				"Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Boa viagem", sdf.parse("22/03/2000"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("23/03/2000"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha um ótima dia!", sdf.parse("25/03/2000"), new AuthorDTO(alex));
		
		post1.getcomments().add(c1);
		post1.getcomments().add(c2);
		post2.getcomments().add(c3);
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		
		userRepository.save(maria);
	}

}

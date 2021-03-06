//este pacote, serve para acesso aos dados
package com.rc.springmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rc.springmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}

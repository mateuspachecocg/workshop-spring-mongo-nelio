package com.mateuspacheco.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mateuspacheco.workshopmongo.domain.User;

/**
 * UserRepository
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {

}

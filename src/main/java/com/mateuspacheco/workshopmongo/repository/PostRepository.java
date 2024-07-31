package com.mateuspacheco.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mateuspacheco.workshopmongo.domain.Post;

/**
 * UserRepository
 */
@Repository
public interface PostRepository extends MongoRepository<Post, String> {

  List<Post> findByTitleContaining(String text);

}

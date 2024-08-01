package com.mateuspacheco.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.mateuspacheco.workshopmongo.domain.Post;

/**
 * UserRepository
 */
@Repository
public interface PostRepository extends MongoRepository<Post, String> {

  @Query("{'title': {$regex: ?0, $options: 'i'}}")
  List<Post> searchTitle(String text);

  List<Post> findByTitleContaining(String text);

}

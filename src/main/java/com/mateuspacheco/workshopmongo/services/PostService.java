package com.mateuspacheco.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateuspacheco.workshopmongo.domain.Post;
import com.mateuspacheco.workshopmongo.repository.PostRepository;
import com.mateuspacheco.workshopmongo.services.exceptions.ObjectNotFoundException;

/**
 * UserService
 */
@Service
public class PostService {

  @Autowired
  private PostRepository postRepository;

  public Post findbyId(String id) {
    Optional<Post> obj = postRepository.findById(id);
    return obj.orElseThrow(() -> new ObjectNotFoundException("Post nao encontrado!"));
  }

  public List<Post> findByTitle(String text) {
    return postRepository.searchTitle(text);
  }
}

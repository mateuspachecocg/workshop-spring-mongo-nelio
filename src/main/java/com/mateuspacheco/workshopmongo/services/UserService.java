package com.mateuspacheco.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateuspacheco.workshopmongo.domain.User;
import com.mateuspacheco.workshopmongo.repository.UserRepository;

/**
 * UserService
 */
@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public List<User> findAll() {
    return userRepository.findAll();
  }

}

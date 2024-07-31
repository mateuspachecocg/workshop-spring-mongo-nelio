package com.mateuspacheco.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateuspacheco.workshopmongo.domain.User;
import com.mateuspacheco.workshopmongo.dto.UserDTO;
import com.mateuspacheco.workshopmongo.repository.UserRepository;
import com.mateuspacheco.workshopmongo.services.exceptions.ObjectNotFoundException;

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

  public User findById(String id) {
    Optional<User> obj = userRepository.findById(id);
    return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado!"));
  }

  public User insert(User obj) {
    return userRepository.insert(obj);
  }

  public void delete(String id) {
    findById(id);
    userRepository.deleteById(id);
  }

  public User update(User obj) {
    Optional<User> newObjOptional = userRepository.findById(obj.getId());
    User newObj = newObjOptional.orElseThrow(() -> new ObjectNotFoundException(("Objeto nao encontrado")));
    updateData(newObj, obj);
    return userRepository.save(newObj);
  }

  private void updateData(User newObj, User obj) {
    newObj.setName(obj.getName());
    newObj.setEmail(obj.getEmail());
  }

  public User fromDTO(UserDTO objDto) {
    return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
  }

}

package com.example.testing.services.impl;

import com.example.testing.exceptions.EntityNotFoundException;
import com.example.testing.models.User;
import com.example.testing.repositories.IUserRepository;
import com.example.testing.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.function.Supplier;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

  @Autowired
  private IUserRepository iUserRepository;

  @Override	
  public User findById(Long id) {
   return iUserRepository
            .findById(id)
            .orElseThrow(() ->
              new EntityNotFoundException("Entity not found with id: " + id));
  }
  
  @Override	
  public User save(User user) {
    // by default creates active user
    return iUserRepository.save(user);
  }
  
  @Override	
  public void update(User user) {
    User existingUser = iUserRepository
                          .findById(user.getId())
                          .orElseThrow(() ->
                            new EntityNotFoundException("User is not in DB"));

    existingUser.setName(user.getName());
    existingUser.setAge(user.getAge());
    existingUser.setAddress(user.getAddress());
  }
  
  @Override	
  public void delete(Long id) {
    User user = iUserRepository.findById(id)
                  .orElseThrow(() ->
                    new EntityNotFoundException("User is not in DB"));

    iUserRepository.delete(user);
  }
}


package com.example.testing.services.impl;

import com.example.testing.models.User;
import com.example.testing.repositories.IUserRepository;
import com.example.testing.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

  @Autowired
  private IUserRepository iUserRepository;

  @Override	
  public User find(Long id) {
   return null;
  }
  
  @Override	
  public User save(User user) {
    return iUserRepository.save(user);
  }
  
  @Override	
  public void update(User user) {
  
  }
  
  @Override	
  public void delete(Long id) {
  
  }
}


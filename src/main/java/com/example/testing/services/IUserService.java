package com.example.testing.services;

import com.example.testing.models.User;

public interface IUserService {
  User findById(Long id);
  User save(User user);
  void update(User user);
  void delete(Long id);
}

package com.example.testing.service;

import com.example.testing.models.User;

public interface IUserService {
  User find(Long id);
  User save(User user);
  void update(User user);
  void delete(Long id);
}

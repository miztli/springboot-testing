package com.example.testing.controllers;

import com.example.testing.models.User;
import com.example.testing.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/users")
public class UserController {

  @Autowired
  private IUserService iUserService;

  @PostMapping
  private ResponseEntity<User> save(@RequestBody final User user, UriComponentsBuilder uriComponentsBuilder) {
    User createdUser = iUserService.save(user);
    URI location = uriComponentsBuilder.path("/{id}").buildAndExpand(createdUser.getId()).toUri();

    return ResponseEntity.created(location).build();
  }
}

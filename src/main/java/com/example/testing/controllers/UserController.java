package com.example.testing.controllers;

import com.example.testing.external.UserDto;
import com.example.testing.external.UserMapper;
import com.example.testing.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/users")
public class UserController {

  @Autowired
  private IUserService iUserService;

  @GetMapping("/{id}")
  public UserDto findById(@PathVariable(name = "id") final Long id) {
    UserDto userDto = UserMapper.from(iUserService.findById(id));
    System.out.println("found user: " + userDto.toString());
    return userDto;
  }
  @PostMapping
  public ResponseEntity<UserDto> save(@RequestBody final UserDto userDto) {
    System.out.println("Creating user: " + userDto.toString());
    UserDto createdUser = UserMapper.from(iUserService.save(UserMapper.from(userDto)));
    URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(createdUser.getId())
                    .toUri();

    return ResponseEntity.created(location).build();
  }
}

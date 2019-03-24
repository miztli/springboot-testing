package com.example.testing.external;

import com.example.testing.models.User;

public class UserMapper {
  public static User from(UserDto userDto) {
    User user = new User();
      user.setId(userDto.getId());
      user.setName(userDto.getName());
      user.setAddress(userDto.getAddress());
      user.setAge(userDto.getAge());

      return user;
  }

  public static UserDto from(User user) {
    UserDto userDto = new UserDto();
      userDto.setId(user.getId());
      userDto.setName(user.getName());
      userDto.setAddress(user.getAddress());
      userDto.setAge(user.getAge());
      userDto.setActive(user.isActive());

    return userDto;
  }
}

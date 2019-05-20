package com.example.testing.services;

import com.example.testing.TestingApplicationIntegrationTests;
import com.example.testing.exceptions.EntityNotFoundException;
import com.example.testing.models.User;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserServiceIntegrationTest extends TestingApplicationIntegrationTests {

  @Autowired
  private IUserService iUserService;

  // FIND
  @Test
  @DatabaseSetup("/db-setup-data/createdUser.xml")
  public void whenRetrievingAnExistingUserById_PropertiesMustMatch() {
    User existingUser = iUserService.findById(1L);

    assertNotNull(existingUser);
    assertEquals("Citlalli", existingUser.getName());
    assertTrue(22 == existingUser.getAge());
    assertEquals("Sur 119a #2223", existingUser.getAddress());
    assertTrue(existingUser.isActive());
  }

  // CREATE
  @Test
  @DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT)
  public void createANewUser_then_validateGeneratedId_and_generatedStatus() {
    User newUser = new User();
      newUser.setName("Oscar");
      newUser.setAddress("Sur 119A #333");
      newUser.setAge(23);

    User savedUser = iUserService.save(newUser);

    assertNotNull("A new user must contain the assigned id", savedUser.getId());
    assertTrue("When creating a user through the API, status must be active", savedUser.isActive());
  }

  // UPDATE
  @Test
  @DatabaseSetup("/db-setup-data/createdUser.xml")
  public void whenUpdatingUserProperties_then_validatePersistedChanges() {
    String name = "Eduardo";
    Integer age = 29;
    String address = "Sur 119A #23";

    User existingUser = new User();
      existingUser.setId(1L);
      existingUser.setName(name);
      existingUser.setAge(age);
      existingUser.setAddress(address);

    iUserService.update(existingUser);

    User updatedUser = iUserService.findById(1L);

    assertNotNull(existingUser);
    assertEquals(name, updatedUser.getName());
    assertTrue(age == updatedUser.getAge());
    assertEquals(address, updatedUser.getAddress());
  }

  // DELETE
  @Test(expected = EntityNotFoundException.class)
  @DatabaseSetup("/db-setup-data/createdUser.xml")
  public void whenUserIsRemovedById_then_whenTryingToRemoveAgain_throwException() {
    iUserService.delete(1L);
    iUserService.delete(1L);
  }
}

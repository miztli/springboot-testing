package com.example.testing.exceptions;

public class EntityNotFoundException extends RuntimeException {
  private int code = 101;
  private int httpStatusCode = 404;

  public EntityNotFoundException(String message) {
    super(message);
  }

  public EntityNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }
}

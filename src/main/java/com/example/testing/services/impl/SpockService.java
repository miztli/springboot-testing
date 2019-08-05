package com.example.testing.services.impl;

import java.util.List;

public class SpockService
{
  private SpockDependency spockDependency;

  public SpockService(final SpockDependency spockDependency)
  {
    this.spockDependency = spockDependency;
  }

  public void storeName(final String name) {
    this.getSpockDependency().addName(name);
  }

  public List<String> retreiveNames() {
    return getSpockDependency().getNames();
  }

  public int retrieveSize() {
    return getSpockDependency().namesSize();
  }

  public SpockDependency getSpockDependency()
  {
    return spockDependency;
  }

  public void setSpockDependency(final SpockDependency spockDependency)
  {
    this.spockDependency = spockDependency;
  }
}

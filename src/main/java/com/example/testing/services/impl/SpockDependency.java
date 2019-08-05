package com.example.testing.services.impl;

import java.util.List;

public class SpockDependency
{

  private List<String> names;

  public void addName(final String name) {
    this.names.add("Hello " + name);
  }

  public int namesSize() {
    return this.names.size();
  }

  public List<String> getNames()
  {
    return names;
  }

  public void setNames(final List<String> names)
  {
    this.names = names;
  }
}

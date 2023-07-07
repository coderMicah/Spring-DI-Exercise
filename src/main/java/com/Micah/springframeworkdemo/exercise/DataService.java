package com.Micah.springframeworkdemo.exercise;

import org.springframework.stereotype.Component;

@Component
public interface DataService {
  public int[] retrieveData();
}

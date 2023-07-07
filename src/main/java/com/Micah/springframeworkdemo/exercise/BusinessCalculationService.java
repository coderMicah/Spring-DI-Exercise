package com.Micah.springframeworkdemo.exercise;

import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class BusinessCalculationService {
	private DataService dataService;

	public BusinessCalculationService(DataService service1) {
		super();
		this.dataService = service1;
	}

	public int findMax() {
		return Arrays.stream(dataService.retrieveData()).max().orElse(0);
	}
}
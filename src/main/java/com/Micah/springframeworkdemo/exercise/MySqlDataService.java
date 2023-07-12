package com.Micah.springframeworkdemo.exercise;

import org.springframework.stereotype.Repository;

//@Component
//Instead of @Component we can use @Repository to indicate the class manipulate or retrieve data from database
@Repository
public class MySqlDataService implements DataService {

	@Override
	public int[] retrieveData() {
		return new int[] { 1, 2, 3, 4, 5 };
	}

}

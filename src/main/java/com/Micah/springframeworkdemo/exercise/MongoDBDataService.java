package com.Micah.springframeworkdemo.exercise;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

//@Component
//Instead of @Component we can use @Repository to indicate the class manipulate or retrieve data from database
@Repository
@Primary
public class MongoDBDataService implements DataService {

	@Override
	public int[] retrieveData() {
		return new int[] { 11, 22, 33, 44, 55 };
	}

}

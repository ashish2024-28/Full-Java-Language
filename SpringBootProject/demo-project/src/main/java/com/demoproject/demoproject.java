package com.demoproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class demoproject {

	public static void main(String[] args) {
		SpringApplication.run(demoproject.class, args);
	}

}


// POST /student  → Controller → Service → Repository → Database
//                                        ↓
//                                 DB returns data
// Controller ← Service ← Repository ← Database

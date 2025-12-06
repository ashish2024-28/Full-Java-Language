package com.demoproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudOperationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudOperationApplication.class, args);
	}

}


// POST /student  → Controller → Service → Repository → Database
//                                        ↓
//                                 DB returns data
// Controller ← Service ← Repository ← Database

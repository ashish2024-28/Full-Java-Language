package com.demoproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class demoprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(demoprojectApplication.class, args);
	}




}


// POST /student  → Controller → Service → Repository → Database
//                                        ↓
//                                 DB returns data
// Controller ← Service ← Repository ← Database

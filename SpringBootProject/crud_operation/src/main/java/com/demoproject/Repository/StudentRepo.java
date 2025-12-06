package com.demoproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demoproject.Entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {
    
}

// JpaRepository<Student, Long> gives free built-in functions:

// | Function       | SQL Behind the Scene           |
// | -------------- | ------------------------------ |
// | `save()`       | INSERT / UPDATE                |
// | `findAll()`    | SELECT * FROM student          |
// | `findById()`   | SELECT * WHERE id=?            |
// | `deleteById()` | DELETE FROM student WHERE id=? |

// Spring + Hibernate generates all queries itself.
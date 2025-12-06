package com.demoproject.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demoproject.Entity.Student;
import com.demoproject.Repository.StudentRepo;

@Service
public class StudentService {

  private final StudentRepo repo;

    public StudentService(StudentRepo repo) {
        this.repo = repo;
    }

    public Student addStudent(Student s) {
        return repo.save(s); // sends to db
    }

    public List<Student> getAll() {
        return repo.findAll();
    }

    public Student getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Student updateStudent(Student s) {
        return repo.save(s);
    }

    public String deleteStudent(Long id) {
        repo.deleteById(id);
        return "Student deleted with id " + id;
    }

}

// @Service → tells Spring it is business logic layer. It calls the repository to interact with DB.

// repo.save() → automatically INSERT or UPDATE depending on presence of ID.
package com.demoproject.Cotroller;

import org.springframework.web.bind.annotation.*;
import com.demoproject.Entity.Student;
import com.demoproject.Service.StudentService;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudenController {

    private final StudentService service;

    public StudenController(StudentService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public Student add(@RequestBody Student s) {
        return service.addStudent(s);
    }

    // READ ALL
    @GetMapping
    public List<Student> getAll() {
        return service.getAll();
    }

    // READ ONE
    @GetMapping("/{id}")
    public Student get(@PathVariable Long id) {
        return service.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student s) {
        s.setId(id);
        return service.updateStudent(s);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return service.deleteStudent(id);
    }
}


/*
@RestController → tells Spring this class contains API endpoints.

@RequestMapping("/student") → all APIs will start with /student.

@Autowired → Spring will automatically create the object of StudentService.

@PostMapping → handles HTTP POST request.

@RequestBody → converts JSON → Student object.
*/
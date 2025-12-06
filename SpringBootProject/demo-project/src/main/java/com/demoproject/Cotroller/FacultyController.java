package com.demoproject.Cotroller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoproject.Entity.Faculty;
import com.demoproject.Service.FacultyService;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
 
    
    private final FacultyService fservice;

    public FacultyController(FacultyService fservice) {
        this.fservice = fservice;
    }

    // CREATE
    @PostMapping
    public Faculty add(@RequestBody Faculty s) {
        return fservice.addFaculty(s);
    }

    // READ ALL
    @GetMapping
    public List<Faculty> getAll() {
        return fservice.getAll();
    }

    // READ ONE
    @GetMapping("/{id}")
    public Faculty get(@PathVariable Long id) {
        return fservice.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Faculty update(@PathVariable Long id, @RequestBody Faculty faculty) {
        faculty.setId(id);
        return fservice.updateFaculty(faculty);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return fservice.deleteFaculty(id);
    }
}


/*
@RestController → tells Spring this class contains API endpoints.

@RequestMapping("/student") → all APIs will start with /student.

@Autowired → Spring will automatically create the object of StudentService.

@PostMapping → handles HTTP POST request.

@RequestBody → converts JSON → Student object.
*/



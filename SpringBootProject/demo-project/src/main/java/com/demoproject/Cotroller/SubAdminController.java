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

import com.demoproject.Entity.SubAdmin;
import com.demoproject.Service.SubAdminService;


@RestController
@RequestMapping("/subadmin") 
public class SubAdminController {    
    
    private final SubAdminService SAservice;

    public SubAdminController(SubAdminService SAservice) {
        this.SAservice = SAservice;
    }

    // CREATE
    @PostMapping
    public SubAdmin add(@RequestBody SubAdmin subAdmin) {
        return SAservice.addSubAdmin(subAdmin);
    }

    // READ ALL
    @GetMapping
    public List<SubAdmin> getAll() {
        return SAservice.getAll();
    }

    // READ ONE
    @GetMapping("/{id}")
    public SubAdmin get(@PathVariable Long id) {
        return SAservice.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public SubAdmin update(@PathVariable Long id, @RequestBody SubAdmin subAdmin) {
        subAdmin.setId(id);
        return SAservice.updateSubAdmin(subAdmin);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return SAservice.deleSubAdmin(id);
    }
}




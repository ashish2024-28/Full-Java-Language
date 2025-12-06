package com.demoproject.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demoproject.Entity.Faculty;
import com.demoproject.Repository.FacultyRepository;

@Service
public class FacultyService {

      private final FacultyRepository frepo;

    public FacultyService(FacultyRepository frepo) {
        this.frepo = frepo;
    }

    public Faculty addFaculty(Faculty s) {
        return frepo.save(s); // sends to db
    }

    public List<Faculty> getAll() {
        return frepo.findAll();
    }

    public Faculty getById(Long id) {
        return frepo.findById(id).orElse(null);
    }

    public Faculty updateFaculty(Faculty s) {
        return frepo.save(s);
    }

    public String deleteFaculty(Long id) {
        frepo.deleteById(id);
        return "Faculty deleted with id " + id;
    }

    // public Faculty addFaculty(Faculty s) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'addFaculty'");
    // }

    // public String deleteFaculty(Long id) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'deleteFaculty'");
    // }

}

// @Service → tells Spring it is business logic layer. It calls the repository to interact with DB.

// repo.save() → automatically INSERT or UPDATE depending on presence of ID.

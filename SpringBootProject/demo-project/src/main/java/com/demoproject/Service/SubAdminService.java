package com.demoproject.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demoproject.Entity.SubAdmin;
import com.demoproject.Repository.SubAdminRepository;

@Service
public class SubAdminService {
    
    private final SubAdminRepository SArepo;

    public SubAdminService(SubAdminRepository SArepo){
        this.SArepo = SArepo;
    }

    public SubAdmin addSubAdmin(SubAdmin SA){
        return SArepo.save(SA);
    }

    public List<SubAdmin> getAll(){
        return SArepo.findAll();
    }

    public SubAdmin getById(Long id){
        return SArepo.findById(id).orElse(null);
    }

    public SubAdmin updateSubAdmin(SubAdmin SA){
        return SArepo.save(SA);
    }
    
    public String deleSubAdmin(Long id){
        SArepo.deleteById(id);
        return "SubAdmin deleted with id " + id;
    }


}

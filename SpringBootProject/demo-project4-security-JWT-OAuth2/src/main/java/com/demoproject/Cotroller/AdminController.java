package com.demoproject.Cotroller;
    
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demoproject.Entity.DomainAdmin;
import com.demoproject.Entity.University;
import com.demoproject.Service.DomainAdminService;
import com.demoproject.Service.UniversityService;


@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    
    @Autowired
    private UniversityService universityService;
    @Autowired
    private DomainAdminService domainAdminService;
    
    @GetMapping
    public String test(){
        return "ADMIN Access OK";
    }
    
    /* ================= DOMAIN ADMIN ================= */

    @GetMapping("/all_domain_admins")
    public List<DomainAdmin> getAllDomainAdmins() {
        return domainAdminService.getAllDomainAdmin();
    }
    
    /* ================= UNIVERSITY ================= */

    // GET ALL
    @GetMapping("/all_universities")
    public List<University> getAllUniversities() {
        return universityService.getAll();
    }
    
    // GET BY ID
    @GetMapping("/universitie_id")
    public University getUniversityById(@RequestParam Long id) {
        return universityService.getById(id);
    }

    // This will match /hu, /dtu, /aku etc.
    @GetMapping("/universitie_domain")
    public University getByDomain(@RequestParam String domain) {
        return universityService.getByDomain(domain);
    }

    // UPDATE id and domain
    @PutMapping("/universitie_update/id_domain")
    public University update(@RequestParam String domain, @RequestParam Long id, @RequestBody University univ){
        univ.setId(id);
        return universityService.updateUniversity(domain,id,univ);
    }

    // delete by id and domain
    @DeleteMapping("/universitie_delete/id_domain")
    public String delete(@RequestParam Long id, @RequestParam String domain){
        return universityService.deleteUniversity(id,domain);
    }

}

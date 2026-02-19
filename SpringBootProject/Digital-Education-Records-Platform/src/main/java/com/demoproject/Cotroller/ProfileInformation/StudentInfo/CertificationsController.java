package com.demoproject.Cotroller.ProfileInformation.StudentInfo;

import java.io.IOException;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

import com.demoproject.Entity.ProfileInformation.StudentInfo.Certifications;
import com.demoproject.Service.ProfileInformation.StudentInfo.CertificationsService;

@RestController
@RequestMapping("/{domain}/student/certifications")
// @PreAuthorize("hasRole('STUDENT') and #domain == authentication.principal.domain")

@RequiredArgsConstructor
public class CertificationsController {

    private final CertificationsService certificationsService;

    @GetMapping
    public String greet(){
        return "welcom to certifications....";
    }

    // ADD Certification
    @PostMapping("/add")
    public Certifications addCertification(
            Authentication authentication,
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam MultipartFile file) throws IOException {

        String email = authentication.getName();

        return certificationsService.addCertification(
                email, title, description, file);
    }

    // GET My Certifications
    @GetMapping("/my")
    public List<Certifications> getMyCertifications(
            Authentication authentication) {

        String email = authentication.getName();

        return certificationsService.getMyCertifications(email);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        certificationsService.deleteCertification(id);
        return "Deleted Successfully";
    }

    // SEARCH
    @GetMapping("/search")
    public List<Certifications> search(@RequestParam String title) {
        return certificationsService.searchByTitle(title);
    }

}

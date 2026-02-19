package com.demoproject.Service.ProfileInformation.StudentInfo;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

import com.demoproject.Entity.Student;
import com.demoproject.Entity.ProfileInformation.StudentInfo.Certifications;
import com.demoproject.Repository.StudentRepository;
import com.demoproject.Repository.ProfileInformation.StudentProfile.CertificationsRepository;

@Service
@RequiredArgsConstructor
public class CertificationsService {

    private final CertificationsRepository certificationsRepository;
    private final StudentRepository studentRepository;

    private final String UPLOAD_DIR = "uploads/certificates/";

    // ADD Certification (Logged-in user)
    public Certifications addCertification(
            String email,
            String title,
            String description,
            MultipartFile file) throws IOException {

        Student student = studentRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        // Save file
        Files.createDirectories(Paths.get(UPLOAD_DIR));

        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(UPLOAD_DIR + fileName);

        Files.write(filePath, file.getBytes());

        Certifications cert = new Certifications();
        cert.setTitle(title);
        cert.setDescription(description);
        cert.setCertificateFilePath(UPLOAD_DIR + fileName);
        cert.setStudent(student);

        return certificationsRepository.save(cert);
    }

    // GET My Certifications
    public List<Certifications> getMyCertifications(String email) {
        Student student = studentRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        return certificationsRepository.findByStudentId(student.getId());
    }

    // DELETE
    public void deleteCertification(Long id) {
        certificationsRepository.deleteById(id);
    }

    // SEARCH
    public List<Certifications> searchByTitle(String title) {
        return certificationsRepository.findByTitleContainingIgnoreCase(title);
    }
}

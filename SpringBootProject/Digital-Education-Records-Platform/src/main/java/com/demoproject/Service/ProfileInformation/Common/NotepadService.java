package com.demoproject.Service.ProfileInformation.Common;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

import com.demoproject.Entity.BaseUser;
import com.demoproject.Entity.ProfileInformation.Common.Notepad;
import com.demoproject.Repository.ProfileInformation.Common.NotepadRepository;
import com.demoproject.Service.BaseUserService;

@Service
@RequiredArgsConstructor
public class NotepadService {

    private  NotepadRepository noteRepository;
    private  BaseUserService baseUserService;
    private  Authentication authentication;

    private final String UPLOAD_DIR = "uploads/notes/";

    public Notepad addNote(String role, String domain, String email, String title, String noteText, MultipartFile file) throws IOException {

        BaseUser user = baseUserService.findUserByDomainAndEmail(email, domain);

        Files.createDirectories(Paths.get(UPLOAD_DIR));

        String filePathString = null;

        if (file != null && !file.isEmpty()) {
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path filePath = Paths.get(UPLOAD_DIR, fileName);
            Files.write(filePath, file.getBytes());
            filePathString = filePath.toString();
        }

        Notepad note = new Notepad();
        note.setTitle(title);
        note.setNoteText(noteText);
        note.setAttachmentPath(filePathString);

        note.setOwnerId(user.getId());
        note.setOwnerRole(user.getRole());

        return noteRepository.save(note);
    }



    public List<Notepad> getMyNotes(String role, String domain, String email) {

    BaseUser user = baseUserService.findUserByDomainAndEmail(domain, email);

    if (!authentication.getAuthorities()
        .stream()
        .anyMatch(a -> a.getAuthority().equals("ROLE_" + role.toUpperCase()))) {
        throw new RuntimeException("Access Denied");
    }


    return noteRepository.findByOwnerIdAndOwnerRole(
            user.getId(),
            user.getRole()
    );
}


       

    // public List<Note> getStudentNotes(String email) {
    //     Student student = studentRepository.findByEmail(email)
    //             .orElseThrow(() -> new RuntimeException("Student not found"));

    //     return noteRepository.findByStudentId(student.getId());
    // }

    // public List<Note> getStudentNotes(String email) {
    //     Student student = studentRepository.findByEmail(email)
    //             .orElseThrow(() -> new RuntimeException("Student not found"));

    //     return noteRepository.findByStudentId(student.getId());
    // }

    // public List<Note> getStudentNotes(String email) {
    //     Student student = studentRepository.findByEmail(email)
    //             .orElseThrow(() -> new RuntimeException("Student not found"));

    //     return noteRepository.findByStudentId(student.getId());
    // }
}

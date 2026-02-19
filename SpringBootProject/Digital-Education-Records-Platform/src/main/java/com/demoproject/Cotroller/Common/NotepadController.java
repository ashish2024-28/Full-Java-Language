package com.demoproject.Cotroller.Common;

import java.io.IOException;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demoproject.Entity.ProfileInformation.Common.Notepad;
import com.demoproject.Service.ProfileInformation.Common.NotepadService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/{domain}/{role}/notes")

@RequiredArgsConstructor
public class NotepadController {

    private final NotepadService noteService;

    // @GetMapping
    // public String greet(){
    //     return "welcom to note....";
    // }
    @GetMapping
    public List<Notepad> getMyNotes(@PathVariable String domain, @PathVariable String role, Authentication authentication) {
        String email = authentication.getName();
        return noteService.getMyNotes(role, domain, email);
    }

    @PostMapping("/add")
    public Notepad addNote(@PathVariable String domain, @PathVariable String role,
            Authentication authentication,
            @RequestParam String title,
            @RequestParam String noteText,
            @RequestParam(required = false) MultipartFile file) throws IOException {
        // 👉 It returns email stored inside JWT.
        String email = authentication.getName();

        return noteService.addNote(role, domain, email, title, noteText, file);
    }

   
}



// 🧠 What is Authentication authentication?
// Spring Security automatically gives you the logged-in user.
// After login:
// JWT token is created
// Every request sends token
// Spring verifies token
// Spring puts user info inside Authentication
// So:
// authentication.getName();
// 👉 Returns logged-in user's email.
// Why use this?
// ❌ We do NOT trust frontend to send email
// ✅ We trust JWT token
// More secure.
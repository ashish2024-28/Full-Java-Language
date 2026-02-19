package com.demoproject.Entity.ProfileInformation.Common;

import com.demoproject.Entity.DomainAdmin;
import com.demoproject.Entity.Faculty;
import com.demoproject.Entity.Role;
import com.demoproject.Entity.Student;
import com.demoproject.Entity.SubAdmin;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "notepad")
public class Notepad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String noteText;

    private String attachmentPath;

    // 🔥 Generic Owner
    private Long ownerId; // ID of Student/Faculty/SubAdmin/DomainAdmin

    @Enumerated(EnumType.STRING)
    private Role ownerRole; // STUDENT / FACULTY / SUB_ADMIN / DOMAIN_ADMIN



    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "student_id")
    // @JsonIgnore
    // private Student student;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "faculty_id")
    // @JsonIgnore
    // private Faculty faculty;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "subAdmin_id")
    // @JsonIgnore
    // private SubAdmin subAdmin;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "domainAdmin_id")
    // @JsonIgnore
    // private DomainAdmin domainAdmin;

}

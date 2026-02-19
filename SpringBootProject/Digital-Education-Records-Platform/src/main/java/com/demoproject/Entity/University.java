package com.demoproject.Entity;


import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Table(
    name="universities",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "permanent_id"),
        @UniqueConstraint(columnNames = "domain"),
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "mobilenumber")
    }
)

@Data
public class University {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String domain;

    // aict Approval data
    @Column(nullable = false)
    private String permanentId;

    @Column(nullable = false)
    private String institutionName; // Name of the Institution (may be same)

    // UGC Approval data                               
    private String universityName; // Name of the University (may be same)

    // These fields for both 
    @Column(nullable = false)
    private String institutionType; //   (private ,State )

    @Column(nullable = false)
    private String establishmentYear;


    @Column(nullable = false)
    private String address; // Address same as Institution

    @Column(nullable = false)
    private String state;
    
    // university contact details
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String mobileNumber;

    @CreationTimestamp
    private LocalDateTime createdDateTime ; // date and time when create account

    // for this use configration extend WebMvcConfigurer
    // @Column(nullable = false)
    private String universityLogoPath; // Stores "alex_profile.png"



/* ================= RELATIONSHIPS ================= */
    //     ** Why mappedBy? **
    // DomainAdmin owns the relationship
    // University only reflects it
    // 1️⃣ University ↔ DomainAdmin (One-To-One)
    // cascade = CascadeType.ALL
    @OneToOne(mappedBy = "university", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    // @JsonManagedReference
    private DomainAdmin domainAdmin;

    // 2️⃣ University ↔ SubAdmin (One-To-Many)
    @OneToMany(mappedBy = "university", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    // @JsonManagedReference
    private List<SubAdmin> subAdmins;

    // 3️⃣ University ↔ Faculty (One-To-Many)
    @OneToMany(mappedBy = "university", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    // @JsonManagedReference
    private List<Faculty> facultyList;

    // 4️⃣ University ↔ Student (One-To-Many)
    @OneToMany(mappedBy = "university", cascade = {CascadeType.ALL, CascadeType.MERGE}, fetch = FetchType.LAZY)
    // @JsonManagedReference
    private List<Student> students;

}
// Student                  <- also for faculty, Subadmin and domainAdmin 
//  └── University
//       └── DomainAdmin
//            └── University
//                 └── DomainAdmin
//                      └── University
//                           └── ...
// This is infinite recursion during JSON serialization.
// University  <---->  DomainAdmin
// ✔ JPA is happy
// ❌ Jackson (JSON) is confused
// Jackson says:
// “University has DomainAdmin → DomainAdmin has University → University has DomainAdmin → LOOP 🔁”
// ✅ SOLUTION OPTIONS (CHOOSE ONE)
// ✅ OPTION 1 (BEST & MOST USED): @JsonManagedReference / @JsonBackReference
    // University (PARENT) =>    @JsonManagedReference
    // DomainAdmin (CHILD) =>    @JsonBackReference
// ✅ OPTION 2 (SIMPLE & CLEAN): @JsonIgnore (Most practical)
    // On CHILD side (recommended) =>   @JsonIgnore
// ✅ OPTION 3 (ADVANCED / PROFESSIONAL): DTOs (BEST PRACTICE)
    // Instead of returning Entities, return DTOs.
    // return StudentResponseDTO.builder()
    //     .id(student.getId())
    //     .name(student.getName())
    //     .email(student.getEmail())
    //     .universityName(student.getUniversity().getUniversityName())
    //     .domain(student.getUniversity().getDomain())
    //     .build();
// ✅ USE THIS COMBINATION
// | Layer  | What to do                      |
// | ------ | ------------------------------- |
// | Entity | `@JsonIgnore` on child → parent |
// | API    | Return DTOs                     |
// | DB     | Keep bidirectional mapping      |




// 🔐 IMPORTANT RULES (REMEMBER FOREVER)
// ✅ Use @ManyToOne on child
// ✅ Use mappedBy on parent
// ✅ Use CascadeType.ALL only where logical




    /*
 here first fill all university details And SecondAdmin (means DomainAdmin) details
  both details filled then submit and save both information in bd or create
  Admin's Details (who handle the owen university) --> DomainAdmin
  private String name;
  private Long mobNo;
  private String gmail;
  private String password; // For login purposes

*/



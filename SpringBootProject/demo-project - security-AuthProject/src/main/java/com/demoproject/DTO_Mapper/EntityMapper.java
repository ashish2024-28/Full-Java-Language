package com.demoproject.DTO_Mapper;

import com.demoproject.DTO.DTO_Response.DomainAdminResponseDTO;
import com.demoproject.DTO.DTO_Response.FacultyResponseDTO;
import com.demoproject.DTO.DTO_Response.StudentResponseDTO;
import com.demoproject.DTO.DTO_Response.SubAdminResponseDTO;
import com.demoproject.DTO.DTO_Response.UniversityResponseDTO;
import com.demoproject.Entity.DomainAdmin;
import com.demoproject.Entity.Faculty;
import com.demoproject.Entity.Student;
import com.demoproject.Entity.SubAdmin;
import com.demoproject.Entity.University;

public class EntityMapper {

    /* ================= STUDENT ================= */
    public static StudentResponseDTO toStudentDTO(Student s) {
        if (s == null) return null;

        StudentResponseDTO dto = new StudentResponseDTO();
        dto.setRollNumber(s.getRollNumber());
        dto.setName(s.getName());
        dto.setCourse(s.getCourse());
        dto.setBranch(s.getBranch());
        dto.setBatch(s.getBatch());
        dto.setEmail(s.getEmail());
        dto.setMobileNumber(s.getMobileNumber());
        dto.setFatherName(s.getFatherName());
        dto.setFatherMobNo(s.getFatherMobNo());

        // 👇 University reference only
        dto.setUniversityName(s.getUniversity().getInstitutionName());

        return dto;
    }

    /* ================= FACULTY ================= */
    public static FacultyResponseDTO toFacultyDTO(Faculty f) {
        if (f == null) return null;

        FacultyResponseDTO dto = new FacultyResponseDTO();
        dto.setFacultyId(f.getFacultyId());
        dto.setName(f.getName());
        dto.setCourse(f.getCourse());
        dto.setTeachingBatch(f.getTeachingBatch());
        dto.setEmail(f.getEmail());
        dto.setMobileNumber(f.getMobileNumber());

        // 👇 University reference only
        dto.setUniversityName(f.getUniversity().getInstitutionName());

        return dto;
    }

    /* ================= DOMAIN ADMIN ================= */
    public static DomainAdminResponseDTO toDomainAdminDTO(DomainAdmin d) {
        if (d == null) return null;

        DomainAdminResponseDTO dto = new DomainAdminResponseDTO();
        dto.setId(d.getId());
        dto.setName(d.getName());
        dto.setEmail(d.getEmail());
        dto.setMobileNumber(d.getMobileNumber());
        dto.setDomain(d.getDomain());

        // 👇 University reference only
        dto.setUniversityName(d.getUniversity().getInstitutionName());

        return dto;
    }

    /* ================= SUB ADMIN ================= */
    public static SubAdminResponseDTO toSubAdminDTO(SubAdmin s) {
        if (s == null) return null;

        SubAdminResponseDTO dto = new SubAdminResponseDTO();
        dto.setSubAdminId(s.getSubAdminId());
        dto.setName(s.getName());
        dto.setCourse(s.getCourse());
        dto.setEmail(s.getEmail());
        dto.setMobileNumber(s.getMobileNumber());

        // 👇 University reference only
        dto.setUniversityName(s.getUniversity().getInstitutionName());

        return dto;
    }

    /* ================= UNIVERSITY ================= */
    public static UniversityResponseDTO toUniversityDTO(University u) {
        if (u == null) return null;

        UniversityResponseDTO dto = new UniversityResponseDTO();
        dto.setId(u.getId());
        dto.setDomain(u.getDomain());
        dto.setInstitutionName(u.getInstitutionName());
        dto.setUniversityName(u.getUniversityName());
        dto.setInstitutionType(u.getInstitutionType());
        dto.setEstablishmentYear(u.getEstablishmentYear());
        dto.setState(u.getState());
        dto.setEmail(u.getEmail());
        dto.setMobileNumber(u.getMobileNumber());
        return dto;
    }
}


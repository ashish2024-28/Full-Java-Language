package com.demoproject.Repository.ProfileInformation.Common;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demoproject.Entity.Role;
import com.demoproject.Entity.ProfileInformation.Common.Notepad;

@Repository
public interface NotepadRepository extends JpaRepository<Notepad, Long>{

    // List<Note> findByStudentId(Long id);

    // List<Note> findByFacultyId(Long id);

    // List<Note> findBySubAdminId(Long id);

    // List<Note> findByDomainAdminId(Long id);

    List<Notepad> findByOwnerIdAndOwnerRole(Long ownerId, Role ownerRole);


}
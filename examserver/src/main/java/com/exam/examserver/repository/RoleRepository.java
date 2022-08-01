package com.exam.examserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.examserver.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}

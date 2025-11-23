package com.hospital.authentication_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.authentication_service.Entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User,Long>{

}

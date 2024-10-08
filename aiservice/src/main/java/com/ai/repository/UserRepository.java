package com.ai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ai.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long>{

	Users findByMobile(Long mobile);

}

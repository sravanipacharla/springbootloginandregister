package com.crud.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crud.example.entity.User;

@Repository
public interface UserRepository extends JpaRepository <User,Long> {

	@Query("SELECT u FROM User u WHERE u.userName = :username")
	User findByUsername (String username);

}

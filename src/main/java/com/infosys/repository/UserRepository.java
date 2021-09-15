package com.infosys.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.entity.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, String>
{

	Optional<UserDetails> findByUserIdAndPassword(String userId, String password);
}

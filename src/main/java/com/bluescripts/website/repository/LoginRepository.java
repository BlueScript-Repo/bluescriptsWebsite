package com.bluescripts.website.repository;

import java.util.Optional;

import com.bluescripts.website.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, String> {

	Optional<Login> findByUserName(String userName);

	Optional<Login> findByEmail(String email);

	//List<Login> findLoginByUserRole(String role);
}

package io.dave.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import io.dave.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

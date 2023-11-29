package com.sportlines.Sportlinez.repository;

import com.sportlines.Sportlinez.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

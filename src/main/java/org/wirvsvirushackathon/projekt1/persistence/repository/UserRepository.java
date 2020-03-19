package org.wirvsvirushackathon.projekt1.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wirvsvirushackathon.projekt1.persistence.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);
}

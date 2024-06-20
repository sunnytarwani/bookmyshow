package com.suunnytarwanni.BookMyShow.Repository;

import com.suunnytarwanni.BookMyShow.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findById(Long id);
    User findUserByEmail(String email);

    User save(User user);
}

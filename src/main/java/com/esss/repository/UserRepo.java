package com.esss.repository;

import com.esss.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

    @Query("SELECT user FROM User user WHERE user.email = ?1")
    User getUserByEmail(String email);

    @Query("SELECT user FROM User user WHERE user.role.name = ?1 ")
    List<User> getUsersByRole(String role);
}

package com.example.usersubscriptionsapi.repositories;

import com.example.usersubscriptionsapi.models.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

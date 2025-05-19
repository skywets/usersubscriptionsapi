package com.example.usersubscriptionsapi.repositories;

import com.example.usersubscriptionsapi.models.entites.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    @Query("SELECT s FROM Subscription s WHERE s.user.id = :user_id")
    List<Subscription> findAllByUserId(@Param("user_id") long id);

    @Query("SELECT s FROM Subscription s ORDER BY s.popularity DESC limit 3")
    List<Subscription> findTopSubscriptions();
}

package com.example.usersubscriptionsapi.services;

import com.example.usersubscriptionsapi.models.dtos.SubscriptionDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubscriptionService {
    void create(SubscriptionDto subscriptionDto, Long id);

    void delete(Long id);

    List<SubscriptionDto> findAllByUserId(Long id);

    List<SubscriptionDto> findTopThreeSubscriptions();
}

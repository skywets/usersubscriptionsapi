package com.example.usersubscriptionsapi.models.mapper;

import com.example.usersubscriptionsapi.models.dtos.SubscriptionDto;
import com.example.usersubscriptionsapi.models.dtos.UserDto;
import com.example.usersubscriptionsapi.models.entites.Subscription;
import com.example.usersubscriptionsapi.models.entites.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class SubscriptionImplMapper implements MapperDto<SubscriptionDto, Subscription, SubscriptionDto> {

    private MapperDto<UserDto, User, UserDto> mapperDto;

    @Override
    public SubscriptionDto mapToDto(Subscription entity) {
        SubscriptionDto subscriptionDto = new SubscriptionDto();
        subscriptionDto.setId(entity.getId());
        subscriptionDto.setName(entity.getName());
        subscriptionDto.setDescription(entity.getDescription());
        subscriptionDto.setPopularity(entity.getPopularity());
        return subscriptionDto;
    }

    @Override
    public Subscription mapToEntity(SubscriptionDto dto) {
        Subscription subscription = new Subscription();
        subscription.setId(dto.getId());
        subscription.setName(dto.getName());
        subscription.setDescription(dto.getDescription());
        subscription.setPopularity(dto.getPopularity());
        return subscription;
    }

    @Override
    public List<SubscriptionDto> maptoDto(Iterable<Subscription> entities) {
        List<SubscriptionDto> subscriptionDtos = new ArrayList<>();
        for (Subscription subscription : entities) {
            subscriptionDtos.add(mapToDto(subscription));
        }
        return subscriptionDtos;
    }

    @Override
    public List<Subscription> mapToEntity(Iterable<SubscriptionDto> dtos) {
        List<Subscription> subscriptions = new ArrayList<>();
        for (SubscriptionDto subscriptionDto : dtos) {
            subscriptions.add(mapToEntity(subscriptionDto));
        }
        return subscriptions;
    }
}

package com.example.usersubscriptionsapi.services.servicesImpl;

import com.example.usersubscriptionsapi.exceptions.NotFoundException;
import com.example.usersubscriptionsapi.models.dtos.SubscriptionDto;
import com.example.usersubscriptionsapi.models.entites.Subscription;
import com.example.usersubscriptionsapi.models.entites.User;
import com.example.usersubscriptionsapi.models.mapper.MapperDto;
import com.example.usersubscriptionsapi.repositories.SubscriptionRepository;
import com.example.usersubscriptionsapi.repositories.UserRepository;
import com.example.usersubscriptionsapi.services.SubscriptionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("subscriptionService")
@AllArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private SubscriptionRepository subscriptionRepository;
    private UserRepository userRepository;
    private MapperDto<SubscriptionDto, Subscription, SubscriptionDto> mapperDto;

    @Transactional
    @Override
    public void create(SubscriptionDto subscriptionDto, Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            throw new NotFoundException("The User does not exist");
        }
        User user = optionalUser.get();
        Subscription subscription = new Subscription();
        subscription.setName(subscriptionDto.getName());
        subscription.setDescription(subscriptionDto.getDescription());
        subscription.setPopularity(subscriptionDto.getPopularity());
        subscription.setUser(user);
        subscriptionRepository.save(subscription);
    }

    @Override
    public void delete(Long id) {
        subscriptionRepository.deleteById(id);
    }

    @Override
    public List<SubscriptionDto> findAllByUserId(Long id) {
        return mapperDto.maptoDto(subscriptionRepository.findAllByUserId(id));
    }

    @Override
    public List<SubscriptionDto> findTopThreeSubscriptions() {
        return mapperDto.maptoDto(subscriptionRepository.findTopSubscriptions());
    }
}

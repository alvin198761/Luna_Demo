package org.alvin.webflux.service;

import org.alvin.webflux.domain.User;
import org.alvin.webflux.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Administrator on 2017/8/16.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Flux<User> findAll() {
        return Flux.fromIterable(userRepository.findAll());
    }

    public Mono<User> findById(Long id) {
        return Mono.just(userRepository.findById(id));
    }
}

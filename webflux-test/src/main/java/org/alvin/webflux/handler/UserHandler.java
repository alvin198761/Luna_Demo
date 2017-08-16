package org.alvin.webflux.handler;

import org.alvin.webflux.domain.User;
import org.alvin.webflux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * Created by Administrator on 2017/8/16.
 */
@Component
public class UserHandler {

    @Autowired
    private UserService userService;

    public Mono<ServerResponse> fetchAll(ServerRequest request) {
        return ServerResponse.ok().body(this.userService.findAll(), User.class);
    }

    public Mono<ServerResponse> fetchById(ServerRequest request) {
        return ServerResponse.ok().body(this.userService.findById(Long.valueOf(request.pathVariable("id"))), User.class).switchIfEmpty(ServerResponse.notFound().build());
    }

}

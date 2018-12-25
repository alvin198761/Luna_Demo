package org.alvin.home.data.user;

import org.reactivestreams.Publisher;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserBus {
	public Mono<Integer> save(Publisher<UserBean> user) {
		return null;
	}
}

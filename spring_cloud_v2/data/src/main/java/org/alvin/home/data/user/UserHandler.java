package org.alvin.home.data.user;

import org.apache.catalina.User;
import org.reactivestreams.Publisher;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 模拟的用户请求处理类
 */
@RestController
@RequestMapping("/api/user")
public class UserHandler {

	private UserBus bus;

	@PostMapping("/save")
	public Mono<ServerResponse> save(ServerRequest request) {
		request.bodyToMono(UserBean.class).map(item -> new User);
//		return ServerResponse.ok().body(bus.save(user), Integer.TYPE);
		return null;
	}

	@GetMapping("/queryList")
	public Flux<ServerResponse> list() {
//		return this.repository.findAll();
		return null;
	}

	@GetMapping("/findById/{id}")
	public Mono<UserBean> findById(@PathVariable String id) {
//		return this.repository.findOne(id);
		return null;
	}

	@PostMapping("/update")
	public Mono<Integer> update(@RequestBody Publisher<UserBean> user) {
		return null;
	}

	@DeleteMapping("delete/{id}")
	public Mono<Integer> delete(@PathVariable("id") Long id) {
		return null;
	}

}

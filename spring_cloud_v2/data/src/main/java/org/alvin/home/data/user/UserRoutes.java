package org.alvin.home.data.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@SpringBootConfiguration
public class UserRoutes {


	@Bean
	@Autowired
	public RouterFunction<ServerResponse> userRoutes(UserHandler userHandler) {
		return RouterFunctions.route(
				RequestPredicates.POST("/api/user/save")
						.and(RequestPredicates.accept(MediaType.ALL))
				, userHandler::save);
	}
}

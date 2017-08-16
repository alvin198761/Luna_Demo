package org.alvin.webflux.handler;

import org.alvin.webflux.domain.User;
import org.alvin.webflux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.http.codec.multipart.Part;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/16.
 */
@Component
public class UserHandler {

    @Autowired
    private UserService userService;
    //数据查询
    public Mono<ServerResponse> fetchAll(ServerRequest request) {
        return ServerResponse.ok().body(this.userService.findAll(), User.class);
    }

    public Mono<ServerResponse> fetchById(ServerRequest request) {
        return ServerResponse.ok().body(this.userService.findById(Long.valueOf(request.pathVariable("id"))), User.class).switchIfEmpty(ServerResponse.notFound().build());
    }
    //图片显示
    public Mono<ServerResponse> imgs(ServerRequest request) {
        try {
            return ServerResponse.ok().contentType(MediaType.parseMediaType("image/jpeg")).body(Mono.just(Files.readAllBytes(Paths.get("E://t.jpg"))), byte[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    //文件上传
    public Mono<ServerResponse> upload(ServerRequest serverRequest) {
        serverRequest.body(BodyExtractors.toMultipartData()).flatMap(parts -> {
            Map<String, Part> map = parts.toSingleValueMap();
            FilePart part = ((FilePart) map.get("file"));
            part.transferTo(Paths.get("E:", "upload", part.filename()).toFile());
            return ServerResponse.ok().body(Mono.empty(), Void.class);
        });
        return ServerResponse.ok().body(Mono.empty(), Void.class);
    }
}

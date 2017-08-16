package org.alvin.webflux.repository;

import org.alvin.webflux.domain.User;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.MonoSink;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Administrator on 2017/8/16.
 */
@Repository
public class UserRepository {

    private List<User> users = new ArrayList<>();

    public UserRepository() {
        initDefaults();
    }

    private void initDefaults() {
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId((long) i);
            user.setEnabled(true);
            user.setName("name" + i);
            user.setPassword("password" + i);
            this.users.add(user);
        }
    }

    public List<User> findAll() {
        return this.users;
    }

    public User findById(Long id) {
        return this.users.stream().filter(user -> user.getId() == id).findFirst().get();
    }
}

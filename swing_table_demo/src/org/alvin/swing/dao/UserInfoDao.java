/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alvin.swing.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.alvin.swing.bean.UserInfo;

/**
 *
 * @author Administrator
 *
 * 模拟数据库操作
 */
public class UserInfoDao {

    private List<UserInfo> userList = new ArrayList<>();

    private static Long id = 0L;

    public UserInfoDao() {
        //模拟原始数据
        for (long i = 0; i < 10; i++) {
            UserInfo user = new UserInfo();
            user.setId(i);
            user.setName("name_" + i);
            user.setPassword("password_" + i);
            user.setEnabled(i % 3 == 0);
            this.add(user);
        }
    }

    public UserInfo add(UserInfo user) {
        user.setId(id++);
        this.userList.add(user);
        return user;
    }

    public UserInfo del(Long id) {
        UserInfo user = this.find(id);
        if (user != null) {
            this.userList.remove(user);
        }
        return user;
    }

    public UserInfo find(Long id) {
        return this.userList.stream().filter(user -> user.getId() == id).findFirst().get();
    }

    public List<UserInfo> findAll() {
        return this.userList;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alvin.swing.service;

import java.util.List;
import org.alvin.swing.bean.UserInfo;
import org.alvin.swing.dao.UserInfoDao;

/**
 *
 * @author Administrator 模拟业务逻辑
 */
public class UserInfoService implements IUserService{

    private UserInfoDao userInfoDao = new UserInfoDao();

    public void add(UserInfo user) {
        this.userInfoDao.add(user);
    }

    public void del(Long id) {
        this.userInfoDao.del(id);
    }

    public UserInfo find(Long id) {
        return this.userInfoDao.find(id);
    }

    public List<UserInfo> findAll() {
        return this.userInfoDao.findAll();
    }

}

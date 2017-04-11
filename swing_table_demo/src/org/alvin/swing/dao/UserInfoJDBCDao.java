/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alvin.swing.dao;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.alvin.swing.bean.UserInfo;

/**
 *
 * @author tangzhichao
 */
public class UserInfoJDBCDao {

    public UserInfo add(UserInfo user) throws SQLException {
        String sql = "insert into userinfo (id,name,password,enabled) values(?,?,?,?)";
        ConnectUtils.getInstance().execute(sql, new Object[]{
            user.getId(),
            user.getName(),
            user.getPassword(),
            user.getEnabled()
        });
        return user;
    }

    public int del(Long id) throws SQLException {
        String sql = "delete from userinfo where id=?";
        return ConnectUtils.getInstance().execute(sql, new Object[]{id});
    }

    public UserInfo find(Long id) throws SQLException {
        String sql = "select id,name,password,enabled from userinfo where id=?";
        Map<String, Object> res = ConnectUtils.getInstance().queryObj(sql, new Object[]{id});
        UserInfo user = new UserInfo();
        user.setId((Long) res.get("id"));
        user.setName((String) res.get("name"));
        user.setPassword((String) res.get("password"));
        user.setEnabled((Boolean) res.get("enabled"));
        return user;
    }

    public List<UserInfo> findAll() throws SQLException {
        String sql = "select id,name,password,enabled from userinfo";
        List<Map<String, Object>> list = ConnectUtils.getInstance().queryList(sql, null);
        return list.stream().map(res -> {
            UserInfo user = new UserInfo();
            user.setId((Long) res.get("id"));
            user.setName((String) res.get("name"));
            user.setPassword((String) res.get("password"));
            user.setEnabled((Boolean) res.get("enabled"));
            return user;
        }).collect(Collectors.toList());
    }

}

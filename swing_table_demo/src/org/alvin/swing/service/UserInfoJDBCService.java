/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alvin.swing.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.alvin.swing.bean.UserInfo;
import org.alvin.swing.dao.UserInfoJDBCDao;

/**
 * jdbc 业务逻辑
 * @author tangzhichao
 */
public class UserInfoJDBCService implements IUserService{
     private UserInfoJDBCDao userInfoDao = new UserInfoJDBCDao();

    public void add(UserInfo user) {
         try {
             this.userInfoDao.add(user);
         } catch (SQLException ex) {
             Logger.getLogger(UserInfoJDBCService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    public void del(Long id) {
         try {
             this.userInfoDao.del(id);
         } catch (SQLException ex) {
             Logger.getLogger(UserInfoJDBCService.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    public UserInfo find(Long id) {
         try {
             return this.userInfoDao.find(id);
         } catch (SQLException ex) {
             Logger.getLogger(UserInfoJDBCService.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
    }

    public List<UserInfo> findAll() {
         try {
             return this.userInfoDao.findAll();
         } catch (SQLException ex) {
             Logger.getLogger(UserInfoJDBCService.class.getName()).log(Level.SEVERE, null, ex);
         }
         return new ArrayList<>();
    }
}

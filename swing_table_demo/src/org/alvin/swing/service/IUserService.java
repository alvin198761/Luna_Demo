/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alvin.swing.service;

import java.util.List;
import org.alvin.swing.bean.UserInfo;

/**
 *
 * @author tangzhichao
 */
public interface IUserService {

    public void add(UserInfo user);

    public void del(Long id);

    public UserInfo find(Long id);

    public List<UserInfo> findAll();
}

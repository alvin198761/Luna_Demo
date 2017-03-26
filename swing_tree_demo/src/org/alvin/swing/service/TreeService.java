/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alvin.swing.service;

import java.util.List;
import org.alvin.swing.bean.TreeNode;
import org.alvin.swing.dao.TreeDao;

/**
 *
 * @author Administrator
 */
public class TreeService {
    
    private static final TreeService instance = new TreeService();

    private TreeService() {
    }
    
    public static TreeService getInstance(){
        return instance;
    }
    
    public TreeDao treeDao = new TreeDao();
    
    public List<TreeNode> getChildrenNodes(){
        return this.treeDao.getChildNode();
    }
    
    public List<TreeNode> getLeafNodes(){
        return this.treeDao.getLeafNode();
    }
    
}

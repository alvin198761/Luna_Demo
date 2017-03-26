/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alvin.swing.dao;

import java.util.ArrayList;
import java.util.List;
import org.alvin.swing.bean.ChildNode;
import org.alvin.swing.bean.LeafNode;
import org.alvin.swing.bean.TreeNode;

/**
 *
 * @author Administrator
 */
public class TreeDao {
    
    public List<TreeNode> getChildNode(){
        List<TreeNode> list = new ArrayList<>();
        int size =(int)( Math.random() *10);
        for(int i = 0 ;i < size ;i++){
            ChildNode childNode = new ChildNode("title-子节点-"+i);
            list.add(childNode);
        }
        return list;
    }
    
    public List<TreeNode> getLeafNode(){
       List<TreeNode> list = new ArrayList<>();
        int size =(int)( Math.random() *10);
        for(int i = 0 ;i < size ;i++){
            LeafNode childNode = new LeafNode("title-叶节点-"+i);
            list.add(childNode);
        }
        return list;
    }
    
}

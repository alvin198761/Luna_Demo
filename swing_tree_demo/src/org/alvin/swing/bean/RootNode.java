/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alvin.swing.bean;

import java.util.ArrayList;
import java.util.List;
import org.alvin.swing.service.TreeService;

/**
 *
 * @author Administrator
 */
public class RootNode implements TreeNode{
    
    private TreeService treeService = TreeService.getInstance() ;
    
    private List<TreeNode> children;

    public RootNode() {
        this.children = this.treeService.getChildrenNodes();
    }

    @Override
    public List<TreeNode> children() {
        return children;
    }

    @Override
    public String toString() {
        return "根节点";
    }
    
}

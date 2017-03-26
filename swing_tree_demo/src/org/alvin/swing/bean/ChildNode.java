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
public class ChildNode implements TreeNode {

    private TreeService treeService = TreeService.getInstance();
    private List<TreeNode> children  ;
    private String title;

    public ChildNode(String title) {
        this.title = title;
        this.children = this.treeService.getLeafNodes();
    }

    @Override
    public List<TreeNode> children() {
        return children;
    }

    @Override
    public String toString() {
        return title;
    }

}

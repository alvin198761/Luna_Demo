/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alvin.swing.bean;

import java.util.List;

/**
 *
 * @author Administrator
 */
public class LeafNode implements TreeNode {

    private String title;

    public LeafNode(String title) {
        this.title = title;
    }

    @Override
    public List<TreeNode> children() {
        return null;
    }

    @Override
    public String toString() {
        return this.title;
    }

}

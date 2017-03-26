/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alvin.swing.ui.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.alvin.swing.bean.UserInfo;
import org.alvin.swing.service.UserInfoService;

/**
 *
 * @author Administrator jtable 显示数据 模型
 */
public class UserInfoModel extends AbstractTableModel {

    public UserInfoService userInfoService = new UserInfoService();

    private List<UserInfo> content;

    private String[] columns = {"编号", "名称", "密码", "启用/禁用"};

    public UserInfoModel() {
        this.refresh();
    }

    @Override
    public int getRowCount() {
        return this.content.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        UserInfo user = this.content.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return user.getId();
            case 1:
                return user.getName();
            case 2:
                return user.getPassword();
            case 3:
                return user.getEnabled();
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex != 0;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 3) {
            return Boolean.class;
        }
        return super.getColumnClass(columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return this.columns[column];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        UserInfo user = this.content.get(rowIndex);
        switch (columnIndex) {
            case 1:
                user.setName((String) aValue);
                break;
            case 2:
                user.setPassword((String) aValue);
                break;
            case 3:
                user.setEnabled((Boolean) aValue);
                break;
        }
    }

    public void addBlankRow() {
        this.userInfoService.add(new UserInfo());
        this.refresh();
    }

    public void delRow(int row) {
        UserInfo user = this.content.get(row);
        this.userInfoService.del(user.getId());
        this.refresh();
    }

    private void refresh() {
        this.content = this.userInfoService.findAll();
        this.fireTableDataChanged();
    }

}

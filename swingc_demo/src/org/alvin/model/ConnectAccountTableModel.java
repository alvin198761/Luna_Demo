/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alvin.model;

import javax.swing.table.AbstractTableModel;

/**
 * 连接管理器的table model
 *
 * @author zctang 2014-12-25
 */
public class ConnectAccountTableModel extends AbstractTableModel {

    private String[] columns = new String[]{"Name", "Type", "Address", "Status"};

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return this.columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        return null;
    }

}

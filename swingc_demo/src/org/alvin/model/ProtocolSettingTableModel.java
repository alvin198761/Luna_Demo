/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alvin.model;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author zctang 2015-10-17
 */
public class ProtocolSettingTableModel extends AbstractTableModel {

    private String[] columns = new String[]{"Protocol", "Remark"};

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

}

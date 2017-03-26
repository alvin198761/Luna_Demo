/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alvin.swing.ui.action;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JTable;
import org.alvin.swing.ui.model.UserInfoModel;

/**
 *
 * @author Administrator
 */
public class DeleteAction extends AbstractAction {

    private JTable table;

    public DeleteAction(JTable table) {
        this.putValue(NAME, "删除");
        this.table = table;
        this.table.getSelectionModel().addListSelectionListener(e -> {
            if (e.getValueIsAdjusting()) {
                return;
            }
            DeleteAction.this.firePropertyChange("enabled", true, false);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        UserInfoModel userModel = (UserInfoModel) this.table.getModel();
        int row = this.table.getSelectedRow();
        row = this.table.convertRowIndexToModel(row);
        userModel.delRow(row);
    }

    @Override
    public boolean isEnabled() {
        return this.table.getSelectedRow() != -1;
    }

}

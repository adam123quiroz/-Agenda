package com.company;

import javax.swing.table.DefaultTableModel;

public class ModelTable extends DefaultTableModel {
    Class[] types = new Class [] {
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class
    };
    boolean[] canEdit = new boolean [] {
            true, true, true, true, true
    };
    ModelTable(String[] nameColumns){
        super(null, nameColumns);
    }
    @Override
    public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
    }
    @Override
    public boolean isCellEditable(int rowIndex, int colIndex){
        return canEdit [colIndex];
    }
}

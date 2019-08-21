package com.company;

import javax.swing.table.DefaultTableModel;

public class ActualizarTabla {
    private DefaultTableModel modelo;
    private Contacto contacto;
    private int i;

    ActualizarTabla(DefaultTableModel modelo, Contacto contacto, int i) {
        this.modelo = modelo;
        this.contacto = contacto;
        this.i = i;
    }

    public DefaultTableModel update(){
        modelo.addRow((Object[]) null);
        modelo.setValueAt(contacto.getName(), i, 0);
        modelo.setValueAt(contacto.getApellido(), i, 1);
        modelo.setValueAt(contacto.getAdress(), i, 2);
        modelo.setValueAt(contacto.getEmail(), i, 3);
        modelo.setValueAt(contacto.getNumber(), i, 4);
        return modelo;
    }
}

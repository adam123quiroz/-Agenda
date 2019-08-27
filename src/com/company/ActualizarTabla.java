package com.company;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ActualizarTabla {
    private DefaultTableModel model;
    private List<Contact> listContacts;

    ActualizarTabla(List listContacts) {
        this.listContacts = listContacts;
        model = new ModelTable(new String[]{"CI", "Nombre", "Apellido",
                "Dirección", "Correo", "Número de Celular"});
    }

    public DefaultTableModel update(){

        model = new ModelTable(new String[]{"CI", "Nombre", "Apellido",
                "Dirección", "Correo", "Número de Celular"});
        
        for (int i = 0; i < listContacts.size() ; i++) {
            model.addRow((Object[]) null);
            model.setValueAt(listContacts.get(i).getId(), i, 0);
            model.setValueAt(listContacts.get(i).getName(), i, 1);
            model.setValueAt(listContacts.get(i).getSurname(), i, 2);
            model.setValueAt(listContacts.get(i).getAddress(), i, 3);
            model.setValueAt(listContacts.get(i).getEmail(), i, 4);
            model.setValueAt(listContacts.get(i).getNumber(), i, 5);
        }

        return model;
    }

	public List<Contact> getListContacts() {
		return listContacts;
	}

	public void setListContacts(List<Contact> listContacts) {
		this.listContacts = listContacts;
	}
    
}

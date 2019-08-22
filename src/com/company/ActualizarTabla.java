package com.company;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ActualizarTabla {
    private DefaultTableModel modelo;
    private List<Contacto> listContacto;

    ActualizarTabla(List listContacto) {
        this.listContacto = listContacto;
        modelo = new ModelTable(new String[]{"CI", "Nombre", "Apellido",
                "Dirección", "Correo", "Número de Celular"});
    }

    public DefaultTableModel update(){
        
        for (int i = 0; i < listContacto.size() ; i++) {
            modelo.addRow((Object[]) null);
            modelo.setValueAt(listContacto.get(i).getId(), i, 0);
            modelo.setValueAt(listContacto.get(i).getName(), i, 1);
            modelo.setValueAt(listContacto.get(i).getApellido(), i, 2);
            modelo.setValueAt(listContacto.get(i).getAdress(), i, 3);
            modelo.setValueAt(listContacto.get(i).getEmail(), i, 4);
            modelo.setValueAt(listContacto.get(i).getNumber(), i, 5);
        }

        return modelo;
    }

	public List<Contacto> getListContacto() {
		return listContacto;
	}

	public void setListContacto(List<Contacto> listContacto) {
		this.listContacto = listContacto;
	}
    
}

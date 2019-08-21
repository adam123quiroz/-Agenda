package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class FrameContacto extends JFrame{
    private JPanel contentPane;
    private JTextField textFieldName;
    private JTextField textFieldApellido;
    private JTextField textFieldEmail;
    private JTextField textFieldAdress;
    private JTextField textFieldNumber;
    private JButton aniadirButton;
    private JButton resetearButton;
    private JButton eliminarButton;
    private JTable tableContactos;

    private List<Contacto> listaContactos;
    private DefaultTableModel modelo;

    private int rowSelected;

    FrameContacto() throws HeadlessException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setContentPane(contentPane);

        listaContactos = new LinkedList<>();
        String[] nameColums = new String [] {
                "Nombre", "Apellido",
                "Dirección", "Correo", "Número de Celular"};
        modelo = new ModelTable(nameColums);
        tableContactos.setModel(modelo);
        actualizarContacto();

        aniadirButton.addActionListener(actionEvent -> {
            Contacto aux = new Contacto(
                    textFieldName.getText(),
                    textFieldApellido.getText(),
                    textFieldEmail.getText(),
                    textFieldAdress.getText(),
                    Integer.parseInt(textFieldNumber.getText())
            );
            actualizarContacto(aux);
            resetearSeldas();
        });
        resetearButton.addActionListener(actionEvent -> resetearSeldas());
        eliminarButton.addActionListener(actionEvent -> {
            listaContactos.remove(rowSelected);
            modelo.removeRow(rowSelected);
            tableContactos.setModel(modelo);
        });
        tableContactos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int row = tableContactos.rowAtPoint(e.getPoint());
                int column = tableContactos.columnAtPoint(e.getPoint());
                if (row >= 0 && column >= 0) {
                    rowSelected = row;
                }
            }
        });
    }//end constructor class

    private void actualizarContacto() {
        for (int i = 0; i < listaContactos.size(); i++) {
            modelo.addRow((Object[]) null);
            Contacto getP = listaContactos.get(i);
            modelo.setValueAt(getP.getName(), i, 0);
            modelo.setValueAt(getP.getApellido(), i, 1);
            modelo.setValueAt(getP.getAdress(), i, 2);
            modelo.setValueAt(getP.getEmail(), i, 3);
            modelo.setValueAt(getP.getNumber(), i, 4);
        }
        tableContactos.setModel(modelo);
    }

    private void actualizarContacto(Contacto contacto) {
        System.out.println("numero de la lista "+listaContactos.size());
        listaContactos.add(contacto);
        int i = listaContactos.size() - 1;
        modelo.addRow((Object[]) null);
        Contacto getP = listaContactos.get(i);
        modelo.setValueAt(getP.getName(), i, 0);
        modelo.setValueAt(getP.getApellido(), i, 1);
        modelo.setValueAt(getP.getAdress(), i, 2);
        modelo.setValueAt(getP.getEmail(), i, 3);
        modelo.setValueAt(getP.getNumber(), i, 4);
        tableContactos.setModel(modelo);
    }
    private void resetearSeldas(){
        textFieldAdress.setText(null);
        textFieldApellido.setText(null);
        textFieldEmail.setText(null);
        textFieldName.setText(null);
        textFieldNumber.setText(null);
    }
}
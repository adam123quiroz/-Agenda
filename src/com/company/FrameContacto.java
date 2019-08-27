package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;

public class FrameContacto extends JFrame{
    private JPanel contentPane;
    private JTextField textFieldName;
    private JTextField textFieldSurname;
    private JTextField textFieldEmail;
    private JTextField textFieldAddress;
    private JTextField textFieldNumber;
    private JButton aniadirButton;
    private JButton resetearButton;
    private JButton eliminarButton;
    private JTable tableContacts;
    private JTextField textFieldCi;


    private List<Contact> listaContactos;
    private DefaultTableModel modelo;

    private int rowSelected;
    private ActualizarTabla actualizarTabla;

    private DataBaseContacto dataBaseContacto;

    FrameContacto() throws HeadlessException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setContentPane(contentPane);

        listaContactos = new LinkedList<>();
        dataBaseContacto = new DataBaseContacto();

        listaContactos = dataBaseContacto.getAllContacts();
        actualizarTabla = new ActualizarTabla(listaContactos);
        modelo = actualizarTabla.update();
        tableContacts.setModel(modelo);

        aniadirButton.addActionListener(actionEvent -> {
            Contact aux = new Contact(
                    textFieldCi.getText(),
                    textFieldName.getText(),
                    textFieldSurname.getText(),
                    textFieldEmail.getText(),
                    textFieldAddress.getText(),
                    Integer.parseInt(textFieldNumber.getText())
            );
            dataBaseContacto.setContanct(aux);
            actualizarContacto();
            resetearSeldas();
        });

        resetearButton.addActionListener(actionEvent -> resetearSeldas());

        eliminarButton.addActionListener(actionEvent -> {
            listaContactos.remove(rowSelected);
            modelo.removeRow(rowSelected);
            tableContacts.setModel(modelo);
        });
        tableContacts.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tableContacts.rowAtPoint(e.getPoint());
                int column = tableContacts.columnAtPoint(e.getPoint());
                if (row >= 0 && column >= 0) {
                    rowSelected = row;
                }
            }
        });
    }//end constructor class

    private void actualizarContacto() {
        listaContactos = dataBaseContacto.getAllContacts();
        System.out.println(listaContactos.toString());
        actualizarTabla.setListContacts(listaContactos);
        tableContacts.setModel(actualizarTabla.update());
    }

    private void resetearSeldas() {
        textFieldCi.setText(null);
        textFieldAddress.setText(null);
        textFieldSurname.setText(null);
        textFieldEmail.setText(null);
        textFieldName.setText(null);
        textFieldNumber.setText(null);
    }
}
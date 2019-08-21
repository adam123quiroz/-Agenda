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
    private ActualizarTabla actualizarTabla;

    FrameContacto() throws HeadlessException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setContentPane(contentPane);

        modelo = new ModelTable(new String[]{"Nombre", "Apellido",
                "Dirección", "Correo", "Número de Celular"});

        listaContactos = new LinkedList<>();
        tableContactos.setModel(modelo);

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
        tableContactos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tableContactos.rowAtPoint(e.getPoint());
                int column = tableContactos.columnAtPoint(e.getPoint());
                if (row >= 0 && column >= 0) {
                    rowSelected = row;
                }
            }
        });
    }//end constructor class

    private void actualizarContacto(Contacto contacto) {
        listaContactos.add(contacto);
        int i = listaContactos.size() - 1;
        Contacto getP = listaContactos.get(i);
        actualizarTabla = new ActualizarTabla(modelo, getP, i);
        tableContactos.setModel(actualizarTabla.update());
    }

    private void resetearSeldas() {
        textFieldAdress.setText(null);
        textFieldApellido.setText(null);
        textFieldEmail.setText(null);
        textFieldName.setText(null);
        textFieldNumber.setText(null);
    }
}
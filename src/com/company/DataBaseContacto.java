package com.company;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataBaseContacto extends Database {

    private PreparedStatement selectContact = null;
    private PreparedStatement insertContact = null;
    private PreparedStatement deleteContact = null;
    private PreparedStatement updateContact = null;
    private PreparedStatement selectContactPerKey = null;

    public DataBaseContacto() {

        try {
            insertContact = getConnection().prepareStatement(
                    "INSERT INTO contacto (id, nombre, apellido, email, address, numero) VALUES (? ,? ,? ,? ,? ,? )");

            selectContact = getConnection().prepareStatement(
                    "SELECT * FROM contacto");

            deleteContact = getConnection().prepareStatement(
					"DELETE FROM contacto"
					+ "WHERE contacto.id = ?" );

            selectContactPerKey = getConnection().prepareStatement(
                    "SELECT * FROM `maquina` "
                            + "WHERE `COD_MAQUINA` = ?");

        } catch (SQLException sqlException) {

            sqlException.printStackTrace();
            System.exit( 1 );
        }
    }//fin del constructor

    public List<Contact> getAllContacts() {

        List <Contact>  listContactos = null;
        ResultSet resultSet = null;
        try {

            resultSet = selectContact.executeQuery();//ejecuta los queries
            listContactos = new ArrayList<>();

            while(resultSet.next()) {
                listContactos.add( new Contact(
                        resultSet.getString("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellido"),
                        resultSet.getString("email"),
                        resultSet.getString("address"),
                        resultSet.getInt("numero")));
            }//fin del while

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }//end try catch

        finally {
            try	{
                Objects.requireNonNull(resultSet).close();
            }catch ( SQLException sqlException ) {
                sqlException.printStackTrace();
                close();
            }	// end try catch
        } // end finally

        return listContactos;
    }

    public void deleteContact(String cod) {

        int actualizacion = 0;
        ResultSet resultSet = null;
        try {

            deleteContact.setString(1, cod);
            actualizacion = deleteContact.executeUpdate();//ejecuta los queries

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }//end try catch
    }//fin del metodo

    public void setContanct(Contact contact) {

        int actualizacion = 0;
        try {

            insertContact.setString(1, contact.getId());
            insertContact.setString(2, contact.getName());
            insertContact.setString(3, contact.getSurname());
            insertContact.setString(4, contact.getEmail());
            insertContact.setString(5, contact.getAddress());
            insertContact.setInt(6, contact.getNumber());

            actualizacion = insertContact.executeUpdate();

        } catch ( SQLException sqlException ) {
            sqlException.printStackTrace();
            close();
        }//fin del try catch

    }

    private void close() {
        try {
            getConnection().close();
        } catch ( SQLException sqlException ) {
            sqlException.printStackTrace();
        } // end try catch
    } // end method close
}

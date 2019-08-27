package com.company;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataBaseContacto extends Database {

    private PreparedStatement selectContacto = null;
    private PreparedStatement insertContacto = null;
    private PreparedStatement deleteContacto= null;
    private PreparedStatement selectContactoPorCodigo = null;

    public DataBaseContacto() {

        try {
            insertContacto = getConnection().prepareStatement(
                    "INSERT INTO contacto (id, nombre, apellido, email, addres, numero) VALUES (? ,? ,? ,? ,? ,? )");

            selectContacto = getConnection().prepareStatement(
                    "SELECT * FROM contacto");

            deleteContacto = getConnection().prepareStatement(
					"DELETE FROM contacto"
					+ "WHERE contacto.id = ?" );

            selectContactoPorCodigo = getConnection().prepareStatement(
                    "SELECT * FROM `maquina` "
                            + "WHERE `COD_MAQUINA` = ?");

        } catch (SQLException sqlException) {

            sqlException.printStackTrace();
            System.exit( 1 );
        }
    }//fin del constructor

    public List<Contact> getAllContactos() {

        List <Contact>  listContactos = null;
        ResultSet resultSet = null;
        try {

            resultSet = selectContacto.executeQuery();//ejecuta los queries
            listContactos = new ArrayList<>();

            while(resultSet.next()) {
                listContactos.add( new Contact(
                        resultSet.getString("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellido"),
                        resultSet.getString("email"),
                        resultSet.getString("addres"),
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

    public void deleteContacto(String cod) {

        int actualizacion = 0;
        ResultSet resultSet = null;
        try {

            deleteContacto.setString(1, cod);
            actualizacion = deleteContacto.executeUpdate();//ejecuta los queries

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }//end try catch
    }//fin del metodo

    public void setContanto(Contact contacto) {

        int actualizacion = 0;
        try {

            insertContacto.setString(1, contacto.getId());
            insertContacto.setString(2, contacto.getName());
            insertContacto.setString(3, contacto.getSurname());
            insertContacto.setString(4, contacto.getEmail());
            insertContacto.setString(5, contacto.getAddress());
            insertContacto.setInt(6, contacto.getNumber());

            actualizacion = insertContacto.executeUpdate();

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

package com.company;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseContacto extends Database {

    private PreparedStatement selectTodoMaquina = null;
    private PreparedStatement insertMaquina = null;
    private PreparedStatement selectMaquinaPorCodigo = null;

    public DataBaseContacto() {

        try {

            insertMaquina = getConnection().prepareStatement(
                    "INSERT INTO `maquina`(`COD_MAQUINA`, `NOMBRE`, `AÑO_FABRICACION`, "
                            + "`FUNCION`, `VALOR_ADQUIRIDO`, `VALOR_DEPRECIADO`, `MOTOR`) VALUES "
                            + "(? ,? ,? ,? ,? ,? ,? )" );

            selectTodoMaquina = getConnection().prepareStatement(
                    "SELECT * FROM `maquina`");

			/*deleteMaquina = getConnection().prepareStatement(
					"DELETE FROM `maquina`"
					+ "WHERE `maquina`.`COD_MAQUINA` = ?" );*/

            selectMaquinaPorCodigo = getConnection().prepareStatement(
                    "SELECT * FROM `maquina` "
                            + "WHERE `COD_MAQUINA` = ?");


        } catch (SQLException sqlException) {

            sqlException.printStackTrace();
            System.exit( 1 );
        }
    }//fin del constructor
}

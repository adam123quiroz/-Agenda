/*package com.company;

 Estandarizar las variables para el correcto funcionamiento
    import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ModificarDAO { {

       Pool metodospool = new Pool();

        public void Modificar(String nombres, String apellidos, String email, String celular,
                              String direccion, String ciudad, String idcontacto){

            int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea modificar los datos actuales?");


            if(confirmar == JOptionPane.YES_OPTION){

                Connection conexion = null;

                try {

                    conexion = metodospool.dataSource.getConnection();

                    String Ssql = "UPDATE contacto SET nombres=?, apellidos=?, email=?, celular=?, direccion=?, ciudad=? "
                            + "WHERE id_contacto=?";

                    PreparedStatement prest = conexion.prepareStatement(Ssql);

                    prest.setString(1, nombres);
                    prest.setString(2, apellidos);
                    prest.setString(3, email);
                    prest.setString(4, celular);
                    prest.setString(5, direccion);
                    prest.setString(6, ciudad);
                    prest.setString(7, idcontacto);

                    if(prest.executeUpdate() > 0){

                        JOptionPane.showMessageDialog(null, "Los datos han sido modificados con éxito", "Operación Exitosa",
                                JOptionPane.INFORMATION_MESSAGE);

                    }else{

                        JOptionPane.showMessageDialog(null, "No se ha podido realizar la actualización de los datos\n"
                                        + "Inténtelo nuevamente.", "Error en la operación",
                                JOptionPane.ERROR_MESSAGE);

                    }

                } catch (SQLException e) {

                    JOptionPane.showMessageDialog(null, "No se ha podido realizar la actualización de los datos\n"
                                    + "Inténtelo nuevamente.\n"
                                    + "Error: "+e, "Error en la operación",
                            JOptionPane.ERROR_MESSAGE);

                }finally{

                    if(conexion!=null){

                        try {

                            conexion.close();

                        } catch (SQLException e) {

                            JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexión."
                                            + "Error: "+e, "Error en la operación",
                                    JOptionPane.ERROR_MESSAGE);

                        }

                    }

                }


            }

        }

    }
}
*/
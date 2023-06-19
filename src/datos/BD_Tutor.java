/*
 * Proyecto: Sistema para el control de Registro y Solicitudes de Titulos
 * Descripción: Esta clase representa a una instancia de Tutor desde la 
                parte de base de datos. Contiene todos los métodos para operar
                con la base de datos.
 * Fecha: 12/06/2023
 */
package datos;

import java.sql.SQLException;
import negocio.Tutor;
import servicios.ConexionGenerica;
import servicios.MS_SQLServer;

/**
 *
 * @author Lawdee N. NArváez B.
 * @version 1.0.0
 * @since jdk 17.0.0
 */
public class BD_Tutor {
  /*  ***********************************************************************/
  /*        Variables de Instancia                                          */
  /*  ***********************************************************************/
    private Tutor tutor; //Instancia de tutor
    private ConexionGenerica cnn; //Manejador de conexión
  /*  ***********************************************************************/
  /*        Constructor para nuevas instancias                              */
  /*  ***********************************************************************/
  public BD_Tutor (){
      tutor = null;
      cnn = null;
  }
  
  /*  ***********************************************************************/
  /*        Métodos de Instancia                                            */
  /*  ***********************************************************************/
  public String leerTutor (String c) throws ClassNotFoundException,
                                            InstantiationException,
                                            IllegalAccessException,
                                            SQLException
    {
      //String que retornará el nombre
      String tutor = " ";
      cnn = new MS_SQLServer ();
      //Definir el String de la consulta que se requiere
      String sql =  "SELECT nomb_tut,p_apellido,s_apellido ";
             sql += "FROM act_TutorVIEW ";
             sql += "WHERE correo = ?";
      //Establecer y preparar la consulta
      cnn.pst = cnn.conexion.prepareStatement(sql);
      cnn.pst.setString(1, c);
      //Recibir los resultados      
      cnn.resultado = cnn.pst.executeQuery();
      //Verificar si hay resultados en la consulta y recuperar los datos
	if (cnn.resultado.next()) {
            tutor = cnn.resultado.getString("nomb_tut") + " ";
            tutor += cnn.resultado.getString("p_apellido") + " ";
            tutor += cnn.resultado.getString("s_apellido");
        }//fin de if
      return tutor; //Retornar el nombre y apellido del tutor      
  }//Fin del método
  
    
}//Fin de la clase

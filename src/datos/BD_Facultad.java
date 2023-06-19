/*
 * Proyecto: Sistema para el control de Registro y Solicitudes de Titulos
 * Descripción: Esta clase representa a una instancia de Facultad Acta desde la 
                parte de base de datos. Contiene todos los métodos para operar
                con la base de datos.
 * Fecha: 12/06/2023
 */
package datos;

import java.util.ArrayList;
import negocio.Facultades;
import servicios.ConexionGenerica;
import servicios.MS_SQLServer;

/**
 *
 * @author Lawde N. Nasrváez B.
 * @version 1.0.0
 * @since jdk 17.0.5
 */
public class BD_Facultad {
   /*  ***********************************************************************/
   /*        Variables de instancia/ Atributos de Clase                      */
   /*  ***********************************************************************/
    private Facultades fac;
    private ConexionGenerica cnn; //Manejador de conexión
   
   /*  ***********************************************************************/
   /*        Constructor para nuevas instancias                              */
   /*  ***********************************************************************/
    public BD_Facultad (){
        fac = null;
        cnn = null;
    }
    
   /*  ***********************************************************************/
   /*        Métodos de instancia                                            */
   /*  ***********************************************************************/
    /**
     * Lista todas las Facultades que se encuentren registradas en la 
     * Entidad Facultad de la Base de Datos
     * @return ArrayList con todos los Registros de Facultades que se han 
     *         encontrado, null en el caso que no se encuentren registradas
     *         facultades
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     * @throws java.sql.SQLException 
     */
    public ArrayList<String> leerFacultades () 
                                    throws java.lang.ClassNotFoundException,
                                           java.lang.InstantiationException,
                                           java.lang.IllegalAccessException,
                                           java.sql.SQLException
                                           
    {
      //Definir el ArrayList que contendra los nombres de la Facultad
        ArrayList<String> lstFact = null;        
      //Crear la instancia de conexión
        cnn = new MS_SQLServer ();
      //Definir el String que se encarga de llamar a la vista
       String sql = "SELECT nombreFacultad FROM act_FacultyView";
       cnn.pst = cnn.conexion.prepareStatement(sql);
       cnn.resultado = cnn.pst.executeQuery();
       
       //Verificar resultados de la consulta
       if (cnn.resultado != null)
       {
           lstFact = new ArrayList<> ();
           while (cnn.resultado.next()) {
               lstFact.add(cnn.resultado.getString("nombreFacultad"));
           }//Fin de la instrucción while
       }//Fin del condicional if
      return lstFact; 
    }//Fin de leer
}//Fin de la clase

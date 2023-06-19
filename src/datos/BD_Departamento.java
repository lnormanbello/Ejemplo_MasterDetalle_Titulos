/*
 * Proyecto: Sistema para el control de Registro y Solicitudes de Titulos
 * Descripción: Esta clase representa a una instancia de Departamento desde la 
                parte de base de datos. Contiene todos los métodos para operar
                con la base de datos.
 * Fecha: 12/06/2023
 */
package datos;

import java.util.ArrayList;
import negocio.Departamentos;
import servicios.ConexionGenerica;
import servicios.MS_SQLServer;

/**
 *
 * @author Lawdee Norman Narváez B.
 * @since  JDK 17.0.5
 * @version 1.0.0
 */
public class BD_Departamento {
   /*  ***********************************************************************/
   /*        Variables de instancia/ Atributos de Clase                      */
   /*  ***********************************************************************/
    private Departamentos dept;
    private ConexionGenerica cnn; //Manejador de conexión
    
   /*  ***********************************************************************/
   /*        Constructor para nuevas instancias                              */
   /*  ***********************************************************************/
    public BD_Departamento (){
        dept = null;
        cnn = null;
    }
    
   /*  ***********************************************************************/
   /*        Métodos de instancia                                            */
   /*  ***********************************************************************/
    public ArrayList<String> leerDepartamentos () 
                                        throws java.lang.ClassNotFoundException,
                                               java.lang.InstantiationException,
                                               java.lang.IllegalAccessException,
                                               java.sql.SQLException
                                           
    {
      //Definir el ArrayList que contendra los nombres de la Facultad
        ArrayList<String> lstDpto = null;        
      //Crear la instancia de conexión
        cnn = new MS_SQLServer ();
      //Definir el String que se encarga de llamar a la vista
       String sql = "SELECT nombreDepto FROM act_DepartmentView";
       cnn.pst = cnn.conexion.prepareStatement(sql);
       cnn.resultado = cnn.pst.executeQuery();
       
       //Verificar resultados de la consulta
       if (cnn.resultado != null)
       {
           lstDpto = new ArrayList<> ();
           while (cnn.resultado.next()) {
               lstDpto.add(cnn.resultado.getString("nombreDepto"));
           }//Fin de la instrucción while
       }//Fin del condicional if
      return lstDpto; 
    }//Fin de leer
}//Fin de clase 

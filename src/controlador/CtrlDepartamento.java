
package controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import negocio.Departamentos;

/**
 *
 * @author Lawdee N. Narváez B.
 * @version 1.0.0
 * @since jdk 17.0.5
 */
public class CtrlDepartamento {
   
    public static ArrayList<String> listar () throws ClassNotFoundException,
                                                     InstantiationException,
                                                     IllegalAccessException,
                                                     SQLException
    {
        //Crear la instancia de Departamento de la Capa de negocio
        Departamentos d = new Departamentos ();
        return d.listarDepartamentos();
    }//Fin método
}//Fin de la clase 

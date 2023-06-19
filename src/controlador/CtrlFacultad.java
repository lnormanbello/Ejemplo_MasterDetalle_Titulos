
package controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import negocio.Facultades;

/**
 *
 * @author lnarvaezb
 */
public class CtrlFacultad {
   
    public static ArrayList<String> listar () throws ClassNotFoundException,
                                              InstantiationException,
                                              IllegalAccessException,
                                              SQLException
    {
       Facultades f = new Facultades ();
       return f.listaFacultades();
    }
}//Fin de controlador

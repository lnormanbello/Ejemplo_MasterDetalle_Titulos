
package controlador;

import java.sql.SQLException;
import negocio.Tutor;

/**
 *
 * @author lnarvaezb
 */
public class CtrlTutores {
     
    public static Tutor buscarTutor (int inss) 
                                                throws ClassNotFoundException,
                                                       InstantiationException,
                                                       IllegalAccessException,
                                                       SQLException
    {       
        Tutor t = new Tutor ();
        return t.buscar(inss);
    }//Fin método
}//Fin de clase

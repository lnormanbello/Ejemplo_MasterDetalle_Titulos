
package controlador;

import java.sql.SQLException;
import negocio.Evaluador;

/**
 *
 * @author lnarvaezb
 */
public class CtrlEvaluador {
    
    public static Evaluador Seek (int val) throws ClassNotFoundException,
                                                  InstantiationException,
                                                  IllegalAccessException,
                                                  SQLException
    {
        Evaluador e = new Evaluador ();
        return e.SeekEvaluator(val);
    }
}//Fin de la clase

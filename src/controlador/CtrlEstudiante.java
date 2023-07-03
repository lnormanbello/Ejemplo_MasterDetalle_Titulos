
package controlador;

import java.sql.SQLException;
import negocio.Estudiante;

/**
 *
 * @author Lawdee Norman Narváez B.
 */
public class CtrlEstudiante {
    
    public static Estudiante seek (String c) throws ClassNotFoundException,
                                                    InstantiationException,
                                                    IllegalAccessException,
                                                    SQLException
                                                    
    
    {
       Estudiante e = new Estudiante ();
       return e.SeekStudent(c);
    }//Fin de método
}

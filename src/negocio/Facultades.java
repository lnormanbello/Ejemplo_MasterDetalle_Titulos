/*
 * Proyecto: Sistema para el control de Registro y Solicitudes de Titulos
 * Descripción: Esta clase representa a una instancia de Facultad como un objeto
 *              en el sistema. Contiene sus correspondientes
 *              métodos de encapsulación setter y getter
 * Fecha: 12/06/2023
 */
package negocio;

import datos.BD_Facultad;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author lnarvaezb
 */
public class Facultades {
   /*  ***********************************************************************/
   /*        Variables de instancia/ Atributos de Clase                      */
   /*  ***********************************************************************/
    private int codigo;
    private String nombre;
    
   /*  ************************************************************************/
   /*        Constructor para nuevas instancias                               */
   /*  ************************************************************************/
    public Facultades () {
        codigo = 0;
        nombre = "";
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public ArrayList <String> listaFacultades () throws ClassNotFoundException,
                                                 InstantiationException,
                                                 IllegalAccessException,
                                                 SQLException
    {
        //Crear la instancia de BD_Facultad
        BD_Facultad fac = new BD_Facultad ();
        return fac.leerFacultades(); //Leer los registros
    }//Fin de método
    
}//Fin de Clase

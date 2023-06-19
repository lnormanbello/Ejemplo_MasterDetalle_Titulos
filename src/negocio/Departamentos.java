/*
 * Proyecto: Sistema para el control de Registro y Solicitudes de Titulos
 * Descripción: Esta clase representa a una instancia de Departamento como 
                como un objeto en el sistema. Contiene sus correspondientes
                métodos de encapsulación setter y getter
 * Fecha: 12/06/2023
 */
package negocio;

import datos.BD_Departamento;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lawdee N. Narvárez B.
 * @since JDK 17.0.5
 * @version 1.0.0
 */
public class Departamentos {
   /*  ***********************************************************************/
   /*        Variables de instancia/ Atributos de Clase                      */
   /*  ***********************************************************************/
    private int id_Facultad; //Id del objeto que asocia con Facultad
    private String codigo;  //Código del departamento
    private String nombre; //Nombre del departamento
   /*  ***********************************************************************/
   /*        Constructor para nuevas instancias                              */
   /*  ***********************************************************************/
    public Departamentos () {
       id_Facultad = 0;
       codigo = "";
       nombre = "";
    }//Fin del constructor

   /*  ***********************************************************************/
   /*        Propiedades de los Objetos                                      */
   /*  ***********************************************************************/
    /**
     * @return the id_Facultad
     */
    public int getId_Facultad() {
        return id_Facultad;
    }

    /**
     * @param id_Facultad the id_Facultad to set
     */
    public void setId_Facultad(int id_Facultad) {
        this.id_Facultad = id_Facultad;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
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
    
   /*  ************************************************************************/
   /*        Métodos de Instancia                                             */
   /*  ************************************************************************/
    public ArrayList <String> listarDepartamentos () 
                                                throws ClassNotFoundException,
                                                InstantiationException,
                                                IllegalAccessException,
                                                SQLException
    {
        //Crear la instancia de BD_Facultad
        BD_Departamento dpt = new BD_Departamento ();
        return dpt.leerDepartamentos(); //Leer los registros
    }//Fin de método
    
}//Fin de la clase Departamento

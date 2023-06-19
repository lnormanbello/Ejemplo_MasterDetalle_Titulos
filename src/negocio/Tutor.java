/*
 * Proyecto: Sistema para el control de Registro y Solicitudes de Titulos
 * Descripción: Esta clase representa a una instancia de Tutor como 
                como un objeto en el sistema, Es una clase que hereda de la
                superclase Persona. Contiene sus correspondientes
                métodos de encapsulación setter y getter
 * Fecha: 12/06/2023
 */
package negocio;

import datos.BD_Tutor;
import java.sql.SQLException;

/**
 *
 * @author Lawdee N. Narváez B.
 * @version 1.0.0
 * @since   jdk 17.05
 */
public class Tutor {
  /*  ***********************************************************************/
  /*       Variables de Instancias o Atrinbutos                             */
  /*  ***********************************************************************/
    private String nombre;
    private String pApellido;
    private String sApellido;
    private String correo;
    private String telefono;
    private int estado;
    
  /*  ********************************************************************** */
  /*       Constructor para nuevas instancias                                */
  /*  ********************************************************************** */
    public Tutor () {
        nombre = "";
        pApellido = "";
        sApellido = "";
        correo = "";
        telefono = "";
        estado = 1;
    }

  /*  ********************************************************************** */
  /*       Propiedades                                             */
  /*  ********************************************************************** */
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

    /**
     * @return the pApellido
     */
    public String getpApellido() {
        return pApellido;
    }

    /**
     * @param pApellido the pApellido to set
     */
    public void setpApellido(String pApellido) {
        this.pApellido = pApellido;
    }

    /**
     * @return the sApellido
     */
    public String getsApellido() {
        return sApellido;
    }

    /**
     * @param sApellido the sApellido to set
     */
    public void setsApellido(String sApellido) {
        this.sApellido = sApellido;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }
    
  /*  ********************************************************************** */
  /*       Métodos de Instancia                                              */
  /*  ********************************************************************** */
    public String buscar (String email ) throws ClassNotFoundException,
                                                InstantiationException,
                                                IllegalAccessException,
                                                SQLException
    {
        //Crear la instancia de  la capa de datos
        BD_Tutor t = new BD_Tutor ();
        return t.leerTutor(email);
    }//Fin  método
    
}//Fin de la clase

/*
 * Proyecto: Sistema para el control de Registro y Solicitudes de Titulos
 * Descripción: Esta clase representa una Entidad Acta desde la parte de 
 *              objetos en el sistema.              
 * Fecha: 12/06/2023
 */
package negocio;

import datos.BD_Actas;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lawdee Norman Narváez B.
 * @see datos.BD_Actas
 * @since jdk 17.0.5
 * 
 */
public class Actas {
   /* Definición de variable de instancias */
    private int numActa;
    private String local;
    private java.time.LocalDate fecha; //Manejo de la fecha
    private String tema;
    private int activo;
    //Establecer enlace para comunicación con objetos relacionados
    private Departamentos navDepto; //Objeto que permitirá navegar en Departamento
    private Tutors navTutor; //Objeto que permitiran navegar en Tutor
    
    /* Definición de constructor de nuevas instancias */
    public Actas ()
    {
        numActa = 0;
        local = "";
        fecha = java.time.LocalDate.now(); //Obtener fecha actual
        tema = "";
        activo = 1; //El registro se asumira como vigente o activo
        navDepto = null;
        navTutor =  null;
    } //Fin de constructor

    /* ************************************************************************/
    /*                      Propiedades                                       */
    /* ************************************************************************/
    /**
     * @return the numActa
     */
    public int getNumActa() {
        asignarNumActa (); //Determinar el valor que le corresponde al Acta
        return numActa;
    }
    
    /**
     * @return the local
     */
    public String getLocal() {
        return local;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(String local) {
        this.local = local;
    }

    /**
     * @return the fecha
     */
    public java.time.LocalDate getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(java.time.LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the tema
     */
    public String getTema() {
        return tema;
    }

    /**
     * @param tema the tema to set
     */
    public void setTema(String tema) {
        this.tema = tema;
    }

    /**
     * @return the activo
     */
    public int getActivo() {
        return activo;
    }

    /**
     * @param activo the activo to set
     */
    public void setActivo(int activo) {
        this.activo = activo;
    }

    /**
     * @return the navDepto
     */
    public Departamentos getNavDepto() {
        return navDepto;
    }

    /**
     * @param navDepto the navDepto to set
     */
    public void setNavDepto(Departamentos navDepto) {
        this.navDepto = navDepto;
    }

    /**
     * @return the navTutor
     */
    public Tutors getNavTutor() {
        return navTutor;
    }

    /**
     * @param navTutor the navTutor to set
     */
    public void setNavTutor(Tutors navTutor) {
        this.navTutor = navTutor;
    }
    
    /* ************************************************************************/
    /*              Métodos de instancia                                      */
    /* ************************************************************************/
    private void asignarNumActa ()
    {
        try {
            //Establecer enlace con la capa de datos para validar el n° de acta
            BD_Actas a = new BD_Actas ();
            int val = a.getNumberReg();
            if (val == 0)
              numActa = 100; //Se iniciará a generar numeración a partir de 0  
            else
              numActa = val + 1; //Incremenar en 1 el valor actual del acta
        }//Fin de la instrucción try        
        catch (ClassNotFoundException | InstantiationException | 
                IllegalAccessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido determinar"
                    + " el número de acta correspondiente", 
                    "Error Número de Acta", JOptionPane.ERROR_MESSAGE);
        }
    }//Fin del método
}//Fin de la clase

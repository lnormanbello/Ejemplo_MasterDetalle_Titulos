/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import java.sql.SQLException;

/**
 *
 * @author Lawde Norman Narváez B.
 * @version 1.0.0
 * @since jdk 17.0.5
 * @see PersonalOperativo
 */
public abstract class Personal {
    /* ************************************************************************/
    /*                      Variables de Instancia                            */
    /* ************************************************************************/
    protected String nombres;
    protected String pApellido;
    protected String sApellido;
    protected String correo;
    
    /* ************************************************************************/
    /*                      Métodos de Instancia                              */
    /* ************************************************************************/
    public abstract int agregarRegistro () throws ClassNotFoundException,
                                                  InstantiationException,
                                                  IllegalAccessException,
                                                  SQLException;
    
    public abstract Personal leerPersonal (int val) throws 
                                                    ClassNotFoundException,
                                                    InstantiationException,
                                                    IllegalAccessException,
                                                    SQLException;
            
    public abstract boolean borrarRegistro (int cod) throws ClassNotFoundException,
                                                 InstantiationException,
                                                 IllegalAccessException,
                                                 SQLException;
    
}//Fin de la clase

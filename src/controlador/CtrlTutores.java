/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.SQLException;
import negocio.Tutor;

/**
 *
 * @author lnarvaezb
 */
public class CtrlTutores {
     
    public static String buscarTutor (String email) 
                                                throws ClassNotFoundException,
                                                       InstantiationException,
                                                       IllegalAccessException,
                                                       SQLException
    {       
        Tutor t = new Tutor ();
        return t.buscar(email);
    }//Fin método
}//Fin de clase

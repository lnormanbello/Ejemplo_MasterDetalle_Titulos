/*
 * Proyecto: Sistema para el control de Registro y Solicitudes de Titulos
 * Descripción: Esta clase funciona como representación intermedia entre 
 *              la interacción con el usuario y las capas internas de la 
 *              apicación
 * Fecha: 12/06/2023
 */
package controlador;

import negocio.Actas;

/**
 *
 * @author Lawdee Norman Narváez B.
 * @version 1.0.0
 * @since jdk 17.0.5
 */
public class CtrlActas {
    
    public static int generarNumActa (){
        //Crear instancia de la capa de negocio
        Actas act = new Actas ();
        return act.asignarNumActa(); //Obtener el número de acta
    }//Fin de método
            
}//Fin de la clase

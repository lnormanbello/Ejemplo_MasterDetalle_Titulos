/*
 * Proyecto: Sistema para el control de Registro y Solicitudes de Titulos
 * Descripción: Esta clase representa un instancia en el nivel intermedio de la
 *              aplicación, toma los datos de vista del usuario y comunica hacia
 *              la capa de negocio para el procesamiento de la información por 
 *              de una instancia de Personal Operativo
 * Fecha: 18/05/2023
 */
package controlador;

import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import negocio.PersonalOperativo;

/**
 *
 * @author Lawdee Norman Narváez B.
 * @version 1.0.0
 * @since JDK 17.0.5
 * @see negocio.PersonalOperativo
 */
public class CtrlOperativo {
    /* ************************************************************************
     *                          Métodos de Clase                              *
     * ********************************************************************** */
    /**
     * Toma los datos de entrada para asociarlos a una instancia de Personal
     * Operativo en la capa de negocio de la aplicación
     * @param inss valor de la propiedad número de inss
     * @param nomb valor nombre que le será asignado a la entidad Personal
     *             operativo
     * @param apell1 valor de la propiedad de instancia de primer apellido
     * @param apell2 valor de la propiedad de instancia de segundo apellido
     * @param email  valor de la propiedad de dirección de correo electrónico
     * @param func   valor de la propiedad función o cargo de la instancia
     * @return El valor de la cantidad de registro afectado si se procesarón
     *         los datos correctamente desde la capa de negocios
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws SQLException 
     */
    public static int agregar (int inss, String nomb, String apell1, 
                               String apell2, String email, String func) 
                               throws ClassNotFoundException,
                                      InstantiationException,
                                      IllegalAccessException,
                                      SQLException
    
            
    {
       PersonalOperativo po = new PersonalOperativo (inss, nomb, apell1,apell2,
                                                     email, func);
       return po.agregarRegistro(); //Mandar agregar el registro
    }//Fin método
    
    public static PersonalOperativo leerRegistro (int inss) throws 
                                                    ClassNotFoundException,
                                                    InstantiationException,
                                                    InstantiationException,
                                                    IllegalAccessException,
                                                    SQLException
    {
        PersonalOperativo po = new PersonalOperativo ();
        return (PersonalOperativo) po.leerPersonal(inss);
    }

    public static void listar (javax.swing.JTable tModel) throws
                                                  ClassNotFoundException,
                                                  InstantiationException,
                                                  InstantiationException,
                                                  IllegalAccessException,
                                                  SQLException
    {
        DefaultTableModel modelo = (DefaultTableModel) tModel.getModel();
        //Obtener la lista de la capa de negocio
        PersonalOperativo po = new PersonalOperativo ();
        List<PersonalOperativo> p = po.leerPersonal();
        
        //Recorrer los elementos de la lista
        for (PersonalOperativo dato : p) {
            modelo.addRow(new Object [] {dato.getInss(), dato.getNombres(),
                          dato.getpApellido(), dato.getsApellido(),
                          dato.getCorreo(), dato.getCargo()});
        }//Fin de la instrucción foreach
        
    }//Fin método
    
    public static boolean eliminar (int inss) throws ClassNotFoundException,
                                                     InstantiationException,
                                                     InstantiationException,
                                                     IllegalAccessException,
                                                     SQLException      
    {
        PersonalOperativo po = new PersonalOperativo ();
        return po.borrarRegistro(inss);
    }
}//Fin de la clase
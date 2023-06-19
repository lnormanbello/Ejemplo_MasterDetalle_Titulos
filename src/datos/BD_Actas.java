/*
 * Proyecto: Sistema para el control de Registro y Solicitudes de Titulos
 * Descripción: Esta clase representa a una instancia de Entidad Acta desde la 
                parte de base de datos. contiene sus correspondientes
                métodos de encapsulación setter y getter
 * Fecha: 12/06/2023
 */
package datos;

import negocio.Actas;
import servicios.ConexionGenerica;
import servicios.MS_SQLServer;
import java.sql.CallableStatement; 
import java.sql.Types;

/**
 *
 * @author Lawde Norman Narváez B.
 * @version 1.0.0
 * @see JDK 17.0.5
 */
public class BD_Actas {
   /*  ***********************************************************************/
   /*        Variables de instancia/ Atributos de Clase                      */
   /*  ***********************************************************************/
    private Actas act; //Instancia de PersonalOperativo
    private ConexionGenerica cnn; //Manejador de conexión
    
   /*  ***********************************************************************/
   /*        Definición de Constructor de Nuevas Instancias                  */
   /*  ***********************************************************************/
    public BD_Actas (){
        cnn = null;
        act = null;
    }//Fin del constructor
    /* Sobre carga de constructor */
    public BD_Actas (Actas act) {
        cnn = null;
        this.act = act;
    }//Fin constructor
    
   /*  ***********************************************************************/
   /*        Métodos de instancia                                            */
   /*  ***********************************************************************/
    /**
     * Recupera la cantidad de registros de Entidades actas que se tienen
     * actualmente en la base de datos
     * @return Cantidad de registros actuales en la base de datos
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     * @throws java.sql.SQLException 
     */
    public int getNumberReg () throws java.lang.ClassNotFoundException,
                                      java.lang.InstantiationException,
                                      java.lang.IllegalAccessException,
                                      java.sql.SQLException
    {
        int value;
        //Definir la instancia de conexión con la base de datos
        cnn = new MS_SQLServer ();
        /*Esta vez la sentencia es una cadena que invoca un procedimiento 
          que contiene un parámetro de salida*/
        String sql = "{CALL Usp_GetRegisterTotal (?)}";
        //Invocar a instancia de la clase CallableStatement que ejecuta consulta
        CallableStatement stmt = cnn.conexion.prepareCall(sql);
        
        //Definir el parámetro de salida que se espera del procedimiento
        stmt.registerOutParameter(1, Types.INTEGER);
        //Hacer la ejecución del procedimiento almacenado
        stmt.execute();
        
        //recuperar el parámetro que se espera de la salida del procedimiento
        value = stmt.getInt(1);
        //Liberar la conexión del Statement
        stmt.close();
        //Retornar el valor obtenido
        return value;
    }//Fin acta
    
}//Fin de la clase 

/*
 * Representa la generación de conexiones con el motor de base de datos, el 
 * propósito es mantener una sola conexión, de modo que se evite un uso 
 * indebido de los recursos de consultas al motor de base de datos
 * 
 */
package servicios;

import java.sql.SQLException;

/**
 *
 * @author Lawdee Norman Narváez Bello
 */
public class ServiceFactory {
    /* ************************************************************************/
    /*                  Variables de Instancia                                */
    /* ************************************************************************/
    //Definir una variable para instanciar a ConexionGenerica
    private ConexionGenerica cnn;
    //Variable de instancia para que se comparta por cualquier clase instancia
    // de la Clase ServiceFactory
    private static ServiceFactory instancia; //Manejar la instancia actual
    
    /* ************************************************************************/
    /*                             Constructor                                */
    /* ************************************************************************/
    public ServiceFactory () {
        //Constructor por default para que no modifique el estado de las
        //variables de instancia
    }//Fin de constructor
    
    /**
     * Método sincronizado que determina si hay actualmente instancias en uso y
     * la retorna, si no se han establecido instancia, crea una nueva para 
     * establecer uso de la conexión
     * @return Instancia de Conexión con la base de datos, si ya existe retorna
     *         la instancia de conexión vigente
     */
    public static synchronized ServiceFactory getInstancia () {
        //Determinar si no hay una instancia en uso para crear una nueva
        if (instancia == null)
            instancia = new ServiceFactory ();
        //Si ya existe la instancia, se devuelve la que esta en uso
        return instancia;
    }//Fin de la clase
        
    /**
     * Obtiene una conexión el motor de base de datos
     * @return Conexión con el Sistema Gestor de Base de Datos
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws SQLException 
     */
    public ConexionGenerica getConexion () throws ClassNotFoundException,
                                                  InstantiationException,
                                                  IllegalAccessException,
                                                  SQLException
    {
        //Leer del archivo de Propiedades el nombre de la clase
        //encargada de comunicar con el manejador de base de datos        
        String nombClass = System.getProperty("databaseclass");        
        if (cnn == null) {            
            cnn = (ConexionGenerica) Class.forName(nombClass).cast(cnn);                    
        }//Fin de condicional if        
      return cnn; 
    }//Fin método de conexión
    
}//Fin de la clase
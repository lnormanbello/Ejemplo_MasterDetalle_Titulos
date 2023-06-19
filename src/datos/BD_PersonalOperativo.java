/*
 * Proyecto: Sistema para el control de Registro y Solicitudes de Titulos
 * Descripción: Esta clase representa un de Personal Operativo de la
 *              aplicación, como una entidad (Tabla en la base de datos), en la
 *              capa de datos para el procesamiento registro de la información
 *              en el sistema.
 * Fecha: 18/05/2023
 */
package datos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import negocio.PersonalOperativo;
import servicios.ConexionGenerica;
import servicios.MS_SQLServer;
import servicios.ServiceFactory;
/**
 *
 * @author Lawdee Norman Narvpaez B.
 * @since jdk 17.0.4
 * @see negocio.PersonalOperativo
 */
public class BD_PersonalOperativo {
   /*  ***********************************************************************/
   /*        Variables de instancia/ Atributos de Clase                      */
   /*  ***********************************************************************/
    private PersonalOperativo pt; //Instancia de PersonalOperativo
    private ConexionGenerica cnx; //= null; //Manejador de conexión
    /*  ***********************************************************************/
    /*        Constructor / Sobrecarga                                        */
    /*  ***********************************************************************/
    public BD_PersonalOperativo () 
    {
        pt = null;
    }
    
    public BD_PersonalOperativo (PersonalOperativo pt){
        this.pt = pt;
    }//Fin constructor
    
    /* ************************************************************************/
    /*                      Métodos de Instancia                              */
    /* ************************************************************************/
    public int guardar (boolean op) throws ClassNotFoundException,
                                    InstantiationException,
                                    IllegalAccessException,
                                    SQLException
    {
       //Instancia de Conexión con la base de datos
       cnx = new MS_SQLServer ();
       String sql; //Define la cadena de SQL a procesar
       //Si op (operación) no es true se trata de un nuevo registro
       if (!op) 
       {
          sql = "INSERT INTO personal_operativo (codigo_inss, nombres"
              + ", p_apellido, s_apellido, correo_institucional, "
              + "funcion_laboral, anulado)";
          sql += "VALUES (?, ?, ?, ?, ?, ?, ?)";
          //Preparar la consulta y establecer los valores del PreparedStatement
          cnx.pst = cnx.conexion.prepareStatement(sql);
          cnx.pst.setInt(1, pt.getInss());
          cnx.pst.setString(2, pt.getNombres());
          cnx.pst.setString(3, pt.getpApellido());
          cnx.pst.setString(4, pt.getsApellido());
          cnx.pst.setString(5, pt.getCorreo());
          cnx.pst.setString(6, pt.getCargo());
          cnx.pst.setInt(7, 1);
       }
       else {
        //La Operación se trata de una actualización de Registro
            sql = "UPDATE personal_operativo SET ";
            sql += "nombres = ?, p_apellido = ?, s_apellido = ?, ";
            sql += "correo_institucional = ?, funcion_laboral = ? ";
            sql += "WHERE \"codigo_inss\" = ?";
        //Establecer los parámetros a pasar a la consulta
            cnx.pst = cnx.conexion.prepareStatement(sql);
            cnx.pst.setString(1, pt.getNombres());
            cnx.pst.setString(2, pt.getpApellido());
            cnx.pst.setString(3, pt.getsApellido());
            cnx.pst.setString(4, pt.getCorreo());
            cnx.pst.setString(5, pt.getCargo());
            cnx.pst.setInt(6, pt.getInss());
       }//Fin de la instrucción else
        return cnx.pst.executeUpdate(); 
    }//Fin método
    
    /**
     * Consulta en la base de datos la información de una Entidad de Personal
     * Operativo y la retorna a través de su instancia
     * @param inss valor por el cual se debe filtrar la información de la 
     *             Entidad
     * @return Una instancia de PersonalOperativo, sino la encuentra retorna 
     *         null
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws SQLException 
     */
    public PersonalOperativo leer (int inss) throws ClassNotFoundException,
                                                    InstantiationException,
                                                    IllegalAccessException,
                                                    SQLException
            
    {
       PersonalOperativo p = null;       
       String sql = "SELECT * FROM personal_operativo ";
              sql += "WHERE \"codigo_inss\" = ?";
       cnx = new MS_SQLServer ();
       //Preparar la conexión hacia el SGBD para obtener registros
       //cnx = ServiceFactory.getInstancia().getConexion();       
       //Procesar la ejecución de la consulta en la base de datos
       cnx.pst = cnx.conexion.prepareStatement(sql);
       cnx.pst.setInt(1, inss);
       cnx.resultado = cnx.pst.executeQuery();
       //Recorrer los resultados obtenidos en la consulta si los hay
       if (cnx.resultado.next()){
          //Recuperar los valores del registro y asignar al objeto p
        p = new PersonalOperativo (cnx.resultado.getInt("codigo_inss"),
                                cnx.resultado.getString("nombres"),
                                cnx.resultado.getString("p_apellido"),
                                cnx.resultado.getString("s_apellido"),
                                cnx.resultado.getString("correo_institucional"),
                                cnx.resultado.getString("funcion_laboral")
                                   );          
       }//Fin de la instrucción if       
       return p;//Retornar el objeto con los valores encontrados
    }//Fin de método
        
    /**
     * Lee de una Entidad Personal Operativo la existencia de un registro 
     * de un Personal Operativo, buscando por su número de INSS.
     * @return Verdadero si ya existe un registro del personal operativo con el
     * número de inss indicado.
     * @see datos.BD_PersonalOperativo
     * @throws ClassNotFoundException
     * @see java.lang.ClassNotFoundException
     * @throws InstantiationException
     * @see java.lang.InstantiationException
     * @throws IllegalAccessException
     * @see java.lang.IllegalAccessException
     * @throws SQLException
     * @see java.sql.SQLException
     */
    public boolean leer () throws ClassNotFoundException,
                                  InstantiationException,
                                  IllegalAccessException,
                                  SQLException
    
    {
       //Instancia de conexión con la base de datos
       cnx = new MS_SQLServer ();
       //Establecer la Sentencia SQL de consulta en la base de datos
       String sql = "SELECT codigo_inss FROM personal_operativo ";
              sql += "WHERE \"codigo_inss\" = ?";
       
        cnx.pst = cnx.conexion.prepareStatement(sql);
        cnx.pst.setInt(1, pt.getInss()); //Indicar el número de INSS
        cnx.resultado = cnx.pst.executeQuery();
        //Retornar el resultado obtenido en la consulta
       return cnx.resultado.next();
    }//Fin Método
   
    public List<PersonalOperativo> listado () throws ClassNotFoundException,
                                                     InstantiationException,
                                                     IllegalAccessException,
                                                     SQLException
    {
       List<PersonalOperativo> list = null; //Lista de instancia a retornar
        cnx = new MS_SQLServer (); //Establecer la instancia para la conexión
        //Consultar todos los registros que estan activo para retornarlos
        String sql = "SELECT codigo_inss, nombres, p_apellido, s_apellido,";
               sql += " correo_institucional, funcion_laboral";
               sql += " FROM personal_operativo WHERE \"anulado\" <> 0";
        
        cnx.pst = cnx.conexion.prepareStatement(sql);
        //Ejecutar la consulta del PreparedStatement
        cnx.resultado = cnx.pst.executeQuery();
        
        //Verificar que se obtuvieron registros, si hay se procesan        
        if (cnx.resultado != null){
            list = new ArrayList<>();//ArrayList almacen
            while (cnx.resultado.next()) {
              PersonalOperativo p = new PersonalOperativo (); //Generar instanc
              p.setInss(cnx.resultado.getInt("codigo_inss"));
              p.setNombres(cnx.resultado.getString("nombres"));
              p.setpApellido(cnx.resultado.getString("p_apellido"));
              p.setsApellido(cnx.resultado.getString("s_apellido"));
              p.setCorreo(cnx.resultado.getString("correo_institucional"));
              p.setCargo(cnx.resultado.getString("funcion_laboral"));
              list.add(p); //Agregar el resultado a la lista
            }//Fin de la instrucción While
        }//Fin de la instrucción if
        
        return list;
    }//Fin del método
    
    /**
     * Realiza un borrado lógico de un registro de Personal Operativo en la 
     * entidad. 
     * @param inss Valor del número de INSS del registro a dar Baja.
     * @return Verdadero si la operación se ha alcanzado con satisfacción
     * @throws ClassNotFoundException
     * @see java.lang.ClassNotFoundException
     * @throws InstantiationException
     * @see java.lang.InstantiationException
     * @throws IllegalAccessException
     * @see java.lang.IllegalAccessException
     * @throws SQLException 
     */
    public boolean borrar (int inss) throws ClassNotFoundException,
                                            InstantiationException,
                                            IllegalAccessException,
                                            SQLException
    {
        boolean rst = false;  //Variable para indicar el proceso de la consulta
       //Instancia de conexión con la base de datos
       cnx = new MS_SQLServer ();
       String sql;
       
       sql = "UPDATE personal_operativo SET ";
            sql += "anulado = ? ";            
            sql += "WHERE \"codigo_inss\" = ?";
        //Establecer los parámetros a pasar a la consulta
            cnx.pst = cnx.conexion.prepareStatement(sql);
            cnx.pst.setInt(1, 0);
            cnx.pst.setInt(2, inss);
        //Retornará verdadero si hubieron registros afectados false sino es así
        return cnx.pst.executeUpdate() > 0; 
    }//Fin método borrar
    
}//Fin de la clase
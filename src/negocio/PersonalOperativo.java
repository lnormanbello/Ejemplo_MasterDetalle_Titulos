/*
 * Proyecto: Sistema de Control para el Tramite de Titulos
 * Descripción: Clase que representa una entidad Personal Operativo, como un 
                objeto dentro de las funcionalidades e interacciones del 
                sistema.
   Fecha: 18/05/2023
 */
package negocio;

import datos.BD_PersonalOperativo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lawdee Norman Narváez B.
 * @version 1.0.0
 * @since jdk 17.0.5
 * @see datos.BD_PersonalOperativo
 */
public class PersonalOperativo extends Personal {
   /*  ***********************************************************************/
   /*        Variables de instancia/ Atributos de Clase                      */
   /*  ***********************************************************************/ 
   private int inss;
   private String cargo;  
   /*  ***********************************************************************/
   /*        Constructor / Sobrecarga                                        */
   /*  ***********************************************************************/ 
    public PersonalOperativo ()
    {
        this.inss =0;
        this.nombres = "";
        this.pApellido = "";
        this.sApellido = "";
        this.correo = "";
        this.cargo = "";
    }//Fin método
    public PersonalOperativo (int inss, String nombres, String pApellido,
                              String sApellido, String correo, String cargo) 
    {
        this.inss = inss;
        this.nombres = nombres;
        this.pApellido = pApellido;
        this.sApellido = sApellido;
        this.correo = correo;
        this.cargo = cargo;
    }//Fin constructor
    /* ************************************************************************/
    /*                      Propiedades                                       */
    /* ************************************************************************/
    /**
     * Establece un valor para la propiedad nombre del objeto PersonalOperativo
     * @param nombres String que representa el valor asignado a la propiedad
     *                nombre
     */
    public void setNombres (String nombres) {
        this.nombres = nombres;
    }
    /**
     * Recupera el valor del nombre de la instancia
     * @return valor asignado a la propiedad nombre de la instancia
     */
    public String getNombres (){
        return nombres;
    }
    /**
     * Establece el valor para la propiedad primer apellido de la instancia
     * @param pApellido valor asignado a la propiedad
     */
    public void setpApellido (String pApellido) {
        this.pApellido = pApellido;
    }
    /**
     * Obtiene el valor de la propiedad del primer apellido de una instancia
     * @return String que representa el valor de la instancia
     */
    public String getpApellido (){
        return this.pApellido;
    }
    /**
     * Establece el valor a la propiedad para segundo apellido de una instancia
     * @param sApellido valor asignado a la propiedad
     */
    public void setsApellido (String sApellido) {
        this.sApellido = sApellido;
    }
    /**
     * Recupera el valor que tiene establecido en la propiedad segundo apellido
     * @return String con el valor en la propiedad del segundo apellido
     */
    public String getsApellido (){
        return this.sApellido;
    }
    /**
     * Recupera el valor del nombre de la instancia
     * @param inss
     */
    public void setInss (int inss){
        this.inss = inss;
    }    
    /**
     * Recupera el valor de número de inss de la instancia
     * @return valor asignado a la propiedad inss de la instancia
     */    
    public int getInss (){
        return inss;
    }        
    /**
     * Establece un valor a la propiedad correo de la instancia correo
     * @param correo String con el valor que se debe asignar a la propiedad
     */
    public void setCorreo (String correo) {
        this.correo = correo;
    }
    /**
     * Recupera el valor del correo electrónico de la instancia
     * @return valor asignado a la propiedad correo de la instancia
     */ 
    public String getCorreo () {
        return this.correo;
    }
    /**
     * @return El valor de la propiedad Cargo de la instancia
     */
    public String getCargo() {
        return cargo;
    }
    /**
     * @param cargo El valor de la propiedad Cargo que se debe asignar
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    /* ************************************************************************/
    /*                      Métodos de Instancia                              */
    /* ************************************************************************/
    /**
     * Agrega o Actualiza un registro de una instancia PersonalOperativo
     * @return 0 Si no se proceso la inserción o modificación de la información
     *         de la instancia al procesar el registro
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws SQLException 
     */
    @Override
    public int agregarRegistro() throws ClassNotFoundException,
                                        InstantiationException,
                                        IllegalAccessException,
                                        SQLException 
    {       
        BD_PersonalOperativo po_bd = new BD_PersonalOperativo (this);
        
        //Verificar si es una actualización o una nueva inserción
        if (!po_bd.leer())
           return po_bd.guardar(false);  //Se trata deu una nueva inserción
        else
           return po_bd.guardar(true); //Se tratad de una actualización        
    }
    /**
     * Realiza una búsqueda de una instancia Personal Operativo
     * @param inss valor por el cual se debe hacer el filtro
     * @return Una instancia de Personal Operativo, sino existe devuele null
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws SQLException 
     */
   @Override
    public Personal leerPersonal (int inss) throws ClassNotFoundException,
                                                   InstantiationException,
                                                   IllegalAccessException,
                                                   SQLException
                                                   
    {
      BD_PersonalOperativo bdP = new BD_PersonalOperativo ();
      return (Personal) bdP.leer(inss);
    }
    
    public List<PersonalOperativo> leerPersonal () throws 
                                                   ClassNotFoundException,
                                                   InstantiationException,
                                                   IllegalAccessException,
                                                   SQLException
    {
        BD_PersonalOperativo bdP = new BD_PersonalOperativo ();
        return (ArrayList) bdP.listado();
    }//Fin de método
    
    @Override
    public boolean borrarRegistro(int cod) throws ClassNotFoundException,
                                           InstantiationException,
                                           IllegalAccessException,
                                           SQLException
    {
        //Temporalmente el método no tiene definido una funcionalidad
        BD_PersonalOperativo bdP = new BD_PersonalOperativo ();               
        return bdP.borrar(cod); //Valor temporal solo para evitar marca de error
    }
    
}//fin de la clase

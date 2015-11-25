package logica;

import GUIpresentacion.GUIInformeAltasBajas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Abogado;
import persistencia.Conexion;

import Utilidad.Utilidad;

/**
 * @author jau
 * @version 1.0
 * @created 28-oct.-2015 11:03:58
 */
public class Universidad {

	private String ciudad;
	private String nombre;
	private String provincia;
	public Abogado m_Abogado;
      //  Conexion cn;
    //private Object cn;
   //Conexion cn;    
        
        
        
        
	public Universidad(){

	}


	public String get_ciudad(){
		return "";
	}

	public String get_nombre(){
		return "";
	}

	public String get_provincia(){
		return "";
	}

	/**
	 * 
	 * @param ciudad
	 */
	public void set_ciudad(String ciudad){

	}

	/**
	 * 
	 * @param nombre
	 */
	public void set_nombre(String nombre){

	}

	/**
	 * 
	 * @param provincia
	 */
	public void set_provincia(String provincia){

	}
        
          public ResultSet getlistauniversidadDB() throws ClassNotFoundException, SQLException{
              
              Conexion cn= Conexion.getInstance();
              ResultSet rs;
                
                rs=cn.Select("SELECT nombre FROM universidad");
//              System.out.println("sss"+rs.getString("nombre"));
            
            return(rs);
        }
        
        
        
        

}
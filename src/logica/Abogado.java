/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import Utilidad.Utilidad;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.Conexion;

/**
 *
 * @author gabriel
 */
public class Abogado extends Persona {
    private float condicion_iva;
	private String dir_profesional;
	private String email;
	private Date fecha_titulo;
	private float ingresos_brutos;
	private String localidad_profesional;
	private String provincia_profesional;
	private int tel_profesional;
        private int nro;
	private String titulo;
        private String obraSocial;
        private String regimen;
        private Date regimen_inicio;
        private Date regimen_final;
        java.sql.Date desde, hasta;
        
       Conexion cn;
       Planilla_de_Inscripcion planilla;
       Persona familar;
       Universidad universidad;

    public Planilla_de_Inscripcion getPlanilla() {
        return planilla;
    }

    public void setPlanilla(Planilla_de_Inscripcion planilla) {
        this.planilla = planilla;
    }

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }
       
       
	public Abogado(){
            planilla = new Planilla_de_Inscripcion();
            familar = new Persona();
            universidad = new Universidad();
	}
        
       
       
    public String getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(String obraSocial) {
        this.obraSocial = obraSocial;
    }

    public String getRegimen() {
        return regimen;
    }

    public void setRegimen(String regimen) {
        this.regimen = regimen;
    }

    public Date getRegimen_inicio() {
        return regimen_inicio;
    }

    public void setRegimen_inicio(Date regimen_inicio) {
        this.regimen_inicio = regimen_inicio;
    }

    public Date getRegimen_final() {
        return regimen_final;
    }

    public void setRegimen_final(Date regimen_final) {
        this.regimen_final = regimen_final;
    }
     
       
       
       

        


	public float get_condicion_iva(){
		return condicion_iva;
	}

	public String get_dP_calle(){
		return "";
	}

	public String get_dP_localidad(){
		return "";
	}

	public int get_dP_nro(){
		return 0;
	}

	public String get_dP_provincia(){
		return provincia_profesional;
	}

	public String get_email(){
		return email;
	}

	public Date get_fecha_titulo(){
		return fecha_titulo;
	}

	public float get_ingresos_brutos(){
		return ingresos_brutos;
	}

	public int get_tel_profecional(){
		return tel_profesional;
	}

	public String get_titulo(){
		return titulo;
	}

	/**
	 * 
     * @param condicion_iva
	 
	 */
	public void set_condicion_iva(float condicion_iva){
               condicion_iva =condicion_iva;
	}

	/**
	 * 
	 * @param calle
	 */
	public void set_dP_calle(String calle){
            dir_profesional=calle;
	}

	/**
	 * 
	 * @param localidad
	 */
	public void set_dP_localidad(String localidad){
              localidad_profesional=localidad;
	}

	/**
	 * 
	 * @param nro
	 */
	public void set_dP_nro(int nro){
           nro=nro;
	}

	/**
	 * 
	 * @param provincia
	 */
	public void set_dP_provincia(String provincia){
           provincia_profesional=provincia;
	}

	/**
	 * 
	 * @param email
	 */
	public void set_email(String email){
          email=email;
	}

	/**
	 * 
	 * @param fecha_titulo
	 */
	public void set_fecha_titulo(Date fecha_titulo){
             fecha_titulo=fecha_titulo;
	}

	/**
	 * 
	 * @param ingresos_brutos
	 */
	public void set_ingresos_brutos(float ingresos_brutos){

	}

	/**
	 * 
	 * @param tel_prof
	 */
	public void set_tel_profecional(int tel_prof){
           tel_profesional=tel_prof;
	}

    public Persona getFamilar() {
        return familar;
    }

    public void setFamilar(Persona familar) {
        this.familar = familar;
    }

	/**
	 * 
	 * @param titulo
	 */
	public void set_titulo(String titulo){
            titulo=titulo;
	}
        
    /**
     *
     * @param desde
     * @param hasta
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ResultSet altasybajas (String desde, String hasta) throws ClassNotFoundException, SQLException{
        

            cn=  Conexion.getInstance();
            ResultSet rs=null;
            
            rs=cn.Select("SELECT count(estado), estado FROM altabaja WHERE fecha>='"+desde+"' AND fecha<='"+hasta+"' group by estado");
            //rs=cn.Select("SELECT count(estado) as Cantidad, estado as Estado FROM altabaja group by estado");
            return(rs);
        }
    
    
     public ResultSet get_localidadesDB(String provincia) throws ClassNotFoundException, SQLException{
        
            cn=  Conexion.getInstance();
            ResultSet rs=null;
            
            //rs = conexion.Select("SELECT fecha_pedido, CLIENTE_DNI,"
              //  + " CULTIVO_variedad,cantidad_pedida FROM pedido WHERE estado_pedido ='aceptado'"
               // + "AND CULTIVO_nombre_cultivo =  '"+cultivo+"'");
            rs=cn.Select("SELECT nombre FROM Ciudad  WHERE Provincia_nombre = '"+provincia+"'"); // ORDER BY DESC");
            
            return(rs);
        }
  
    public ResultSet get_provinciasDB() throws ClassNotFoundException, SQLException{
        
            cn=  Conexion.getInstance();
            ResultSet rs=null;
            
                    rs=cn.Select("SELECT nombre FROM Provincia ");//ORDER BY DESC");
            
            
            return(rs);
        }
    
    
    
    public ResultSet get_regimenDB() throws ClassNotFoundException, SQLException{
        
            cn=  Conexion.getInstance();
            ResultSet rs=null;
            

                    rs=cn.Select("SELECT nombre FROM regimen ");

            
            return(rs);
        }
    
    
     public ResultSet get_obraSocialDB() throws ClassNotFoundException, SQLException{
        
            cn=  Conexion.getInstance();
            ResultSet rs=null;
            
                    rs=cn.Select("SELECT nombre FROM ObraSocial");
            
            
            return(rs);
            
        }
    
    
      public void guardar() throws ClassNotFoundException, SQLException{
        
            cn=  Conexion.getInstance();
            ResultSet rs=null;
         
            System.out.println("++++++"+get_cuit()+get_nombre()+get_apellido());
            
           String cadena="SELECT idDirecciones FROM direcciones ORDER BY idDirecciones DESC LIMIT 1";
           
           rs=cn.Select(cadena);
          
           rs.first();
          // if(rs!=null)
         //  System.out.println("+id+"+rs.getObject(1));
           int dir= Integer.parseInt(rs.getObject(1).toString())+ 1;
           
           cadena="INSERT INTO direcciones(calle, nro, tel, mail, tipo, idDirecciones) "
                    + "VALUES ('"+get_dR_Calle()+"','"+get_dR_Nro()+"','"+get_telefono_particualr()+"',"
                     + "'"+get_email()+"','REAL','"+dir+"')";
            
      cn.Insert(cadena);
            
            System.out.println(get_cuit()+" "+get_cuit()+" "+get_nombre()+" "+get_apellido()+" "+get_fechanac()+" "+dir);
            
             cadena="INSERT INTO abogado"
                    + "(cuil,codprof, nombre, apellido,Universidad_idUniversidad,fecha_nac,ObraSocial_idObraSocial,RegimenPrevisional_idRegimenPrevisional,Direcciones_idDirecciones)"
                    + "VALUES ('"+get_cuit()+"','"+get_cuit()+"','"+get_nombre()+"','"+get_apellido()+"','1',"
                    + "'"+get_fechanac()+"','1','1','"+dir+"')";               
          
             
             
             
       cn.Insert(cadena);
           
             int cuit= (int) (get_cuit()+1);
           cadena="INSERT INTO familiar (`nombre`, `apellido`, `cuil`, `tipo_familiar`)"
                   + " VALUES ('"+familar.get_nombre()+"','"+familar.get_apellido()+"','"+cuit+"','"+familar.getTipo_familiar()+"')";
            System.out.println(familar.get_nombre()+familar.get_apellido()+familar.getTipo_familiar()+cuit);
            
        cn.Insert(cadena);
      
      }

   public ResultSet buscar (String desde, String hasta) throws ClassNotFoundException, SQLException{
        

            cn=  Conexion.getInstance();
            ResultSet rs=null;
            
            rs=cn.Select("SELECT count(estado), estado FROM altabaja WHERE fecha>='"+desde+"' AND fecha<='"+hasta+"' group by estado");
            //rs=cn.Select("SELECT count(estado) as Cantidad, estado as Estado FROM altabaja group by estado");
            return(rs);
        }

     
}

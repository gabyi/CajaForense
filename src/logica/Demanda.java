/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import Utilidad.Utilidad;
import java.sql.ResultSet;
import java.sql.SQLException;
import persistencia.Conexion;

/**
 *
 * @author jau
 */
public class Demanda {

	private boolean caja_inicio_ap;
	private boolean caja_inicio_cont;
	private float caja_inicio_prop_ap;
	private float caja_inicio_prop_cont;
	private int id;
	private String materia;
	private float monto;
	public Persona actor;
	public Persona demandado;
        String fecha;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
        

    public boolean isCaja_inicio_ap() {
        return caja_inicio_ap;
    }

    public void setCaja_inicio_ap(boolean caja_inicio_ap) {
        this.caja_inicio_ap = caja_inicio_ap;
    }

    public boolean isCaja_inicio_cont() {
        return caja_inicio_cont;
    }

    public void setCaja_inicio_cont(boolean caja_inicio_cont) {
        this.caja_inicio_cont = caja_inicio_cont;
    }

    public float getCaja_inicio_prop_ap() {
        return caja_inicio_prop_ap;
    }

    public void setCaja_inicio_prop_ap(float caja_inicio_prop_ap) {
        this.caja_inicio_prop_ap = caja_inicio_prop_ap;
    }

    public float getCaja_inicio_prop_cont() {
        return caja_inicio_prop_cont;
    }

    public void setCaja_inicio_prop_cont(float caja_inicio_prop_cont) {
        this.caja_inicio_prop_cont = caja_inicio_prop_cont;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Persona getActor() {
        return actor;
    }

    public void setActor(Persona actor) {
        this.actor = actor;
    }

    public Persona getDemandado() {
        return demandado;
    }

    public void setDemandado(Persona demandado) {
        this.demandado = demandado;
    }

	public Demanda(){

	}

   public ResultSet buscarDemanda(String dato) throws ClassNotFoundException, SQLException{
   
            Conexion cn = Conexion.getInstance();
       ResultSet rs=null;
       
     
       String aux="%"+dato+"%";
       String[] cadena= Utilidad.cortarCadenaPorEspacios(dato);
     System.out.println("leng .... 1 "+dato);
       
//       if(dato.length()>0){
               
     rs= cn.Select("SELECT * FROM valorescajarentas WHERE materia LIKE '"+aux+"'");
          System.out.println("leng .... 1 "+dato);

       
       if(rs.getRow()>0){
       rs.first();
           System.out.println("rs- "+rs.getString(1));
       }
    
       return(rs);
   
   }
        
  public void guardarDamanda(Afiliado afiliado,Persona demandado,Persona actor) throws ClassNotFoundException, SQLException{
  
     Conexion cn = Conexion.getInstance();
     ResultSet rs=null;
     
       // rs=cn.Select("")
  
     
         cn.Insert("INSERT INTO `boletas` (`idBoletas`, `ValoresCajaRentas_id`, `fecha`, `monto_juicio`, `monto_aportes`, `monto_contrubu`, `actor`, `demandado`) "
                 + "VALUES ('SELECT COUNT(`idBoletas`) FROM `boletas`'+1, '"+id+"','"+fecha+"','"+monto+"', '"+caja_inicio_ap+"', '"+caja_inicio_cont+"', '"+actor.get_nombre()+"', '"+demandado.get_nombre()+"')");
          //System.out.println("leng .... 1 "+dato);
     
  }
        
}

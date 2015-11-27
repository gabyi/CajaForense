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
public class Afiliado extends Abogado {
    
  String cod_profecional;

    public Afiliado() {
    }

    public String getCodigo_profecional() {
        return cod_profecional;
    }

    public void setCodigo_profecional(String codigo_profecional) {
        this.cod_profecional = codigo_profecional;
    }
    
    
    
    
    public ResultSet buscarAfiliado (String dato) throws ClassNotFoundException, SQLException{
   
       cn =Conexion.getInstance();
       ResultSet rs=null;
       
     
       String aux="%"+dato+"%";
       String[] cadena= Utilidad.cortarCadenaPorEspacios(dato);
     
       if(cadena.length==1){
               
     rs= cn.Select("SELECT nombre, apellido, codprof FROM abogado WHERE nombre LIKE '"+aux+"' or apellido LIKE '"+aux+"'");
         }
       if(cadena.length>1){
           
           System.out.println("leng > 1 "+cadena[0]);
       rs= cn.Select("SELECT nombre, apellido, codprof FROM abogado WHERE nombre LIKE '%"+cadena[1]+"%' and apellido "
               + "LIKE '%"+cadena[0]+"%' OR apellido LIKE '%"+cadena[1]+"%' and nombre LIKE '%"+cadena[0]+"%'");
       
       }
    
       return(rs);
   }
    
    
    
    
    
    
}

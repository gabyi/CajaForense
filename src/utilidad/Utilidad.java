/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidad;


import com.toedter.calendar.JDateChooser;
import datechooser.beans.DateChooserCombo;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.MessageDigest;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jau
 */
public class Utilidad {
    /**
     * Metodo que devuelve si un String contiene unicamente numeros.
     * @param rs
     * @return true(Si la cadena es de numeros) ! false(si la cadena contiene algun letra o caracter)
     * @throws java.sql.SQLException
     */
    
    
    /*
    *Calcula la cantidad de elementos que iene una consulta sql a tabla
    *
    *
    */
    
    public static int cantidadElementos(ResultSet rs) throws SQLException{
        int i=0;
        while(!rs.isLast()){  
                  i++;
                  rs.next();}
        return i;
    
    }
    
            
    
    
    public static boolean isNumero(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }

    /**
     * Metodo que comprueba la estructura de un DNI cumpliendo la restricion de 8 digitos y que sea unicamente numero.
     * @param String
     * @return True o False - ( boolean)
     */
    public boolean validarDNI(String dni){
    boolean ban;
        if((dni.length()<7 || dni.length()>8 )|| !isNumero(dni)){
         ban=true;
        }else{
            ban=false;
        }       
        return(ban);
    }
    /**
     * Metodo q comprueba si un String esta compuesto unicamente de caracteres no numericos, o simbolos.
     * @param String
     * @return Boolean 
     */
    public static boolean esPalabra(String a){
     boolean ban=true;
       for(int i=0;i<a.length();i++){
            if(!Character.isLetter(a.charAt(i))) {
                ban = false;
            }
       }    
    return ban;
    }
   
    /**
     * Metodo q comprueba la estructura de un mail
     * @param correo
     * @return boolean
     */
    public static boolean isEmail(String correo) {
        Pattern pat;
        Matcher mat;        
        pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        mat = pat.matcher(correo);
        if (mat.find()) {
            System.out.println("[" + mat.group() + "]");
            return true;
        }else{
            return false;
        }        
    }
    /**
     * Metodo que verifica de una fecha tiene el formato especificado.
     * @param fechax
     * @return boolean
     */
    public static boolean isDate(String fechax) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/mm/yyyy");
            Date fecha = (Date) formatoFecha.parse(fechax);
        } catch (Exception e) {
            return false;
        }
        return true;
    } 
    
    
    public static Object getData(JTable table, int row_index, int col_index){
        return table.getModel().getValueAt(row_index, col_index);
        } 
    
    
    /**
     * Metodo que construye un DefaultTableModel mediante un ResultSet. construye una tabla
     * dependiendo de como se realice la consulta a la base de datos, cargando en el DefaultTableModel,
     * los encabezados y datos de la consulta.
     * @param ResultSet
     * @return DefaultTableModel
     */
    public static DefaultTableModel crearTabla(ResultSet rs) {
        
    DefaultTableModel modelo=new DefaultTableModel();
   
       
      try {
             if(rs!=null){   
            ResultSetMetaData rsMd = rs.getMetaData();
        //La cantidad de columnas que tiene la consulta
            int cantidadColumnas = rsMd.getColumnCount();
             
        //Establecer como cabezeras el nombre de las colimnas
            for (int i = 1; i <= cantidadColumnas; i++) {
                modelo.addColumn(rsMd.getColumnLabel(i));
            } 
        //Creando las filas para el JTable
           rs.first();
           
           while(!rs.isAfterLast()){
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i]=rs.getObject(i+1); 
                }
                 
                modelo.addRow(fila);
                rs.next();
            }
             }
            } catch (Exception ex) {
    
            System.out.println("Nose pudo crear la tabla en utilidad: "+ex.getMessage());
            return modelo;
            }
            return modelo;
 
    }
    
    
    
    /**
     * Metodo que construye un DefaultTableModel mediante un ResultSet. construye una tabla
     * dependiendo de como se realice la consulta a la base de datos, cargando en el DefaultTableModel,
     * los encabezados y datos de la consulta.
     * @param ResultSet
     * @return DefaultTableModel
     */
    public static DefaultTableModel crearTablaAportes(ResultSet rs) {
        
    DefaultTableModel modelo=new DefaultTableModel();

      
      try {
           //Creando las filas para el JTable
          String monto, porcentaje; 
          float total=0;
           while(rs.next()){
               
               monto= rs.getString("monto");
               porcentaje= rs.getString("porcentaje");
               Float aporte= (Float.parseFloat(monto)*Float.parseFloat(porcentaje))/100;
               DecimalFormat formateador = new DecimalFormat("###.##");
               String particip = formateador.format(aporte);
               total= total + Float.parseFloat(monto);
               modelo.addRow(new Object []{rs.getObject("fecha"),rs.getObject("idBoleta"), rs.getObject("juicio"),particip});
   
           }
              //  Object[] fila = new Object[cantidadColumnas];
              //  for (int i = 0; i < cantidadColumnas; i++) {
               //     fila[i]=rs.getObject(i+1); 
                     
             
            } catch (Exception ex) {
    
            System.out.println("Nose pudo crear la tabla en utilidad: "+ex.getMessage());
            return modelo;
            }
            return modelo;
 
    }
    
public static DefaultListModel crearLista(ResultSet rs) {
        
    DefaultListModel modelo=new DefaultListModel();
          
        try {
             if(rs!=null){   
            ResultSetMetaData rsMd = rs.getMetaData();
        //La cantidad de columnas que tiene la consulta
            int cantidadColumnas = rsMd.getColumnCount();
        /*
        ///*Establecer como cabezeras el nombre de las colimnas
            for (int i = 1; i <= cantidadColumnas; i++) {
                modelo.addColumn(rsMd.getColumnLabel(i));
            } 
        //Creando las filas para el JTable
           */
            rs.first();
           
           while(!rs.isAfterLast()){
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i]=rs.getObject(i+1); 
                }
                 
                modelo.addElement(fila);
                rs.next();
            }
             }
            } catch (Exception ex) {
    
            System.out.println("Nose pudo crear la lista:"+ex.getMessage());
            return modelo;
            }
            return modelo;
 
    }
    
public static String encriptarMD5(String palabra){ 
String pe=""; 
try { 
pe = hash(palabra); 
} 
catch (Exception e) { 
    
} 
return pe; 
} 

private static String hash(String clear) throws Exception { 
MessageDigest md = MessageDigest.getInstance("MD5"); 
byte[] b = md.digest(clear.getBytes()); 
int size = b.length; 
StringBuffer h = new StringBuffer(size); 
for (int i = 0; i < size; i++) { 
int u = b.length; 
if (u<16) {
    h.append("0"+Integer.toHexString(u)); 
}else { 
h.append(Integer.toHexString(u)); 
} 
} 
return h.toString(); 
}

/**
 * Metodo q carga un JComboBox (pasado por parametro) con un ResultSet, este metodo toma la primera columna
 * del ResultSet y la vuelca sobre el JComboBox
 * @param JComboBox
 * @param ResultSet
 */
public static void cargarJComboBox(javax.swing.JComboBox c,java.sql.ResultSet rs){
    if(rs!=null){
    c.setModel(crearModeloComobobox(rs));
    try{
        if(rs!=null && rs.next()){
            c.setSelectedIndex(0);
        }
    }catch(SQLException e){
    }
    }
    }


private static DefaultComboBoxModel crearModeloComobobox(ResultSet rs){
    DefaultComboBoxModel cbm=new DefaultComboBoxModel();
    
     try {
            /*en este parte se cargan en la interfece todos los tipos de cuenta existentes en la base de datos*/
           if(rs!=null){     
            rs.first();  
            int i=0;
            while(!rs.isAfterLast()){
                cbm.addElement(rs.getString(1));
                rs.next();
            }
           }} catch (SQLException ex) {
        }    
  return(cbm);
}


/**
 * Metodo q pasa un tipo de dato String a otro tipo de dato Date.
     * @param jDatefecha
 * @param String
 * @return Date
 */

public static java.sql.Date DeStringADate(String fecha){
        java.sql.Date fecFormatoDate = null;
      try {
      SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-mm-dd", new Locale("es", "ES"));
      fecFormatoDate = new java.sql.Date(sdf.parse(fecha).getTime());
      System.out.println("Fecha con el formato java.sql.Date: " + fecFormatoDate);
} catch (Exception ex) {
      System.out.println("Error al obtener el formato de la fecha/hora: " + ex.getMessage());
}
      return(fecFormatoDate);
    } 

 public static boolean areEqualDays(Calendar c1, Calendar c2) {
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    
    // System.out.println("ss "+getAnio(Date.valueOf(convertToSqlDate(c1))));//+getAnio(c2));//convertToSqlDate(c1).equals(convertToSqlDate(c2)));
    
    return (sdf.format(c1.getTime()). equals(sdf.format(c2.getTime())));
}



 public static String convertToSqlDate(Calendar date){
     
        String dia= Integer.toString(date.get(Calendar.DAY_OF_MONTH));
        String mes= Integer.toString(date.get(Calendar.MONTH)+1);
        String anio= Integer.toString(date.get(Calendar.YEAR));
        String fecha=anio+"-"+mes+"-"+dia;
     
        return fecha; 
}


/**
 * Metodo que devuelve el mes de una fecha determinada
 * @param Date
 * @return Integer
 */
public static Integer getMes(java.sql.Date fecha){
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(fecha);
        int month = cal.get(java.util.Calendar.MONTH);
    
    return month+1;
}
/**
 * Metodo que devuelve el año de una fecha determinada
 * @param Date
 * @return Integer
 */
public static Integer getAnio(java.sql.Date fecha){
    java.util.Calendar cal = java.util.Calendar.getInstance();
    
        cal.setTime(fecha);
        int years = cal.get(java.util.Calendar.YEAR);
    
    return years;
}

public static void soloNumeros(javax.swing.JTextField jT){
 jT.addKeyListener(new KeyAdapter() {
@Override
public void keyTyped(KeyEvent e) {
char c = e.getKeyChar();
if (!(Character.isDigit(c) ||
(c == KeyEvent.VK_BACK_SPACE) ||
(c == KeyEvent.VK_DELETE))) {
 //  getToolkit().beep();
e.consume();
}
}
});
}




 public static void cargarLista(ArrayList<Object>  obj,JList lista){
   
DefaultListModel modelo = new DefaultListModel();
for(int i = 0; i<obj.size(); i++){
        modelo.addElement(obj.get(i));
        System.out.println("<<<<< "+obj.get(i));
}

lista.setModel(modelo);
 
 
 }  
   
public static String[] cortarCadenaPorEspacios(String cadena) {
  return cadena.split("\\s+");
}



}

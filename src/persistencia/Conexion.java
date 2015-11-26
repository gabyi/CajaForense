/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
    
    static Connection con; // atribut per a guardar l’objecte connexió.
    private static Conexion INSTANCE = null;

   Statement stm;
   
   Connection conn = null;
   
   public Conexion() throws ClassNotFoundException, SQLException{
       performConnection();
   }
   
   //crea un ainstancia de la conexion de no estar creada
   private synchronized static void createInstance() throws ClassNotFoundException, SQLException {
      if (INSTANCE == null) {
          INSTANCE = new Conexion();
       }
    }
   
   /**Metodo para retorna una instancia de la conexion. Si no esta creada la crea, y si esta creada la retorna
     * @return retorna una instancia de la conexión a la base de datos
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public static Conexion getInstance() throws ClassNotFoundException, SQLException {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
    
    
    /**Método para eliminar la instancia de la conexión
     *
     */
    public static void delInstance() {
        INSTANCE = null;
        closeConnection();
    }
 
    
    /**Método para cerrar la conexión con la base de dades
     *
     */
    public static void closeConnection() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexión.");
        }
    }

    /**
     *
     */
    public void performConnection(){
        String bd = "sql294149"; 
        String login = "sql294149";
        String password = "GabyJorge";
        String url = "jdbc:mysql://www.db4free.net/"+bd;
        
        
        try{
         //Se obtiene el driver de para mysql
         Class.forName("org.gjt.mm.mysql.Driver");
         //Instanciar la conexión
         conn = DriverManager.getConnection(url,login,password);
         stm= conn.createStatement();
         if (conn!=null){
            System.out.println("Conexion a base de datos "+bd+" OK");
         }
      } catch(ClassNotFoundException e){

         System.out.println(e);
         
      } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
 
 
  
    
   //para consultas de recuperación
public ResultSet Select (String SelectSql) {
 
     ResultSet rs=null;
    try {
             rs=stm.executeQuery(SelectSql);     
                  
   } catch (SQLException e) {
      e.printStackTrace();
        return null;
   }       
   return rs;
}

//para consultas de insert
   
 public  boolean Insert(String query){
  boolean resul=true;
  try{
   stm.executeUpdate(query); 
   }
catch(Exception e){ resul=false;
   return resul;
   }
 return resul;
 } 

 //para consultas de actualización (modificación)  
  public boolean Update(String update){
       boolean resul=false;
      try{
          stm.executeUpdate(update);
          resul=true;
      }catch(SQLException e){
          return(resul);
      } 
       return resul;
   }
   
  
    
}

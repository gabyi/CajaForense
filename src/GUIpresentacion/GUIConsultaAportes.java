/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIpresentacion;

import Utilidad.Utilidad;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.Abogado;

/**
 *
 * @author gabriel
 */
public class GUIConsultaAportes extends javax.swing.JPanel {

    Abogado ab;
    ResultSet rs;
    String dato;
    TextAutoCompleter abnombres;
    float totalAportes=0;
    /**
     * Creates new form GUIConsultaAportes
     */
    public GUIConsultaAportes() {
        initComponents();
        ab=new Abogado();
        texnombre.requestFocus();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        texnombre = new javax.swing.JTextField();
        titulo_altas = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        buscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaaportes = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        ltotal = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(910, 559));

        texnombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        texnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                texnombreKeyReleased(evt);
            }
        });

        titulo_altas.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        titulo_altas.setText("Consulta de Aportes Previsionales");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Apellido del Profesional: ");

        buscar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        buscar.setText("Buscar Profesional");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        tablaaportes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Nro Boleta", "Tipo de Juicio", "Aporte"
            }
        ));
        jScrollPane2.setViewportView(tablaaportes);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Total de Aportes:  $");

        ltotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ltotal.setText("0,00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(titulo_altas)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(texnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buscar)
                .addContainerGap(129, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(289, 289, 289))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titulo_altas)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(texnombre)
                                .addComponent(buscar)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ltotal))
                .addGap(308, 308, 308))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        /*crear ventana flotante
        JDialog ventanita= new JDialog();
        ventanita.setVisible(true);
        ventanita.add(busquedaprof);
        ////ver biennnnnn*/
        
        
        if(texnombre.isEditable()){
        texnombre.setEditable(false);
        buscar.setText("Volver a Buscar");
        llenartabla();
        totalanual();
        }else{
        texnombre.setEditable(true);
        texnombre.setText("");
        buscar.setText("Buscar Profesional");
        }
    }//GEN-LAST:event_buscarActionPerformed

    private void texnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_texnombreKeyReleased
        autocompletarAbogado();
    }//GEN-LAST:event_texnombreKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel ltotal;
    private javax.swing.JTable tablaaportes;
    private javax.swing.JTextField texnombre;
    private javax.swing.JLabel titulo_altas;
    // End of variables declaration//GEN-END:variables
  
  public void llenartabla (){        

        DefaultTableModel table = new DefaultTableModel();
        
        ResultSet rs=null;
                
            try {
                rs=ab.consultaaportes(texnombre.getText());
                table=Utilidad.crearTablaAportes(rs, (DefaultTableModel) tablaaportes.getModel());
                
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(GUIInformeAltasBajas.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
            tablaaportes.setModel(table);
  }
  
  
  public void totalanual(){
      int cant= tablaaportes.getRowCount();
      System.out.println(cant+"cantidad de filas en consulta aportes");
      
      for (int i = 0; i < cant; i++) {
          totalAportes+= Float.parseFloat((String) tablaaportes.getValueAt(i,3));
      }
      
     ltotal.setText(String.valueOf(totalAportes));
      System.out.println(totalAportes); 
      System.out.println(tablaaportes.getValueAt(0,3));
  }
  
  
  public void autocompletarAbogado() {
   abnombres= new TextAutoCompleter(texnombre);
        
         String cadena = texnombre.getText();
         abnombres.setMode(0);//busca en toda la oracion

       cadena = texnombre.getText();
      
       System.out.println("escribo: "+cadena);
          
    if(cadena.length()>0){    
       try {
           ResultSet rs=null;
             System.out.println("---------: "+cadena);
             rs=ab.buscarabogado(cadena);
           
        rs.first();  
         if(rs.getRow()>0){
           rs.first();  
          
            while( !rs.isAfterLast()){//.!=null){// !rs..isLast()){
            
           abnombres.addItem( rs.getString("apellido")+' '+rs.getString("nombre")+' '+rs.getString("codprof"));
             
                rs.next();
            }}
    
       } catch (ClassNotFoundException | SQLException ex) {
           Logger.getLogger(GUIConsultaAportes.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       
          }
    
        //System.out.println("---selccionado: "+abnombres.getItemSelected());
  
        }
    
    
    
}
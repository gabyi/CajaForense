/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIpresentacion;


import com.mxrck.autocompleter.TextAutoCompleter;


import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import logica.Abogado;
import logica.Afiliado;
import logica.Demanda;
import logica.Persona;

/**
 *
 * @author gabriel
 */
public class GUIInicioJuicio extends javax.swing.JPanel {
Afiliado afiliado;
TextAutoCompleter nombres,juicios;
Demanda demanda;
ResultSet rst=null;
Abogado ab;
Persona actor, demandado;
    /**
     * Creates new form GUIInicioJuicio
     */
    public GUIInicioJuicio() {
        initComponents();
         actor=new Persona();
         demandado=new Persona();
         afiliado=new Afiliado();
         demanda=new Demanda();
       //  ab=new Abogado();
        fechaactual();
        
         System.out.println("----");
        if(this.isOpaque()){
            System.out.println("asdasdasd");
            texnombreJuicio.setRequestFocusEnabled(true);
    
    }
        
        addMouseListener(null);
        
    }
  
   

    
    
    private float calcularParticipacion(int participantes){
    
    return 100/(float)participantes;
    }
    
    public void addAfiliado(){
        
    DefaultTableModel modelo = (DefaultTableModel) tablaAsociados.getModel();
    
    String campo=texnombreJuicio.getText(),celdaNombre = "";
    String[] celdas=Utilidad.Utilidad.cortarCadenaPorEspacios(campo);
    int ultimoIndex=celdas.length-1,row=modelo.getRowCount()+1;
    float participacion=calcularParticipacion(modelo.getRowCount()+1);
    
   
    DecimalFormat formateador = new DecimalFormat("###.##");

 String particip = formateador.format(participacion);
    
    
     
      // JTF_SubtotalProd.setText(String.valueOf(Double.valueOf(formateador.format(subtotal))));       
   
    for(int i=0;i<celdas.length-1;i++){
    celdaNombre=celdaNombre+" "+celdas[i];
        }
    
    
    for(int j = 0;j<modelo.getRowCount();j++ ){
    modelo.setValueAt(particip,j, modelo.findColumn("Participacion (%)"));
    
    
    }
    
    
    if(celdas.length>0){
        System.out.println("- "+row+"- "+modelo.findColumn("Codigo Profecional"));
   
        modelo.addRow(new Object[]{celdas[ultimoIndex],celdaNombre,particip});
//        modelo.setValueAt(celdas[ultimoIndex],row, modelo.findColumn("Codigo Profecional"));
//    modelo.setValueAt(celdaNombre, modelo.findColumn("Nombre"), row);
//    modelo.setValueAt("nada", modelo.findColumn("Participacion"), row);
    }
   
    tablaAsociados.setModel(modelo);
    }
    

    
    public void autocompletarAfiliado() {
   nombres= new TextAutoCompleter(texnombreJuicio);
        
         String cadena = texnombreJuicio.getText();
         nombres.setMode(0);//busca en toda la oracion

       cadena = texnombreJuicio.getText();
      
       System.out.println("escribo: "+cadena);
          
    if(cadena.length()>0){    
       try {
           ResultSet rs=null;
              System.out.println("---------: "+cadena);
             rs=afiliado.buscarAfiliado (cadena);
           
        rs.first();  
         if(rs.getRow()>0){
           rs.first();  
          
            while( !rs.isAfterLast()){//.!=null){// !rs..isLast()){
            
           nombres.addItem( rs.getString("apellido")+' '+rs.getString("nombre")+' '+rs.getString("codprof"));
             
                rs.next();
            }}
    
       } catch (ClassNotFoundException | SQLException ex) {
           Logger.getLogger(GUIConsultaAportes.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       
          }
    
        System.out.println("---selccionado: "+nombres.getItemSelected());
  
        }
    
    
    
    
    
     public void autocompletarJuicio() {
   juicios = new TextAutoCompleter(textjuicio);
        
         String cadena = textjuicio.getText();
         juicios.setMode(0);//busca en toda la oracion

       cadena = textjuicio.getText();
      
       System.out.println("escribo: "+cadena);
          
    if(cadena.length()>0){    
       try {
           ResultSet rs=null;
              System.out.println("---------: "+cadena);
             rs=demanda.buscarDemanda(cadena);
           
        rs.first();  
         if(rs.getRow()>0){
           rs.first();  
          
            while( !rs.isAfterLast()){//.!=null){// !rs..isLast()){
            
           juicios.addItem( rs.getString("materia"));
             
                rs.next();
            }}
    
       } catch (ClassNotFoundException | SQLException ex) {
           Logger.getLogger(GUIConsultaAportes.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       
          }
    
        System.out.println("---selccionado: "+juicios.getItemSelected());
  
        }
    
    
    
   private void guardarInicioJuicio(){
   // String 
   actor.set_nombre(texActorNombre.getText());
   actor.set_apellido(textactorApellido.getText());
   demandado.set_nombre(textDemandadoNombre.getText());
   demandado.set_apellido(textDemandadoApellido.getText());
   
   if(textmonto.getText().length()>0){
   demanda.setMonto(Float.parseFloat(textmonto.getText()));
   }else
      demanda.setMonto(0);
   
   
   }
   
   
   private void calcularAporte() throws ClassNotFoundException, SQLException{
   
   if(textjuicio.getText().length()>0 && textmonto.getText().length()>0){
   
   ResultSet rs=null;
   rs=demanda.buscarDemanda(textjuicio.getText());
   rs.first();
   
   if(rs!=null){
   /////aporte
   
       if(rs.getObject("caja_inicio_ap_porc")==null){
//       
//        Float aporte = rs.getObject("caja_inicio_ap_porc")
//           
//       la
       
       
       
       }
   
   
   
   
   
   
   
   }
   
   System.out.println("row- "+rs.getString(1));
   }
  
   }
   
   
    
  
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        titulo_altas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        observaciones = new javax.swing.JTextArea();
        labelobserv = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        labelprof = new javax.swing.JLabel();
        texnombreJuicio = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaAsociados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        labelActor = new javax.swing.JLabel();
        textactorApellido = new javax.swing.JTextField();
        labeldemandado = new javax.swing.JLabel();
        textDemandadoApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textjuicio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textmonto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        textexpte = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        textautos = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        combojuz = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        labelimportea = new javax.swing.JLabel();
        labelimporteb = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        labeltotalb = new javax.swing.JLabel();
        labeltotala = new javax.swing.JLabel();
        totalgral = new javax.swing.JLabel();
        impimir = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        fecha = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        texActorNombre = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        textDemandadoNombre = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        jButton2.setText("jButton2");

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo_altas.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        titulo_altas.setText("Inicio de Juicio");
        add(titulo_altas, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, -1, 30));

        observaciones.setColumns(20);
        observaciones.setRows(5);
        jScrollPane1.setViewportView(observaciones);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, 310, -1));

        labelobserv.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelobserv.setText("Observaciones");
        add(labelobserv, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, -1, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 830, 12));

        labelprof.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelprof.setText("Profesional:");
        add(labelprof, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        texnombreJuicio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        texnombreJuicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                texnombreJuicioKeyReleased(evt);
            }
        });
        add(texnombreJuicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 322, 30));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, 117, -1));

        tablaAsociados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Profesional", "Nombre", "Participacion (%)"
            }
        ));
        tablaAsociados.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(tablaAsociados);
        tablaAsociados.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 82, 580, 90));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Caratula");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 110, -1));

        labelActor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelActor.setText("Actor: ");
        add(labelActor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, -1, -1));

        textactorApellido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textactorApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textactorApellidoActionPerformed(evt);
            }
        });
        add(textactorApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 208, 143, -1));

        labeldemandado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labeldemandado.setText("Demandado: ");
        add(labeldemandado, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        textDemandadoApellido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(textDemandadoApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 257, 144, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Juicio: ");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 320, -1, -1));

        textjuicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textjuicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textjuicioKeyReleased(evt);
            }
        });
        add(textjuicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 321, 480, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Monto: ");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 357, -1, -1));

        textmonto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textmonto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textmontoFocusLost(evt);
            }
        });
        add(textmonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 356, 480, 23));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Expediente: ");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 390, -1, -1));

        textexpte.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(textexpte, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 390, 480, 23));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Juzgado: ");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 427, -1, -1));

        textautos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(textautos, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 461, 480, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("En autos: ");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 461, -1, 14));

        combojuz.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        combojuz.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "General Pico", "Santa Rosa", "Castex" }));
        combojuz.setSelectedIndex(-1);
        add(combojuz, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 424, 480, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Fecha: ");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, -1, -1));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 29, 16, 570));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Importes a pagar");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 200, -1, -1));

        labelimportea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelimportea.setText("Art 41 inciso a) Ley 1861 $");
        add(labelimportea, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 240, 220, -1));

        labelimporteb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelimporteb.setText("Art 41 inciso b) Ley 1861 $");
        add(labelimporteb, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 280, 220, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Total $");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 340, 60, -1));
        add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 320, 310, 10));

        labeltotalb.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labeltotalb.setText("-");
        add(labeltotalb, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 280, 70, -1));

        labeltotala.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labeltotala.setText("-");
        add(labeltotala, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 240, 70, -1));

        totalgral.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        totalgral.setText("jLabel9");
        add(totalgral, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 340, 100, -1));

        impimir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        impimir.setText("Imprimir");
        add(impimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 460, -1, -1));

        guardar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 460, -1, -1));

        cancelar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cancelar.setText("Cancelar");
        add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 460, -1, -1));

        fecha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fecha.setText("10/05/2015");
        add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 0, 100, -1));

        jLabel9.setText("Apellido");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 218, 50, -1));

        texActorNombre.setFont(new java.awt.Font("Tahoma", 0, 18));
        texActorNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texActorNombreActionPerformed(evt);
            }
        });
        add(texActorNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, 166, 28));

        jLabel10.setText(" Nombre");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 47, 20));

        jLabel12.setText("Apellido");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 267, -1, -1));

        textDemandadoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDemandadoNombreActionPerformed(evt);
            }
        });
        add(textDemandadoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 257, 166, 30));

        jLabel13.setText(" Nombre");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(379, 267, 47, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void texnombreJuicioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_texnombreJuicioKeyReleased
        // TODO add your handling code here:
       
        autocompletarAfiliado();
        
    }//GEN-LAST:event_texnombreJuicioKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        addAfiliado();
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
        
        guardarInicioJuicio();
    }//GEN-LAST:event_guardarActionPerformed

    private void texActorNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texActorNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texActorNombreActionPerformed

    private void textactorApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textactorApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textactorApellidoActionPerformed

    private void textDemandadoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDemandadoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDemandadoNombreActionPerformed

    private void textjuicioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textjuicioKeyReleased
        // TODO add your handling code here:
        
        autocompletarJuicio();
        
        
    }//GEN-LAST:event_textjuicioKeyReleased

    private void textmontoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textmontoFocusLost
    try {
        // TODO add your handling code here:
        calcularAporte();
        System.out.println("Monto");
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(GUIInicioJuicio.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(GUIInicioJuicio.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_textmontoFocusLost
  public void fechaactual(){
    Calendar c1 = Calendar.getInstance();
    Calendar c2 = new GregorianCalendar();
    String dia = Integer.toString(c1.get(Calendar.DATE));
    String mes = Integer.toString(c1.get(Calendar.MONTH)+1);
    String annio = Integer.toString(c1.get(Calendar.YEAR));
    
    fecha.setText(dia+"/"+mes+"/"+annio);
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JComboBox combojuz;
    private javax.swing.JLabel fecha;
    private javax.swing.JButton guardar;
    private javax.swing.JButton impimir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel labelActor;
    private javax.swing.JLabel labeldemandado;
    private javax.swing.JLabel labelimportea;
    private javax.swing.JLabel labelimporteb;
    private javax.swing.JLabel labelobserv;
    private javax.swing.JLabel labelprof;
    private javax.swing.JLabel labeltotala;
    private javax.swing.JLabel labeltotalb;
    private javax.swing.JTextArea observaciones;
    private javax.swing.JTable tablaAsociados;
    private javax.swing.JTextField texActorNombre;
    private javax.swing.JTextField texnombreJuicio;
    private javax.swing.JTextField textDemandadoApellido;
    private javax.swing.JTextField textDemandadoNombre;
    private javax.swing.JTextField textactorApellido;
    private javax.swing.JTextField textautos;
    private javax.swing.JTextField textexpte;
    private javax.swing.JTextField textjuicio;
    private javax.swing.JTextField textmonto;
    private javax.swing.JLabel titulo_altas;
    private javax.swing.JLabel totalgral;
    // End of variables declaration//GEN-END:variables

    private static class addFocusListener {

        public addFocusListener() {
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIpresentacion;
import Utilidad.Utilidad;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import logica.Abogado;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import persistencia.Conexion;
/**
 *
 * @author gabriel
 */
public class GUIInformeAltasBajas extends javax.swing.JPanel {

        Abogado ab;
        JFreeChart chart;
        DefaultPieDataset pieDataset;
        PiePlot p;
        int anio1, anio2,anio_actual;
        Calendar fecha; 
        DefaultCategoryDataset datos;
    /**
     * Creates new form AltasBajas
     */
    public GUIInformeAltasBajas() {
            try {
                Conexion cn = Conexion.getInstance();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(GUIInformeAltasBajas.class.getName()).log(Level.SEVERE, null, ex);
            }

       
        initComponents();

            
        initComponents();ab=new Abogado();
        tabla.setRowHeight(25);
        

        tabla.setEnabled(false);
            
    }
   
    public DefaultTableModel mostrar (){
        

        DefaultTableModel table = new DefaultTableModel();
        
        ResultSet rs=null;
        String a=Utilidad.convertToSqlDate(fecha_desde.getSelectedDate());
        String b=Utilidad.convertToSqlDate(fecha_hasta.getSelectedDate());
                
            try {
                rs=ab.buscar(a,b);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(GUIInformeAltasBajas.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            table=Utilidad.crearTabla(rs);
            
            return(table);
        }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        altasybajas = new javax.swing.JPanel();
        titulo_altas = new javax.swing.JLabel();
        label_desde = new javax.swing.JLabel();
        fecha_desde = new datechooser.beans.DateChooserCombo();
        label_hasta = new javax.swing.JLabel();
        fecha_hasta = new datechooser.beans.DateChooserCombo();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        panelLinea = new javax.swing.JPanel();
        labeltotal = new javax.swing.JLabel();
        fieldactivos = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        titulo_altas.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        titulo_altas.setText("Altas y bajas entre periodos");

        label_desde.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        label_desde.setText("Desde");

        label_hasta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        label_hasta.setText("Hasta");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Generar ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tabla.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla.setEnabled(false);
        tabla.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(tabla);

        panelLinea.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout panelLineaLayout = new javax.swing.GroupLayout(panelLinea);
        panelLinea.setLayout(panelLineaLayout);
        panelLineaLayout.setHorizontalGroup(
            panelLineaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 309, Short.MAX_VALUE)
        );
        panelLineaLayout.setVerticalGroup(
            panelLineaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        labeltotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labeltotal.setText("Total de abogados activos");

        fieldactivos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        fieldactivos.setFocusable(false);
        fieldactivos.setRequestFocusEnabled(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 299, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(labeltotal))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(fieldactivos, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(labeltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldactivos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelLinea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout altasybajasLayout = new javax.swing.GroupLayout(altasybajas);
        altasybajas.setLayout(altasybajasLayout);
        altasybajasLayout.setHorizontalGroup(
            altasybajasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, altasybajasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titulo_altas)
                .addGap(270, 270, 270))
            .addGroup(altasybajasLayout.createSequentialGroup()
                .addGroup(altasybajasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(altasybajasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(altasybajasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(altasybajasLayout.createSequentialGroup()
                                .addComponent(label_desde, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fecha_desde, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, altasybajasLayout.createSequentialGroup()
                                .addComponent(label_hasta, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fecha_hasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(altasybajasLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        altasybajasLayout.setVerticalGroup(
            altasybajasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(altasybajasLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(titulo_altas)
                .addGroup(altasybajasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(altasybajasLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(altasybajasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(label_desde, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                            .addComponent(fecha_desde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(38, 38, 38)
                        .addGroup(altasybajasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(altasybajasLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(fecha_hasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(label_hasta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(312, Short.MAX_VALUE))
                    .addGroup(altasybajasLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(altasybajas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(altasybajas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         
        
        this.tabla.setModel(mostrar());
        fieldactivos.setText(String.valueOf(tabla.getValueAt(1,0)));
        graficarTorta();
        graficarLinea();
    }//GEN-LAST:event_jButton1ActionPerformed




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel altasybajas;
    private datechooser.beans.DateChooserCombo fecha_desde;
    private datechooser.beans.DateChooserCombo fecha_hasta;
    private javax.swing.JLabel fieldactivos;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_desde;
    private javax.swing.JLabel label_hasta;
    private javax.swing.JLabel labeltotal;
    private javax.swing.JPanel panelLinea;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel titulo_altas;
    // End of variables declaration//GEN-END:variables

   private void graficarTorta() {
        panelLinea.removeAll();
        
        pieDataset= new DefaultPieDataset();        
    
    
        pieDataset.setValue("Baja",Integer.parseInt(String.valueOf(tabla.getValueAt(1,0))));        
       
        pieDataset.setValue("Alta",Integer.parseInt(String.valueOf(tabla.getValueAt(0,0))));        
        
        if(tabla.getRowCount()>2)
        pieDataset.setValue("Suspensiones",Integer.parseInt(String.valueOf(tabla.getValueAt(2,0))));
        
        chart= ChartFactory.createPieChart("Datos",pieDataset, true, true, true);
        p= (PiePlot)chart.getPlot();
        ChartPanel frame= new ChartPanel(chart);        
        frame.setSize(310,340);
        panelLinea.add(frame);
        panelLinea.updateUI();
    }
    
    private void graficarLinea() {
        jPanel2.removeAll();
        fecha = new GregorianCalendar();
        Integer anio= fecha.get(Calendar.YEAR);
        
       
        String fch1 = Integer.toString(anio);
        //String fch2 = Integer.toString(anio-2);
        //String fch3 = Integer.toString(anio-3);
        
        datos= new DefaultCategoryDataset();         

    
        datos.setValue(5,"2013","2013");
        datos.setValue(5,"2014","2014");
        datos.setValue(2,"2015","2015");
        
        chart= ChartFactory.createBarChart("Activos ","Años","Cantidad Activos",datos,PlotOrientation.HORIZONTAL, true, true, true);
        ChartPanel frame= new ChartPanel(chart);        
        frame.setSize(300,340);//ancho,alto
        jPanel2.add(frame);
        jPanel2.updateUI();
    }
    
  
}

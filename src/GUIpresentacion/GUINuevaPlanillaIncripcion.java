/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIpresentacion;

import Utilidad.Utilidad;
import static Utilidad.Utilidad.convertToSqlDate;
import static Utilidad.Utilidad.getAnio;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.print.attribute.Size2DSyntax.MM;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import logica.Abogado;
import logica.Persona;
import logica.Planilla_de_Inscripcion;
import logica.Universidad;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author jau
 */
public class GUINuevaPlanillaIncripcion extends javax.swing.JPanel {

    /**
     * Creates new form NuevaPlanillaIncripcion
     */
    Abogado abogado;
   Planilla_de_Inscripcion planilla;
   Universidad universidad;
   Persona familiar;
   Calendar fechaactual;
    
   
  
    
    public GUINuevaPlanillaIncripcion() {
        
        
        universidad = new Universidad();
        abogado = new Abogado();
        planilla = new Planilla_de_Inscripcion();
        familiar = new Persona();
       
        
        /* try {
            nro_planillaLabel.setText(planilla.get_nro_planillaDB().toString());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUINuevaPlanillaIncripcion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GUINuevaPlanillaIncripcion.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
         initComponents();
        cargaBox();
        
       
    }
    
    
    
    private void cargo_datos() throws ParseException{
    //SimpleDateFormat formatoDelTexto = new SimpleDateFormat(yyyy-MM-dd');
         fechaactual=Calendar.getInstance(); //nacimientoChooser.getSelectedDate();
         
         
  
        
        if(Utilidad.areEqualDays(fechaactual,nacimientoChooser.getSelectedDate())){
        System.out.println(">> "+Utilidad.convertToSqlDate(nacimientoChooser.getSelectedDate() ));
    
    }
        
      if(!dni_cuit_texto.getText().isEmpty())
    abogado.setDNI(Integer.parseInt(dni_cuit_texto.getText()));
    
      if(!inicio_cuit_texto.getText().isEmpty() && !dni_cuit_texto.getText().isEmpty() && !fin_cuit_texto.getText().isEmpty())
    abogado.set_cuit(Long.valueOf(inicio_cuit_texto.getText()+dni_cuit_texto.getText()+fin_cuit_texto.getText()));
    
    
    
    if(Utilidad.getAnio(Date.valueOf(convertToSqlDate(fechaactual)))<Utilidad.getAnio(Date.valueOf(convertToSqlDate(nacimientoChooser.getSelectedDate()))))    
    abogado.set_fechanac(Utilidad.DeStringADate(Utilidad.convertToSqlDate(nacimientoChooser.getSelectedDate())));
    
    if(!apellidoTexto.getText().isEmpty())
    abogado.set_apellido(apellidoTexto.getText());
    
    if(!nobreTexto.getText().isEmpty())
    abogado.set_nombre(nobreTexto.getText());
    
    if(estadoCivilBox!=null)
    abogado.setEstadoCivil(estadoCivilBox.getSelectedItem().toString());
    
    if(universidadBox!=null)
    universidad.set_nombre(universidadBox.getSelectedItem().toString());
    
    if(fechaexpChooser!=null)
    abogado.set_fecha_titulo(Utilidad.DeStringADate(Utilidad.convertToSqlDate(fechaexpChooser.getSelectedDate())));
    
    if(!calleRTexto.getText().isEmpty())
    abogado.set_dR_Calle(calleRTexto.getText());
    
    if(!nroRTexto.getText().isEmpty())
    abogado.set_dR_Nro(Integer.parseInt(nroRTexto.getText()));
    
    if(localidadRBox!=null)
    abogado.set_dR_Localidad(localidadRBox.getSelectedItem().toString());
    
    if(provinciaRBox!=null)
    abogado.set_dR_Provincia(provinciaRBox.getSelectedItem().toString());
    
    if(!telRTexto.getText().isEmpty())
    abogado.set_telefono_particualr(Integer.parseInt(telRTexto.getText()));
    
    if(!calleRTexto.getText().isEmpty())
    abogado.set_dP_calle(calleRTexto.getText());
    
    if(!nroPTexto.getText().isEmpty())
    abogado.set_dP_nro(Integer.parseInt(nroPTexto.getText()));
    
    if(localidadPBox!=null)
    abogado.set_dP_localidad(localidadPBox.getSelectedItem().toString());
    
    if(provinciaPBox!=null)
    abogado.set_dP_provincia(provinciaPBox.getSelectedItem().toString());
    
    if(!telPTexto.getText().isEmpty())
    abogado.set_tel_profecional(Integer.parseInt(telPTexto.getText()));
    
    if(!emailTexto.getText().isEmpty())
    abogado.set_email(emailTexto.getText());
    
    if(!nombreFamiliaTexto.getText().isEmpty())
    familiar.set_nombre(nombreFamiliaTexto.getText());
    
    //abogado.getFamilar().set_nombre(apellidoFamiliaTexto.getText());
    
    if(!apellidoFamiliaTexto.getText().isEmpty()){
    familiar.set_apellido(apellidoFamiliaTexto.getText()); 
    familiar.setTipo_familiar(tipoFamiliarBox.getSelectedItem().toString());}
    
    if(regimenBox!=null)
    abogado.setRegimen(regimenBox.getSelectedItem().toString());
    
     if(Utilidad.getAnio(Date.valueOf(convertToSqlDate(fechaactual)))<Utilidad.getAnio(Date.valueOf(convertToSqlDate(fechaRegimenInicioChooser.getSelectedDate()))))
    abogado.setRegimen_inicio( Utilidad.DeStringADate(Utilidad.convertToSqlDate(fechaRegimenInicioChooser.getSelectedDate())) );
    
      if(Utilidad.getAnio(Date.valueOf(convertToSqlDate(fechaactual)))<Utilidad.getAnio(Date.valueOf(convertToSqlDate(fechaRegimenFinalChooser.getSelectedDate()))))
    abogado.setRegimen_final( Utilidad.DeStringADate(Utilidad.convertToSqlDate(fechaRegimenFinalChooser.getSelectedDate())));
    
    if(obraSocialBox!=null)
    abogado.setObraSocial(obraSocialBox.getSelectedItem().toString());
    
    
    
    
    
    
    
    
    abogado.setFamilar(familiar);
    
    
    
   
    }
    
    private void cargaBox(){
        
        
        try {
           
           // universidadBox.add(universidad.getlistauniversidadDB().getString("nombre"));
            
            
            
            
            Utilidad.cargarJComboBox(universidadBox,universidad.getlistauniversidadDB());
            
            Utilidad.cargarJComboBox(provinciaRBox,abogado.get_provinciasDB());
          
            
            Utilidad.cargarJComboBox(localidadRBox,abogado.get_localidadesDB(provinciaRBox.getSelectedItem().toString()));
            
            Utilidad.cargarJComboBox(provinciaPBox,abogado.get_provinciasDB());
            
         
            Utilidad.cargarJComboBox(localidadPBox,abogado.get_localidadesDB(provinciaPBox.getSelectedItem().toString()));
            
            Utilidad.cargarJComboBox(regimenBox,abogado.get_regimenDB());
            
            Utilidad.cargarJComboBox(obraSocialBox,abogado.get_obraSocialDB());
        
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GUINuevaPlanillaIncripcion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
    
    
    
    
    }
    
    
    void cargarLocalidad(){
    
        try {
            Utilidad.cargarJComboBox(localidadRBox,abogado.get_localidadesDB(provinciaRBox.getSelectedItem().toString()));
            
            Utilidad.cargarJComboBox(localidadPBox,abogado.get_localidadesDB(provinciaPBox.getSelectedItem().toString()));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUINuevaPlanillaIncripcion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GUINuevaPlanillaIncripcion.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
   private boolean alertas(){
   Boolean b=false;
       if(nobreTexto.getText().isEmpty() || apellidoTexto.getText().isEmpty() || dni_cuit_texto.getText().isEmpty() ){//|| (Utilidad.getAnio(Date.valueOf(convertToSqlDate(fechaactual))>Utilidad.getAnio(Date.valueOf(convertToSqlDate(nacimientoChooser.getSelectedDate()))))){    
           
       JOptionPane.showMessageDialog(null,"Campos obligatorios (*) vacios, re vea el formuario");
       b=true;
       }
       
       return b;
   }
    
    
    

    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        inicio_cuit_texto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dni_cuit_texto = new javax.swing.JTextField();
        fin_cuit_texto = new javax.swing.JTextField();
        nobreTexto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        apellidoTexto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        estadoCivilBox = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        fechaexpChooser = new datechooser.beans.DateChooserCombo();
        nacimientoChooser = new datechooser.beans.DateChooserCombo();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        calleRTexto = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        callePTexto = new javax.swing.JTextField();
        nroPTexto = new javax.swing.JTextField();
        telPTexto = new javax.swing.JTextField();
        telRTexto = new javax.swing.JTextField();
        emailTexto = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        localidadPBox = new javax.swing.JComboBox();
        provinciaPBox = new javax.swing.JComboBox();
        localidadRBox = new javax.swing.JComboBox();
        provinciaRBox = new javax.swing.JComboBox();
        nroRTexto = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        tipoFamiliarBox = new javax.swing.JComboBox();
        nombreFamiliaTexto = new javax.swing.JTextField();
        apellidoFamiliaTexto = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        regimenBox = new javax.swing.JComboBox();
        fechaRegimenInicioChooser = new datechooser.beans.DateChooserCombo();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        obraSocialBox = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        fechaRegimenFinalChooser = new datechooser.beans.DateChooserCombo();
        universidadBox = new javax.swing.JComboBox();

        jLabel3.setText("Cuit/cuil: *");

        inicio_cuit_texto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicio_cuit_textoActionPerformed(evt);
            }
        });

        jLabel4.setText("-");

        jLabel5.setText("-");

        dni_cuit_texto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dni_cuit_textoActionPerformed(evt);
            }
        });

        fin_cuit_texto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fin_cuit_textoActionPerformed(evt);
            }
        });

        jLabel6.setText("Nombre: *");

        jLabel7.setText("Apellido: *");

        apellidoTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidoTextoActionPerformed(evt);
            }
        });

        jLabel8.setText("Universidad");

        jLabel9.setText("Estado Civil:");

        estadoCivilBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Soltero", "Casado", "Viudo" }));

        jLabel10.setText("Fecha Nacimiento:*");

        jButton1.setText("Nueva Declaracion Jurada de Salud");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        nacimientoChooser.addSelectionChangedListener(new datechooser.events.SelectionChangedListener() {
            public void onSelectionChange(datechooser.events.SelectionChangedEvent evt) {
                nacimientoChooserOnSelectionChange(evt);
            }
        });

        jLabel11.setText("Fecha expedicion de titulo:");

        jLabel12.setText("Calle:");

        jLabel13.setText("Numero:");

        jLabel14.setText("Localidad:");

        jLabel15.setText("Provincia:");

        jLabel16.setText("Telefono:*");

        jLabel17.setText("Datos Profecional");

        jLabel18.setText("Datos Reales");

        jLabel19.setText("Calle:");

        jLabel20.setText("Numero:");

        jLabel21.setText("Localidad:");

        jLabel22.setText("Provincia:");

        jLabel23.setText("Telefono:");

        callePTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                callePTextoActionPerformed(evt);
            }
        });

        telRTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telRTextoActionPerformed(evt);
            }
        });

        emailTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTextoActionPerformed(evt);
            }
        });

        jLabel24.setText("Email:");

        provinciaPBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                provinciaPBoxActionPerformed(evt);
            }
        });

        provinciaRBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                provinciaRBoxActionPerformed(evt);
            }
        });

        jLabel25.setText("Familiar");

        jLabel26.setText("Nombre:");

        jLabel27.setText("Apellido:");

        jLabel28.setText("Tipo familiar:");

        tipoFamiliarBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PADRE", "MADRE", "HIJO/A", "CONYUGE" }));
        tipoFamiliarBox.setSelectedIndex(-1);

        apellidoFamiliaTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidoFamiliaTextoActionPerformed(evt);
            }
        });

        jLabel29.setText("REGIMEN PREVISIONAL");

        jLabel30.setText("Regimen:");

        jLabel31.setText("Desde:");

        jLabel32.setText("Hasta:");

        jLabel33.setText("Obra Social");

        jLabel34.setText("Nombre obra Social:");

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(inicio_cuit_texto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dni_cuit_texto, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fin_cuit_texto, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addComponent(nacimientoChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(nobreTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(apellidoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                                                .addComponent(jLabel9)
                                                .addGap(18, 18, 18)
                                                .addComponent(estadoCivilBox, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(59, 59, 59)))))
                                .addGap(38, 38, 38)
                                .addComponent(jButton1))
                            .addComponent(jLabel25)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(18, 18, 18)
                                        .addComponent(localidadRBox, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(calleRTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nroRTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(provinciaRBox, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(telRTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(localidadPBox, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(18, 18, 18)
                                        .addComponent(callePTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(provinciaPBox, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(82, 82, 82)
                                        .addComponent(jLabel23)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(telPTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(nroPTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(emailTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(88, 88, 88))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(universidadBox, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(98, 98, 98)
                                .addComponent(jLabel11)
                                .addGap(28, 28, 28)
                                .addComponent(fechaexpChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nombreFamiliaTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(apellidoFamiliaTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel28)
                                .addGap(18, 18, 18)
                                .addComponent(tipoFamiliarBox, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel33))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel29))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(jLabel34)
                                .addGap(44, 44, 44)
                                .addComponent(obraSocialBox, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel30)
                                .addGap(18, 18, 18)
                                .addComponent(regimenBox, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fechaRegimenInicioChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fechaRegimenFinalChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(inicio_cuit_texto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(dni_cuit_texto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fin_cuit_texto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(nobreTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton1)
                    .addComponent(nacimientoChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel9)
                        .addComponent(estadoCivilBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(apellidoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(jLabel11)
                                .addComponent(universidadBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(fechaexpChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(nroRTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(calleRTexto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16)
                                    .addComponent(telRTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(localidadRBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(provinciaRBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addComponent(jLabel17))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(emailTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 210, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(callePTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(nroPTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(telPTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(localidadPBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(provinciaPBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(nombreFamiliaTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(apellidoFamiliaTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(tipoFamiliarBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel30)
                        .addComponent(regimenBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel31))
                    .addComponent(fechaRegimenInicioChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addComponent(fechaRegimenFinalChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel33)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(obraSocialBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void inicio_cuit_textoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicio_cuit_textoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inicio_cuit_textoActionPerformed

    private void dni_cuit_textoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dni_cuit_textoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dni_cuit_textoActionPerformed

    private void fin_cuit_textoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fin_cuit_textoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fin_cuit_textoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        
        try {
            cargo_datos();
            
            
            if(!alertas())
            abogado.guardar();
        } catch (ClassNotFoundException | SQLException | ParseException ex) {
            Logger.getLogger(GUINuevaPlanillaIncripcion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void emailTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTextoActionPerformed

    private void callePTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_callePTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_callePTextoActionPerformed

    private void apellidoFamiliaTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidoFamiliaTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellidoFamiliaTextoActionPerformed

    private void provinciaRBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_provinciaRBoxActionPerformed
        
        cargarLocalidad();
     
    }//GEN-LAST:event_provinciaRBoxActionPerformed

    private void provinciaPBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_provinciaPBoxActionPerformed
        // TODO add your handling code here:
        
        
        cargarLocalidad();
    }//GEN-LAST:event_provinciaPBoxActionPerformed

    private void nacimientoChooserOnSelectionChange(datechooser.events.SelectionChangedEvent evt) {//GEN-FIRST:event_nacimientoChooserOnSelectionChange
      
        
    }//GEN-LAST:event_nacimientoChooserOnSelectionChange

    private void telRTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telRTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telRTextoActionPerformed

    private void apellidoTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidoTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellidoTextoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidoFamiliaTexto;
    private javax.swing.JTextField apellidoTexto;
    private javax.swing.JTextField callePTexto;
    private javax.swing.JTextField calleRTexto;
    private javax.swing.JTextField dni_cuit_texto;
    private javax.swing.JTextField emailTexto;
    private javax.swing.JComboBox estadoCivilBox;
    private datechooser.beans.DateChooserCombo fechaRegimenFinalChooser;
    private datechooser.beans.DateChooserCombo fechaRegimenInicioChooser;
    private datechooser.beans.DateChooserCombo fechaexpChooser;
    private javax.swing.JTextField fin_cuit_texto;
    private javax.swing.JTextField inicio_cuit_texto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JComboBox localidadPBox;
    private javax.swing.JComboBox localidadRBox;
    private datechooser.beans.DateChooserCombo nacimientoChooser;
    private javax.swing.JTextField nobreTexto;
    private javax.swing.JTextField nombreFamiliaTexto;
    private javax.swing.JTextField nroPTexto;
    private javax.swing.JTextField nroRTexto;
    private javax.swing.JComboBox obraSocialBox;
    private javax.swing.JComboBox provinciaPBox;
    private javax.swing.JComboBox provinciaRBox;
    private javax.swing.JComboBox regimenBox;
    private javax.swing.JTextField telPTexto;
    private javax.swing.JTextField telRTexto;
    private javax.swing.JComboBox tipoFamiliarBox;
    private javax.swing.JComboBox universidadBox;
    // End of variables declaration//GEN-END:variables
}

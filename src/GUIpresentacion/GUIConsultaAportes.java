/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIpresentacion;

import com.mxrck.autocompleter.TextAutoCompleter;

/**
 *
 * @author gabriel
 */
public class GUIConsultaAportes extends javax.swing.JPanel {

    /**
     * Creates new form GUIConsultaAportes
     */
    public GUIConsultaAportes() {
        initComponents();
        additemtextfield();
    }

    /**Este metodo autocompleta solo lo que esta ahi
     * faltaria que se autocomplete con datos de la base
     */
    
    public void additemtextfield(){
   
    TextAutoCompleter nombres= new TextAutoCompleter(texnombre);
    
    
    
    
    nombres.addItem("gabriel");
    nombres.addItem("gabrieles");
    nombres.addItem("gabrielitos");
    nombres.addItem("natalias");
    nombres.addItem("natalia");
    nombres.addItem("holas");
       
     
   
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
        jButton1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(910, 559));

        texnombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        titulo_altas.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        titulo_altas.setText("Consulta de Aportes Previsionales");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Apellido del Profesional: ");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Buscar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(titulo_altas)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(texnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(221, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(titulo_altas)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(texnombre)
                        .addComponent(jButton1)))
                .addContainerGap(429, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField texnombre;
    private javax.swing.JLabel titulo_altas;
    // End of variables declaration//GEN-END:variables
}

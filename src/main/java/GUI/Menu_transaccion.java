
package GUI;

import com.mycompany.proyecto1_bd2.Validacion;

public class Menu_transaccion extends javax.swing.JFrame {
    private String numeroTarjeta;
    private int atmId;
    public Menu_transaccion(String numeroTarjeta, int atmId) {
        initComponents();
        setLocationRelativeTo(null);
        this.numeroTarjeta = numeroTarjeta;
        this.atmId = atmId;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbutton_transferencia = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton_ATRAS = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbutton_transferencia.setText("TRANSFERENCIA");
        jbutton_transferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton_transferenciaActionPerformed(evt);
            }
        });
        jPanel1.add(jbutton_transferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 220, 40));

        jButton1.setText("RETIRO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 220, 40));

        jButton_ATRAS.setText("ATRAS");
        jButton_ATRAS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ATRASActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_ATRAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbutton_transferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton_transferenciaActionPerformed
        int tarjetaId = Validacion.obtenerTarjetaId(numeroTarjeta); 
        int atmId = 1; 

        Menu_transferir ver = new Menu_transferir(numeroTarjeta,tarjetaId, atmId);
        ver.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jbutton_transferenciaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int tarjetaId = Validacion.obtenerTarjetaId(numeroTarjeta); 
        int atmId = 1; 

        Menu_extraccion ver = new Menu_extraccion(numeroTarjeta,tarjetaId, atmId);
        ver.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton_ATRASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ATRASActionPerformed
        Menu_secundario ver = new Menu_secundario(numeroTarjeta, atmId);
        ver.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton_ATRASActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_ATRAS;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbutton_transferencia;
    // End of variables declaration//GEN-END:variables
}

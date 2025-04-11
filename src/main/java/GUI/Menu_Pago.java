
package GUI;


public class Menu_Pago extends javax.swing.JFrame {
    private int atmId;
    private String numeroTarjeta;
    private int tarjetaId;
    public Menu_Pago(String numeroTarjeta, int atmId) {
        initComponents();
        setLocationRelativeTo(null);
        this.tarjetaId = com.mycompany.proyecto1_bd2.Validacion.obtenerTarjetaId(numeroTarjeta);
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton_ATRAS = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton_ATRAS1 = new javax.swing.JButton();
        jButton_Solicitar_Prestamo = new javax.swing.JButton();
        jButton_Pagar_Prestamo = new javax.swing.JButton();

        jButton_ATRAS.setText("ATRAS");
        jButton_ATRAS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ATRASActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_ATRAS1.setText("ATRAS");
        jButton_ATRAS1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ATRAS1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_ATRAS1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 40));

        jButton_Solicitar_Prestamo.setText("Solicitar Prestamo");
        jButton_Solicitar_Prestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Solicitar_PrestamoActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Solicitar_Prestamo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 170, 50));

        jButton_Pagar_Prestamo.setText("Pagar Prestamo");
        jButton_Pagar_Prestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Pagar_PrestamoActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Pagar_Prestamo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 170, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ATRASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ATRASActionPerformed
        Menu_transaccion ver = new Menu_transaccion(numeroTarjeta, atmId);
        ver.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton_ATRASActionPerformed

    private void jButton_ATRAS1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ATRAS1ActionPerformed
        Menu_transaccion ver = new Menu_transaccion(numeroTarjeta, atmId);
        ver.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton_ATRAS1ActionPerformed

    private void jButton_Solicitar_PrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Solicitar_PrestamoActionPerformed
        Solicitar_Prestamo ver = new Solicitar_Prestamo(numeroTarjeta,atmId);
        ver.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton_Solicitar_PrestamoActionPerformed

    private void jButton_Pagar_PrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Pagar_PrestamoActionPerformed
        Menu_Pagar_Prestamo ver = new Menu_Pagar_Prestamo(tarjetaId);
        ver.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton_Pagar_PrestamoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_ATRAS;
    private javax.swing.JButton jButton_ATRAS1;
    private javax.swing.JButton jButton_Pagar_Prestamo;
    private javax.swing.JButton jButton_Solicitar_Prestamo;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

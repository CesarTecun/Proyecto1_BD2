package GUI;

import javax.swing.JOptionPane;
import com.mycompany.proyecto1_bd2.DatosUsuario;
import com.mycompany.proyecto1_bd2.UsuarioInfo;


class Menu_extraccion extends javax.swing.JFrame {
    
    private int tarjetaId;
    private int atmId;
    private String numeroTarjeta;
    
    public Menu_extraccion(String numeroTarjeta, int tarjetaId, int atmId) {
        initComponents();
        setLocationRelativeTo(null);
        this.tarjetaId = tarjetaId;
        this.atmId = atmId;
        this.numeroTarjeta = numeroTarjeta;
        jButton_CONFIRMAR.addActionListener(e -> realizarExtraccion());
        //MOSTAR EL SALDO
        UsuarioInfo info = DatosUsuario.obtenerInfoDesdeTarjeta(numeroTarjeta);
        if (info != null) {
            jLabel_Saldo.setText("Saldo disponible: Q" + info.getSaldo());
        } else {
            jLabel_Saldo.setText("Saldo no disponible");
        }
         actualizarSaldo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel_monto = new javax.swing.JLabel();
        Jtext_Monto = new javax.swing.JTextField();
        jButton_CONFIRMAR = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jButton_ATRAS = new javax.swing.JButton();
        jLabel_Saldo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_monto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel_monto.setText("INGRESE MONTO");
        jPanel1.add(jLabel_monto, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 130, -1));

        Jtext_Monto.setBackground(new java.awt.Color(255, 255, 255));
        Jtext_Monto.setBorder(null);
        jPanel1.add(Jtext_Monto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 270, 30));

        jButton_CONFIRMAR.setText("CONFIRMAR");
        jPanel1.add(jButton_CONFIRMAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 170, 40));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 270, 10));

        jButton_ATRAS.setText("ATRAS");
        jButton_ATRAS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ATRASActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_ATRAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 40));

        jLabel_Saldo.setText("SALDO");
        jPanel1.add(jLabel_Saldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 200, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ATRASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ATRASActionPerformed
        Menu_transaccion ver = new Menu_transaccion(numeroTarjeta, atmId);
        ver.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton_ATRASActionPerformed
    
    private void actualizarSaldo() {
    UsuarioInfo info = DatosUsuario.obtenerInfoDesdeTarjeta(numeroTarjeta);
    if (info != null) {
        jLabel_Saldo.setText("Saldo disponible: Q" + info.getSaldo());
    } else {
        jLabel_Saldo.setText("Saldo no disponible");
    }
}

private void realizarExtraccion() {
    String montoText = Jtext_Monto.getText().trim();

    try {
        double monto = Double.parseDouble(montoText);

        if (monto <= 0) {
            JOptionPane.showMessageDialog(this, "❌ El monto debe ser mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirmar = JOptionPane.showConfirmDialog(
            this,
            "¿Deseas retirar Q" + monto + "?",
            "Confirmar Extracción",
            JOptionPane.YES_NO_OPTION
        );

        if (confirmar == JOptionPane.YES_OPTION) {
            String resultado = com.mycompany.proyecto1_bd2.Validacion.realizarExtraccion(tarjetaId, monto, atmId);

            if (resultado != null && resultado.toUpperCase().contains("EXITOSAMENTE")) {
                JOptionPane.showMessageDialog(this, "✅ " + resultado);
                
                // 🔁 Actualiza el saldo en pantalla
                actualizarSaldo();

                // 🔄 Limpia el campo de monto
                Jtext_Monto.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "❌ " + resultado, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "❌ Ingrese un monto válido.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Jtext_Monto;
    private javax.swing.JButton jButton_ATRAS;
    private javax.swing.JButton jButton_CONFIRMAR;
    private javax.swing.JLabel jLabel_Saldo;
    private javax.swing.JLabel jLabel_monto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}

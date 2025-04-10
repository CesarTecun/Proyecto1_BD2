package GUI;

import com.mycompany.proyecto1_bd2.UsuarioInfo;
import com.mycompany.proyecto1_bd2.Validacion;
import javax.swing.JOptionPane;

public class Menu_transferir extends javax.swing.JFrame {

private int tarjetaId;
private int atmId;
private String numeroTarjeta;

    public Menu_transferir(String numeroTarjeta, int tarjetaId, int atmId) {
        initComponents();
        setLocationRelativeTo(null);
        this.tarjetaId = tarjetaId;
        this.atmId = atmId;
        this.numeroTarjeta = numeroTarjeta;
        jButton_CONFIRMAR.addActionListener(e -> realizarTransferencia());
        
        UsuarioInfo info = com.mycompany.proyecto1_bd2.DatosUsuario.obtenerInfoDesdeTarjeta(numeroTarjeta);
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
        jLabel_cuenta_destino = new javax.swing.JLabel();
        Jtext_cuenta_D = new javax.swing.JTextField();
        jButton_CONFIRMAR = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jButton_ATRAS = new javax.swing.JButton();
        jLabel_Saldo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_monto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel_monto.setText("INGRESE MONTO");
        jPanel1.add(jLabel_monto, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 130, -1));

        Jtext_Monto.setBackground(new java.awt.Color(255, 255, 255));
        Jtext_Monto.setBorder(null);
        jPanel1.add(Jtext_Monto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 270, 30));

        jLabel_cuenta_destino.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel_cuenta_destino.setText("INGRESE LA CUENTA DESTINO");
        jPanel1.add(jLabel_cuenta_destino, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 210, -1));

        Jtext_cuenta_D.setBackground(new java.awt.Color(255, 255, 255));
        Jtext_cuenta_D.setBorder(null);
        jPanel1.add(Jtext_cuenta_D, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 270, 30));

        jButton_CONFIRMAR.setText("CONFIRMAR");
        jPanel1.add(jButton_CONFIRMAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 170, 40));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 270, 10));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 270, 10));

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ATRASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ATRASActionPerformed
    Menu_transaccion ver = new Menu_transaccion(numeroTarjeta, atmId);
    ver.setVisible(true);
    this.setVisible(false); 
    }//GEN-LAST:event_jButton_ATRASActionPerformed
  
    private void actualizarSaldo() {
    com.mycompany.proyecto1_bd2.UsuarioInfo info =
        com.mycompany.proyecto1_bd2.DatosUsuario.obtenerInfoDesdeTarjeta(numeroTarjeta);
    if (info != null) {
        jLabel_Saldo.setText("Saldo disponible: Q" + info.getSaldo());
    } else {
        jLabel_Saldo.setText("Saldo no disponible");
    }
}

    private void realizarTransferencia() {
        String cuentaDestinoText = Jtext_cuenta_D.getText().trim();
        String montoText = Jtext_Monto.getText().trim();

        try {
            int cuentaDestino = Integer.parseInt(cuentaDestinoText);
            double monto = Double.parseDouble(montoText);

            if (monto <= 0) {
                JOptionPane.showMessageDialog(this, "❌ El monto debe ser mayor que 0.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int confirmar = JOptionPane.showConfirmDialog(
                this,
                "¿Deseas transferir Q" + monto + " a la cuenta " + cuentaDestino + "?",
                "Confirmar Transferencia",
                JOptionPane.YES_NO_OPTION
            );

            if (confirmar == JOptionPane.YES_OPTION) {
                boolean exito = Validacion.realizarTransferencia(tarjetaId, cuentaDestino, monto, atmId);
                if (exito) {
                    JOptionPane.showMessageDialog(this, "✅ Transferencia realizada exitosamente.");
                        Jtext_Monto.setText("");
                        Jtext_cuenta_D.setText("");
                         actualizarSaldo();
                } else {
                    JOptionPane.showMessageDialog(this, "❌ No se pudo realizar la transferencia.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "❌ Datos inválidos. Ingrese números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Jtext_Monto;
    private javax.swing.JTextField Jtext_cuenta_D;
    private javax.swing.JButton jButton_ATRAS;
    private javax.swing.JButton jButton_CONFIRMAR;
    private javax.swing.JLabel jLabel_Saldo;
    private javax.swing.JLabel jLabel_cuenta_destino;
    private javax.swing.JLabel jLabel_monto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}

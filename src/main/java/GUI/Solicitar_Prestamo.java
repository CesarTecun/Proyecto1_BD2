package GUI;

import com.mycompany.proyecto1_bd2.GestorPrestamos;


public class Solicitar_Prestamo extends javax.swing.JFrame {
    private String numeroTarjeta;
    private int atmId;
    private javax.swing.JComboBox<String> jComboBox_Tipo_Tasa;

    public Solicitar_Prestamo(String numeroTarjeta, int atmId) {
        initComponents();
        setLocationRelativeTo(null);
        
        jComboBox_Tipo_Tasa = new javax.swing.JComboBox<>();
        jComboBox_Tipo_Tasa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
            "Hipotecario", "Consumo", "Educativo", "Empresarial"
        }));
        jPanel1.add(jComboBox_Tipo_Tasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 270, 30));

        
        Jbutton_Prestamo.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
        solicitarPrestamoActionPerformed(evt);
    }
});
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        Jtext_Monto = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        Jtext_Solicitado = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        Jtext_Meses = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        Jtext_Destino_Prestamo = new javax.swing.JTextField();
        Jtext_Ofrecida = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        Jbutton_Prestamo = new javax.swing.JButton();
        jButton_ATRAS = new javax.swing.JButton();

        Jtext_Monto.setBackground(new java.awt.Color(255, 255, 255));
        Jtext_Monto.setBorder(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Garantia ofrecida");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 140, 30));

        jLabel3.setText("Tipo de Prestamo");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 140, 30));

        jLabel4.setText("Monto Solicitado");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 140, 30));

        jLabel5.setText("Plazo en meses");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 140, 30));

        jLabel6.setText("Destino del préstamo");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 140, 30));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 270, 10));

        Jtext_Solicitado.setBackground(new java.awt.Color(255, 255, 255));
        Jtext_Solicitado.setBorder(null);
        jPanel1.add(Jtext_Solicitado, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 270, 30));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 270, 10));

        Jtext_Meses.setBackground(new java.awt.Color(255, 255, 255));
        Jtext_Meses.setBorder(null);
        jPanel1.add(Jtext_Meses, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 270, 30));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 270, 10));

        Jtext_Destino_Prestamo.setBackground(new java.awt.Color(255, 255, 255));
        Jtext_Destino_Prestamo.setBorder(null);
        jPanel1.add(Jtext_Destino_Prestamo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 270, 30));

        Jtext_Ofrecida.setBackground(new java.awt.Color(255, 255, 255));
        Jtext_Ofrecida.setBorder(null);
        jPanel1.add(Jtext_Ofrecida, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 270, 30));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 270, 10));

        Jbutton_Prestamo.setText("SOLICITAR PRESTAMO");
        jPanel1.add(Jbutton_Prestamo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 170, 50));

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ATRASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ATRASActionPerformed
        Menu_Pago ver = new Menu_Pago(numeroTarjeta,atmId);
        ver.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton_ATRASActionPerformed

private void solicitarPrestamoActionPerformed(java.awt.event.ActionEvent evt) {
    try {
       String tipoPrestamo = jComboBox_Tipo_Tasa.getSelectedItem().toString();  
        double montoSolicitado = Double.parseDouble(Jtext_Solicitado.getText());
        int plazo = Integer.parseInt(Jtext_Meses.getText());
        String destino = Jtext_Destino_Prestamo.getText();
        String garantia = Jtext_Ofrecida.getText();

        // Aquí puedes ajustar el cliente_id y cuenta_desembolso reales
        int clienteId = 1;
        int cuentaDesembolso = 99;

        String resultado = GestorPrestamos.registrarPrestamo(
            clienteId,
            tipoPrestamo,
            montoSolicitado,
            "GTQ",
            plazo,
            destino,
            garantia,
            cuentaDesembolso
        );

        if (resultado.startsWith("APROBADO")) {
            javax.swing.JOptionPane.showMessageDialog(this, "✅ " + resultado);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "❌ " + resultado);
        }


    } catch (NumberFormatException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "❗ Error: Verifique que todos los campos numéricos estén bien ingresados.");
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Jbutton_Prestamo;
    private javax.swing.JTextField Jtext_Destino_Prestamo;
    private javax.swing.JTextField Jtext_Meses;
    private javax.swing.JTextField Jtext_Monto;
    private javax.swing.JTextField Jtext_Ofrecida;
    private javax.swing.JTextField Jtext_Solicitado;
    private javax.swing.JButton jButton_ATRAS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    // End of variables declaration//GEN-END:variables
}

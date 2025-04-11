package GUI;
import com.mycompany.proyecto1_bd2.DatosUsuario;
import com.mycompany.proyecto1_bd2.UsuarioInfo;
public class Menu_secundario extends javax.swing.JFrame {
    
    private String numeroTarjeta;
    private int atmId;
    
    public Menu_secundario(String numeroTarjeta, int atmId) {
        initComponents();
        setLocationRelativeTo(null);
        this.numeroTarjeta = numeroTarjeta;
        this.atmId = atmId;
        cargarDatosUsuario();;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Button_Transaccion = new javax.swing.JButton();
        Button_Prestamo = new javax.swing.JButton();
        Jlabel_nombreUser = new javax.swing.JLabel();
        Jlabel_Cuenta_Ahorro = new javax.swing.JLabel();
        Jlabel_Saldo_Actual = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Button_Transaccion.setText("TRANSACCION");
        Button_Transaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_TransaccionActionPerformed(evt);
            }
        });
        jPanel1.add(Button_Transaccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 150, 40));

        Button_Prestamo.setText("PRESTAMO");
        Button_Prestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_PrestamoActionPerformed(evt);
            }
        });
        jPanel1.add(Button_Prestamo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, 150, 40));

        Jlabel_nombreUser.setBackground(new java.awt.Color(204, 204, 204));
        Jlabel_nombreUser.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Jlabel_nombreUser.setText("Titular");
        Jlabel_nombreUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(Jlabel_nombreUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 260, 30));

        Jlabel_Cuenta_Ahorro.setBackground(new java.awt.Color(204, 204, 204));
        Jlabel_Cuenta_Ahorro.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Jlabel_Cuenta_Ahorro.setText("Cuenta");
        jPanel1.add(Jlabel_Cuenta_Ahorro, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 210, 30));

        Jlabel_Saldo_Actual.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Jlabel_Saldo_Actual.setText("Saldo");
        jPanel1.add(Jlabel_Saldo_Actual, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 190, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_TransaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_TransaccionActionPerformed
        Menu_transaccion ver = new Menu_transaccion(numeroTarjeta, atmId); // usa el atmId real
        ver.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_Button_TransaccionActionPerformed

    private void Button_PrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_PrestamoActionPerformed
        Menu_Pago ver = new Menu_Pago(numeroTarjeta, atmId); // usa el atmId real
        ver.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_Button_PrestamoActionPerformed

    private void cargarDatosUsuario() {
        UsuarioInfo info = DatosUsuario.obtenerInfoDesdeTarjeta(numeroTarjeta);

        if (info != null) {
            Jlabel_nombreUser.setText("Bienvenido: " + info.getNombreCompleto());
            Jlabel_Cuenta_Ahorro.setText("Cuenta: " + info.getCuentaId());
            Jlabel_Saldo_Actual.setText("Saldo actual: Q" + info.getSaldo());
        } else {
            Jlabel_nombreUser.setText("Usuario no encontrado");
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Prestamo;
    private javax.swing.JButton Button_Transaccion;
    private javax.swing.JLabel Jlabel_Cuenta_Ahorro;
    private javax.swing.JLabel Jlabel_Saldo_Actual;
    private javax.swing.JLabel Jlabel_nombreUser;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

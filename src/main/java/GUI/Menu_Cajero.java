package GUI;

import com.mycompany.proyecto1_bd2.Validacion;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class Menu_Cajero extends javax.swing.JPanel {
    public Menu_Cajero() {
        initComponents();
        Validar_tarjeta.addActionListener(e -> validarDatos());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo_Cajero = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Jtext_Tarjeta = new javax.swing.JTextField();
        n_tarjeta = new javax.swing.JLabel();
        Validar_tarjeta = new javax.swing.JButton();
        Jlabel_tarjeta_validada = new javax.swing.JLabel();
        Jtext_Tarjeta1 = new javax.swing.JTextField();
        Jlabel_PIN_validado = new javax.swing.JLabel();
        Jpassword_PIN = new javax.swing.JPasswordField();

        Fondo_Cajero.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("CAJERO AUTOMATICO");
        Fondo_Cajero.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 260, 50));
        Fondo_Cajero.add(Jtext_Tarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 270, 30));

        n_tarjeta.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        n_tarjeta.setText("Introduce tu tarjeta");
        Fondo_Cajero.add(n_tarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 130, 30));

        Validar_tarjeta.setText("CONFIRMAR");
        Validar_tarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Validar_tarjetaActionPerformed(evt);
            }
        });
        Fondo_Cajero.add(Validar_tarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, 100, 40));
        Fondo_Cajero.add(Jlabel_tarjeta_validada, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 270, 20));
        Fondo_Cajero.add(Jtext_Tarjeta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 270, 30));
        Fondo_Cajero.add(Jlabel_PIN_validado, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, 270, 20));
        Fondo_Cajero.add(Jpassword_PIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 242, 270, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo_Cajero, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo_Cajero, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Validar_tarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Validar_tarjetaActionPerformed

    }//GEN-LAST:event_Validar_tarjetaActionPerformed

    
    private void validarDatos() {
    String numeroTarjeta = Jtext_Tarjeta.getText().trim();
    String pin = new String(Jpassword_PIN.getPassword()).trim();

    // Validación número de tarjeta
    if (!numeroTarjeta.matches("\\d{16}")) {
        JOptionPane.showMessageDialog(this, "El número de tarjeta debe tener 16 dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (!Validacion.existeTarjeta(numeroTarjeta)) {
        Jlabel_tarjeta_validada.setText("❌ Tarjeta no válida o inactiva");
        return;
    } else {
        Jlabel_tarjeta_validada.setText("✅ Tarjeta válida");
    }

    // Validación de PIN
    if (!pin.matches("\\d{4}")) {
        JOptionPane.showMessageDialog(this, "El PIN debe tener 4 dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (!Validacion.validarPin(numeroTarjeta, pin)) {
        Jlabel_PIN_validado.setText("❌ PIN incorrecto");
        return;
    } else {
        Jlabel_PIN_validado.setText("✅ PIN válido");
        JOptionPane.showMessageDialog(this, "Acceso concedido. Bienvenido.");
        Menu_secundario ver = new Menu_secundario();
        ver.setVisible(true);
        SwingUtilities.getWindowAncestor(this).setVisible(false);
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo_Cajero;
    private javax.swing.JLabel Jlabel_PIN_validado;
    private javax.swing.JLabel Jlabel_tarjeta_validada;
    private javax.swing.JPasswordField Jpassword_PIN;
    private javax.swing.JTextField Jtext_Tarjeta;
    private javax.swing.JTextField Jtext_Tarjeta1;
    private javax.swing.JButton Validar_tarjeta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel n_tarjeta;
    // End of variables declaration//GEN-END:variables
}

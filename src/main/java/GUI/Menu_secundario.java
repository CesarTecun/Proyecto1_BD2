
package GUI;


public class Menu_secundario extends javax.swing.JFrame {


    public Menu_secundario() {
        initComponents();
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

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Button_Transaccion.setText("TRANSACCION");
        jPanel1.add(Button_Transaccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 150, 40));

        Button_Prestamo.setText("PRESTAMO");
        jPanel1.add(Button_Prestamo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 150, 40));

        Jlabel_nombreUser.setText("xd");
        jPanel1.add(Jlabel_nombreUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 150, 30));

        Jlabel_Cuenta_Ahorro.setText("jLabel1");
        jPanel1.add(Jlabel_Cuenta_Ahorro, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 140, 30));

        Jlabel_Saldo_Actual.setText("Saldo Disponible");
        jPanel1.add(Jlabel_Saldo_Actual, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 140, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_secundario().setVisible(true);
            }
        });
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

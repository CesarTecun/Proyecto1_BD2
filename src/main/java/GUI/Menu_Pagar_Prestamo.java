package GUI;

import com.mycompany.proyecto1_bd2.GestorPrestamos;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Menu_Pagar_Prestamo extends javax.swing.JFrame {

   private int tarjetaId;
   private DefaultTableModel modeloTabla;

    public Menu_Pagar_Prestamo(int tarjetaId) {
    this.tarjetaId = tarjetaId;
    initComponents();
    setLocationRelativeTo(null);
    configurarTabla();
    cargarPagosPendientes();

    jButton_Pagar_Prestamo.addActionListener(evt -> pagarSeleccionados());
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Prestamo_pagados = new javax.swing.JTable();
        jButton_Pagar_Prestamo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_Prestamo_pagados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable_Prestamo_pagados);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 930, 420));

        jButton_Pagar_Prestamo.setText("PAGAR PRESTAMO");
        jPanel1.add(jButton_Pagar_Prestamo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 450, 170, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 605, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void configurarTabla() {
    modeloTabla = new DefaultTableModel(
        new String[]{"Seleccionar", "Pago ID", "Número de Pago", "Vencimiento", "Capital", "Interés", "Total", "Estado"}, 0
    ) {
        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return columnIndex == 0 ? Boolean.class : super.getColumnClass(columnIndex);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return column == 0;
        }
    };
    jTable_Prestamo_pagados.setModel(modeloTabla);
}
    
private void cargarPagosPendientes() {
    modeloTabla.setRowCount(0);
    List<Object[]> pagos = GestorPrestamos.obtenerPagosPendientes(tarjetaId);
    System.out.println("🔎 Cuotas encontradas: " + pagos.size()); // 👈 Agrega esto

    for (Object[] fila : pagos) {
        modeloTabla.addRow(fila);
    }
}

    private void pagarSeleccionados() {
        List<Integer> pagosSeleccionados = new ArrayList<>();

        for (int i = 0; i < jTable_Prestamo_pagados.getRowCount(); i++) {
            Boolean marcado = (Boolean) jTable_Prestamo_pagados.getValueAt(i, 0);
            if (marcado != null && marcado) {
                int pagoId = (int) jTable_Prestamo_pagados.getValueAt(i, 1);
                pagosSeleccionados.add(pagoId);
            }
        }

        if (pagosSeleccionados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "⚠️ Selecciona al menos una cuota para pagar.");
            return;
        }

        List<String> resultados = GestorPrestamos.pagarPrestamos(pagosSeleccionados, tarjetaId);
        System.out.println("🧪 Ejecutando búsqueda de pagos pendientes para tarjeta ID: " + tarjetaId);
        StringBuilder resumen = new StringBuilder("📋 Resultados del pago:\n");
        for (String r : resultados) {
            resumen.append(r).append("\n");
        }

        JOptionPane.showMessageDialog(this, resumen.toString());
        cargarPagosPendientes(); // recarga la tabla actualizada
        jTable_Prestamo_pagados.repaint();
        jTable_Prestamo_pagados.revalidate();

    }


    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Pagar_Prestamo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Prestamo_pagados;
    // End of variables declaration//GEN-END:variables
}

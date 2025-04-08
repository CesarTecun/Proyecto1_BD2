package com.mycompany.proyecto1_bd2;

public class SimuladorConcurrencia {

    public static void main(String[] args) {
        System.out.println("🌀 Simulación de concurrencia iniciada...");

        // Hilo 1: realiza extracción
        Thread retiroThread = new Thread(() -> {
            System.out.println("🧍‍♂️ Cliente 1 realizando retiro...");
            Transacciones.realizarExtraccion(1, 100, 1); // tarjeta_id = 1, monto = 100, atm_id = 1
        });

        // Hilo 2: realiza transferencia
        Thread transferenciaThread = new Thread(() -> {
            System.out.println("🧍‍♀️ Cliente 2 realizando transferencia...");
            Transacciones.realizarTransferencia(2, 1, 50, 2); // tarjeta_id = 2, destino = cuenta 1, monto = 50, atm_id = 2
        });

        // Iniciar los hilos
        retiroThread.start();
        transferenciaThread.start();

        try {
            retiroThread.join();
            transferenciaThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("✅ Simulación finalizada.");
    }
}

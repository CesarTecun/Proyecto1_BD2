package com.mycompany.proyecto1_bd2;

import java.util.Scanner;

public class SimuladorConcurrencia {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tarjetaId = 1002;          // Tarjeta origen
        int cuentaDestino = 103;      // Cuenta destino (para transferencia)
        int atm1 = 8;             // Primer cajero
        int atm2 = 7;             // Segundo cajero (opcional)
        double montoExtraccion = 100;
        double montoTransferencia = 100;

        while (true) {
            System.out.println("\n🧪 MENÚ DE SIMULACIÓN DE CONCURRENCIA:");
            System.out.println("1. Ejecutar Extracción");
            System.out.println("2. Ejecutar Transferencia");
            System.out.println("3. Ejecutar Extracción y Transferencia (Simultáneo)");
            System.out.println("4. Salir");
            System.out.print("👉 Opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    if (Validacion.estaCajeroActivo(atm1)){
                    new Thread(() -> {
                        String resultado = Validacion.realizarExtraccion(tarjetaId, montoExtraccion, atm1);
                        System.out.println("🧾 Extracción: " + resultado);
                    }).start();
                    } else {
                        System.out.println("EL CAJERO" + atm1 + "Esta inactivo chavo");
                    }
                    break;

                case "2":
                     if (Validacion.estaCajeroActivo(atm1)){
                    new Thread(() -> {
                        boolean exito = Validacion.realizarTransferencia(tarjetaId, cuentaDestino, montoTransferencia, atm2);
                        System.out.println("💸 Transferencia: " + (exito ? "Exitosa" : "Fallida"));
                    }).start();
                        } else {
                        System.out.println("EL CAJERO" + atm1 + "Esta inactivo chavo");
                    }
                    break;

                case "3":
                     if (Validacion.estaCajeroActivo(atm1)){
                    Thread extraccion = new Thread(() -> {
                        String resultado = Validacion.realizarExtraccion(tarjetaId, montoExtraccion, atm1);
                        System.out.println("🧾 Extracción simultánea: " + resultado);
                    });

                    Thread transferencia = new Thread(() -> {
                        boolean exito = Validacion.realizarTransferencia(tarjetaId, cuentaDestino, montoTransferencia, atm2);
                        System.out.println("💸 Transferencia simultánea: " + (exito ? "Exitosa" : "Fallida"));
                    });

                    extraccion.start();
                    transferencia.start();
                        } else {
                        System.out.println("EL CAJERO" + atm1 + "Esta inactivo chavo");
                    }
                    break;

                case "4":
                    System.out.println("🚪 Saliendo del simulador...");
                    scanner.close();
                    return;

                default:
                    System.out.println("❌ Opción no válida. Intenta de nuevo.");
            }
        }
    }
}

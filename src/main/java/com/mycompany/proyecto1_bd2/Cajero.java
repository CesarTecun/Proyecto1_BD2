package com.mycompany.proyecto1_bd2;

import java.util.Scanner;

public class Cajero {

    public static void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("💳 Bienvenido al Cajero Automático");
        System.out.print("Ingrese el número de su tarjeta: ");
        String numeroTarjeta = scanner.nextLine();

        System.out.print("Ingrese su PIN: ");
        String pin = scanner.nextLine();

        if (Validacion.validarPin(numeroTarjeta, pin)) {
            int tarjetaId = Validacion.obtenerTarjetaId(numeroTarjeta);
            int atmId = 1; // puedes cambiar esto si manejas múltiples ATM

            while (true) {
                System.out.println("\nSeleccione una opción:");
                System.out.println("1. Realizar extracción");
                System.out.println("2. Realizar transferencia");
                System.out.println("3. Salir");
                System.out.print("Opción: ");
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese monto a extraer: ");
                        double montoExtraccion = scanner.nextDouble();
                        Transacciones.realizarExtraccion(tarjetaId, montoExtraccion, atmId);
                        break;
                    case 2:
                        System.out.print("Ingrese número de cuenta destino: ");
                        int cuentaDestino = scanner.nextInt();
                        System.out.print("Ingrese monto a transferir: ");
                        double montoTransferencia = scanner.nextDouble();
                        Transacciones.realizarTransferencia(tarjetaId, cuentaDestino, montoTransferencia, atmId);
                        break;
                    case 3:
                        System.out.println("👋 Gracias por usar el cajero.");
                        return;
                    default:
                        System.out.println("❗ Opción no válida.");
                }
            }
        } else {
            System.out.println("🚫 PIN inválido. Acceso denegado.");
        }
    }
}

package com.mycompany.proyecto1_bd2;

import java.util.Scanner;

public class Cajero {

    public static void ejecutar() {
        Scanner sc = new Scanner(System.in);

        System.out.println("💳 Bienvenido al Cajero Automático");
        System.out.print("Ingrese el número de su tarjeta: ");
        String numeroTarjeta = sc.nextLine();

        System.out.print("Ingrese su PIN: ");
        String pin = sc.nextLine();

        // Validar PIN
        if (!Validacion.validarPin(numeroTarjeta, pin)) {
            System.out.println("⛔ PIN inválido. Acceso denegado.");
            return;
        }

        int tarjetaId = Validacion.obtenerTarjetaId(numeroTarjeta);
        if (tarjetaId == -1) {
            System.out.println("❌ No se encontró la tarjeta.");
            return;
        }

        int atmId = 1; // puedes cambiar o pedirlo por input

        while (true) {
            System.out.println("\n📋 MENÚ CAJERO");
            System.out.println("1. Realizar Extracción");
            System.out.println("2. Realizar Transferencia");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese monto a extraer: ");
                    double montoExtraccion = sc.nextDouble();
                    Transacciones.realizarExtraccion(tarjetaId, montoExtraccion, atmId);
                    break;
                case 2:
                    System.out.print("Ingrese cuenta destino: ");
                    int cuentaDestino = sc.nextInt();
                    System.out.print("Ingrese monto a transferir: ");
                    double montoTransferencia = sc.nextDouble();
                    Transacciones.realizarTransferencia(tarjetaId, cuentaDestino, montoTransferencia, atmId);
                    break;
                case 3:
                    System.out.println("👋 Gracias por usar el cajero.");
                    return;
                default:
                    System.out.println("❗ Opción no válida.");
            }
        }
    }
}

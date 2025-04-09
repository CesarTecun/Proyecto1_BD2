package com.mycompany.proyecto1_bd2;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cajero {

    public static void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("💳 Bienvenido al Cajero Automático");
        
        String numeroTarjeta;
        while (true) {
            System.out.print("Ingrese el número de su tarjeta: ");
            numeroTarjeta = scanner.nextLine();

            if (!numeroTarjeta.matches("\\d{16}")) {
                System.out.println("El número debe tener exactamente 16 dígitos.");
                continue;
            }

            if (!Validacion.existeTarjeta(numeroTarjeta)) {
                System.out.println("Tarjeta no encontrada o inactiva. Intente nuevamente.");
                continue;
            }
            break;
        }

        String pin;
        while (true) {
            System.out.print("Ingrese su PIN: ");
            pin = scanner.nextLine();

            if (!pin.matches("\\d{4}")) {
                System.out.println("El PIN debe tener exactamente 4 dígitos.");
                continue;
            }

            if (!Validacion.validarPin(numeroTarjeta, pin)) {
                System.out.println("PIN inválido. Intente nuevamente.");
                continue;
            }

            break; // si pasó ambas validaciones, se sale del ciclo
        }

        if (Validacion.validarPin(numeroTarjeta, pin)) {
            int tarjetaId = Validacion.obtenerTarjetaId(numeroTarjeta);
            int atmId = 1; // LO CAMBIAMOS DEPENDIENDO DEL ATM XD

            while (true) {
                System.out.println("\nSeleccione una opción:");
                System.out.println("1. Realizar extracción");
                System.out.println("2. Realizar transferencia");
                System.out.println("3. Salir");
                System.out.print("Opción: ");
                
                 String input = scanner.nextLine();
                 int opcion;
                 try{
                     opcion = Integer.parseInt(input);
                 }catch (NumberFormatException e){
                     System.out.println("Entrada no válida. intenta de nuevo");
                     continue;
                 }
                 
                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese monto a extraer: ");
                        if (scanner.hasNextDouble()) {
                            double montoExtraccion = scanner.nextDouble();
                            scanner.nextLine(); // limpiar salto de línea
                            if (montoExtraccion > 0) {
                                System.out.println("Confirma la extraccion con S " + montoExtraccion);
                                String confirmar = scanner.nextLine();
                                if (confirmar.equalsIgnoreCase("S")){
                                    Transacciones.realizarExtraccion(tarjetaId, montoExtraccion, atmId);
                                    mostrarSaldoRestante(tarjetaId);
                                } else{
                                    System.out.println("Operacion cancelada.");
                                }
                            } else {
                                System.out.println("El monto debe ser mayor que 0.");
                            }
                        } else {
                            System.out.println("Entrada inválida.");
                            scanner.nextLine(); // limpiar entrada inválida
                        }
                        break;

                    case 2:
                        System.out.print("Ingrese número de cuenta destino: ");
                        if (scanner.hasNextInt()) {
                            int cuentaDestino = scanner.nextInt();
                            scanner.nextLine(); // limpiar salto de línea
                            System.out.print("Ingrese monto a transferir: ");
                            if (scanner.hasNextDouble()) {
                                double montoTransferencia = scanner.nextDouble();
                                scanner.nextLine(); // limpiar salto de línea
                                if (montoTransferencia > 0) {
                                    System.out.println("Estas seguro de realizar la transferencia a " + cuentaDestino + "con un total de " + montoTransferencia);
                                    String confirmar = scanner.nextLine();
                                    if (confirmar.equalsIgnoreCase("S")){
                                        Transacciones.realizarTransferencia(tarjetaId, cuentaDestino, montoTransferencia, atmId);
                                        mostrarSaldoRestante(tarjetaId);
                                    } else{
                                        System.out.println("Operacion cancelada.");
                                    }
                                   
                                } else {
                                    System.out.println("❌ El monto debe ser mayor que 0.");
                                }
                            } else {
                                System.out.println("❌ Entrada inválida.");
                                scanner.nextLine(); // limpiar entrada inválida
                            }
                        } else {
                            System.out.println("❌ Número de cuenta inválido.");
                            scanner.nextLine(); // limpiar entrada inválida
                        }
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
    
    private static double leerMonto (Scanner scanner){
        try{
            double monto = Double.parseDouble(scanner.nextLine());
            if (monto <=0){
                System.out.println("El monto debe ser mayor que 0");
                return -1;
            }
            return monto;
        }catch (NumberFormatException e){
            System.out.println("Entrada invalida. intente con un numero");
            return -1;
        }
    }
    
    
     private static void mostrarSaldoRestante(int tarjetaId) {
        try (Connection conn = Conexion.getConnection()) {
            String query = "SELECT c.saldo FROM banco.CUENTA c JOIN banco.TARJETA t ON c.cuenta_id = t.cuenta_id WHERE t.tarjeta_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, tarjetaId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                double saldo = rs.getDouble("saldo");
                System.out.println("💰 Saldo actual: Q" + saldo);
            }
                } catch (SQLException e) {
             System.out.println("⚠️ No se pudo obtener el saldo restante.");
             e.printStackTrace(); 
         }

     }
     
}

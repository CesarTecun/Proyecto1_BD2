import java.util.Scanner;

public class Cajero {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese ID de tarjeta: ");
        int tarjetaId = sc.nextInt();

        System.out.print("Ingrese código de ATM: ");
        int atmId = sc.nextInt();

        while (true) {
            System.out.println("\n--- MENÚ CAJERO ---");
            System.out.println("1. Realizar extracción");
            System.out.println("2. Realizar transferencia");
            System.out.println("3. Salir");
            System.out.print("Opción: ");
            int op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.print("Monto a extraer: ");
                    double montoExt = sc.nextDouble();
                    Transacciones.realizarExtraccion(tarjetaId, montoExt, atmId);
                    break;
                case 2:
                    System.out.print("Cuenta destino: ");
                    int cuentaDestino = sc.nextInt();
                    System.out.print("Monto a transferir: ");
                    double montoTrans = sc.nextDouble();
                    Transacciones.realizarTransferencia(tarjetaId, cuentaDestino, montoTrans, atmId);
                    break;
                case 3:
                    System.out.println("¡Gracias por usar el cajero!");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}

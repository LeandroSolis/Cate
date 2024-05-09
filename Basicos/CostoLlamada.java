import java.util.Scanner;

public class CostoLlamada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la duración de la llamada en minutos: ");
        int duracionLlamada = scanner.nextInt();

        double costoBase = 5.0;
        double costoMinAdicional = 0.5;
        double costoTotal;

        if (duracionLlamada <= 5) {
            costoTotal = costoBase;
        } else {
            costoTotal = costoBase + (duracionLlamada - 5) * costoMinAdicional;
        }

        System.out.println("El monto a pagar por la llamada es: " + costoTotal + " pesos.");

        scanner.close();
    }
}

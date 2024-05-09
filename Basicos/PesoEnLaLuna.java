import java.util.Scanner;

public class PesoEnLaLuna {
    public static void main(String[] args) {
        
        final double PesoLuna = 0.17;

        // Crear un objeto Scanner para la entrada de usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que ingrese su peso en la Tierra
        System.out.print("Ingrese su peso en la Tierra (en kg): ");
        double pesoEnTierra = scanner.nextDouble();

        // Calcular el peso en la Luna
        double pesoEnLuna = pesoEnTierra * PesoLuna;

        // Mostrar el peso en la Luna
        System.out.println("Su peso en la Luna sería: " + pesoEnLuna + " kg");

        // Cerrar el scanner
        scanner.close();
    }
}

import java.util.Scanner;

public class SumaDigitosNumero {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int numero;

        do {
            // Solicitar al usuario que ingrese un número de 5 dígitos
            System.out.print("Ingrese un número entero de 5 dígitos: ");
            numero = scanner.nextInt();

            // Verificar si el número tiene exactamente 5 dígitos
            if (numero <= 10000 || numero > 99999) {
                System.out.println("Error: Debe ingresar un número de 5 dígitos. Inténtelo de nuevo.");
            }
        } while (numero <= 10000 || numero > 99999);

        // Calcular la suma de los dígitos
        int suma = 0;
        int temp = numero;
        while (temp != 0) {
            suma += temp % 10;
            temp /= 10;
        }

        // Mostrar la suma de los dígitos
        System.out.println("La suma de los dígitos del número es: " + suma);

        
        scanner.close();
    }
}

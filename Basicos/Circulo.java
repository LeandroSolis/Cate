import java.util.Scanner;

public class Circulo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el radio del círculo como un número entero: ");
        int radio = scanner.nextInt();

        double pi = 3.14159;
        double diametro = 2 * radio;
        double circunferencia = 2 * pi * radio;
        double area = pi * radio * radio;

        System.out.println("Diámetro del círculo: " + diametro);
        System.out.println("Circunferencia del círculo: " + circunferencia);
        System.out.println("Área del círculo: " + area);

        scanner.close();
    }
}

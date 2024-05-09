import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear un arreglo para almacenar los números enteros
        int[] numeros = new int[10];
        
        // Pedir al usuario que ingrese 10 números enteros
        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor, introduce 10 números enteros:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Número " + (i+1) + ": ");
            numeros[i] = sc.nextInt();
        }
        
        // Mostrar los datos del vector con sus índices correspondientes
        System.out.println("Datos del vector con sus índices:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Índice [" + i + "]: " + numeros[i]);
        }
    }
}


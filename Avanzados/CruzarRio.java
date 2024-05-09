
import java.util.Scanner;
public class CruzarRio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean granjero = true; // true: lado inicial, false: lado opuesto
        boolean lobo = true;
        boolean gallina = true;
        boolean maiz = true;

        while (lobo || gallina || maiz) {
            System.out.println("Granjero cruza el río.");
            granjero = !granjero;

            if (!granjero) {
                System.out.println("El lobo se come a la gallina. ¡Has perdido!");
                break;
            }

            if (!granjero && !lobo && !gallina) {
                System.out.println("La gallina se come el maíz. ¡Has perdido!");
                break;
            }

            System.out.println("¿Quién cruza con el granjero? (Escribe: lobo, gallina, maiz)");
            String elemento = scanner.nextLine();

            switch (elemento) {
                case "lobo":
                    lobo = !lobo;
                    break;
                case "gallina":
                    gallina = !gallina;
                    break;
                case "maiz":
                    maiz = !maiz;
                    break;
                default:
                    System.out.println("Opción inválida. Inténtalo de nuevo.");
            }
        }

        if (!lobo && !gallina && !maiz) {
            System.out.println("¡Felicidades! Has logrado cruzar el río con el granjero, el lobo, la gallina y el maíz.");
        }

        scanner.close();
    }
}

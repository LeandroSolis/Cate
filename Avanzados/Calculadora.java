import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la expresión matemática a evaluar:");
        String expresion = scanner.nextLine();

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");

        try {
            Object resultado = engine.eval(expresion);
            System.out.println("El resultado es: " + resultado);
        } catch (ScriptException e) {
            System.out.println("Error al evaluar la expresión. Por favor, asegúrese de ingresar una expresión matemática válida.");
        }
    }
}

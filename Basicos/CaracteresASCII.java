public class CaracteresASCII {
    public static void main(String[] args) {
        int inicio = 30;
        int fin = 126;
        int columnas = 15;

        int contador = 0;

        for (int i = inicio; i <= fin; i++) {
            System.out.print((char) i + " ");
            contador++;

            if (contador == columnas) {
                System.out.println();
                contador = 0;
            }
        }
    }
}

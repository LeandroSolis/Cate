public class PoblacionMundial {
    public static void main(String[] args) {
        long poblacionActual = 7309784505l;
        long crecimientoAnual = 24807909l;

        for (int i = 1; i <= 5; i++) {
            poblacionActual += crecimientoAnual;
            System.out.println("Población mundial después de " + i + " año(s): " + poblacionActual);
        }
    }
}

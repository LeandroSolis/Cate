class Frasco {
    String color;
    boolean toxico;

    Frasco(String color) {
        this.color = color;
        this.toxico = false;
    }

    void marcarToxico() {
        this.toxico = true;
    }

    boolean esToxico() {
        return this.toxico;
    }

    String getColor() {
        return this.color;
    }
}

public class ResolverFrascos {
    public static void main(String[] args) {
        Frasco rojo = new Frasco("rojo");
        Frasco anaranjado = new Frasco("anaranjado");
        Frasco amarillo = new Frasco("amarillo");
        Frasco azul = new Frasco("azul");
        Frasco violeta = new Frasco("violeta");

        // Marcamos los frascos con veneno según las pistas
        azul.marcarToxico();
        amarillo.marcarToxico();
        anaranjado.marcarToxico();

        // Verificamos si el frasco rojo no es tóxico
        if (!rojo.esToxico()) {
            System.out.println("El líquido del frasco rojo no es venenoso.");
        }

        // Mostramos los frascos con líquidos tóxicos
        System.out.println("Frascos con líquidos tóxicos:");
        if (violeta.esToxico()) {
            System.out.println("Violeta");
        }
        if (azul.esToxico()) {
            System.out.println("Azul");
        }
        if (amarillo.esToxico()) {
            System.out.println("Amarillo");
        }
        if (anaranjado.esToxico()) {
            System.out.println("Anaranjado");
        }
    }
}

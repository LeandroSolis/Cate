public class ProblemaMujeresTrabajos {

    public static void main(String[] args) {
        String[] mujeres = {"Clara", "Luisa", "María", "Nélida"};
        String[] trabajos = {"diseñadora de moda", "florista", "jardinera", "directora de orquesta"};
        
        for (String mujer1 : mujeres) {
            for (String trabajo1 : trabajos) {
                for (String mujer2 : mujeres) {
                    for (String trabajo2 : trabajos) {
                        if (!mujer1.equals(mujer2) && !trabajo1.equals(trabajo2)) {
                            // Clara es violentamente alérgica a las plantas
                            if (mujer1.equals("Clara") && trabajo2.equals("jardinera")) continue;
                            // Luisa y la florista comparten el departamento
                            if (mujer2.equals("Luisa") && !trabajo2.equals("florista")) continue;
                            // A María y Luisa les gusta solamente la música rock
                            if ((mujer1.equals("María") || mujer2.equals("María")) &&
                                    (!trabajo1.equals("directora de orquesta") || !trabajo2.equals("directora de orquesta"))) continue;
                            // La jardinera, la diseñadora de modas y Nélida no se conocen entre sí
                            if ((trabajo1.equals("jardinera") || trabajo1.equals("diseñadora de moda") || mujer1.equals("Nélida")) &&
                                    (trabajo2.equals("jardinera") || trabajo2.equals("diseñadora de moda") || mujer2.equals("Nélida"))) continue;

                            // Si no se cumple ninguna de las condiciones anteriores, encontramos una solución
                            System.out.println("Clara es " + trabajo1);
                            System.out.println("Luisa es " + trabajo2);
                            for (String mujer3 : mujeres) {
                                if (!mujer3.equals(mujer1) && !mujer3.equals(mujer2)) {
                                    for (String trabajo3 : trabajos) {
                                        if (!trabajo3.equals(trabajo1) && !trabajo3.equals(trabajo2)) {
                                            // Llena el resto de la solución
                                            if (mujer3.equals("María") && !trabajo3.equals("directora de orquesta")) continue;
                                            if (mujer3.equals("Nélida") && (trabajo3.equals("jardinera") || trabajo3.equals("diseñadora de moda"))) continue;
                                            System.out.println("María es " + trabajo3);
                                            for (String mujer4 : mujeres) {
                                                if (!mujer4.equals(mujer1) && !mujer4.equals(mujer2) && !mujer4.equals(mujer3)) {
                                                    for (String trabajo4 : trabajos) {
                                                        if (!trabajo4.equals(trabajo1) && !trabajo4.equals(trabajo2) && !trabajo4.equals(trabajo3)) {
                                                            System.out.println("Nélida es " + trabajo4);
                                                            return;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


public class NrosEntre4y14 {
    public static void main(String[] args) {
        
        int[] numeros = new int[11]; 

        for (int i = 4; i <= 14; i++) {
            numeros[i - 4] = i; 
        }
        
       
        System.out.println("Datos del arreglo con sus índices:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Índice [" + i + "]: " + numeros[i]);
        }
    }
}

public class NrosPares {
    public static void main(String[] args) {
        
        int[] numerosPares = new int[50]; 
        
        int indice = 0;
        
        
        for (int i = 2; i <= 100; i += 2) {
            numerosPares[indice] = i; 
            indice++;
        }
        
       
        System.out.println("Números pares del 1 al 100 con sus índices:");
        for (int i = 0; i < numerosPares.length; i++) {
            System.out.println("Índice [" + i + "]: " + numerosPares[i]);
        }
    }
}

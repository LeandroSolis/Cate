public class Nros5 {
        public static void main(String[] args) {
            
            int[] arregloOriginal = new int[5];
    
            
            for (int i = 0; i < 5; i++) {
                arregloOriginal[i] = i + 1; 
            }
    
            
            int[] copiaArreglo = new int[5];
    
            
            for (int i = 0; i < 5; i++) {
                copiaArreglo[i] = arregloOriginal[i];
            }
    
            
            System.out.println("Arreglo Original:");
            for (int i = 0; i < 5; i++) {
                System.out.println("Índice [" + i + "]: " + arregloOriginal[i]);
            }
    
           
            System.out.println("\nArreglo Copiado:");
            for (int i = 0; i < 5; i++) {
                System.out.println("Índice [" + i + "]: " + copiaArreglo[i]);
            }
        }
    }
    


package pilas;

/**
 *
 * @author Emiliano Sandoval
 */
public class InvierteCad {
    
    /**
     * 
     * @param cadena: cadena que se quiere invertir
     * @return cadena invertida
     */
    public static String invierteCadena(String cadena){
        PilaA<Character> aux = new PilaA();
        StringBuilder sB = new StringBuilder();
        
        for(int i = 0;i < cadena.length(); i++){
            aux.push(cadena.charAt(i));
        }
        
        while (!aux.isEmpty()) {
            sB.append(aux.pop());
        }
        
        return sB.toString();
    }
    
    public static void main(String[] args) {
       
        System.out.println(invierteCadena("hola"));
    }
}

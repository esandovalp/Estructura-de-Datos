
package pilas;

/**
 *
 * @author Emiliano Sandoval
 * @param <T>
 */
public class RevisorParentesis<T> {
    private String cadena; 

    public RevisorParentesis(String cadena) {
        this.cadena = cadena;
    }
    
    //hay que garantizar que cada vez que haya un parentesis izquierdo encuentre su pareja derecha, y viceversa 
    /**
     * 
     * @param cadena que se va a analizar
     * @return 
     */
    public static boolean parentesisBalanceados(String cadena) {   // esta solucion no garantiza que esten bien balanceados 
        PilaA <Character> aux = new PilaA();
        boolean resp = true; 
        int i = 0;
        
        while(i < cadena.length() && resp){
            if(cadena.charAt(i) == '(') 
                aux.push(cadena.charAt(i));
            else if (cadena.charAt(i) == ')') {
                
                if(aux.isEmpty())
                    resp = false;
                else 
                    aux.pop();           
            }
          i++;      
        }
        return resp && aux.isEmpty(); 
    }
    
    public static void main(String[] args) {
        System.out.println(parentesisBalanceados("((Hola mundo))"));
    }
}

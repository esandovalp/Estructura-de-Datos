
package pilas;

/**
 *
 * @author Emiliano Sandoval
 */
public class ExcepcionColeccionVacia extends RuntimeException {

    public ExcepcionColeccionVacia() {
        super();
    }
    
    public ExcepcionColeccionVacia(String mensaje) {
        super(mensaje);
    }
     
}

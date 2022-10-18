/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author coron
 */
public class ExcepcionColeccionVacia extends RuntimeException {

    public ExcepcionColeccionVacia() {
        super();
    }
    
    public ExcepcionColeccionVacia(String mensaje) {
        super(mensaje);
    }
    
}

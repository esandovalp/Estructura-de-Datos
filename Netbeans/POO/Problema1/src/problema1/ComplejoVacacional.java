
package problema1;

import java.util.ArrayList;

public class ComplejoVacacional {
    private String nombre;
    private int numAlb;
    private Rectangulo albercas[];
    private final int MAX=10;

    public ComplejoVacacional() {
        this.numAlb=0;
        this.albercas = new Rectangulo[MAX];
    }

    public ComplejoVacacional(String nombre) {
        this();     // este this() llama al primer constructor
        this.nombre = nombre;
    }
    
    /*
    public ComplejoVacacional(String nombre, int maximoDeAlbercas) {
       this();
        alb = new Rectangulo[maximoDeAlbercas];
    }
    */
    
    public void registraAlberca(double base, double altura ) {
        if (numAlb <= MAX) {
            Rectangulo r = new Rectangulo(base, altura);
            albercas[numAlb] = r;
            numAlb++;
        }
    }
    
    /*
    public boolean registraAlberca(double base, double altura ) {
        boolean resp = false;
        if (numAlb <= MAX) {
            resp = true;
            Rectangulo r = new Rectangulo(base, altura);
            albercas[numAlb] = r;
            numAlb++;
        }
        return resp;
    }
    */
    
    public double totalMetrosLona(){
        double metros=0;
        for (int i=0;i<numAlb;i++){
            metros = metros + albercas[i].calculaArea();
        }
        return metros;
    }
    
    public double totalMetrosLineales() {
        double metros=0;
        for (int i=0; i<numAlb;i++){
            metros = metros + albercas[i].calculaPerimetro();
        }
        return metros;
    }
    
    
}

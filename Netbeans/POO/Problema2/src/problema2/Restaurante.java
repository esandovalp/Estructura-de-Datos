
package problema2;

public class Restaurante {
    private String nombre;
    private int numMesas;
    private Cuadrado[] mesas; 
    private final int MAX = 25;

    public Restaurante() {
        this.numMesas=0;
        this.mesas = new Cuadrado[MAX];
    }

    public Restaurante(String nombre) {
        this();
        this.nombre = nombre;
    }
    
    public boolean registraMesas(double largo) {
        boolean resp = false; 
        if (numMesas<=MAX){
            Cuadrado c = new Cuadrado(largo);
            mesas[numMesas] = c;
            numMesas++;
            resp = true;
        }
        return resp;
    }
    
    public double totalMetrosTela() {
        double metros=0;
        for (int i=0; i<numMesas;i++)
            metros = metros + mesas[i].calculaArea();
        return metros;
    }
    
      public double totalMetrosLineales() {
        double metros=0;
        for (int i=0; i<numMesas;i++)
            metros = metros + mesas[i].calculaPerimetro();
        return metros;
    }
}


package problema2;

public class Cuadrado {
    private double lado;

    public Cuadrado() {
    }

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    @Override
    public boolean equals(Object obj) {
        boolean resp = false;
        Cuadrado c = (Cuadrado) obj;
        
        if(obj == this)
            resp = true;
        if(obj != this)
            resp = false;
        return resp;
    }

    public String toString() {
        return "Cuadrado de lado: " + this.lado;
    }
    
    public double calculaArea() {
        return lado*lado;
    }
    
    public double calculaPerimetro(){
        return lado+lado+lado+lado;
    }
}

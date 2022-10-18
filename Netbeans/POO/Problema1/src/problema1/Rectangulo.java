
package problema1;

public class Rectangulo {
    private double lado1;
    private double lado2;

    public Rectangulo() {
    }

    public Rectangulo(double lado1, double lado2) {
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    public double getLado1() {
        return lado1;
    }

    public double getLado2() {
        return lado2;
    }

    @Override
    public boolean equals(Object obj) {
        //return super.equals(obj); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        Rectangulo r = (Rectangulo) obj;
        boolean resp;
       
        resp = ((r.lado1 == this.lado1 && r.lado2 == this.lado2)
                || (r.lado1 == this.lado2 && r.lado2 == this.lado1));
        return resp;
    }

    @Override
    public String toString() {
        return "Lado 1 del rectángulo: " + this.lado1 + "\n Lado 2 del rectángulo: " + this.lado2;
    }
    
    public double calculaArea() {
        return lado1*lado2;
    }
    
    public double calculaPerimetro() {
        return (lado1*2)+(lado2*2);
    }
    
}

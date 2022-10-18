/**
 * 
 * @author Emiliano Sandoval
 */
public abstract class Quadrilatero implements FiguraGeometrica {
    double lado1;
    double lado2;

    public Quadrilatero() {
    }

    public Quadrilatero(double l1, double l2) {
        this.lado1 = l1;
        this.lado2 = l2;
    }

    @Override
    public double calculaArea(){
        return lado1*lado2;
    }
    
    @Override
    public double calculaPerimetro(){
        return lado1 * 2 + lado2 * 2;
    }
}

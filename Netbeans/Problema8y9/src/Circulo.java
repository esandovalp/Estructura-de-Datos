/**
 * 
 * @author Emiliano Sandoval
 */
public class Circulo implements FiguraGeometrica {
    double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double calculaArea() {
        return Math.PI*radio*radio;
    }

    @Override
    public double calculaPerimetro() {
        return 2*Math.PI*radio;
    }
    
}

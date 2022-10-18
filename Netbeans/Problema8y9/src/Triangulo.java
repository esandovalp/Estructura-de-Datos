/**
 * 
 * @author Emiliano Sandoval
 */
public class Triangulo implements FiguraGeometrica {
    double lado1, lado2, lado3;

    public Triangulo() {
    }

    public Triangulo(double lado1, double lado2, double lado3) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    public double getLado1() {
        return lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public double getLado3() {
        return lado3;
    }
    
    
    //sqrt(s*(s-a)*(s-b)*(s-c)): Formula para el area de un triangulo dados 3 lados 
    @Override
    public double calculaArea() {
        double s, area;
        
        s = (lado1 + lado2 + lado3)/2;
        
        area = Math.sqrt(s*(s - lado1)*(s - lado2)*(s - lado3));
        
        return area;
    }

    @Override
    public double calculaPerimetro() {
        return lado1 + lado2 + lado3;
    }
    
    
}


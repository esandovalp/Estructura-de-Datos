/**
 * 
 * @author Emiliano Sandoval
 */
public class Problema9 {
    FiguraGeometrica[] figuras;
    final int MAX = 20;
    int totalF;

    public Problema9() {
        figuras = new FiguraGeometrica[MAX];
        this.totalF = 0;
    }
    
    /**
     * 
     * @param a: lado 1
     * @param b: lado 2
     * @param c: lado 3 
     * @return Alta de un triangulo dados tres lados 
     */
    public boolean altaFigurasTriangulo(double a, double b, double c) {
        boolean resp = false;
        
        if(totalF<MAX){
            figuras[totalF] = new Triangulo(a, b, c);
            totalF++;
            resp = true;
        }
        
        return resp;
    }
    
      /**
     * 
     * @param base
     * @param altura
     * @return Alta Quadrilatero
     */
    public boolean altaFigurasRectangulo(double base, double altura) {
        boolean resp = false;
        
        if(totalF<MAX){
            resp = true;
            figuras[totalF] = new Rectangulo(base, altura);
            totalF++;
        }
        
        return resp;
    }
    
    /**
     * 
     * @param lado
     * @return Alta de un cuadrado
     */
    public boolean altaFigurasCuadrado(double lado){
        boolean resp = false;
        
        if(totalF < MAX){
            resp = true;
            figuras[totalF] = new Cuadrado(lado);
            totalF++;
        }
        return resp; 
    }
    
    /**
     * 
     * @param radio
     * @return Alta Circulo
     */
    public boolean altaFigurasCirculo(double radio) {
        boolean resp = false;
        
        if(totalF<MAX){
            figuras[totalF] = new Circulo(radio);
            totalF++;
            resp = true;
        }
        
        return resp;
    }
    
    /**
     * 
     * @return Imprime area y tipo de cada una de las figuras 
     */
    public String cadenaFiguras(){
        StringBuilder sB = new StringBuilder();
        
        for (int i=0;i<totalF;i++){
            sB.append(figuras[i].getClass().getSimpleName()).append("\nArea: ").append(figuras[i].calculaArea()).append("\n");
        }
        
        return sB.toString();
    }
    
    /**
     * 
     * @return Regresa los datos del circulo mas grande
     */
    public String circuloGrande() {
        StringBuilder sB = new StringBuilder();
        double area=0, perimetro = 0;
        
        for(int i=0;i<figuras.length;i++){
            if(figuras[i] instanceof Circulo){
                if(figuras[i].calculaArea() >= area){
                    area = figuras[i].calculaArea();
                    perimetro =  figuras[i].calculaPerimetro();
                }
            }  
                
        }
        sB.append("Datos del circulo mas grande: \n").append("Area: ").append(area).append("\nPerimetro: ").append(perimetro);
        
        return sB.toString();
    }
    
    /**
     * 
     * @return Total de cuadrados.
     */
    public String totalCuadrados(){
        StringBuilder sB = new StringBuilder();
        int total = 0;
        
        for(int i=0;i<figuras.length;i++){
            if(figuras[i] instanceof Cuadrado)
                total = total + 1;
        }
        sB.append("Total de cuadrados: ").append(total);
        
        return sB.toString();
    }
    
    // Eliminar todos los triángulos equiláteros. Me esta quitando el ultimo cuadrado que hice x|x| x
    public void eliminaEquilateros(){
        int i=0;
        
        while(i<totalF){
            if(figuras[i] instanceof Triangulo triangulo){
                if(triangulo.getLado1() == triangulo.getLado2() && triangulo.getLado2() == triangulo.getLado3() ) {
                    figuras[i] = figuras[totalF-1]; // le asigno el ultimo lugar
                    totalF--;   // los recorro 
                } else
                    i++; 
            } else
                i++;
        }
        
    }
}

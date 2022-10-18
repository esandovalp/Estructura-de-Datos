
package problema3;

public class Alumno {
    private static int serie = 100;
    private int claveUnica;
    private String nombreAlum;
    private double[] califMateriasAprob;    // arreglo con materias aprobadas
    private int totalCalif;     // total de una calificación
    private int MAX_CALIF = 50;
    
    public Alumno(String nombre){
        this.nombreAlum = nombre;
        this.califMateriasAprob = new double[MAX_CALIF];
        this.claveUnica = serie;
        serie++;
        this.totalCalif=0;
    }

    public boolean altaCalificacion(double calif) {
        boolean resp = false; 
        
        if(totalCalif < MAX_CALIF && calif >= 6){
            califMateriasAprob[totalCalif]=calif;
            resp = true;
            totalCalif++;
        }
        
        return resp;
    }
    
    public String getNombreAlum() {
        return this.nombreAlum;
    }
    
    public boolean equals(Object obj){
        Alumno a = (Alumno) obj;
        boolean resp;
        
        resp = this.nombreAlum.equals(a.getNombreAlum()); // no abusar de los parentesis 
        return resp;
    }
    
    public String toString() {
        return "Alumno: " + this.nombreAlum + "\nClave unica: " + this.claveUnica;
    }
    
    public double calculaPromedio() {
        
        double promedio;
        
        if(totalCalif==0)
            promedio = -1;
        else {
            int suma=0;
            for(int i=0;i<totalCalif;i++) 
                suma += califMateriasAprob[i]; 
            promedio = (double) suma/totalCalif;
            
        }
        
      
        return promedio;
    }

    public int getClaveUnica() {
        return this.claveUnica;
    }
    
    public int getMateriasAprob() {
        return this.totalCalif;
    }
}


public class Alumno implements Comparable<Alumno> {
    private int claveUnica;
    private double promedio;
    
    public Alumno(int claveUnica){
        this.promedio = 0;
        this.claveUnica = claveUnica;
    }
    
    public Alumno(int claveUnica, double promedio){
        this.promedio = promedio;
        this.claveUnica = claveUnica;
    }
    
    public String toString() {
        return "Clave unica: " + this.claveUnica + "\nPromedio: " + this.promedio;
    }

    public int getClaveUnica() {
        return this.claveUnica;
    }

    public double getPromedio() {
        return promedio;
    }
    
    
    public boolean equals(Object obj){
        Alumno a = (Alumno) obj;
        
        return this.claveUnica == a.claveUnica;
    }

    @Override
    public int compareTo(Alumno o) {
        return this.claveUnica - o.claveUnica;
    }
}


public class Persona implements Comparable<Persona> {
    // la clase Persona tenga un método que, a partir de la fecha de nacimiento del pasajero,
    // calcule y regrese los años que tiene o que tendrá al 31 de diciembre.
    private String fechaDeNacimiento;

    public Persona(String fecha) {
        this.fechaDeNacimiento = fecha;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }
    
    // Se considerarán años cumplidos al 31 de diciembre del año en curso.
    // 31 12 2022 es la fecha base, para calcular su edad restamos? 01 03 2002  
    // La fecha de nacimiento se da "dia mes año" dia y mes con cero al principio si son meses con una unidad
    
    public int calculaEdad(){
        int año;
        
        String fecha = this.getFechaDeNacimiento();
        
        año = Integer.parseInt(fecha.substring(6));
        
        int res = 2022 - año;
        
        return res;
    }

    @Override
    public String toString() {
        return "" + calculaEdad();
    }
    
    
    
    public static void main(String[] args) {
        Persona p1 = new Persona("01 03 2002");
        
        System.out.println(p1.calculaEdad());
    }

    @Override
    public int compareTo(Persona otra) {
        return  this.calculaEdad() -  otra.calculaEdad()  ;
    }

   
}

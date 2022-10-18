
package problema4;

public class Operario extends Empleado {
    private int horasExtras;

    public Operario() {
    }

    public Operario(int claveEmpleado) {
        super(claveEmpleado);
    }

    public Operario(int horasExtras, String nombreEmpleado, double sueldoBase) {
        super(nombreEmpleado, sueldoBase);
        this.horasExtras = horasExtras;
    }

    public int getHorasExtras() {
        return horasExtras;
    }

    @Override
    public String toString() {
        return super.toString() + "\nHoras extras trabajadas: " + horasExtras; 
    }
      
    @Override       // este esta sobreescrito para quitar el error 
    public double calculaSalario(double prestac, double deduc) {
        return sueldoBase + prestac - deduc;
    }
    
    // este esta sobrecargado para cumplir con las necesidades del operario
    public double calculaSalario(double prestac, double deduc, double precioHorasExtras) {
        return calculaSalario(prestac, deduc) + horasExtras * precioHorasExtras;
    }
    
}

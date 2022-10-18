
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

    @Override
    public String toString() {
        return super.toString() + "\nHoras extras trabajadas: " + horasExtras; 
    }

    // Método sobrecargado
    public double calculaSalario (double prestac, double deduc, double precioHE){
        double salario;
        
        salario = super.calculaSalario(prestac, deduc) + precioHE * horasExtras;
        return salario;
    }
}

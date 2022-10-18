// Clase de un empleado Administrativo
package problema4;

public class Administrativo extends Empleado {      // Asi estoy heredando 
    private String departamento;
    private String telefono;

    public Administrativo(String departamento, String telefono, String nombreEmpleado, double sueldoBase) {
        super(nombreEmpleado, sueldoBase);
        this.departamento = departamento;
        this.telefono = telefono;
    }

    public Administrativo() {
        super();        // no lo necesito pero reforzamos la idea de que estamos sacandolo de empleado
    }

    public Administrativo(int claveEmpleado) {
        super(claveEmpleado);
    }

    public String getDepartamento() {
        return departamento;
    }
    
    public void cambioDepartamento(String departamentoNuevo) {
        this.departamento = departamentoNuevo;
    }

    @Override
    public String toString() {
        StringBuilder sB = new StringBuilder();
        
        sB.append(super.toString());
        sB.append("\nDepartamento: ").append(departamento);
        return sB.toString();
    }

    @Override
    public double calculaSalario(double prestac, double deduc) {
        return sueldoBase + prestac - deduc;
    }
    
    public double aumento(int porcentaje, double prestac, double deduc) {
        return calculaSalario(prestac, deduc) * porcentaje;
    }
    
}

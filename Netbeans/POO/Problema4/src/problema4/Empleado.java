
package problema4;

public class Empleado {
    private static int serie = 100;
    private int claveEmpleado;
    private String nombreEmpleado;
    private double sueldoBase;

    public Empleado() {         // es más auxiliar porque en realidad a una empresa no le interesa crear un empleado sin nombre ni sueldo 
        this.claveEmpleado = serie;
        serie++;
    }

    public Empleado(String nombreEmpleado, double sueldoBase) {
        this();
        this.nombreEmpleado = nombreEmpleado;
        this.sueldoBase = sueldoBase;
    }
    
    public Empleado (int claveEmpleado){
        this.claveEmpleado = claveEmpleado;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public int getClaveEmpleado() {
        return claveEmpleado;
    }

    @Override
    public String toString() {
        return "Empleado: " + nombreEmpleado + "\nClave: " + claveEmpleado;
    }

    @Override
    public boolean equals(Object obj) {
        Empleado e = (Empleado) obj;
        boolean resp = false;
        
        if(e.equals(obj))
            resp = true;
        return resp;
    }
    
    public double calculaSalario(double prestac, double deduc) {
        return sueldoBase + prestac/100 * sueldoBase - deduc/100 * sueldoBase;
    }
    
    public double aumento(int porcentaje, double prestac, double deduc) {
        return calculaSalario(prestac, deduc) * porcentaje;
    }
    
}

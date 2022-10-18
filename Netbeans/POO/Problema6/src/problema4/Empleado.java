// Documentar clases 
package problema4;

public abstract class Empleado {
    private static int serie = 100;
    private int claveEmpleado;
    private String nombreEmpleado;
    protected double sueldoBase;

    protected Empleado() {         // cualquier clase hija de empleado puede acceder a esto
        this.claveEmpleado = serie;
        serie++;
    }

    protected Empleado(String nombreEmpleado, double sueldoBase) {
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

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
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
    
    // abstracta porque no sabemos bien como se manejara el salario de otras clases 
    public abstract double calculaSalario(double prestac, double deduc);        
    
    
}

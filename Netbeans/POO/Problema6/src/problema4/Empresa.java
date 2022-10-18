
package problema4;

public class Empresa {
    private String nombreEmpresa;
    private Empleado[] empleados;
    private int totalE;
    private final int MAX = 20;

    public Empresa() {
       empleados = new Empleado[MAX];
       totalE = 0;
    }
    
    public Empresa(String nombreEmpresa) {
        this();
        this.nombreEmpresa = nombreEmpresa;
    }
    
    // public static <T> int busquedaSecuencial(T[] arreglo, int total, T claseAux)
    
    // alta administrativos 
    public boolean altaEmpleado(String nombreEmpleado, double sueldoBase, String departamento, String telefono) {
        boolean resp = false;
        
        if (totalE < empleados.length) {
            resp = true;
            empleados[totalE] = new Administrativo(departamento, telefono, nombreEmpleado, sueldoBase);
            totalE++;
        }
        
        return resp;
    }
    
    // alta operarios 
    public boolean altaEmpleado(String nombreEmpleado, double sueldoBase, int horasExtras) {
        boolean resp = false;
        
        if (totalE < empleados.length) {
            resp = true;
            empleados[totalE] = new Operario(horasExtras, nombreEmpleado, sueldoBase);
            totalE++;
        }
        
        return resp;
    }
    
    public String reporteEmpleados(){
        StringBuilder sB = new StringBuilder();
        
        for(int i=0; i<totalE;i++){
            sB.append("Nombre: ").append(empleados[i].getNombreEmpleado()).append("\nSueldo base: ").append(empleados[i].getSueldoBase()).append("\nClave: ").append(empleados[i].getClaveEmpleado()).append("\n");
            
            if (empleados[i] instanceof Administrativo)
                sB.append("Departamento: ").append(((Administrativo)empleados[i]).getDepartamento()).append("\n");
            
            else 
                sB.append("Horas extras: ").append(((Operario)empleados[i]).getHorasExtras()).append("\n");
            
        }
        
        return sB.toString();
    }
    
    public boolean actualizaSueldoAdmin(int clave, double sueldoNuevo) {
        boolean bandera = false; 
        int contador = 0;
        
        while (contador < totalE && bandera == false) {
            if (empleados[contador] instanceof Administrativo){
                if(empleados[contador].getClaveEmpleado() == clave) {
                    bandera = true;
                    empleados[contador].setSueldoBase(sueldoNuevo);
                    //nuevoSueldo = ((Administrativo)empleados[contador]).aumento(porcentaje, prestac, deduc);    // hacer a nivel empleado el cambio de sueldo
                }    
            }
            contador++;
        }
        
        return bandera;
    }
    
    public boolean cambioDepartamento(int clave, String nombreDepto) {
        boolean bandera = false;
        int contador = 0;
        
        while (contador < totalE && bandera == false){
            if(empleados[contador] instanceof Administrativo){
                if(((Administrativo)empleados[contador]).getClaveEmpleado() == clave) {
                    bandera = true;
                    ((Administrativo)empleados[contador]).cambioDepartamento(nombreDepto);
                }
            }
            contador++;
        }
        
        return bandera; 
    }
    
    // Generar un reporte con los nombres de todos los operarios que tienen un sueldo base menor
    // a cierta cantidad dada como parámetro. Además, debe incluir el total de empleados que cumplen con esa condición.
    public String reporteOperSueldo(double cantidad) {
        StringBuilder sB = new StringBuilder();
        int totalEmpleados = 0;
        
        for(int i=0;i<totalE;i++) {
            if(empleados[i] instanceof Operario) {
                if(empleados[i].getSueldoBase() < cantidad){
                    //bandera = true;
                    totalEmpleados = totalEmpleados + 1;
                    sB.append("Operarios con sueldo menor a la cantidad ").append(cantidad).append(":\n").append(empleados[i].getNombreEmpleado()).append("\n");
                }
            }
        }
        
        sB.append("\nTotal: ").append(totalEmpleados);
        
        return sB.toString();
    }
    
    // Suponiendo que el porcentaje de deducciones y aportaciones es el mismo para todos los administradores,
    // calcular e imprimir el salario de cada uno de los administradores. 
    // Además, imprimir el total de la nómina de la empresa (sólo con administradores).
    public String salarioAdminNomina() {
        StringBuilder sB = new StringBuilder();
        double totalNomina = 0;
        
        for(int i=0;i<totalE;i++) {
            if(empleados[i] instanceof Administrativo) {
                sB.append("Salario: ").append(empleados[i].getSueldoBase()).append("\n");
                totalNomina = totalNomina + empleados[i].getSueldoBase();
            }
        }
        sB.append("Total nomina: ").append(totalNomina);
        
        return sB.toString();
    }
    
}

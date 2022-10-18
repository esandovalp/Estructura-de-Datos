    
package problema4;

public class Empresa {
    private String nombreEmpresa;
    private Administrativo[] admin;
    private Operario[] oper;
    private int totalA;
    private int totalO;
    private final int MAXIMO = 20;

    public Empresa() {
        admin = new Administrativo[MAXIMO];
        totalA = 0;
        oper = new Operario[MAXIMO];
        totalO = 0;
    }
    
    public Empresa(String nombreEmpresa) {
        this();
        this.nombreEmpresa = nombreEmpresa;
    }
    
    public boolean altaEmpleado(String dep, String tel ,String nombre, double sueldo) {
        boolean resp = false; 
        
        if (totalA < admin.length){
            resp = true;
            admin[totalA] = new Administrativo(dep, tel, nombre, sueldo);
            totalA++;
        }
        return resp;
    }
    
    // sobrecargamos el metodo 
    // 1) Dar de alta tanto operarios como administrativos
    public boolean altaEmpleado(String nombre, double sueldo, int horas) {
        boolean resp = false; 
        
        if (totalO < oper.length){
            resp = true;
            oper[totalO] = new Operario(horas, nombre, sueldo);
            totalO++;
        }
        return resp;
    }
    
    public String reporteNombresSueldosAdministrativo() {
        StringBuilder sB = new StringBuilder();
        
        for (int i=0; i<totalA;i++){
            sB.append("Empleado: ").append(admin[i].getNombreEmpleado()).append("\nSueldo base: ").append(admin[i].getSueldoBase()).append("\n");
        }
        return sB.toString();
    }
    
    /*
        En la solución usa un Administrativo auxiliar con una clave, hace una busqueda secuencial
        La maestra lo que recomienda es hacer el aumento a nivel empleado
    */
    public double actualizaSueldoAdmin(int clave, int porcentaje, double prestac, double deduc){
        boolean flag = false;
        int contador = 0;
        
        double nuevoSueldo = 0;
        
        while(contador < totalA && flag == false) {
            
            if(admin[contador].getClaveEmpleado() == clave) {
                flag = true;
                nuevoSueldo = admin[contador].aumento(porcentaje, prestac, deduc);
            }
            
            else 
                contador++;
        }
        return nuevoSueldo;
    }
    
    
    /*
        su metodo necesito todo lo del sueldo del operario, igual usa una busqueda secuencial para buscar el operaio segun la clave
        y segun la posicion de la busqueda, imprime su sueldo preferentemente un double con la cantidad del sueldo 
    */
    public double cobroOperario(int clave, double prestac, double deduc, double precioHE){
        boolean flag = false;
        int contador = 0;
        double sueldo=0;
        
        while (contador < totalO && flag == false){
            if (oper[contador].getClaveEmpleado() == clave) {
                flag = true;
                sueldo = oper[contador].calculaSalario(prestac, deduc, precioHE);
            }
            else 
                contador++;
        }
        return sueldo;
    }
    
    // Generar un reporte con los nombres de todos los operarios que tienen un sueldo base menor a
    //cierta cantidad dada como parámetro. Además, debe incluir el total de empleados operarios
    // que cumplen con esa condición.
    public String reporteOperarios(double cantidad){
        StringBuilder sB = new StringBuilder();
        int totalEmpleados=0;
        
        for(int i=0;i<totalO;i++){
            if(oper[i].getSueldoBase() < cantidad) {
                totalEmpleados = totalEmpleados + 1;
                sB.append("Empleados: ").append(oper[i].getNombreEmpleado());   // si hubiera dejado mi total aqui a cada rato se hubiera puesto
            }
        } 
        sB.append("\nTotal: ").append(totalEmpleados);
        
        return sB.toString();
    }
    
}

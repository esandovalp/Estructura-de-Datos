/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package problema4;

/**
 *
 * @author coron
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empresa e = new Empresa();
        
        System.out.println("Altas: ");
        System.out.println(e.altaEmpleado("Pedro", 12000, "Severance", "4411"));
        System.out.println(e.altaEmpleado("Juan", 15000, 8));
        System.out.println(e.altaEmpleado("Lucas", 30000, "Severance","2232" ));
        System.out.println("---------------");
        System.out.println("Primer reporte: ");
        System.out.println(e.reporteEmpleados());
        
        System.out.println("---------------");
        System.out.println("Actualiza sueldo: ");
        System.out.println(e.actualizaSueldoAdmin(100,35000));
        
        System.out.println("-------------------");
        System.out.println("Cambio de departamento: ");
        System.out.println(e.cambioDepartamento(100, "Monsters inc."));
        
        System.out.println("-------------");
        System.out.println("Reporte empleados con cambio de departamento y sueldo actualizado: ");
        System.out.println(e.reporteEmpleados());
        
        System.out.println("----------------------");
        System.out.println(e.reporteOperSueldo(20000));
        System.out.println(e.salarioAdminNomina());
    }
    
    
}

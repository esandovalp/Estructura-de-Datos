
package problema4;

public class Problema4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Empresa ep1 = new Empresa("Nestle");
        System.out.println(ep1.altaEmpleado("Severance","2213123", "Juan", 12000));
        System.out.println(ep1.altaEmpleado("Severance", "2341556","Pedro", 10000));
        System.out.println(ep1.reporteNombresSueldosAdministrativo());
    }
    
}

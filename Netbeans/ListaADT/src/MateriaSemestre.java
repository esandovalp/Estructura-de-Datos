
import java.util.Iterator;


public class MateriaSemestre {
    private String nombre, salon, semestre, nombreMaestro;
    private ListaOrdenadaADT<Alumno> alumnos;
    private ListaOrdenadaADT<Libro> bibliografia;

    public MateriaSemestre() {
        
    }

    public MateriaSemestre(String nombre, String salon, String semestre, String nombreMaestro, ListaOrdenada<Alumno> alumnos, ListaOrdenada<Libro> bibliografia) {
        this.nombre = nombre;
        this.salon = salon;
        this.semestre = semestre;
        this.nombreMaestro = nombreMaestro;
        this.alumnos = new ListaOrdenada();
        this.bibliografia = new ListaOrdenada();
    }
    
    // 1) Un método que permita dar de baja un alumno de dicha materia.
    public boolean bajaAlumno(int claveUnica){
        boolean resp = false;
        
        if (!alumnos.estaVacia()){
            Alumno a = new Alumno(claveUnica);
            if(alumnos.contiene(a)) {
                alumnos.quita(a);
                resp = true;
            }
        }
        
        return resp;
    }
    
    // 2) Un método que permita dar de alta un alumno de dicha materia.
    public boolean altaAlumno(int claveUnica, double promedio){
        boolean resp = false;
        
        Alumno a = new Alumno(claveUnica, promedio);
        if (!alumnos.contiene(a)) {
            alumnos.agrega(a);
            resp = true;
        }
        
        return resp; 
    }
    
    // 3) Un método que permita cambiar el salón en el cual se imparte la materia.

    public void setSalon(String salon) {
        this.salon = salon;
    }
    
    // 4) Un método que permita agregar un libro como referencia de dicha materia.
    public boolean agregaLibro(String titulo, String nombreAutor){
        boolean resp = false;
        
        Libro l = new Libro(titulo, nombreAutor);
        if (!bibliografia.contiene(l)){
            bibliografia.agrega(l);
            resp = true;
        }
        
        return resp;
    }
    
    // 5) Un método que permite quitar uno de los libros dados como referencia de dicha materia.
    public boolean quitaLibro(String titulo, String nombreAutor){
        boolean resp = false;
        
        if (!bibliografia.estaVacia()){
            Libro l = new Libro(titulo, nombreAutor);
            if(bibliografia.contiene(l)) {
                bibliografia.quita(l);
                resp = true;
            }
        }
        
        return resp;
    }
    
    // 6) Un método que calcula y regresa el promedio de todos los alumnos inscritos en la materia.
    public double calculaPromedio(){
        double res = 0;
        int cont = 0;
        
        if (!alumnos.estaVacia()){
            for (Alumno a : alumnos){
                res = res + a.getPromedio();
                cont++;
            }
            
            res = res/cont;
        }
        
        return res;
    }
    
    //7) Un método que, dada la clave de un alumno, regrese en forma de cadena los datos del alumno. Si el alumno no se encuentra registrado, deberá regresar null.
    public String consultaAlumno(int clave){
        String res = null;
        
        if (!alumnos.estaVacia()){
            Alumno a = new Alumno(clave);
            if (alumnos.contiene(a)){
                res = a.toString();
            }
        }
        
        return res;
    }
    
    // 8) Un método que reciba un entero (n>0) y un promedio y que regrese true si hay, al menos, n alumnos con un promedio mayor al dado. 
    // En caso contrario deberá regresar false.
    
    
    public static void main(String[] args) {
        ListaOrdenadaADT<Alumno> alumnos = new ListaOrdenada();
        
        Alumno a1 = new Alumno(195557,8);
        
        alumnos.agrega(a1);
        
        System.out.println(alumnos.consultaPrimero());
        //MateriaSemestre mat = new MateriaSemestre("Estructura de Datos", "CC102","Indefinido","Silvia Guardati",);
    }
}

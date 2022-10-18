
package problema3;

import java.util.ArrayList;

public class Escuela {
    private String nombre;
    private String direccion;
    private int numAlumnos;
    private Alumno alumnos[];
    private final int MAX = 50;

    public Escuela() {
        this.numAlumnos = 0;
        this.alumnos = new Alumno[MAX];
    }

    public Escuela(String nombre, String direccion) {
        this();
        this.nombre = nombre;
        this.direccion = direccion;
    }
    
    public boolean registraAlumno(String nombre) {
        boolean resp= false;
        if (numAlumnos <= MAX){
            Alumno a = new Alumno(nombre);
            alumnos[numAlumnos] = a;
            numAlumnos++;
            resp = true;
        }
        return resp;
    }
    
    public String consultaClave(int clave) {
        String res = "No se encontro al alumno con esa clave";
        int contador;
        contador = buscaAlumno(clave);
        
        if(contador >= 0)
            res = alumnos[contador].toString() + "\n Su promedio es: " + alumnos[contador].calculaPromedio();
        return res;
    }
    
    public String promNombAlumnos(){
        StringBuilder sb = new StringBuilder();
        
        for (int i=0;i<numAlumnos;i++){
            sb.append("Nombre del alumno ").append(i+1).append(": ").append(alumnos[i].getNombreAlum());
            sb.append(". Su promedio es: ").append(alumnos[i].calculaPromedio());
        }
        return sb.toString();
    }
    
    public String materiasAprob() {
        String res = "No hay materias aprob" ;
        int max = 0;
        for(int i=0;i<numAlumnos;i++) {
            if(alumnos[i].getMateriasAprob() > max) {
                max = alumnos[i].getMateriasAprob();
                res = alumnos[i].getNombreAlum();
            }
        }
        return res;
    }
    
    public ArrayList<String> maxMateriasRepetidas() {
        ArrayList<String> res = new ArrayList();
        int max = 0;
        
        for (int i=0;i<numAlumnos;i++){
            if(alumnos[i].getMateriasAprob() > max ){
                max = alumnos[i].getMateriasAprob();
                res.clear();
                res.add(alumnos[i].getNombreAlum());
            } else {
                if(alumnos[i].getMateriasAprob() == max) 
                    res.add(alumnos[i].getNombreAlum());
            }
        }
        return res;
    }
    
    private int buscaAlumno(int clave){     // de trabajo auxiliar en escuela 
        int contador = 0;
        boolean indicador = true;
        
        while(contador < numAlumnos && indicador) {     // busqueda secuencial 
            
            if( alumnos[contador].getClaveUnica() == clave)
                indicador = false;      // me sirve para salirme ciclo 
            else 
                contador++;
        } 
        
        if (indicador)        // si no tengo un alumno con esa clave
            contador = -1;
        
        return contador;
    }
    
    public boolean altaCalif(int clave, double cal) {
        int pos;
        boolean res = false; 
        
        pos = buscaAlumno(clave);
        if(pos >= 0) // quiere decir que si tengo un alumno con esa clave 
            res = alumnos[pos].altaCalificacion(cal);
        return res;
    }
    
}

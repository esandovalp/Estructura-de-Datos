
public class Libro implements Comparable<Libro>{
    private String nombreAutor;
    private String titulo;

    public Libro() {
    }

    public Libro(String titulo, String nombreAutor) {
        this.titulo = titulo;
        this.nombreAutor = nombreAutor;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public int compareTo(Libro o) {
        return this.titulo.compareTo(o.nombreAutor);
    }
}

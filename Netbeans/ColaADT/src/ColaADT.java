
import java.util.ArrayList;


public interface ColaADT <T> {
    public void agrega (T dato);
    public T saca();
    public T consultaPrimero();
    public boolean estaVacia();
    public int cuentaElementos();
    public T consultaUltimo();
    public ArrayList<T> multiQuita(int n);
}

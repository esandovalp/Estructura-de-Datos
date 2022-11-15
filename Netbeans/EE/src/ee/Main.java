
package ee;

public class Main {
    public static void main(String[] args) {
        EE <Integer> ejem1 = new EE();
        System.out.println("\nLuego de construir la EE: " + ejem1);
        System.out.println("\nLuego de eliminar el primero de una EE vacia: " + ejem1.quitaPrimero());
        System.out.println("\nLuego de construir busqueda de un elemento: " + ejem1.buscaElemento(3));
        ejem1.agregaInicio(12);
        System.out.println("\nDato eliminado de una EE con 1 elemento: " + ejem1.quitaPrimero());
        System.out.println("\nLuego de eliminar el primer de una EE que queda vacia: " + ejem1);
        
        ejem1.agregaInicio(10);
        ejem1.agregaInicio(8);
        ejem1.agregaInicio(6);
        ejem1.agregaInicio(4);
        System.out.println("\nLuego de agregar al inicio: " + ejem1);
        ejem1.agregaFinal(44);
        ejem1.agregaFinal(33);
        ejem1.agregaFinal(22);
        ejem1.agregaFinal(11);
        System.out.println("\nLuego de agregar al final: " + ejem1);
        System.out.println("\nDato eliminado de una EE con quitaUltimo: " + ejem1.quitaUltimo());
        System.out.println("\nLuego de eliminar el ultimo elemento: " + ejem1);
        
        int elemento = 99;
        System.out.println("\nPrueba busqueda de " + elemento + ": " + ejem1.buscaElemento(elemento));
        System.out.println("\nPrueba busqueda booleana " + elemento + ": " + ejem1.buscaElementoBooleano(elemento));
        
        int aBorrar = 22;
        System.out.println("\nElemento borrado: " + ejem1.eliminaElemento(aBorrar));
        System.out.println("EE despues de borrar " + aBorrar + ": " + ejem1);
        
        int eliS = 4;
        System.out.println("\nElimina siguinte a " + eliS + ": ");
        System.out.println(ejem1.eliminaSiguienteDe(eliS));
        System.out.println(ejem1);
        
        
        int eliA = 4;
        System.out.println("\nElimina anterior a " + eliA + ": ");
        System.out.println(ejem1.eliminaAnteriorA(eliA));
        System.out.println(ejem1);
        
        int aAgregar = 78;
        int antesDe = 4;
        System.out.println("\nAgrega antes de " + antesDe + ": " + ejem1.insertaAntesQue(antesDe,aAgregar) );
        System.out.println(ejem1);
        
        EE <Integer> ejem2 = new EE();
        
        ejem2.agregaFinal(1);
        ejem2.agregaFinal(1);
        ejem2.agregaFinal(2);
        ejem2.agregaFinal(2);
        ejem2.agregaFinal(2);
        ejem2.agregaFinal(2);
        ejem2.agregaFinal(3);
        ejem2.agregaFinal(4);
        ejem2.agregaFinal(4);
        ejem2.agregaFinal(4);
        
        System.out.println("\nEE 2 ordenada: " + ejem2);
        System.out.println("\nElimina todos repetidos ordenado: " + ejem2.eliminaTodosRepetidosOrdenado());
        System.out.println("\n" + ejem2);
        
        EE <Integer> ejem3 = new EE();
        
        ejem3.agregaFinal(1);
        ejem3.agregaFinal(5);
        ejem3.agregaFinal(8);
        ejem3.agregaFinal(6);
        ejem3.agregaFinal(1);
        ejem3.agregaFinal(7);
        ejem3.agregaFinal(5);
        ejem3.agregaFinal(4);
        ejem3.agregaFinal(5);
        ejem3.agregaFinal(1);
        
        System.out.println("\nEE 3 desordenada: " + ejem3);
        System.out.println("\nElimina todos repetidos desordenado: " + ejem3.eliminaTodosRepetidoDesordenado());
        System.out.println("\n" + ejem3);
        
        System.out.println("\nMezcla de EE:");
        System.out.println("\nEE2: " + ejem2);
        System.out.println("EE3: " + ejem3);
        ejem3.merge(ejem2);
        System.out.println("EE2 y EE3 mezclados: " + ejem3);
        
        
    }
}

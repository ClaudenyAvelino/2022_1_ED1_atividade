// package ListaOrdenada;

public class Main {
    public static void main(String[] args) throws Exception {
        
        ListaEncOrdenada<Integer> listaOrdenada = new ListaEncOrdenada<>();

        listaOrdenada.incluir(5);
        listaOrdenada.incluir(7);
        listaOrdenada.incluir(8);
        listaOrdenada.incluir(9);

        // Aqui vai dá erro porque, 10 é maior q 5 e a Lista é CRESCENTE!!
        listaOrdenada.incluirInicio(10); 
        listaOrdenada.incluirInicio(3);

        listaOrdenada.incluir(6, 3);

        System.out.println("\n\n");
        listaOrdenada.imprimirLista();
        listaOrdenada.setTipoOrdenacao(false);
        listaOrdenada.imprimirLista();
    }
}

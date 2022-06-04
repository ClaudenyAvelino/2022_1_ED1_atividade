package br.edu.ifs.ED.lista;

public class ListaEncOrdenada <T extends Comparable<T>> extends ListaEnc<T>{

    public No<T> inicio;
    int qtd;

    public ListaEncOrdenada() {
        this.inicio = null;
        this.qtd=0;
    }

    public boolean isVazia() {
        if (inicio == null) {
            return true;
        }
        return false;
    }
    //pega INICIO NO
    private No<T> PegarNo(int posicao) throws  Exception{
        if (posicao > getTamanho()) {
            throw new Exception("Posição solicitada não existe na lista");
        }
        No<T> auxPegaNo = null;
        for (int i = 0; i <= posicao; i++) {
            if (i == 0) {
                auxPegaNo = this.inicio;
            } else {
                auxPegaNo = auxPegaNo.getProx();
            }
        }
        return auxPegaNo;
    }
    //FIM PEGA NO

    @Override
    public  void incluir(T elemento) throws Exception {
        for (int i = 0; i < getTamanho(); i++) {
            No<T> Atual = PegarNo(i);
            if ( Atual.getDado().equals(elemento)) {
                throw new Exception("Elemento já existe na lista");
            }
        }
        No novo = new No(elemento);
        if (inicio == null || inicio.dado.compareTo(elemento) > 0) {
            novo.prox = inicio;
            inicio = novo;
            this.qtd++;
        } else {
            No aux = inicio;
            while (aux.prox != null && (elemento).compareTo((T) aux.prox.dado) > 0) {
                aux = aux.prox;
            }
            novo.prox = aux.prox;
            aux.prox = novo;
            this.qtd++;
        }
    }

    @Override
    public void incluirInicio(T elemento) throws Exception {
        No<T> novoNo = new No<T>(elemento, null);
        if (inicio == null) {
            inicio = novoNo;
        } else {
            novoNo.setProx(inicio);
            inicio = novoNo;
        }
        qtd++;
    }
    public No<T> getCauda(){
        No<T> aux = inicio;
        if (aux == null) {
            return null;
        }
        while (aux.getProx() != null) {
            aux = aux.getProx();
        }
        return aux;
    }

    @Override
    public void incluir(T elemento, int posicao) throws Exception {
        for (int i = 0; i < getTamanho(); i++) {
            No<T> Atual = PegarNo(i);
            if ( Atual.getDado().equals(elemento)) {
                throw new Exception("Elemento já existe na lista");
            }
        }
        No novo = new No(elemento);
        if (inicio == null || inicio.dado.compareTo(elemento) > 0) {
            novo.prox = inicio;
            inicio = novo;
            this.qtd++;
        } else {
            No aux = inicio;
            while (aux.prox != null && (elemento).compareTo((T) aux.prox.dado) > 0) {
                aux = aux.prox;
            }
            novo.prox = aux.prox;
            aux.prox = novo;
            this.qtd++;
        }
    }

    @Override
    public T get(int posicao) throws Exception {
        No<T> no = PegarNo(posicao);
        if (no != null) {
            return no.getDado();
        }
        throw new Exception("Posição solicitada não existe na lista");
    }

    @Override
    public int getPosElemento(T elemento) throws Exception {
        No<T> novo;
        novo = inicio;
        int i = 0;
        while (novo != null) {
            if(novo.dado.equals(elemento)){
                return i;
            }else{
                novo = novo.prox;
            }
            i++;
        }
        throw new Exception("Posição solicitada não existe na lista");


    }

    @Override
    public void remover(int posicao) throws Exception {

    }

    @Override
    public void limpar() {
        if(inicio==null){
            System.out.println("Lista Vazia");
        }
        else {
            this.inicio = null;
            this.qtd=0;
        }
    }

    @Override
    public int getTamanho() {
        return qtd-1;
    }

    @Override
    public boolean contem(T elemento) throws Exception {

        for (int i = 0; i < getTamanho(); i++) {
            No<T> Atual = PegarNo(i);
            if (Atual.getDado() != null && Atual.getDado().equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    public void imprimeLista() {
        //Realiza validações
        if(isVazia()) {
            System.out.println("Lista Vazia. Não há elementos para impressão\n");
            return;
        }
        No<T> auxiliar = inicio;
        while(auxiliar != null) {
            System.out.print(" - " + auxiliar.getDado());
            auxiliar = auxiliar.getProx();
        }
        System.out.println("\n");

    }


}
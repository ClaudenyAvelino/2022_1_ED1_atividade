package br.edu.ifs.ED.lista;

public class ListaEnc<T extends Comparable<T>> extends Lista<T> {

    // Atributos
    public No<T> primeiro, ultimo;
    public int Comprimento_Lista;
    private int qtd_Elements;

    public ListaEnc(){
        this.primeiro = null;
        this.ultimo = null;
        this.qtd_Elements = 0;
    }

    // Construtor
    public ListaEnc(Class<T> dataType, int tamanho_lista) {
        this.primeiro = null;
        this.ultimo = null;
        this.Comprimento_Lista = tamanho_lista;
        this.qtd_Elements = 0;
    }

    public int getQtd_Elements() {
        return qtd_Elements;
    }

    public void setQtd_Elements(int qtd) {
        this.qtd_Elements = qtd;
    }

    @Override
    public void incluir(T elemento) throws Exception {
        if (qtd_Elements >= Comprimento_Lista) throw new Exception("Lista cheia");
        if(qtd_Elements == 0) {
            incluirInicio(elemento);
        } else {
            No<T> novo = new No<>(elemento);
            ultimo.setProx(novo);
            ultimo = novo;
            qtd_Elements++;
        }
    }

    public T get(int posicao)  throws Exception {
        if (posicao >= qtd_Elements) throw new Exception("Posição solicitada não existe na lista");
        No<T> aux = primeiro;

        for (int i = 0; i < posicao; i++) aux = aux.getProx();
        return aux.getDado();
    }


    public int getPosElemento(T elemento)  throws Exception {
        No<T> aux = primeiro;
        int contador = 0;

        do {
            if (aux.getDado().equals(elemento)) return contador;
            aux = aux.getProx();
            contador++;
        } while (aux != null);

        throw new Exception("O elemento não foi localizado na lista");
    }

    @Override
    public void incluirInicio(T elemento) throws Exception {
        if (qtd_Elements >= Comprimento_Lista) throw new Exception("Lista cheia");
        if(qtd_Elements == 0) {
            No<T> novo = new No<>(elemento);
            primeiro = novo;
            ultimo = novo;
        } else {
            No<T> novo = new No<>(elemento);
            novo.setProx(primeiro); // Novo está apontando para o primeiro
            primeiro = novo;
        }
        qtd_Elements++;
    }

    @Override
    public void incluir(T elemento, int posicao) throws Exception {
        if (qtd_Elements >= Comprimento_Lista) throw new Exception("A lista está cheia");
        if (posicao >= Comprimento_Lista || posicao < 0) throw new Exception("Posição inexistente");
        No<T> novo = new No<>(elemento);
        No<T> ant = primeiro;
        for (int i = 0; i < posicao - 1; i++) ant = ant.getProx();
        novo.setProx(ant.getProx());
        ant.setProx(novo);
        qtd_Elements++;
    }

    @Override
    public void remover(int posicao) throws Exception {
        if (posicao >= Comprimento_Lista || posicao < 0) throw new Exception("Posição inexistente");
        if (qtd_Elements == 0 || primeiro == null) throw new Exception("Lista Vazia");

        No aux = primeiro;
        No anterior = null;

        if (posicao == 1) {
            this.primeiro.setProx(primeiro.getProx().getProx());
            qtd_Elements--;
        } else {
            for (int i = 1; i <= posicao; i++) {
                anterior = aux;
                aux = aux.getProx();
            }
            anterior.setProx(aux.getProx());
            setQtd_Elements(getQtd_Elements() - 1);
        }
    }

    @Override
    public int getTamanho() {
        return qtd_Elements;
    }

    public void limpar() {
        this.primeiro = null;
        this.ultimo = null;
        setQtd_Elements(0);

    }
    @Override
    public boolean contem(T elemento) throws Exception {
        No<T> aux = primeiro;
        do {
            if (aux.getDado().equals(elemento)) return true;
            aux = aux.getProx();
        } while (aux != null);

        throw new Exception("Elemento não encontrado.");
    }
}
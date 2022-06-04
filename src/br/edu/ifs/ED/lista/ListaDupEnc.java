package br.edu.ifs.ED.lista;

public class ListaDupEnc<T extends Comparable<T>> extends Lista<T>{

    // Atributos
    public No<T> primeiro;
    public No<T> ultimo;
    public int qtd_Elements;
    public int Comprimento_Lista;

    // Contrutor
    public ListaDupEnc(int tamanhoLista) {
        this.primeiro = null;
        this.ultimo = null;
        this.qtd_Elements = 0;
        this.Comprimento_Lista = tamanhoLista;
    }


    @Override
    public void incluir(T elemento) throws Exception {
        if (qtd_Elements >= Comprimento_Lista) throw new Exception("Lista cheia");
        if (qtd_Elements == 0){
            incluirInicio(elemento);
        } else {
            No<T> novo = new No<>(elemento);
            ultimo.setProx(novo);
            novo.setAnterior(ultimo);
            ultimo = novo;
            qtd_Elements++;
        }
    }

    @Override
    public void incluirInicio(T elemento) throws Exception {
        if (qtd_Elements >= Comprimento_Lista) throw new Exception("Lista cheia");
        No<T> novo = new No<>(elemento);
        if (qtd_Elements == 0) {
            primeiro = novo;
            ultimo = novo;
        } else {
            primeiro.setAnterior(novo);
            novo.setProx(primeiro);
            primeiro = novo;
        }
        qtd_Elements++;
    }

    @Override
    public void incluir(T elemento, int posicao) throws Exception {
        if (posicao >= Comprimento_Lista || posicao < 0) throw new Exception("Posição inexistente");
        if (qtd_Elements >= Comprimento_Lista) throw new Exception("A lista está cheia");
        if (posicao == 0) {
            incluirInicio(elemento);
        } else {
            No<T> novo = new No<>(elemento);
            No<T> aux = primeiro;
            for (int i = 0; i < posicao - 1; i++) aux = aux.getProx();
            novo.setProx(aux.getProx());
            aux.setProx(novo);

            No<T> auxAnterior = aux.getAnterior();
            auxAnterior.setProx(novo);
            novo.setAnterior(auxAnterior);
            novo.setProx(aux);
            aux.setAnterior(novo);
            qtd_Elements++;
        }
    }

    @Override
    public T get(int posicao) throws Exception {
        if (posicao >= qtd_Elements) throw new Exception("Posição solicitada não existe na lista");
        No<T> aux = primeiro;
        for (int i = 0; i < posicao; i++) {
            aux = aux.getProx();
            aux.setAnterior(ultimo);
        }
        return aux.getDado();
    }

    @Override
    public int getPosElemento(T elemento) throws Exception {
        No<T> aux = this.primeiro;
        int pos = 0;

        do {
            if(aux.getDado().equals(elemento)) return pos;
            pos = pos + 1;
            aux = aux.getProx();
        } while (aux != null);
        throw new Exception("O elemento não foi localizado na lista");
    }

    @Override
    public void remover(int posicao) throws Exception {
        if (posicao >= Comprimento_Lista || posicao < 0) throw new Exception("Posição inexistente");
        if (qtd_Elements == 0) throw new Exception("Lista vazia");
        No ant = primeiro;
        for (int i = 0; i < posicao; i++) {
            ant = ant.getProx();
            ant.setAnterior(ultimo);
        }
        No noAtual = ant.getProx();
        No proximo = noAtual.getProx();
        ant.setProx(proximo);
        proximo.setAnterior(ant);
        this.qtd_Elements--;
    }

    @Override
    public void limpar() {
        this.primeiro = null;
        this.ultimo = null;
        qtd_Elements = 0;
    }

    @Override
    public int getTamanho() {
        No novo = this.primeiro;
        int auxTamanho = 0;

        for(No i = novo; i != null; auxTamanho++){
            novo = novo.getProx();
        }
        return auxTamanho;
    }

    @Override
    public boolean contem(T elemento) throws Exception {
        No<T> aux = primeiro;
        do {
            if (aux.getDado().equals(elemento)) return true;
            aux = aux.getProx();
        } while (aux != null);

        throw new Exception("O elemento não localizado na lista");
    }
}

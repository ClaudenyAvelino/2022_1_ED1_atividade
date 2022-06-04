package br.edu.ifs.ED.lista;

public class No<T> {
    public T dado;
    public No<T> prox;
    private No<T> anterior; // Apenas para Listas Duplamente Encadeada!



    public No<T> getProximo() {
        return prox;
    }

    public void setProximo(No<T> proximo) {
        this.prox = proximo;
    }

    public No<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(No<T> anterior) {
        this.anterior = anterior;
    }

    //public No<T> anterior; // Este é de uso exclusivo da lista dupalemente encadeada


    public class ListaEncOrdenada<T> {
        private No<T> inicio;
    }

    public No(T dado, No prox) {
        this.dado = dado;
        this.prox = null;
        this.anterior = null;
    }


    public No(T dado) {
        this.dado = dado;
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    public No<T> getProx() {
        return prox;
    }

    public void setProx(No<T> prox) {
        this.prox = prox;
    }

    @Override
    public String toString() {
        return "No{" +
                "elemento=" + dado +
                '}';

    }
}
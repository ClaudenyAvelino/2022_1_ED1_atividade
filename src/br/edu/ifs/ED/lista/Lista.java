package br.edu.ifs.ED.lista;

public abstract class Lista<T extends Comparable>  {


    public void Lista()throws Exception{}
    public abstract void incluir(T elemento) throws Exception;
    public abstract void incluirInicio(T elemento) throws Exception;
    public abstract void incluir(T elemento, int posicao) throws Exception;
    public abstract T get(int posicao) throws Exception;
    public abstract int getPosElemento(T elemnto) throws Exception;
    public abstract void remover(int posicao) throws Exception;
    public abstract void limpar();
    public abstract int getTamanho();
    public abstract boolean contem(T elemento) throws Exception;

}


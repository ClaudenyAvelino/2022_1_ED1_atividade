// package ListaOrdenada;

public class ListaEnc<T extends Comparable<T>> extends Lista<T> {

    protected No<T> inicio;
    protected No<T> fim;
    protected int quantidade;

    public ListaEnc() {
        this.inicio = null;
        this.fim = null;
        this.quantidade = 0;
    }

    @Override
    public void incluir(T elemento) throws Exception {
        No<T> novo = new No<>(elemento);

        if (inicio == null) {
            inicio = novo;
            fim = inicio;
        } else {
            fim.setProx(novo);
            fim = novo;
        }
        quantidade++;
    }

    @Override
    public void incluirInicio(T elemento) throws Exception {
        No<T> novo = new No<>(elemento);

        if (quantidade == 0) {
            inicio = novo;
            fim = novo;
        } else {
            novo.setProx(inicio);
            inicio = novo;
        }
        quantidade++;
    }

    @Override
    public void incluir(T elemento, int posicao) throws Exception {
        if (posicao < 0 || posicao > quantidade)
            throw new Exception("Posição não existente na lista!");
        No<T> novo = new No<>(elemento);
        if (quantidade == 0) {
            inicio = novo;
            fim = novo;
        } else {
            if (posicao == 0) {
                No<T> temp = inicio;
                inicio = novo;
                inicio.setProx(temp);
            } else {
                No<T> temp = inicio;

                for (int i = 0; i < posicao - 1; i++) {
                    temp = temp.getProx();
                }
                novo.setProx(temp.getProx());
                temp.setProx(novo);
            }
        }
        quantidade++;
    }

    @Override
    public T get(int posicao) throws Exception {
        if (posicao >= quantidade || posicao < 0)
            throw new Exception("Posição não existente na lista!");

        No<T> temp = inicio;

        for (int i = 0; i < posicao; i++)
            temp = temp.getProx();

        return temp.getDado();
    }

    @Override
    public int get(T elemento) throws Exception {
        No<T> temp = inicio;
        int posicao = 0;
        while (temp != null) {
            if (temp.getDado().equals(elemento)) {
                return posicao;
            } else {
                posicao++;
                temp = temp.getProx();
            }
        }
        throw new Exception("Elemento não encontrado!");
    }

    @Override
    public void remover(int posicao) throws Exception {
        if (quantidade == 0)
            throw new Exception("Lista vazia!");

        if (posicao == 0) {
            inicio = inicio.getProx();
            quantidade--;
        }

        No<T> temp = inicio;
        No<T> aux = temp;

        for (int i = 0; i < posicao; i++) {
            temp = temp.getProx();
        }
        for (int i = 0; i < posicao - 1; i++) {
            aux = aux.getProx();
        }
        aux.setProx(temp.getProx());
        quantidade--;
    }

    @Override
    public void limpar() {
        this.inicio = null;
        this.fim = null;
        this.quantidade = 0;
    }

    @Override
    public int getTamanho() {
        return quantidade;
    }

    @Override
    public boolean contem(T elemento) throws Exception {
        if (quantidade == 0)
            throw new Exception("A lista vazia!");

        No<T> temp = inicio;

        while (temp != null) {
            if (temp.getDado().equals(elemento))
                return true;

            temp = temp.getProx();
        }
        return false;
    }
}

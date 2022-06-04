// package ListaOrdenada;

public class ListaEncOrdenada<T extends Comparable<T>> extends ListaEnc<T> {

    protected boolean crescente;

    public ListaEncOrdenada() {
        super();
        this.crescente = true;
    }

    public void setTipoOrdenacao(boolean crescente) throws Exception {
        if (this.crescente) {
            if (this.crescente == crescente)
                throw new Exception("A lista já está CRESCENTE!!");
            else {
                this.crescente = crescente;
                ordenar();
            }
        } else {
            if (this.crescente == crescente)
                throw new Exception("A lista já está DESCRESCENTE!!");
            else {
                this.crescente = crescente;
                ordenar();
            }
        }
    }

    private void ordenar() {
        No<T> temp = this.inicio, anterior = null, atual = null;

        while (temp != null) {
            atual = temp.getProx();
            temp.setProx(anterior);
            anterior = temp;
            temp = atual;
        }

        temp = this.inicio;
        this.inicio = this.fim;
        this.fim = temp;
    }

    public void imprimirLista() {
        var i = this.inicio;
        while (i != null) {
            System.out.print(i.dado + " | ");
            i = i.getProx();
        }
        System.out.println();
    }

    @Override
    public void incluir(T elemento) throws Exception {
        if (quantidade == 0)
            super.incluir(elemento);
        else {
            if (crescente && this.fim.dado.compareTo(elemento) < 0) {
                super.incluir(elemento);
                return;
            }

            if (!crescente && this.fim.dado.compareTo(elemento) > 0) {
                super.incluir(elemento);
                return;
            }

            throw new Exception("Elemento não inserido, pois a ordenação foi quebrada!");
        }
    }

    @Override
    public void incluirInicio(T elemento) throws Exception {
        if (quantidade == 0) {
            super.incluirInicio(elemento);
        } else {
            if (crescente && this.inicio.dado.compareTo(elemento) > 0) {
                super.incluirInicio(elemento);
                return;
            }

            if (!crescente && this.inicio.dado.compareTo(elemento) < 0) {
                super.incluirInicio(elemento);
                return;
            }

            throw new Exception("Elemento não inserido, pois a ordenação foi quebrada!");
        }
    }

    @Override
    public void incluir(T elemento, int posicao) throws Exception {
        if (posicao == 0)
            incluirInicio(elemento);
        else if (posicao == quantidade)
            incluir(elemento);
        else {
            if (crescente) {
                var anterior = get(posicao - 1);
                var proximo = get(posicao);
                if (anterior.compareTo(elemento) < 0 && proximo.compareTo(elemento) > 0) {
                    super.incluir(elemento, posicao);
                    return;
                } else
                    throw new Exception("Elemento não inserido, pois a ordenação foi quebrada!");
            } else {
                var anterior = get(posicao - 1);
                var proximo = get(posicao);
                if (anterior.compareTo(elemento) > 0 && proximo.compareTo(elemento) < 0) {
                    super.incluir(elemento, posicao);
                    return;
                } else
                    throw new Exception("Elemento não inserido, pois a ordenação foi quebrada!");
            }
        }
    }

    @Override
    public T get(int posicao) throws Exception {
        return super.get(posicao);
    }

    @Override
    public int get(T elemento) throws Exception {
        return super.get(elemento);
    }

    @Override
    public void remover(int posicao) throws Exception {
        super.remover(posicao);
    }

    @Override
    public void limpar() {
        super.limpar();
    }

    @Override
    public int getTamanho() {
        return super.getTamanho();
    }

    @Override
    public boolean contem(T elemento) throws Exception {
        return super.contem(elemento);
    }
}

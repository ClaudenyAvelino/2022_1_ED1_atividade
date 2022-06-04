package br.edu.ifs.ED.lista;
import java.util.Arrays;
import java.util.Scanner;

public class Ordenador {

        Scanner leitor = new Scanner(System.in);
        int[] Array = new int[10]; // 10 posições
        int Contador = 0;

    public Ordenador() {
            setTipoOrdenacao();
            organizaResultado();
            exibeOrdem();
        }

        private void setTipoOrdenacao () {
        }

        public void setTipoOrdenacao ( boolean crescente) throws Exception {

            while (Contador < 10) {

                try {
                    System.out.println("Insira um numero: ");
                    Array[Contador] = leitor.nextInt(); // guarda o valor na posição
                    Contador++; // contador recebe +1
                } catch (java.util.InputMismatchException e) {
                    System.out.println("!Só numeros são aceitos!");
                    leitor.nextLine(); // continua lendo
                }
            }
        }

    public void exibeOrdem () {
            System.out.println(Arrays.toString(Array)); // mostra o array em ordem
        }

    private void organizaResultado() {
        Arrays.sort(Array); // organiza valores do array em ordem
    }
}
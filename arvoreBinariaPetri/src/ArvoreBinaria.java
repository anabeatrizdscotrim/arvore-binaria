import java.util.LinkedList;
import java.util.Queue;

public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public No getRaiz() {
        return this.raiz;
    }

    public No inserir(int valor) {
        No novoNo = new No(valor);
        if (this.raiz == null) {
            this.raiz = novoNo;
        } else {
            No atual = this.raiz;
            No pai = null;
            while (atual != null) {
                if (novoNo.getValor() < atual.getValor()) {
                    pai = atual;
                    atual = atual.getEsq();
                } else {
                    pai = atual;
                    atual = atual.getDir();
                }
            }
            if (novoNo.getValor() < pai.getValor()) {
                pai.setEsq(novoNo);
            } else {
                pai.setDir(novoNo);
            }
        }
        return novoNo;
    }

    public void preOrdem(No no) {
        if (no == null) {
            return;
        }
        System.out.println(no.getValor());
        preOrdem(no.getEsq());
        preOrdem(no.getDir());
    }

    public void emOrdem(No no) {
        if (no == null) {
            return;
        }
        emOrdem(no.getEsq());
        System.out.println(no.getValor());
        emOrdem(no.getDir());
    }

    public void posOrdem(No no) {
        if (no == null) {
            return;
        }
        posOrdem(no.getEsq());
        posOrdem(no.getDir());
        System.out.println(no.getValor());
    }

    public No remover(int valor) {
        No atual = raiz;
        No pai = null;

        while(atual != null && atual.getValor() != valor) {
            pai = atual;
            if (valor < atual.getValor()) {
                atual = atual.getEsq();
            } else {
                atual = atual.getDir();
            }

            if (atual == null) {
                return null; //nó não existe, retorna nulo
            }
        }
        // se existir o no

        // se for nó folha
        if (atual.getEsq() == null && atual.getDir() == null) {
            if(pai != null){
                if(pai.getEsq() == atual){
                    pai.setEsq(null);
                } else {
                    pai.setDir(null);
                }
            } else {
                raiz = null;
            }
        }

        // se for no com 1 filho
        else if (atual.getEsq() == null ){
            if (pai != null) {
                if (pai.getEsq() == atual) {
                    pai.setEsq(atual.getDir());
                } else {
                    pai.setDir(atual.getDir());
                }
            } else {
                raiz = atual.getDir();
            }
        } else if (atual.getDir() == null) {
            if (pai !=null) {
                if (pai.getEsq() == atual){
                    pai.setEsq(atual.getEsq());
                } else {
                    pai.setDir(atual.getEsq());
                }
            } else {
                raiz = atual.getEsq();
            }
        }

        // se for com 2 filhos
        else {
            No sucessor = atual.getDir();
            No paiSucessor = atual;
            while (sucessor.getEsq() != null) {
                paiSucessor = sucessor;
                sucessor = sucessor.getEsq();
            }

            atual.setValor(sucessor.getValor());

            if (paiSucessor == atual) { //sucessor é o filho direito de atual
                atual.setDir(sucessor.getDir());
            } else { // Sucessor não é o filho direito de atual
                paiSucessor.setEsq(sucessor.getDir());
            }
        }
        return atual;
    }


    public void mostrarArvore() {
        if (raiz == null) {
            System.out.println("Árvore vazia.");
            return;
        }

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);

        int altura = altura(raiz);
        int maxNiveis = altura + 2;

        int espacosEntreNos = (int) Math.pow(2, maxNiveis) - 1;
        int espacosEntreNiveis = espacosEntreNos / 2;

        while (!fila.isEmpty()) {
            int nosNesseNivel = fila.size();
            boolean todosNull = true;

            for (int i = 0; i < nosNesseNivel; i++) {
                No atual = fila.poll();


                printEspacos(espacosEntreNiveis);

                if (atual != null) {
                    System.out.print(atual.getValor());
                    fila.add(atual.getEsq());
                    fila.add(atual.getDir());
                    todosNull = false;
                } else {
                    System.out.print(" ");
                    fila.add(null);
                    fila.add(null);
                }


                printEspacos(espacosEntreNos);
            }

            if (todosNull) {
                break;
            }

            System.out.println();

            espacosEntreNiveis /= 2;
            espacosEntreNos /= 2;
        }
    }

    private void printEspacos(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    private int altura(No no) {
        if (no == null) {
            return -1;
        }
        return 1 + Math.max(altura(no.getEsq()), altura(no.getDir()));
    }


}

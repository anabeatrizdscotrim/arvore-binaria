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
            if(pai != null){ //se o no tiver um pai
                if(pai.getEsq() == atual){ //Se o nó for o filho esquerdo do pai
                    pai.setEsq(null); //Se for, o ponteiro para o filho esquerdo do pai é definido como nulo, "desconectando" o nó folha da árvore
                } else {
                    pai.setDir(null);
                }
            } else { //Se o nó não tiver pai
                raiz = null; //se for a raiz, define ela como nula
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

        // se for no com 2 filhos
        else {
            No sucessor = atual.getDir();
            No paiSucessor = atual;
            while (sucessor.getEsq() != null) {
                paiSucessor = sucessor;
                sucessor = sucessor.getEsq();
            }

            atual.setValor(sucessor.getValor());

            if (paiSucessor.getEsq() == sucessor) {
                paiSucessor.setEsq(sucessor.getDir());
            } else {
                paiSucessor.setDir(null);
            }
        }
        return atual;

    }

}

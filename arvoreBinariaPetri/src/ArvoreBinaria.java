public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
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
        if(no == null) {
            return;
        }
        System.out.println(no.getValor());
        preOrdem(no.getEsq());
        preOrdem(no.getDir());
    }

    public void emOrdem(No no) {
        if(no == null) {
            return;
        }
        emOrdem(no.getEsq());
        System.out.println(no.getValor());
        emOrdem(no.getDir());
    }

    public void posOrdem(No no) {
        if(no == null) {
            return;
        }
        posOrdem(no.getEsq());
        posOrdem(no.getDir());
        System.out.println(no.getValor());
    }

    public No getRaiz() {
        return this.raiz;
    }

    public No removerAtual(No atual) {

        /* no folha*/
        if(atual.getEsq() == null) {
            return atual.getDir();
        } else if (atual.getDir()== null){ /*No com 1 filho só*/
            return atual.getEsq();
        }else{
            No paiSucessor = atual;  /*No com 2 filhos */
            No sucessor = atual.getDir();

            while(sucessor.getEsq()!= null){
                paiSucessor = sucessor;
                sucessor = sucessor.getEsq();
            }
            if (sucessor != atual.getDir()){
                paiSucessor.setEsq(sucessor.getDir());
                sucessor.setDir(atual.getDir());
            }

            sucessor.setEsq(atual.getEsq());
            return sucessor;
        }
    }

    public boolean remover(int valor) {
        No atual = this.raiz;
        No pai = null;

        while (atual != null) {
            if (valor == atual.getValor()) {
                if (atual == this.raiz) {
                    this.raiz = removerAtual(atual);
                } else {
                    if (pai.getDir() == atual) {
                        pai.setDir(removerAtual(atual));
                    } else {
                        pai.setEsq(removerAtual(atual));
                    }
                }
                return true;
            }

            pai = atual;
            if (valor > atual.getValor()) {
                atual = atual.getDir();
            } else {
                atual = atual.getEsq();
            }
        }

        return false;
    }
}

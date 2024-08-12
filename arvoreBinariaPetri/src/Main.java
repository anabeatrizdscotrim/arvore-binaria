public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

        arvoreBinaria.inserir(50);
        arvoreBinaria.inserir(12);
        arvoreBinaria.inserir(34);
        arvoreBinaria.inserir(-5);
        arvoreBinaria.inserir(27);
        arvoreBinaria.inserir(57);
        arvoreBinaria.inserir(89);
        arvoreBinaria.inserir(105);


        arvoreBinaria.mostrarArvore();
        System.out.println();
        System.out.println();
        System.out.println();
        arvoreBinaria.remover(27);
        System.out.println("Após remoção");
        System.out.println();
        arvoreBinaria.mostrarArvore();


    }
}

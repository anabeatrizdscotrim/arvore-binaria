public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

        arvoreBinaria.inserir(80);
        arvoreBinaria.inserir(72);
        arvoreBinaria.inserir(87);
        arvoreBinaria.inserir(37);
        arvoreBinaria.inserir(-3);
        arvoreBinaria.inserir(12);

        System.out.println(" ordem antes da remoção");
        arvoreBinaria.emOrdem(arvoreBinaria.getRaiz());
        System.out.println();

        System.out.println("Remover 87");
        arvoreBinaria.remover(80);

        System.out.println("ordem depois da remoção");
        arvoreBinaria.emOrdem(arvoreBinaria.getRaiz());
        System.out.println();
    }
}

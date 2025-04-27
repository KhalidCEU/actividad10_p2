package code;

public class Principal {
    public static void main(String[] args) {
        mostrarFuncionamientoArbolesBinarios();
    }

    static void mostrarFuncionamientoArbolesBinarios() {
        BinaryTree bt = new BinaryTree();
        bt.insert(2);
        bt.insert(1);
        bt.insert(3);
        bt.insert(8);
        bt.insert(5);
        bt.insert(2);
        System.out.println(bt);
        bt.printPostorder();
    }
}

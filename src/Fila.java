public class Fila {
    private Node frente;
    private Node tras;
    private int tamanho;

    public Fila() {
        this.frente = null;
        this.tras = null;
        this.tamanho = 0;
    }

    public boolean vazia() {
        return frente == null;
    }

    public void enfileirar(Elemento e) {
        Node n = new Node(e);
        if (vazia()) {
            frente = n;
            tras = n;
        } else {
            tras.proximo = n;
            tras = n;
        }
        tamanho = tamanho + 1;
    }

    public Elemento desenfileirar() {
        if (vazia()) {
            return null;
        }
        Elemento e = frente.dado;
        frente = frente.proximo;
        if (frente == null) {
            tras = null;
        }
        tamanho = tamanho - 1;
        return e;
    }

    public int tamanho() {
        return tamanho;
    }

    public void exibir() {
        System.out.println("=== FILA DE ATENDIMENTO (frente -> fim) ===");
        Node atual = frente;
        int pos = 0;
        while (atual != null) {
            System.out.println((pos + 1) + ". " + atual.dado.toStringFila());
            atual = atual.proximo;
            pos = pos + 1;
        }
        if (pos == 0) {
            System.out.println("(vazia)");
        }
    }
}
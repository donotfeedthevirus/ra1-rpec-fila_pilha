public class Pilha {
    private Node topo;
    private int tamanho;

    public Pilha() {
        this.topo = null;
        this.tamanho = 0;
    }

    public boolean vazia() {
        return topo == null;
    }

    public void empilhar(Elemento e) {
        Node n = new Node(e);
        n.proximo = topo;
        topo = n;
        tamanho = tamanho + 1;
    }

    public Elemento desempilhar() {
        if (vazia()) {
            return null;
        }
        Elemento e = topo.dado;
        topo = topo.proximo;
        tamanho = tamanho - 1;
        return e;
    }

    public int tamanho() {
        return tamanho;
    }

    public void exibir() {
        System.out.println("=== HISTÓRICO (Pilha, topo -> base) ===");
        Node atual = topo;
        int pos = 0;
        while (atual != null) {
            System.out.println((pos + 1) + ". " + atual.dado.toStringPilha());
            atual = atual.proximo;
            pos = pos + 1;
        }
        if (pos == 0) {
            System.out.println("(vazio)");
        }
    }
}

public class Elemento {
    private String id;        // "CLI001" ou "REQ001"
    private String nome;      // usado na Fila
    private String descricao; // motivo/descrição (Fila) ou descrição (Pilha)
    private String dataHora;  // usado na Pilha

    // Construtor único (use null para os campos que não se aplicam)
    public Elemento(String id, String nome, String descricao, String dataHora) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataHora = dataHora;
    }

    public String getId() { return id; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public String getDataHora() { return dataHora; }

    public String toStringFila() {
        // Ex.: [CLI001] Maria Silva - Dúvida sobre produto
        String s = "[" + id + "] ";
        if (nome != null) {
            s = s + nome + " - ";
        }
        s = s + descricao;
        return s;
    }

    public String toStringPilha() {
        // Ex.: [REQ001] Instalação de software @ 2024-08-20 10:30
        String s = "[" + id + "] " + descricao;
        if (dataHora != null) {
            s = s + " @ " + dataHora;
        }
        return s;
    }
}

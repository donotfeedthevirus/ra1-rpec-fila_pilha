public class Elemento {
    private String id;
    private String nome;
    private String descricao;
    private String dataHora;

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
        String s = "[" + id + "] ";
        if (nome != null) {
            s = s + nome + " - ";
        }
        s = s + descricao;
        return s;
    }

    public String toStringPilha() {
        String s = "[" + id + "] " + descricao;
        if (dataHora != null) {
            s = s + " @ " + dataHora;
        }
        return s;
    }
}

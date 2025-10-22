import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) throws Exception {
        Fila fila = new Fila();
        Pilha pilha = new Pilha();

        // Tenta carregar a partir da raiz ("data/...") e, se falhar, tenta a partir de src ("../data/...")
        tentarCarregarFila(fila);
        tentarCarregarPilha(pilha);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println();
            System.out.println("===== MENU =====");
            System.out.println("1 - Mostrar Fila");
            System.out.println("2 - Atender Próximo (desenfileirar)");
            System.out.println("3 - Adicionar Cliente à Fila");
            System.out.println("4 - Mostrar Histórico (Pilha)");
            System.out.println("5 - Registrar Nova Solicitação no Histórico");
            System.out.println("6 - Desfazer Última Solicitação (pop)");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            String opc = in.readLine();
            if (opc == null) break;

            if (igual(opc, "1")) {
                fila.exibir();
            } else if (igual(opc, "2")) {
                Elemento atendido = fila.desenfileirar();
                if (atendido == null) {
                    System.out.println("Fila vazia.");
                } else {
                    System.out.println("Atendido: " + atendido.toStringFila());
                    System.out.print("Deseja registrar no histórico? (s/n): ");
                    String r = in.readLine();
                    if (r != null && (igual(r, "s") || igual(r, "S"))) {
                        System.out.print("Informe uma descrição para o histórico: ");
                        String d = in.readLine();
                        System.out.print("Informe data e hora (ex.: 2024-08-20 10:30): ");
                        String dh = in.readLine();
                        String hid = "ATD-" + atendido.getId();
                        if (d == null) d = "Atendimento realizado";
                        if (dh == null) dh = "sem-data";
                        // nome = null; descricao = d; dataHora = dh
                        pilha.empilhar(new Elemento(hid, null, d, dh));
                        System.out.println("Registrado no histórico.");
                    }
                }
            } else if (igual(opc, "3")) {
                System.out.print("ID do cliente (ex.: CLI011): ");
                String id = in.readLine();
                System.out.print("Nome do cliente: ");
                String nome = in.readLine();
                System.out.print("Motivo do atendimento: ");
                String motivo = in.readLine();

                if (id == null || nome == null || motivo == null) {
                    System.out.println("Dados inválidos.");
                } else {
                    // dataHora = null
                    fila.enfileirar(new Elemento(id, nome, motivo, null));
                    System.out.println("Cliente adicionado.");
                }
            } else if (igual(opc, "4")) {
                pilha.exibir();
            } else if (igual(opc, "5")) {
                System.out.print("ID da solicitação (ex.: REQ011): ");
                String id = in.readLine();
                System.out.print("Descrição: ");
                String desc = in.readLine();
                System.out.print("Data e hora (ex.: 2024-08-20 10:30): ");
                String dh = in.readLine();

                if (id == null || desc == null || dh == null) {
                    System.out.println("Dados inválidos.");
                } else {
                    // nome = null
                    pilha.empilhar(new Elemento(id, null, desc, dh));
                    System.out.println("Solicitação registrada no histórico.");
                }
            } else if (igual(opc, "6")) {
                Elemento removido = pilha.desempilhar();
                if (removido == null) {
                    System.out.println("Histórico vazio.");
                } else {
                    System.out.println("Removido do histórico: " + removido.toStringPilha());
                }
            } else if (igual(opc, "0")) {
                System.out.println("Encerrando...");
                break;
            } else {
                System.out.println("Opção inválida.");
            }
        }
    }

    private static void tentarCarregarFila(Fila fila) {
        try {
            LeitorArquivo.carregarFilaDeArquivo(fila, "data/filadeatendimento.txt");
            return;
        } catch (Exception e) {
            // tenta caminho alternativo
        }
        try {
            LeitorArquivo.carregarFilaDeArquivo(fila, "../data/filadeatendimento.txt");
        } catch (Exception e2) {
            System.out.println("Aviso: não foi possível carregar a fila (data/filadeatendimento.txt).");
        }
    }

    private static void tentarCarregarPilha(Pilha pilha) {
        try {
            LeitorArquivo.carregarPilhaDeArquivo(pilha, "data/historico.txt");
            return;
        } catch (Exception e) {
            // tenta caminho alternativo
        }
        try {
            LeitorArquivo.carregarPilhaDeArquivo(pilha, "../data/historico.txt");
        } catch (Exception e2) {
            System.out.println("Aviso: não foi possível carregar o histórico (data/historico.txt).");
        }
    }

    private static boolean igual(String a, String b) {
        if (a == null && b == null) return true;
        if (a == null) return false;
        return a.equals(b);
    }
}

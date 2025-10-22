import java.io.FileReader;
import java.io.BufferedReader;

public class LeitorArquivo {

    public static void carregarFilaDeArquivo(Fila fila, String caminho) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(caminho));
        try {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linhaContemElemento(linha)) {
                    // Esperado: new Elemento("CLI001", "Maria Silva", "Dúvida sobre produto"),
                    String id = extrairEntreAspas(linha, 0);
                    String nome = extrairEntreAspas(linha, avancarDepoisDeAspas(linha, 0));
                    String desc = extrairEntreAspas(linha, avancarDepoisDeAspas(linha, avancarDepoisDeAspas(linha, 0)));
                    if (id != null && nome != null && desc != null) {
                        // nome e descricao usados; dataHora = null
                        fila.enfileirar(new Elemento(id, nome, desc, null));
                    }
                }
            }
        } finally {
            br.close();
        }
    }

    public static void carregarPilhaDeArquivo(Pilha pilha, String caminho) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(caminho));
        try {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linhaContemElemento(linha)) {
                    // Esperado: new Elemento("REQ001", "Instalação...", "2024-08-20 10:30"),
                    String id = extrairEntreAspas(linha, 0);
                    String desc = extrairEntreAspas(linha, avancarDepoisDeAspas(linha, 0));
                    String dataHora = extrairEntreAspas(linha, avancarDepoisDeAspas(linha, avancarDepoisDeAspas(linha, 0)));
                    if (id != null && desc != null && dataHora != null) {
                        // descricao e dataHora usados; nome = null
                        pilha.empilhar(new Elemento(id, null, desc, dataHora));
                    }
                }
            }
        } finally {
            br.close();
        }
    }

    // ===== Helpers sem arrays/split/regex =====

    private static boolean linhaContemElemento(String linha) {
        int p = linhaIndexOf(linha, "new Elemento(");
        return p >= 0;
    }

    private static String extrairEntreAspas(String s, int inicioBuscaRelativo) {
        if (s == null) return null;

        int i = inicioBuscaRelativo;
        int len = s.length();

        int asp1 = indexOfCharDesde(s, '\"', i, len);
        if (asp1 < 0) return null;

        int asp2 = indexOfCharDesde(s, '\"', asp1 + 1, len);
        if (asp2 < 0) return null;

        return s.substring(asp1 + 1, asp2);
    }

    private static int avancarDepoisDeAspas(String s, int inicioBuscaRelativo) {
        if (s == null) return inicioBuscaRelativo;

        int i = inicioBuscaRelativo;
        int len = s.length();

        int asp1 = indexOfCharDesde(s, '\"', i, len);
        if (asp1 < 0) return i;

        int asp2 = indexOfCharDesde(s, '\"', asp1 + 1, len);
        if (asp2 < 0) return asp1 + 1;

        return asp2 + 1;
    }

    private static int indexOfCharDesde(String s, char c, int inicio, int len) {
        int i = inicio;
        while (i < len) {
            if (s.charAt(i) == c) {
                return i;
            }
            i = i + 1;
        }
        return -1;
    }

    private static int linhaIndexOf(String s, String alvo) {
        if (s == null) return -1;
        if (alvo == null) return -1;

        int lenS = s.length();
        int lenA = alvo.length();
        if (lenA == 0) return 0;
        if (lenA > lenS) return -1;

        int i = 0;
        while (i <= lenS - lenA) {
            int j = 0;
            boolean ok = true;
            while (j < lenA) {
                if (s.charAt(i + j) != alvo.charAt(j)) {
                    ok = false;
                    break;
                }
                j = j + 1;
            }
            if (ok) return i;
            i = i + 1;
        }
        return -1;
    }
}

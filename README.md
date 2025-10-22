# ATIVIDADE PRÁTICA SUPERVISIONADA 1 — RA01

Projeto que implementa uma fila (ordem de atendimento) e uma pilha (histórico de solicitações) **usando lista encadeada manual** para a disciplina de **Resoluções de Problemas Estruturados em Computação**.

---

## Sobre o projeto

- **Lista encadeada manual** (`Node`) para sustentar **Pilha** e **Fila**.
- **Pilha**: `empilhar`/`desempilhar` O(1); percorre do **topo→base**.
- **Fila**: `enfileirar`/`desenfileirar` O(1); percorre da **frente→fim**.
- **Leitura de dados** dos arquivos `data/filadeatendimento.txt` e `data/historico.txt`
  com **parser manual** (somente `indexOf`, `substring`, `length`) — **sem** `split`, `regex` ou arrays.
- **App** com **menu textual** para exibir/operar fila e pilha, e registrar atendimento no histórico.

---

## Estrutura do projeto

```
atps-fila-pilha/
├─ data/
│  ├─ filadeatendimento.txt # clientes da fila (id, nome, motivo)
│  └─ historico.txt # histórico da pilha (id, descrição, dataHora)
└─ src/
   ├─ App.java  # menu / fluxo principal
   ├─ Elemento.java  # dados (cliente/solicitação)
   ├─ Node.java  # nó da lista encadeada
   ├─ Pilha.java  # histórico (push/pop/exibir)
   ├─ Fila.java  # atendimento (enqueue/dequeue/exibir)
   └─ LeitorArquivo.java  # parser manual dos .txt
```

---

## Como rodar

```bash
# dentro de atps-fila-pilha/
javac src/*.java
java -cp src App
```

> O programa tenta ler `data/...` (raiz) e, alternativamente, `../data/...` (quando executado de `src/`).

**Requisito**: JDK 8+.

---

## Menu e funcionalidades

- **1** – Mostrar Fila (frente - fim)
- **2** – Atender Próximo (desenfileirar)
  - Extra: registrar no histórico (id gerado `ATD-<CLI...>`, descrição e data/hora informadas pelo usuário)
- **3** – Adicionar Cliente à Fila (id, nome, motivo)
- **4** – Mostrar Histórico (topo→base)
- **5** – Registrar Nova Solicitação no Histórico (id, descrição, data/hora)
- **6** – Desfazer Última Solicitação (pop)
- **0** – Sair

---

## Regras do projeto

- **Sem** `List`, `ArrayList`, **sem arrays** dinâmicos, **sem** `StringBuilder`, `split`, `regex` e afins.
- **Somente** `String`, tipos primitivos, `try-catch`/`throws` e I/O básico.
- Estruturas **Pilha** e **Fila** implementadas com **lista encadeada manual**.

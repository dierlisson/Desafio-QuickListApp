# QuickListApp - Desafio #01 NovaEraTech 🚀

Obrigado por vir! 👋

Este aplicativo Android nativo foi desenvolvido como solução para o meu **primeiro desafio prático da comunidade NovaEraTech**.

O objetivo do projeto foi criar um **App de Lista de Tarefas Simples**, focado na consolidação de conceitos fundamentais do Android, como criação de interfaces, manipulação de listas e persistência de dados.

O aplicativo atende a todos os requisitos propostos no desafio:
1.  **Interface Funcional:** Uso de `EditText` e Botão para adicionar tarefas, com validação de entrada (não permite tarefas vazias).
2.  **Listagem Dinâmica:** Exibição das tarefas utilizando `RecyclerView`.
3.  **Interatividade:** Possibilidade de remover tarefas individualmente através de um botão dedicado.
4.  **Persistência:** Os dados são salvos localmente (via `SharedPreferences`), garantindo que a lista se mantenha mesmo após fechar o app.

---

## 📱 Demonstração

https://github.com/user-attachments/assets/4bc78983-7ce6-42e1-841d-b7e0a95d9886

> *Uma demonstração visual das funcionalidades de adicionar, rolar a lista, remover itens e a persistência dos dados.*

---

## ✨ Funcionalidades

* **Adicionar Tarefas:** Interface intuitiva para inserir novas tarefas com um campo de texto e botão.
* **Validação de Entrada:** Impede que o usuário adicione tarefas em branco, melhorando a experiência de uso.
* **Listagem Eficiente:** Utilização de `RecyclerView` para exibir listas de tarefas de forma performática e escalável.
* **Remoção Rápida:** Cada item da lista possui um botão dedicado para exclusão imediata da tarefa.
* **Persistência de Dados:** As tarefas são salvas automaticamente usando `SharedPreferences` (com o auxílio da biblioteca Gson), garantindo que a lista permaneça salva mesmo após fechar e reabrir o aplicativo.
* **Interface:** Layout construído com `ConstraintLayout`, utilizando cards, bordas arredondadas e uma paleta de cores limpa para uma visualização agradável.

---

## 🛠️ Tecnologias e Conceitos Utilizados

* **Linguagem:** [Kotlin](https://kotlinlang.org/) (100%)
* **Componentes de UI:**
    * `ConstraintLayout` (para layouts responsivos e planos)
    * `RecyclerView` & `ListAdapter` customizado
    * Material Design Components (Buttons, TextViews)
    * XML Shape Drawables (para estilização customizada de fundos e bordas)
* **Armazenamento Local:**
    * `SharedPreferences`
    * [Gson Library](https://github.com/google/gson) (Google) - Para serialização/deserialização da lista de objetos em JSON.
* **Ferramentas:** Android Studio Hedgehog | Gradle

---

## 📂 Estrutura do Projeto

Abaixo estão os principais arquivos e diretórios editados neste desafio:

```text
app/src/main/java/
└── com.example.quicklistapp/
    ├── MainActivity.kt       # Lógica: Validação, cliques e persistência (Gson)
    └── TaskAdapter.kt        # Adapter: Gerencia a lista no RecyclerView

app/src/main/res/
├── layout/
│   ├── activity_main.xml     # UI Principal: ConstraintLayout + RecyclerView
│   └── item_task.xml         # UI do Item: Design em "Card" com botão de deletar
├── drawable/
│   ├── bg_input.xml          # Estilo: Bordas arredondadas para o campo de texto
│   └── bg_task_item.xml      # Estilo: Fundo branco e bordas para os itens da lista
└── values/
    └── colors.xml            # Paleta de Cores: Definição do tema "Clean" (Azul/Cinza)
```
---

## 🚀 Como rodar o projeto

1.  **Clone o repositório**:
    ```bash
    git clone [https://github.com/dierlisson/Desafio-QuickListApp.git](https://github.com/dierlisson/Desafio-QuickListApp.git)
    ```
2.  **Abra no Android Studio**:
    Inicie o Android Studio e selecione "Open an Existing Project", navegando até a pasta clonada.
3.  **Sincronize o Gradle**:
    Aguarde o Android Studio baixar as dependências necessárias (incluindo a biblioteca Gson).
4.  **Execute**:
    Conecte um dispositivo físico ou inicie um emulador e clique no botão "Run" (▶️).

---

## 👤 Autor

Desenvolvido por **Dierlisson Justiniano** como parte de um desafio prático de desenvolvimento Android.

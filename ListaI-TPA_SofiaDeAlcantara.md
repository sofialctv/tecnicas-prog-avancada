## Lista de Exercício 1
- **Disciplina:** Técnicas de Programação Avançada 
- **Professor:** Mateus Conrad Barcellos Costa
- **Aluna:** Sofia de Alcantara Silva [20222BSI0199]

#### 1. Explique a diferença entre um algoritmo e um programa de computador. Quais as vantagens de se elaborar um algoritmo para resolver um problema como um passo anterior à implementação do programa?

Pode-se definir algoritmo como uma descrição lógica da solução baseada em conceitos do domínio do problema. Um programa de computador, por sua vez, enquanto um programa é uma sequência de instruções descritas por um algoritmo. As vantagens de aplicar um algoritmo para resolver problemas é que o algoritmo está mais próximo à linguagem humana, facilitando a compreensão da lógica do problema sem se preocupar com detalhes de implementação. Além disso, algoritmos viabilizam portabilidade uma vez que funciona como meio de comunicação genérico para apresentação de um problema-solução.  

#### 2.Explique o que é o gap semântico entre o mundo dos problemas e os programas de computador.

O termo gap semântico pode ser entendido como a distância existente entre a forma que os humanos compreendem e descrevem um problema e a forma como esse problema é representado e solucionado por um computador. Em resumo, é a limitação em traduzir a linguagem natural para a linguagem formal exigida por programas de computadores. A existência de gaps semânticos se explica pela complexidade da linguagem natural e a exigência da programação quanto a abstrações, por exemplo.

#### 3.A busca pela redução do gap semântico levou inicialmente a abordagens voltadas para a extensibilidade das estruturas de fluxo de controle e, posteriormente, à emergência do conceito de Tipo Abstrato de Dados. Explique estes conceitos e faça um comparativo entre estas abordagens.

A extensibilidade das estruturas de fluxo de controle corresponde a estratégia adotada onde as linguagens de programação ofereceram construções mais flexíveis (por meio de definição de macros que eram expandidas em operações de pré-processaamento) para, supostamente, facilitar a expressão de algoritmos complexos. Entretanto, o resultado dessa corrente de pensamento se mostrou desastroso com programas cada vez mais ilegíveis.

Como tentativa de resolução do problema criado pela expansão das estruturas de fluxo houve o surgimento dos TADs, onde o foco mudou para encapsular dados e operações em estruturas que abstraem a implementação interna, oferecendo interfaces claras. 

> *"Um TAD é um componente de programa que implementa um novo tipo de dados, encapsulando a estrutura de dados usada para representar os estados das variáveis
do tipo sendo de definido, e a torna conhecida fora do componente apenas pelas operações que se podem realizar sobre os seus elementos, sem que se permita acesso direto à sua representação nem se indique externamente como essas operações foram codificadas. O termo abstrato enfatiza que essas estruturas de dados não podem ser acessíveis ao usuario do tipo, i.e., as estruturas de dados que formam a representação de um TAD não fazem parte da sua visão externa." — PROGRAMAÇÃO MODULAR, de Roberto Bigonha*

Enquanto a extensibilidade foca em controlar o fluxo de execução, os TADs permitem modelar dados de forma mais intuitiva e segura, promovendo modularidade e reutilização.

#### 4.O que é uma pilha? Descreva suas principais operações utilizando a notação algébrica apresentada no material PROGRAMAÇÃO MODULAR, de Roberto Bigonha.

A pilha é uma estrutura de dados similar a uma lista que tem como paradigma principal o LIFO (Last In, First Out). De acordo com Bigonha, as principais operações de uma pilha se dão por:

- **PilhaVazia:** Cria uma pilha sem elementos; 
- **Empilhar (Push):** Adiciona um elemento no topo da pilha;
- **Desempilhar (Pop):** Remove o elemento do topo;
- **Topo (Top):** Retorna o elemento do topo sem removê-lo;
- **Vazia:** Verifica se a pilha está vazia;

#### 5.Suponha que você queira criar um aplicativo que permita armazenar e manipular livros. Crie o TAD Livro para facilitar a implementação de seu aplicativo. Use a notação algébrica para descrever estes TAD.  

```
type TADLivro
sorts:
    Integer, String, Livro

operations:
    criarLivro: String, String, Integer, String --> Livro (objeto)
    getTitulo: Livro --> String
    getAutor: Livro --> String
    getAnoPublicacao: Livro --> int
    setTitulo: Livro, String --> Livro
    setAutor: Livro, String --> Livro
    setAnoPublicacao: Livro, Integer --> Livro

preconditions:
    pre criarLivro(titulo : String, autor : String, anoPublicacao : Integer) : ( titulo, autor not null)
    pre criarLivro(titulo : String, autor : String, anoPublicacao : Integer) : (anoPublicacao > 0)
    pre setAnoPublicacao(livro : Livro, novoAno : Integer ) : (novoAno > 0)
axioms:
end
```

#### 6.Faça a seguinte experiência: Apresente em uma conversa com o ChatGPT a sua especificação algébrica do TAD Livro e peça ao mesmo para gerar uma classe em Java equivalente a essa especificação. Inicie outra conversa e agora peça ao ChatGPT para criar a classe Livro para seu aplicativo. Informe os detalhes conforme desejar. Compare os códigos gerados.

#### 7.Vimos como implementar uma pilha genérica em Java. Java é uma linguagem estaticamente tipada e, por isso, requer um mecanismo onde os tipos das variáveis sejam definidos em tempo de compilação. Como seria implementar uma pilha genérica em uma linguagem dinamicamente tipada como Python? Tente criar uma pilha genérica em Python e compare a implementação com Java.  

```python
# PILHA GENÉRICA EM PYTHON

class Stack:
    def __init__(self):
        self.stack = []
    
    def push(self, item):
        self.stack.append(item)
    
    def pop(self):
        if not self.is_empty():
            return self.stack.pop()
        else:
            raise IndexError("Pilha vazia.")
    
    def peek(self):
        if not self.is_empty():
            return self.stack[-1]
        else:
            raise IndexError("Pilha vazia.")
    
    def is_empty(self):
        return len(self.stack) == 0
    
    def size(self):
        return len(self.stack)
```

```java
// PILHA GENÉRICA EM JAVA

public class Stack<T> {
    private Node<T> top;
    private int size;

    // Elemento da pilha
    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    // Construtor da pilha
    public Stack() {
        this.top = null;
        this.size = 0;
    }

public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Pilha vazia.");
        }
        T item = top.data;
        top = top.next;
        size--;
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Pilha vazia.");
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }
```
> **Comparativo:** 
Em Java os tipos precisam ser especificados com generics para garantir segurança de tipo em tempo de compilação. Em Python, por ser dinamicamente tipado, não há necessidade de definir tipos; a pilha pode armazenar qualquer tipo de objeto. E os erros de tipo caso existam só serão descobertos em tempo de execução.

#### 8.Qual a vantagem de utilizar métodos genéricos? Explique e exemplifique o mecanismo de Java para implementar este tipo de método.

Métodos genéricos oferecem vantagens como **reutilização de código**, uma vez que permite que o mesmo código funcione com diferentes tipos de dados. Isso evita duplicação de código e torna o código mais fácil de manter e expandir; **segurança e qualidade,** já que garantem segurança de tipo em tempo de compilação, evitando erros de `ClassCastException` (exceções de cast de tipo), além de **legibilidade e flexbilidade,** já que código genérico é mais reutilizável e não precisa ser repetido para cada tipo, mantendo o programa mais fácil de entender. 

```java
import java.util.HashMap;
import java.util.Map;

public class ExemploGenerico {
    public static void main(String[] args){
        Map<String,Object> parametros = new HashMap<String,Object>();
        parametros.put("nome", "Velocidade da Luz");
        parametros.put("velocidade_da_luz", 300000);
        parametros.put("medicao", true);
    }
}

// Key sendo String e Value podendo ter qualquer valor, já que é um Object
```

#### 9.Explique o funcionamento do algoritmo de ordenação Insertion Sort. Qual a pior configuração de entrada para este algoritmo?

O Insertion Sort é um algoritmo de ordenação simples que constrói a sequência ordenada de forma incremental. Ele percorre o vetor da esquerda para a direita, inserindo cada elemento na posição correta em relação aos elementos anteriores e a cada iteração, o elemento atual é comparado com os anteriores e trocado de posição até encontrar seu local adequado. 

A complexidade do Insertion Sort é \(O(n^2)\) no pior caso, que ocorre quando a entrada está em ordem decrescente, pois cada novo elemento precisa ser comparado com todos os anteriores. No melhor caso, com a entrada já ordenada, a complexidade é \(O(n)\).

#### 10.Explique o funcionamento do algoritmo de ordenação Selection Sort. Qual a pior configuração de entrada para este algoritmo?

O Selection Sort é um algoritmo de ordenação que divide o vetor em duas partes: a parte ordenada, à esquerda, e a não ordenada, à direita. A cada iteração, ele busca o menor elemento na parte não ordenada e o troca com o primeiro elemento dessa seção, movendo-o para a parte ordenada. Esse processo se repete até que toda a sequência esteja organizada.

A complexidade do Selection Sort é \(O(n^2)\) tanto no pior quanto no melhor caso, pois ele sempre realiza \(n\) buscas de mínimo e até \(n-1\) trocas, independentemente da disposição inicial dos elementos. Assim, a pior configuração de entrada para o algoritmo não depende da ordem dos elementos, já que o desempenho é sempre quadrático.

#### 11.Compare os algoritmos Insertion Sort e Selection Sort em termos de complexidade e desempenho em diferentes casos. Analise o melhor, o médio e o pior caso para complexidade. Para medir desempenho, faça experimentos.

O Insertion Sort tem complexidade \(O(n^2)\) no pior e no caso médio, mas \(O(n)\) no melhor caso (quando o vetor já está ordenado). Ele é eficiente para conjuntos pequenos e parcialmente ordenados, já que faz menos comparações e trocas. É estável, preservando a ordem de elementos iguais e seu desempenho melhora com o aumento da ordenação inicial.

O Selection Sort tem complexidade \(O(n^2)\) em todos os casos, pois sempre percorre o vetor para encontrar o mínimo em cada posição, independentemente da ordenação inicial. Ele realiza mais trocas, é menos eficiente em grandes conjuntos e não é estável, pois não preserva a ordem de elementos iguais.

Dessa forma conclui-se que o Insertion Sort é mais rápido para entradas parcialmente ordenadas, enquanto o Selection Sort tem desempenho constante, mas mais lento em média.

#### 12.Reescreva o algoritmo Selection Sort utilizando um TAD Arranjo (visto em sala) com as operações troca, menorQue e atualizaIndice.

```java
import java.util.Arrays;

public class Arranjo {
    private int[] items;
    private int tamanhoArranjo; // Quantidade de elementos no array

    // Construtor definindo capacidade inicial
    public Arranjo(int capacidade) {
        this.items = new int[capacidade];
        this.tamanhoArranjo = 0;
    }

    // Insere novo elemento se ele ainda não existir no arranjo (sem repetições)
    public void inserir(int elemento) throws Exception {
        if (!existe(elemento)) {
            if (tamanhoArranjo == items.length) {
                redimensionar();
                throw new Exception("* Será necessário redimensionar o arranjo.");
            }
            items[tamanhoArranjo] = elemento;
            tamanhoArranjo++;
            System.out.println("* Elemento inserido:");
            exibir();
        }
    }

    private boolean existe(int elemento) {
        for (int i = 0; i < tamanhoArranjo; i++) {
            if (items[i] == elemento) {
                return true;
            }
        }
        return false;
    }

    private void redimensionar() {
        items = Arrays.copyOf(items, items.length * 2);
    }

    // Exclui o elemento e desloca os elementos à frente para a esquerda para evitar posições vazias
    public void excluir(int elemento) {
        int indice = -1;
        for (int i = 0; i < tamanhoArranjo; i++) {
            if (items[i] == elemento) {
                indice = i;
                break;
            }
        }

        if (indice != -1) {
            // Desloca os elementos para a esquerda a partir do índice encontrado
            for (int i = indice; i < tamanhoArranjo - 1; i++) {
                items[i] = items[i + 1];
            }
            tamanhoArranjo--;
        }
    }

    // Retorna true se o elemento no índice 'a' é menor que o elemento no índice 'b'
    public boolean menorQue(int a, int b) {
        if (a >= 0 && a < tamanhoArranjo && b >= 0 && b < tamanhoArranjo) {
            return items[a] < items[b];
        }
        throw new IllegalArgumentException("Índices fora do intervalo.");
    }

    // Troca os elementos nos índices 'a' e 'b'
    public void troca(int a, int b) {
        if (a >= 0 && a < tamanhoArranjo && b >= 0 && b < tamanhoArranjo) {
            int temp = items[a];
            items[a] = items[b];
            items[b] = temp;
        } else {
            throw new IllegalArgumentException("Índices fora do intervalo.");
        }
    }

    // Atualiza o valor no índice 'indice' com o valor 'valor'
    public void atualizaIndice(int indice, int valor) {
        if (indice >= 0 && indice < tamanhoArranjo) {
            items[indice] = valor;
        } else {
            throw new IllegalArgumentException("Índice fora do intervalo.");
        }
    }

    // Implementa o Selection Sort usando troca, menorQue e atualizaIndice
    public void selectionSort() {
        for (int i = 0; i < tamanhoArranjo - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < tamanhoArranjo; j++) {
                if (menorQue(j, minIndex)) {
                    minIndex = j;
                }
            }
            // Realiza a troca somente se o menor índice encontrado não for o índice atual
            if (minIndex != i) {
                troca(i, minIndex);
            }
        }
    }

    // Método de soma de pares simétricos
    public int somarParesSimetricos(int k) {
        if (k <= 0 || k > tamanhoArranjo / 2) {
            throw new IllegalArgumentException("* Índice k fora do intervalo.");
        }

        // Ordena o arranjo antes de realizar a soma
        Arrays.sort(items, 0, tamanhoArranjo);

        int menor = items[k - 1]; // Menor elemento é o primeiro, de índice zero
        int maior = items[tamanhoArranjo - k]; // Maior elemento é o último, de índice tamanho - 1

        return menor + maior;
    }

    public void exibir() {
        System.out.print("[");
        for (int i = 0; i < tamanhoArranjo; i++) {
            System.out.print(items[i]);
            if (i < tamanhoArranjo - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
```

#### 13.Quais são as características de um método lambda em Java? Apresente um exemplo de uso.

Um método lambda em Java é um mecanismo de definição de funções anônimas. Uma expressão lamba possui as seguintes características:

- *Sintaxe Concisa:* Lambdas permitem a escrita de blocos de código de maneira mais enxuta e direta, sem a necessidade de declarar uma classe anônima. 

    `param1, param2 -> {/* corpo da função*/}`

- *Uso de Interfaces Funcionais:* Uma expressão lambda só pode ser utilizada em contextos onde existe uma interface funcional, que é uma interface com um único método abstrato. O exemplo mais comum é a interface `java.util.function.Function`.
  
- *Sem necessidade de nomear o método:* Ao invés de criar uma classe ou um método nomeado, o lambda encapsula o comportamento sem um nome explícito.  
  
- *Suporte a "Closure":* Expressões lambda podem capturar variáveis locais (de fora do escopo da lambda) desde que essas variáveis sejam "efetivamente finais", ou seja, seu valor não pode ser alterado após serem usadas na lambda.    
  
- *Inferência de tipo:* O compilador Java pode inferir os tipos dos parâmetros das lambdas, simplificando ainda mais o código. 


```java
import java.util.*;
public class ExemploLambda {
    public static void main(String[] args) {
        List<String> frutas = Arrays.asList("Banana", "Uva", "Maçã");
        Collections.sort(frutas, (String fruta1, String fruta2) -> fruta1.compareTo(fruta2))
        frutas.forEach(nome -> System.out.println(nome));
    }
}
// Ordenando a lista usando expressão lambda que substitui o uso de um Comparator<String>
```

#### 14.Quais são dois dos principais tipos de aplicações para pilhas? Exemplifique cada um deles.

Pilhas são comumente usadas na implementação de *recursão* e *backtracking*, além de em problemas que envolvam expressões pós-fixas.

```
// ExemploPsedo_Backtracking
função resolverLabirinto(labirinto, inicio, fim)
    pilha <- novaPilha()
    pilha.empilhar(inicio)

    enquanto pilha não estiver vazia
        atual <- pilha.desempilhar()
        
        se atual for igual a fim
            retornar "Caminho encontrado!"

        marcar atual como visitado

        para cada vizinho em vizinhos(atual)
            se vizinho não estiver visitado e não for uma parede
                pilha.empilhar(vizinho)

    retornar "Caminho não encontrado"
```

```
// ExemploPsedo_PosFixada
função calcularPosFixada(expressao)
    pilha <- novaPilha()

    para cada token em expressao
        se token for um número
            pilha.empilhar(token)
        senão se token for um operador
            operando2 <- pilha.desempilhar()
            operando1 <- pilha.desempilhar()

            se token for '+'
                resultado <- operando1 + operando2
            se token for '*'
                resultado <- operando1 * operando2

            pilha.empilhar(resultado)

    retornar pilha.desempilhar()  // Resultado final
```

#### 15.Modifique a implementação da pilha genérica para que ela possa redimensionar automaticamente seu tamanho quando estiver cheia.

```java
public class Stack<T> {
    private T[] items;
    private int top;   // Índice do topo da pilha

    // Construtor da pilha com capacidade inicial
    public Stack(int capacidadeInicial) {
        this.items = (T[]) new Object[capacidadeInicial];
        this.top = -1;
    }

    // Método para adicionar um elemento ao topo da pilha
    public void push(T item) {
        // Verifica se é necessário redimensionar
        if (top == items.length - 1) {
            redimensionar(items.length * 2);  // Dobra a capacidade
        }
        items[++top] = item;
    }

    // Método para remover o elemento do topo da pilha
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Pilha vazia.");
        }
        T item = items[top];
        items[top] = null; // Remove referência para o elemento no array
        top--;

        // Reduz o tamanho do array pela metade se o número de elementos for menor que um quarto da capacidade
        if (top > 0 && top == items.length / 4) {
            redimensionar(items.length / 2);
        }
        return item;
    }

    // Retorna o elemento do topo sem removê-lo
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Pilha vazia.");
        }
        return items[top];
    }

    // Verifica se a pilha está vazia
    public boolean isEmpty() {
        return top == -1;
    }

    // Retorna o número de elementos na pilha
    public int size() {
        return top + 1;
    }

    // Redimensiona o array interno para a nova capacidade
    private void redimensionar(int novaCapacidade) {
        T[] novoArray = (T[]) new Object[novaCapacidade];
        System.arraycopy(items, 0, novoArray, 0, top + 1);
        items = novoArray;
    }
}
```

#### 16.Implemente a classe Fila<T> em Java, com as operações insere, remove, vazia, cheia e tamanho. Lembre-se de criar a interface para a mesma.

#### 17.Adicione o método processaElementos na classe Fila<T>, que recebe uma função lambda como parâmetro e executa essa função em cada elemento da fila.

#### 18.Utilize a classe Aluno com um método atualizarInformacao(String info), e mostre como utilizá-lo como parâmetro do método processaElemento na fila.

#### 19.Faça um teste de mesa para o algoritmo Insertion Sort considerando o seguinte arranjo como entrada: {12, 5, 7, 1, 14}.

| **Iteração** | **ElementoAtual** |                                                  **Análise, Ação**                                                  |     **Lista**     |
|:------------:|:-----------------:|:-------------------------------------------------------------------------------------------------------------------:|:-----------------:|
| 1            | 12                |                                                                                                                     | {12, 5, 7, 1, 14} |
| 2            | 5                 | 5 é menor que 12, mover 12 para direita                                                                             | {5, 12, 7, 1, 14} |
| 3            | 7                 | 7 é menor que 12, mover 12 para direita 7 é maior que 5, manter                                                     | {5, 7, 12, 1, 14} |
| 4            | 1                 | 1 é menor que 12, mover 12 para direita 1 é menor que 7, mover 7 para direita 1 é menor que 5, mover 5 para direita | {1, 5, 7, 12, 14} |
| 5            | 14                | 14 é maior que 12, manter                                                                                           | {1, 5, 7, 12, 14} |

#### 20.Faça um teste de mesa para o algoritmo Selection Sort, utilizando o mesmo arranjo {12, 5, 7, 1, 14}.

#### 21.Dado o seguinte arranjo de inteiros {25, 12, 30, 9, 8, 1}, utilize o algoritmo Selection Sort para ordená-lo e, ao mesmo tempo, conte quantas trocas de elementos são realizadas durante o processo. Mostre o resultado final e o número de trocas.

#### 22.Considere a classe PilhaS<T>, que já implementa uma pilha genérica. Implemente um novo método chamado inverterPilha(), que inverte a ordem dos elementos na pilha utilizando outra pilha auxiliar. Teste o método em uma classe cliente.

#### 23.Crie uma classe PilhaMonitorada<T>, que herda de PilhaS<T> e adiciona um contador de operações de empilhamento e desempilhamento. Cada vez que uma dessas operações for chamada, incremente o contador. Teste a classe PilhaMonitorada<T> com uma pilha de inteiros. Empilhe e desempilhe 10 elementos e mostre o número de operações realizadas.
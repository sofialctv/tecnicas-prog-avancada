## Lista de Exercício 1
- **Disciplina:** Técnicas de Programação Avançada Professor: Mateus Costa
- **Aluna:** Sofia de Alcantara Silva [20222BSI0199]

#### 1. Explique a diferença entre um algoritmo e um programa de computador. Quais as vantagens de se elaborar um algoritmo para resolver um problema como um passo anterior à implementação do programa?

Pode-se definir algoritmo como uma descrição lógica da solução baseada em conceitos do domínio do problema. Um programa de computador, por sua vez, enquanto um programa é uma sequência de instruções descritas por um algoritmo. As vantagens de aplicar um algoritmo para resolver problemas é que o algoritmo está mais próximo à linguagem humana, facilitando a compreensão da lógica do problema sem se preocupar com detalhes de implementação. Além disso, algoritmos viabilizam portabilidade uma vez que funciona como meio de comunicação genérico para apresentação de um problema-solução.  

#### 2.Explique o que é o gap semântico entre o mundo dos problemas e os programas de computador.

O termo *gap* semântico pode ser entendido como a distância existente entre a forma que os humanos compreendem e descrevem um problema e a forma como esse problema é representado e solucionado por um computador. Em resumo, é a limitação em traduzir a linguagem natural para a linguagem formal exigida por programas de computadores. A existência de gaps semânticos se explica pela complexidade da linguagem natural e a exigência da programação quanto a abstrações, por exemplo.

#### 3.A busca pela redução do gap semântico levou inicialmente a abordagens voltadas para a extensibilidade das estruturas de fluxo de controle e, posteriormente, à emergência do conceito de Tipo Abstrato de Dados. Explique estes conceitos e faça um comparativo entre estas abordagens.

#### 4.O que é uma pilha? Descreva suas principais operações utilizando a notação algébrica apresentada no material PROGRAMAÇÃO MODULAR, de Roberto Bigonha.  

#### 5.Suponha que você queira criar um aplicativo que permita armazenar e manipular livros. Crie o TAD Livro para facilitar a implementação de seu aplicativo. Use a notação algébrica para descrever estes TAD.  

#### 6.Faça a seguinte experiência: Apresente em uma conversa com o ChatGPT a sua especificação algébrica do TAD Livro e peça ao mesmo para gerar uma classe em Java equivalente a essa especificação. Inicie outra conversa e agora peça ao ChatGPT para criar a classe Livro para seu aplicativo. Informe os detalhes conforme desejar. Compare os códigos gerados.

#### 7.Vimos como implementar uma pilha genérica em Java. Java é uma linguagem estaticamente tipada e, por isso, requer um mecanismo onde os tipos das variáveis sejam definidos em tempo de compilação. Como seria implementar uma pilha genérica em uma linguagem dinamicamente tipada como Python? Tente criar uma pilha genérica em Python e compare a implementação com Java.  

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
}
// Key sendo String e Value podendo ter qualquer valor, já que é um Object
```

#### 9.Explique o funcionamento do algoritmo de ordenação Insertion Sort. Qual a pior configuração de entrada para este algoritmo?

#### 10.Explique o funcionamento do algoritmo de ordenação Selection Sort. Qual a pior configuração de entrada para este algoritmo?

#### 11.Compare os algoritmos Insertion Sort e Selection Sort em termos de complexidade e desempenho em diferentes casos. Analise o melhor, o médio e o pior caso para complexidade. Para medir desempenho, faça experimentos.

#### 12.Reescreva o algoritmo Selection Sort utilizando um TAD Arranjo (visto em sala) com as operações troca, menorQue e atualizaIndice.

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

#### 16.Implemente a classe Fila<T> em Java, com as operações insere, remove, vazia, cheia e tamanho. Lembre-se de criar a interface para a mesma.

#### 17.Adicione o método processaElementos na classe Fila<T>, que recebe uma função lambda como parâmetro e executa essa função em cada elemento da fila.

#### 18.Utilize a classe Aluno com um método atualizarInformacao(String info), e mostre como utilizá-lo como parâmetro do método processaElemento na fila.

#### 19.Faça um teste de mesa para o algoritmo Insertion Sort considerando o seguinte arranjo como entrada: {12, 5, 7, 1, 14}.

#### 20.Faça um teste de mesa para o algoritmo Selection Sort, utilizando o mesmo arranjo {12, 5, 7, 1, 14}.
#### 21.Dado o seguinte arranjo de inteiros {25, 12, 30, 9, 8, 1}, utilize o algoritmo Selection Sort para ordená-lo e, ao mesmo tempo, conte quantas trocas de elementos são realizadas durante o processo. Mostre o resultado final e o número de trocas.
#### 22.Considere a classe PilhaS<T>, que já implementa uma pilha genérica. Implemente um novo método chamado inverterPilha(), que inverte a ordem dos elementos na pilha utilizando outra pilha auxiliar. Teste o método em uma classe cliente.

#### 23.Crie uma classe PilhaMonitorada<T>, que herda de PilhaS<T> e adiciona um contador de operações de empilhamento e desempilhamento. Cada vez que uma dessas operações for chamada, incremente o contador. Teste a classe PilhaMonitorada<T> com uma pilha de inteiros. Empilhe e desempilhe 10 elementos e mostre o número de operações realizadas.
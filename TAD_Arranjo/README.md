# Atividade 1: Classe do TAD Arranjo e classe de teste para uso do TAD

_Envie aqui em um arquivo .java (use o mesmo arquivo para as duas classes) contendo a classe com o TAD Arranjo e a classe de teste (cliente da classe TADArranjo) que realiza as operações insere, somaparesSimétricos e remove, conforme descrito nos slides._

---
#### Problema: Manipulação de Arranjo

Suponha que você deseja usar um arranjo para manipular um
conjunto de números inteiros.

Operações envolvidas:
- Inserir elementos no arranjo (sem repetições).
- Excluir elementos do arranjo, deslocando todos os elementos com índice acima uma posição para baixo.
- Obter a soma de quaisquer pares simétricos do arranjo. Por exemplo:
  - somapParesSimétricos(1): soma o primeiro maior elemento com o primeiro menor.
  - somapParesSimétricos(2): soma o segundo maior elemento com o segundo menor.
  - somapSimétricos(k): soma o k-ésimo maior elemento com o k-ésimo menor.

Considerando essas operações, crie um TAD Arranjo com operações abstratas que possam facilitar a realização dessas funções.
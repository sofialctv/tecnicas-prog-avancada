import java.util.Arrays;

public class Arranjo {
   private int[] items;
   private int tamanhoArranjo;       // tamanhoArranjo de items no array

   // Construtor definindo capacidade inicial
   public Arranjo(int capacidade)
   {
      this.items = new int[capacidade];
      this.tamanhoArranjo = 0;
   }

   // Insere novo elemento se somente se ele ainda não existir no arranjo (sem repetições)
   public void inserir(int elemento) throws Exception {
      if (!existe(elemento))
      {
   // Caso a tamanhoArranjo seja igual ao comprimento do array, significa que não há mais espaço para novos elementos
         if (tamanhoArranjo == items.length)
         {
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

   private void redimensionar(){
   // Arrays.copyOf é usado para clonar o conteúdo do arranjo origem e aumentando seu tamanho em 2x
      items = Arrays.copyOf(items, items.length * 2);
   }

   // Exclui o elemento e desloca os elementos à frente para a esquerda para evitar posições vazias
   public void excluir(int elemento) {
      int indice = -1;
      for (int i = 0; i < tamanhoArranjo; i++) {
         if (items[i] == elemento)
         {
            indice = i;
            break;
         }
      }

      if (indice != -1) {
   // Desloca os elementos para a esquerda a partir do índice encontrado
         for (int i = indice; i < tamanhoArranjo - 1; i++)
         {
            items[i] = items[i + 1];
         }
         tamanhoArranjo--;
      }
   }

   public int somarParesSimetricos(int k){
      if (k <= 0 || k > tamanhoArranjo / 2)
      {
         throw new IllegalArgumentException("* Índice k fora do intervalo.");
      }

   // Ordena o arranjo antes de realizar a soma
      Arrays.sort(items, 0, tamanhoArranjo);

      int menor = items[k -1];                     // Menor elemento é o primeiro, de índice zero
      int maior = items[tamanhoArranjo - k];       // Maior elemento é o último, de índice tamanho - 1

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

   public static void main(String[] args) throws Exception {
      Arranjo arr = new Arranjo(5);

      arr.inserir(13);
      arr.inserir(78);
      arr.inserir(93);
      arr.inserir(12);
      arr.inserir(7);

      System.out.println("---- \n* Arranjo após inserções:");
      arr.exibir();

      System.out.println("\n* Soma do 1º par simétrico = " + arr.somarParesSimetricos(1));
      System.out.println("* Soma do 2º par simétrico = " + arr.somarParesSimetricos(2));

      arr.excluir(30);
      System.out.println("Arranjo após exclusão:");
      arr.exibir();
   }
}
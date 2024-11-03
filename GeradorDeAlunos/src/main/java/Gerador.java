import com.github.javafaker.Faker;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Gerador {

    public static void main(String[] args) {

        // Instanciando o JavaFaker para gerar dados aleatórios
        Faker faker = new Faker();
        Random random = new Random();

        // Definindo o arquivo binário de saída
        String arquivoBinario = "alunos.bin";

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(arquivoBinario))) {

            // Gera um número aleatório de alunos
            int quantidadeAlunos = random.nextInt(16) + 5; // Gera entre 5 e 20 alunos

            for (int i = 0; i < quantidadeAlunos; i++) {

                String nome = faker.name().fullName();
                String matricula = "BSI." + faker.number().digits(4);

                int nota = random.nextInt(101); // Nota entre 0 e 100

                String frequencia = random.nextInt(101) + "%"; // Frequência entre 0 e 100

                Aluno aluno = new Aluno(nome, matricula, nota, frequencia);

                // Salvar os dados do aluno no arquivo binário
                aluno.salvarEmArquivoBinario(dos);

                aluno.printDados();
            }
            System.out.println("\n* Arquivo binário gerado com sucesso!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
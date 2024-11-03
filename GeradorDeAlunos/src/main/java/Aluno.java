import java.io.DataOutputStream;
import java.io.IOException;
import java.sql.SQLOutput;

public class Aluno {

    public String nome;
    public String matricula;
    public int nota;
    public String frequencia;

        public Aluno(String nome, String matricula, int nota, String frequencia)
    {
        this.nome = nome;
        this.matricula = matricula;
        this.nota = nota;
        this.frequencia = frequencia;
    }

//    public String getNome() { return nome; }
//    public void setNome(String nome) {  this.nome = nome; }
//
//    public String getMatricula() { return matricula; }
//    public void setMatricula(String matricula) { this.matricula = matricula; }
//
//    public int getNota() { return nota; }
//    public void setNota(int nota) { this.nota = nota; }
//
//    public String getFrequencia() { return frequencia; }
//    public void setFrequencia(String frequencia) { this.frequencia = frequencia; }

    public void printDados() {
        System.out.println("---\n* Nome: " + this.nome);
        System.out.println("* Matrícula: " + this.matricula);
        System.out.println("* Nota Final: " + this.nota);
        System.out.println("* Frequência: " + this.frequencia);
    }

    // Grava dados de Aluno em arquivo binário (DataOutputStream)
    public void salvarEmArquivoBinario(DataOutputStream dos) throws IOException {
        dos.writeUTF(this.nome);
        dos.writeUTF(this.matricula);
        dos.writeInt(this.nota);
        dos.writeUTF(this.frequencia);
    }
}

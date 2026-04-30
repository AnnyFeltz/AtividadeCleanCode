package funcoes.funcoes_menu;

import java.io.PrintStream;
import java.util.Scanner;
import modelos.Aluno;
import modelos.Escola;

public class FuncoesAluno {

    public static String info(String mensagem){
        String string = "";
        return string += "\n" + mensagem + "\n-------------------------------------------------------------\\n\\nInforme os dados do aluno:";
    }
    
    public static void adicionarAluno(PrintStream video, Scanner teclado, Escola escola) {
        info("Adicionar Aluno");

        video.print("\nNome: ");
        String nome = teclado.nextLine();

        video.print("CPF: ");
        String cpf = teclado.nextLine();

        video.print("Email: ");
        String email = teclado.nextLine();

        video.print("Ano de Nascimento: ");
        int anoNascido = teclado.nextInt();
        teclado.nextLine();

        Aluno novo = new Aluno(nome, cpf, email, anoNascido);

        if (escola.adicionarAluno(novo)) {
            video.println("\nAluno adicionado");
        } else {
            video.println("\nNão foi possível adicionar o aluno, verifique se o CPF já existe ou se não há espaço.");
        }
    }

    public static void buscarAlunoPorNome(PrintStream video, Scanner teclado, Escola escola) {
        info("Buscar Aluno pelo Nome");

        video.print("\nNome: ");
        String nomeBusca = teclado.nextLine();
        
        Aluno alunoBuscarNome = escola.buscarAluno(nomeBusca);
        
        if (alunoBuscarNome != null) {
            video.println("\nAluno encontrado: " + alunoBuscarNome.imprimir());
        } else {
            video.println("\nAluno não encontrado, verifique se o nome foi digitado corretamente");
        }
    }

    public static void buscarAlunoPorCpf(PrintStream video, Scanner teclado, Escola escola) {
        info("Buscar Aluno pelo CPF");

        video.print("\nCPF: ");
        String cpfBusca = teclado.nextLine();
        
        Aluno alunoBuscarCpf = escola.buscarAlunoCpf(cpfBusca);
        
        if (alunoBuscarCpf != null) {
            video.println("\nAluno encontrado: " + alunoBuscarCpf.imprimir());
        } else {
            video.println("\nAluno não encontrado, verifique se o CPF foi digitado corretamente");
        }
    }

    public static void removerAluno(PrintStream video, Scanner teclado, Escola escola) {
        info("Remover Aluno");

        video.print("\nCPF: ");
        String removerCpf = teclado.nextLine();
        
        if (escola.removerAluno(removerCpf)) {
            video.println("\nAluno removido");
        } else {
            video.print("\nNão foi possivel remover o aluno, verifique se digitou o CPf corretamente");
        }
    }
}

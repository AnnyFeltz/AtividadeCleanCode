package funcoes.funcoes_menu;

import java.io.PrintStream;
import java.util.Scanner;
import modelos.Disciplina;
import modelos.Escola;

public class FuncoesDisciplina {

    public static String info(String mensagem){
        String string = "";
        return string += "\n" + mensagem + "\n-------------------------------------------------------------\\n\\nInforme os dados da Disciplina:";
    }

    public static void adicionarDisciplina(PrintStream video, Scanner teclado, Escola escola) {
        info("Adicionar Disciplina");

        video.print("\nNome: ");
        String nomeDisciplina = teclado.nextLine();
        
        video.print("Código: ");
        String codigoDisciplina = teclado.nextLine();
        
        video.print("Carga Horária: ");
        int cargaHorariaDisicplina = teclado.nextInt();
        teclado.nextLine();
        
        video.print("Limite máximo de alunos: ");
        int limiteDisicplina = teclado.nextInt();
        teclado.nextLine();
        
        Disciplina nova = new Disciplina(nomeDisciplina, codigoDisciplina, cargaHorariaDisicplina, limiteDisicplina);
        
        if (escola.adicionarDisciplina(nova)) {
            video.println("\nDisciplina adicionada");
        } else {
            video.println("\nNão foi possivel adionar a disciplina, verifique se o codigo já existe ");
        }
    }

    public static void buscarDisciplinaPorCodigo(PrintStream video, Scanner teclado, Escola escola) {
        info("Buscar Disciplina pelo Código");
        video.print("\nCódigo: ");
        String codigoBuscar = teclado.nextLine();
        
        Disciplina buscarDisciplina = escola.buscarDisciplina(codigoBuscar);
        
        if (buscarDisciplina != null) {
            video.println("\nDisciplina encontrada: " + buscarDisciplina.toString());
        } else {
            video.println("\nDisciplina não encontrada, veifique se foi digitada corretamente.");
        }
    }

    public static void removerDisciplina(PrintStream video, Scanner teclado, Escola escola) {
        info("Remover Disciplina");

        video.print("\nCódigo: ");
        String codigoRemover = teclado.nextLine();
        
        if (escola.removerDisciplina(codigoRemover)) {
            video.println("\nDisciplina Removida");
        } else {
            video.println("\nNão foi possivel remover, verifique se o codigo foi escrito corretamente");
        }
    }

    public static void listarAlunosMatriculados(PrintStream video, Scanner teclado, Escola escola) {
        info("Listar alunos de uma disciplina");

        video.print("\nCódigo: ");
        String codigoListar = teclado.nextLine();
        
        video.println(escola.listarAlunosMatriculados(codigoListar));
    }

    public static void matricularAluno(PrintStream video, Scanner teclado, Escola escola) {
        info("Matricular aluno em uma disciplina");

        video.print("\nCódigo: ");
        String codigoMatricula = teclado.nextLine();
        
        video.print("CPF do aluno: ");
        String cpfMatricula = teclado.nextLine();
        
        if (escola.matricularAluno(codigoMatricula, cpfMatricula)) {
            video.println("\nAluno com o cpf " + cpfMatricula + " foi matriculado na disciplina de codigo " + codigoMatricula);
        } else {
            video.print("\nNão foi possivel matricular o aluno, verifique se o cpf e o codigo foram digitados corretamente, ou se a disicplina não está cheia");
        }
    }

    public static void desmatricularAluno(PrintStream video, Scanner teclado, Escola escola) {
        info("Desmatricular aluno de uma disciplina");

        video.print("\nInforme o codigo da disciplina: ");
        String codigoDesmatricula = teclado.nextLine();
        
        video.print("Digite o CPF do aluno: ");
        String cpfDesmatricula = teclado.nextLine();
        
        if (escola.desmatricularAluno(codigoDesmatricula, cpfDesmatricula)) {
            video.println("\nAluno com o cpf " + cpfDesmatricula + " foi desmatriculado da disciplina de codigo " + codigoDesmatricula);
        } else {
            video.print("\nNão foi possivel desmatricular o aluno, verifique se o cpf e o codigo foram digitados corretamente");
        }
    }
}
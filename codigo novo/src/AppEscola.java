import funcoes.funcoes_menu.FuncoesAluno;
import funcoes.funcoes_menu.FuncoesDisciplina;
import funcoes.funcoes_menu.FuncoesProfessor;

import java.io.PrintStream;
import java.util.Scanner;
import modelos.Escola;
import tela.Menu;

public class AppEscola {

    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            PrintStream video = new PrintStream(System.out);
            
            Escola escola = new Escola("Escola Escolar", "(41) 99999-9999");
            int opcao;
            
            do {
                Menu.exibirMenu(video);
                opcao = teclado.nextInt();
                teclado.nextLine();
                
                switch (opcao) {
                    // adicionar aluno
                    case 1 -> { FuncoesAluno.adicionarAluno(video, teclado, escola); }
                        
                    // buscar nome do aluno
                    case 2 -> { FuncoesAluno.buscarAlunoPorNome(video, teclado, escola); }
                    
                    // buscar cpf do aluno
                    case 3 -> { FuncoesAluno.buscarAlunoPorCpf(video, teclado, escola); }
                    
                    // remover aluno
                    case 4 -> { FuncoesAluno.removerAluno(video, teclado, escola); }
                    
                    // listar aluno
                    case 5 -> { video.println(escola.listarAlunos()); }
                        
                    // contar aluno
                    case 6 -> { video.println("\nTotal de alunos: " + escola.contarAlunos()); }
                        
                    // adicionar disciplina
                    case 7 -> { FuncoesDisciplina.adicionarDisciplina(video, teclado, escola); }
                    
                    // buscar disciplina
                    case 8 -> { FuncoesDisciplina.buscarDisciplinaPorCodigo(video, teclado, escola); }

                    // remover disciplina
                    case 9 -> { FuncoesDisciplina.removerDisciplina(video, teclado, escola); }
                    
                    // listar disciplina
                    case 10 -> { video.println(escola.listarDisciplinas()); }
                        
                    // matricular aluno
                    case 11 -> { FuncoesDisciplina.matricularAluno(video, teclado, escola); }
                    
                    // desmatricular aluno
                    case 12 -> { FuncoesDisciplina.desmatricularAluno(video, teclado, escola); }
                    
                    // contar disciplinas
                    case 13 -> { video.println("\nTotal de disciplinas: " + escola.contarDisciplinas()); }
                    
                    // listar alunos de uma disciplina
                    case 14 -> { FuncoesDisciplina.listarAlunosMatriculados(video, teclado, escola); }
                        
                    // adicionar professor
                    case 15 -> { FuncoesProfessor.adicionarProfessor(video, teclado, escola); }
                    
                    // buscar nome do professor
                    case 16 -> { FuncoesProfessor.buscarProfessorPorNome(video, teclado, escola); }
                    
                    // buscar cpf do professor
                    case 17 -> { FuncoesProfessor.buscarProfessorPorCpf(video, teclado, escola); }
                    
                    // remover professor
                    case 18 -> { FuncoesProfessor.removerProfessor(video, teclado, escola); }
                    
                    // listar professor
                    case 19 -> { video.println(escola.listarProfessores()); }
                        
                    // contar professor
                    case 20 -> { video.println("\nTotal de Professores: " + escola.contarProfessores()); }
                        
                    // Sair do app
                    case 0 -> { video.println("\nEncerrando o programa.."); }
                }
            } while (opcao != 0);
        }
    }
}

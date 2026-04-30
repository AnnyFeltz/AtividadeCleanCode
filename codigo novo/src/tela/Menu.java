package tela;

import java.io.PrintStream;

public class Menu {

    public Menu() {
        //
    }

    public static void exibirMenu(PrintStream video) {
        video.println("\n-------------------------------------------------------------\n");            
        video.println("-  Menu de opções  -");
        video.println("\n-------------------------------------------------------------\n");            
        video.println("\t- Sessão Aluno -");
        video.println("\t\t1  - Adicionar aluno");
        video.println("\t\t2  - Buscar aluno pelo nome");
        video.println("\t\t3  - Buscar aluno pelo CPF");
        video.println("\t\t4  - Remover aluno");
        video.println("\t\t5  - Listar alunos");
        video.println("\t\t6  - Contar os alunos");
        video.println("\n-------------------------------------------------------------\n");
        video.println("\t- Sessão Disciplina -");
        video.println("\t\t7  - Adiconar disciplina");
        video.println("\t\t8  - Buscar disciplina");
        video.println("\t\t9  - Remover disciplina");
        video.println("\t\t10 - Listar disciplina");
        video.println("\t\t11 - Matricular aluno em uma disicplina");
        video.println("\t\t12 - Desmatricular aluno de uma disicplina");
        video.println("\t\t13 - Contar as disciplinas");
        video.println("\t\t14 - Listar alunos de uma disicplina");
        video.println("\n-------------------------------------------------------------\n");            
        video.println("\t- Sessão Professor -");
        video.println("\t\t15 - Adicionar professor");
        video.println("\t\t16 - Buscar professor pelo nome");
        video.println("\t\t17 - Buscar professor pelo CPF");
        video.println("\t\t18 - Remover professor");
        video.println("\t\t19 - Listar professores");
        video.println("\t\t20 - Contar os professores");
        video.println("\n-------------------------------------------------------------\n");
        video.println("\t\t0  - Sair");
        video.println("\n-------------------------------------------------------------\n");
        video.print("escolha uma opção: ");
    }
}

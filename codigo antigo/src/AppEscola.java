
//ava voltou 
import java.io.PrintStream;
import java.util.Scanner;

public class AppEscola {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        PrintStream video = new PrintStream(System.out);

        Escola escola = new Escola("Escola Escolar", "(41) 99999-9999");
        int opcao;

        do {
            // #region Menu
            video.println("\n- Menu de opções -\n");
            video.println("\t1  - Adicionar aluno");
            video.println("\t2  - Buscar aluno pelo nome");
            video.println("\t3  - Buscar aluno pelo CPF");
            video.println("\t4  - Remover aluno");
            video.println("\t5  - Listar alunos");
            video.println("\t6  - Adiconar disciplina");
            video.println("\t7  - Buscar disciplina");
            video.println("\t8  - Remover disciplina");
            video.println("\t9  - Listar disciplina");
            video.println("\t10 - Matricular aluno em uma disicplina");
            video.println("\t11 - Desmatricular aluno de uma disicplina");
            video.println("\t12 - Listar alunos de uma disicplina");
            video.println("\t13 - Adicionar professor");
            video.println("\t14 - Buscar professor pelo nome");
            video.println("\t15 - Buscar professor pelo CPF");
            video.println("\t16 - Remover professor");
            video.println("\t17 - Listar professores");
            video.println("\t18 - Contar os alunos");
            video.println("\t19 - Contar as disciplinas");
            video.println("\t20 - Contar os professores");
            video.println("\t0 - Sair");
            video.print("\nescolha uma opção: ");
            opcao = teclado.nextInt();
            teclado.nextLine();
            // #endregion

            switch (opcao) {

                case 1: // adicionar aluno
                    video.print("\nInforme o nome do aluno: ");
                    String name = teclado.nextLine();

                    video.print("Digite o CPF do aluno: ");
                    String cpf = teclado.nextLine();

                    video.print("Informe o email do aluno: ");
                    String email = teclado.nextLine();

                    video.print("Insira o ano de Nascimento do aluno: ");
                    int anoNascido = teclado.nextInt();
                    teclado.nextLine();

                    Aluno novo = new Aluno(name, cpf, email, anoNascido);

                    if (escola.adicionarAluno(novo)) {
                        video.println("\nAluno adicionado");
                    } else {
                        video.println(
                                "\nNão foi possível adicionar o aluno, verifique se o CPF já existe ou se não há espaço.");
                    }
                    break;

                case 2: // buscar nome do aluno
                    video.print("\nDigite o nome do aluno: ");
                    String nomeBusca = teclado.nextLine();

                    Aluno alunoBuscarNome = escola.buscarAluno(nomeBusca);

                    if (alunoBuscarNome != null) {
                        video.println("\nAluno encontrado: " + alunoBuscarNome.imprimir());
                    } else {
                        video.println("\nAluno não encontrado, verifique se o nome foi digitado corretamente");
                    }
                    break;

                case 3: // buscar cpf do aluno
                    video.print("\nDigite o CPF do aluno: ");
                    String cpfBusca = teclado.nextLine();

                    Aluno alunoBuscarCpf = escola.buscarAlunoCpf(cpfBusca);

                    if (alunoBuscarCpf != null) {
                        video.println("\nAluno encontrado: " + alunoBuscarCpf.imprimir());
                    } else {
                        video.println("\nAluno não encontrado, verifique se o CPF foi digitado corretamente");
                    }
                    break;

                case 4: // remover aluno
                    video.print("\nInforme o CPF do aluno que deseja remover: ");
                    String removerCpf = teclado.nextLine();

                    if (escola.removerAluno(removerCpf)) {
                        video.println("\nAluno removido");
                    } else {
                        video.print("\nNão foi possivel remover o aluno, verifique se digitou o CPf corretamente");
                    }

                    break;

                case 5: // listar aluno
                    video.println(escola.listarAluno());
                    break;

                case 6: // adicionar disciplina
                    video.print("\nInforme o nome da disciplina: ");
                    String nomeDisciplina = teclado.nextLine();

                    video.print("Digite o codigo: ");
                    String codigoDisciplina = teclado.nextLine();

                    video.print("Informe a carga horária: ");
                    int cargaHorariaDisicplina = teclado.nextInt();
                    teclado.nextLine();

                    video.print("Defina um limite maximo de alunos: ");
                    int limiteDisicplina = teclado.nextInt();
                    teclado.nextLine();

                    Disciplina nova = new Disciplina(nomeDisciplina, codigoDisciplina, cargaHorariaDisicplina,
                            limiteDisicplina);

                    if (escola.adicionarDisciplina(nova)) {
                        video.println("\nDisciplina adicionada");
                    } else {
                        video.println("\nNão foi possivel adionar a disciplina, verifique se o codigo já existe ");
                    }

                    break;

                case 7: // buscar disciplina
                    video.print("\nDigite o codigo da disciplina que deseja buscar: ");
                    String codigoBuscar = teclado.nextLine();

                    Disciplina buscarDisciplina = escola.buscarDisciplina(codigoBuscar);

                    if (buscarDisciplina != null) {
                        video.println("\nDisciplina encontrada: " + buscarDisciplina.toString());
                    } else {
                        video.println("\nDisciplina não encontrada, veifique se foi digitada corretamente.");
                    }
                    break;

                case 8: // remover disciplina
                    video.print("\nInforme o codigo da disciplina que deseja remover: ");
                    String codigoRemover = teclado.nextLine();

                    if (escola.removerDisciplina(codigoRemover)) {
                        video.println("\nDisciplina Removida");
                    } else {
                        video.println("\nNão foi possivel remover, verifique se o codigo foi escrito corretamente");
                    }
                    break;

                case 9: // listar disciplina
                    video.println(escola.listarDisciplina());
                    break;

                case 10: // matricular aluno
                    video.print("\nInforme o codigo da disciplina: ");
                    String codigoMatricula = teclado.nextLine();

                    video.print("Digite o CPF do aluno: ");
                    String cpfMatricula = teclado.nextLine();

                    if (escola.matricularAluno(codigoMatricula, cpfMatricula)) {
                        video.println("\nAluno com o cpf " + cpfMatricula + " foi matriculado na disciplina de codigo "
                                + codigoMatricula);
                    } else {
                        video.print(
                                "\nNão foi possivel matricular o aluno, verifique se o cpf e o codigo foram digitados corretamente, ou se a disicplina não está cheia");
                    }
                    break;

                case 11: // desmatricular aluno
                    video.print("\nInforme o codigo da disciplina: ");
                    String codigoDesmatricula = teclado.nextLine();

                    video.print("Digite o CPF do aluno: ");
                    String cpfDesmatricula = teclado.nextLine();

                    if (escola.desmatricularAluno(codigoDesmatricula, cpfDesmatricula)) {
                        video.println("\nAluno com o cpf " + cpfDesmatricula
                                + " foi desmatriculado da disciplina de codigo " + codigoDesmatricula);
                    } else {
                        video.print(
                                "\nNão foi possivel desmatricular o aluno, verifique se o cpf e o codigo foram digitados corretamente");
                    }

                    break;

                case 12: // listar alunos matriculados
                    video.print("\nInforme o codigo da disciplina: ");
                    String codigoListar = teclado.nextLine();

                    video.println(escola.listarAlunosMatriculados(codigoListar));
                    break;

                case 13: // adicionar professor
                    video.print("\nInforme o nome do professor: ");
                    String nomeProf = teclado.nextLine();

                    video.print("Digite o CPF do professor: ");
                    String cpfProf = teclado.nextLine();

                    video.print("Informe o email do professor: ");
                    String emailProf = teclado.nextLine();

                    video.print("Insira o salario do professor: ");
                    double salarioProf = teclado.nextDouble();
                    teclado.nextLine();

                    video.print("Informe a carga Horaria do professor (h): ");
                    double cargaHorariaProf = teclado.nextDouble();
                    teclado.nextLine();

                    Professores novoProf = new Professores(nomeProf, cpfProf, emailProf, salarioProf, cargaHorariaProf);

                    if (escola.adicionarProfessor(novoProf)) {
                        video.println("\nProfessor adicionado");
                    } else {
                        video.println(
                                "\nNão foi possível adicionar o professor, verifique se o CPF já existe ou se não há espaço.");
                    }
                    break;

                case 14: // buscar nome do professor
                    video.print("\nDigite o nome do professor: ");
                    String nomeBuscaProf = teclado.nextLine();

                    Professores profBuscarNome = escola.buscarProfessor(nomeBuscaProf);

                    if (profBuscarNome != null) {
                        video.println("\nProfessor encontrado: " + profBuscarNome.imprimir());
                    } else {
                        video.println("\nProfessor não encontrado, verifique se o nome foi digitado corretamente");
                    }
                    break;

                case 15: // buscar cpf do professor
                    video.print("\nDigite o CPf do professor: ");
                    String cpfBuscaProf = teclado.nextLine();

                    Professores profBuscarCpf = escola.buscarProfessorCpf(cpfBuscaProf);

                    if (profBuscarCpf != null) {
                        video.println("\nProfessor encontrado: " + profBuscarCpf.imprimir());
                    } else {
                        video.println("\nProfessor não encontrado, verifique se o cpf foi digitado corretamente");
                    }
                    break;

                case 16: // remover professor
                    video.print("\nInforme o CPF do professor que deseja remover: ");
                    String removerProf = teclado.nextLine();

                    if (escola.removerProfessor(removerProf)) {
                        video.println("\nProfessor removido");
                    } else {
                        video.println(
                                "\nNão foi possivel remover o professor, verifique se digitou o CPf correramente");
                    }

                    break;

                case 17: // listar professor
                    video.println(escola.listarProfessores());
                    break;

                case 18: // contar aluno
                    video.println("\nTotal de alunos: " + escola.contarAlunos());
                    break;

                case 19: // contar disciplina
                    video.println("\nTotal de disciplinas: " + escola.contarDisciplinas());
                    break;

                case 20: // contar professor
                    video.println("\nTotal de Professores: " + escola.contarProfessores());
                    break;

                case 0: // Sair do app
                    video.println("\nEncerrando o programa..");
                    break;
            }

        } while (opcao != 0);

        teclado.close();
    }
}

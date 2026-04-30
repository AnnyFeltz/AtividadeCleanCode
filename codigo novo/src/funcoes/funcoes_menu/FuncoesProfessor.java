package funcoes.funcoes_menu;

import java.io.PrintStream;
import java.util.Scanner;
import modelos.Professor;
import modelos.Escola;

public class FuncoesProfessor {

    public static String info(String mensagem){
        String string = "";
        return string += "\n" + mensagem + "\n-------------------------------------------------------------\\n\\nInforme os dados do Professor:";
    }

    public static void adicionarProfessor(PrintStream video, Scanner teclado, Escola escola) {
        info("Adicionar Professor");

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
        
        Professor novoProf = new Professor(nomeProf, cpfProf, emailProf, salarioProf, cargaHorariaProf);
        
        if (escola.adicionarProfessor(novoProf)) {
            video.println("\nProfessor adicionado");
        } else {
            video.println("\nNão foi possível adicionar o professor, verifique se o CPF já existe ou se não há espaço.");
        }
    }

    public static void buscarProfessorPorNome(PrintStream video, Scanner teclado, Escola escola) {
        info("Buscar Professor por Nome");

        video.print("\nDigite o nome do professor: ");
        String nomeBuscaProf = teclado.nextLine();
        
        Professor profBuscarNome = escola.buscarProfessor(nomeBuscaProf);
        
        if (profBuscarNome != null) {
            video.println("\nProfessor encontrado: " + profBuscarNome.imprimir());
        } else {
            video.println("\nProfessor não encontrado, verifique se o nome foi digitado corretamente");
        }
    }

    public static void buscarProfessorPorCpf(PrintStream video, Scanner teclado, Escola escola) {
        info("Buscar Professor por CPF");

        video.print("\nDigite o CPF do professor: ");
        String cpfBuscaProf = teclado.nextLine();
        
        Professor profBuscarCpf = escola.buscarProfessorCpf(cpfBuscaProf);
        
        if (profBuscarCpf != null) {
            video.println("\nProfessor encontrado: " + profBuscarCpf.imprimir());
        } else {
            video.println("\nProfessor não encontrado, verifique se o cpf foi digitado corretamente");
        }
    }

    public static void removerProfessor(PrintStream video, Scanner teclado, Escola escola) {
        info("Remover Professor");

        video.print("\nInforme o CPF do professor que deseja remover: ");
        String removerProf = teclado.nextLine();
        
        if (escola.removerProfessor(removerProf)) {
            video.println("\nProfessor removido");
        } else {
            video.println("\nNão foi possivel remover o professor, verifique se digitou o CPF correramente");
        }
    }
}

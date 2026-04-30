package funcoes.funcoes_models;
import java.util.List;
import modelos.Pessoa;

public class FuncoesPessoa {
    public static <P extends Pessoa> boolean cpfExiste(List<P> pessoas, String cpf) {
        for (P pessoa : pessoas) { 
            if (pessoa.getCpf().equals(cpf)) { return true;}
        }
        return false; 
    }

    public static <P extends Pessoa> P buscarPorCpf(List<P> pessoas, String cpf) {
        for (P pessoa : pessoas) { 
            if (pessoa.getCpf().equals(cpf)) { return pessoa;}
        }
        return null; 
    }

    public static <P extends Pessoa> P buscarPorNome(List<P> pessoas, String nome) {
        for (P pessoa : pessoas) { 
            if (pessoa.getNome().equals(nome)) { return pessoa;}
        }
        return null; 
    }
}


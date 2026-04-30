package funcoes.funcoes_models;
import java.util.List;
import modelos.Disciplina;

public class FuncoesDisciplina {
    public static boolean codigoExiste(List<Disciplina> disciplinas, String codigo) {
        for (Disciplina disciplina : disciplinas) { 
            if (disciplina.getCodigo().equals(codigo)) { return true;}
        }
        return false; 
    }

    public static Disciplina buscarPorCodigo(List<Disciplina> disciplinas, String codigo) {
        for (Disciplina disciplina : disciplinas) { 
            if (disciplina.getCodigo().equals(codigo)) { return disciplina;}
        }
        return null; 
    }

    public static Disciplina buscarPorNomeDisciplina(List<Disciplina> disciplinas, String nome) {
        for (Disciplina disciplina : disciplinas) { 
            if (disciplina.getNome().equals(nome)) { return disciplina;}
        }
        return null; 
    }
}


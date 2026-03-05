import java.util.ArrayList;
import java.util.List;

public class Escola {

    // #region atributos
    private String nome;
    private String telefone;
    private List<Aluno> grupoAlunos; // cria uma lista de obj. Aluno chamada grupoAlunos
    private List<Disciplina> listarDisciplinas;
    private List<Professores> listarProfessores;
    // #endregion

    // #region construtores
    public Escola(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
        this.grupoAlunos = new ArrayList<>(); // cria uma lista de alunos vazia e sem limitação pré-definida
        this.listarDisciplinas = new ArrayList<>(); // cria uma lista de disciplinas vazia e sem limitação pré-definida
        this.listarProfessores = new ArrayList<>(); // cria uma lista de professores vazia e sem limitaçãp pré-definida
    }
    // #endregion

    // #region metodos:

    // #region - adicionar
    // adicionar aluno
    boolean adicionarAluno(Aluno a) {
        for (Aluno aluno : grupoAlunos) { // var temporaria aluno representa o valor da lista grupoalunos ~tentando
                                          // entender o for-each~
            if (aluno.getCpf().equals(a.getCpf())) { // se cpf do valor aluno for igual cpf do a return false
                return false;
            }
        }

        for (Professores professor : listarProfessores) {
            if (professor.getCpf().equals(a.getCpf())) {
                return false;
            }
        }

        grupoAlunos.add(a);
        return true;// retorna true se não for igual o cpf
    }

    // adicionar disciplina
    boolean adicionarDisciplina(Disciplina d) {
        for (Disciplina disciplina : listarDisciplinas) { // var temporaria disciplina representa o valor da lista de
                                                          // disciplinas ~tentando entender o for-each~
            if (disciplina.getCodigo().equals(d.getCodigo())) { // se o codigo do valor disciplina for igual ao codigo
                                                                // inserido retorna false pois não queremos duas
                                                                // disciplinas com o mesmo codigo
                return false;
            }
        }
        listarDisciplinas.add(d);
        return true; // retorna true se não for igual o codigo
    }

    boolean adicionarProfessor(Professores p) {
        for (Professores professor : listarProfessores) {
            if (professor.getCpf().equals(p.getCpf())) {
                return false;
            }
        }

        for (Aluno aluno : grupoAlunos) {
            if (aluno.getCpf().equals(p.getCpf())) {
                return false;
            }
        }
        
        listarProfessores.add(p);
        return true;
    }

    // matricular aluno na disciplina
    boolean matricularAluno(String codigo, String cpf) {
        Aluno aluno = null; // criando 'capsula' aluno para armazenar informações
        for (Aluno a : grupoAlunos) {
            if (a.getCpf().equals(cpf)) {// se o cpf do a for igual o cpf inserido
                aluno = a; // aluno armazena a
            }
        }

        if (aluno == null) { // se não achou nenhum aluno com o cpf e continuou nullo
            return false; // retorna false
        }

        Disciplina disciplina = null; // mesma logica aqui
        for (Disciplina d : listarDisciplinas) {
            if (d.getCodigo().equals(codigo)) {
                disciplina = d;
            }
        }

        if (disciplina == null) {
            return false;
        }

        return disciplina.matricularAluno(aluno); // se conseguiu achar o cpf e a disciplina chama o metodo matricular
                                                  // do objeto disciplina e retorna se matriculou o objeto aluno.
    }
    // #endregion

    // #region - buscar

    // buscar aluno nome
    Aluno buscarAluno(String nome) {
        for (Aluno aluno : grupoAlunos) { // var temporaria aluno representa o valor da lista grupoalunos ~tentando entender o for-each~
            if (aluno.getNome().equals(nome)) { // se o nome do valor aluno for igual o nome inserido retorna o valor aluno
                return aluno;
            }
        }
        return null; // se não achar retorna nada
    }

    // buscar aluno cpf
    Aluno buscarAlunoCpf(String cpf) {
        for (Aluno aluno : grupoAlunos) { // var temporaria aluno representa o valor da lista grupoalunos ~tentando entender o for-each~
            if (aluno.getCpf().equals(cpf)) { // se o cpf do valor aluno for igual o cpf inserido retorna o valor aluno
                return aluno;
            }
        }
        return null; // se não achar retorna nada
    }

    // buscar disciplina
    Disciplina buscarDisciplina(String codigo) {
        for (Disciplina disciplina : listarDisciplinas) { // var temporaria disciplina representa o valor da lista de disciplinas ~tentando entender o for-each~
            if (disciplina.getCodigo().equals(codigo)) { // se o codigo do valor disciplina for igual ao codigo inserido retorna o valor disciplina
                return disciplina;
            }
        }

        return null; // se não achar retorna null
    }

    Professores buscarProfessor(String nome) {
        for (Professores professor : listarProfessores) { // var temporaria professor representa o valor da lista de professores ~tentando entender o for-each~
            if (professor.getNome().equals(nome)) { // se o nome do valor professor for igual o nome inserido retorna o valor professor
                return professor;
            }
        }
        return null; // se não achar retorna nada
    }

    // buscar professor cpf
    Professores buscarProfessorCpf(String cpf) {
        for (Professores professor : listarProfessores) { // var temporaria professor representa o valor da lista de professor ~tentando entender o for-each~
            if (professor.getCpf().equals(cpf)) { // se o nome do valor professor for igual o nome inserido retorna o valor professor
                return professor;
            }
        }
        return null; // se não achar retorna nada
    }
    // #endregion

    // #region - remover

    // remover aluno
    boolean removerAluno(String cpf) {
        for (Aluno aluno : grupoAlunos) { // var temporaria aluno representa o valor da lista grupoalunos ~tentando entender o for-each~
            if (aluno.getCpf().equals(cpf)) { // se o cpf do valor aluno for igual o cpf inserido remove o valor aluno e retorna true
                grupoAlunos.remove(aluno); // removendo o valor aluno da lista grupoAlunos
                return true;
            }
        }
        return false; // se não conseguir remover retorna falso
    }

    // remover disciplina
    boolean removerDisciplina(String codigo) {
        for (Disciplina disciplina : listarDisciplinas) {
            if (disciplina.getCodigo().equals(codigo)) {
                listarDisciplinas.remove(disciplina);
                return true;
            }
        }
        return false;
    }

    // desmatricular aluno da disciplina
    boolean desmatricularAluno(String codigo, String cpf) {
        Disciplina disciplina = null; // capsula pra armazenamento
        for (Disciplina d : listarDisciplinas) { // percorrer lista de disciplinas
            if (d.getCodigo().equals(codigo)) { // se tiver uma lista com o codigo inserido
                disciplina = d; // armazenar informação
            }
        }

        if (disciplina == null) {
            return false;
        }

        return disciplina.desmatricularAluno(cpf);
    }

    boolean removerProfessor(String cpf) {
        for (Professores professor : listarProfessores) { // var temporaria professor representa o valor da lista listarProfessores ~tentando
            // entender o for-each~
            if (professor.getCpf().equals(cpf)) { // se o cpf do valor professor for igual o cpf inserido remove o valor professor e retorna true
                listarProfessores.remove(professor); // removendo o valor professor da lista listarProfessores
                return true;
            }
        }
        return false; // se não conseguir remover retorna falso
    }
    // #endregion

    // #region - contar
    public int contarAlunos() {
        int a = 0; // inteiro pra saber a quantidade

        for (Aluno aluno : grupoAlunos) { // percorre a lista de alunos
            if (aluno.getCpf() != null && !aluno.getCpf().isEmpty()) { // verifica se o cpf não é nulo ou esta vazio, pq por algum motivo nulo parece ser um valor
                a++; // soma 1 na quantidade
            }
        }

        return a; // retorna a quantidade
    }

    public int contarDisciplinas() {
        int d = 0; // inteiro pra saber a quantidade

        for (Disciplina disciplina : listarDisciplinas) { // percorre a lista de disciplinas
            if (disciplina.getCodigo() != null && !disciplina.getCodigo().isEmpty()) { // verifica se o cpf não é nulo ou esta vazio, pq por algum motivo nulo parece ser um valor
                d++; // soma 1 na quantidade
            }
        }

        return d; // retorna a quantidade
    }

    public int contarProfessores() {
        int p = 0; // inteiro pra saber a quantidade

        for (Professores professor : listarProfessores) { // percorre a lista de professores
            if (professor.getCpf() != null && !professor.getCpf().isEmpty()) { // verifica se o cpf não é nulo ou esta vazio, pq por algum motivo nulo parece ser um valor
                p++; // soma 1 na quantidade
            }
        }

        return p; // retorna a quantidade
    }
    // #endregion

    // #endregion

    // #region toString
    @Override

    public String toString() {
        String str = "\n\n\tNome: " + nome +
                "\n\tTelefone: " + telefone;

        return str;
    }

    // listar aluno
    public String listarAluno() {
        String str = "";

        for (Aluno aluno : grupoAlunos) {
            if (aluno.getCpf() != null) {
                str += aluno.imprimir();
            }
        }
        return str;
    }

    // listar disciplina
    public String listarDisciplina() {
        String str = "";

        for (Disciplina disciplina : listarDisciplinas) {
            if (disciplina.getCodigo() != null) {
                str += disciplina.toString();
            }
        }

        return str;
    }

    // listar professores
    public String listarProfessores() {
        String str = "";

        for (Professores professor : listarProfessores) {
            str += professor.imprimir();
        }

        return str;
    }

    // listar alunos matriculados na disciplina tal
    public String listarAlunosMatriculados(String codigo) {
        for (Disciplina disciplina : listarDisciplinas) {
            if (disciplina.getCodigo().equals(codigo)) {
                return disciplina.listarAlunos();
            }
        }

        return "Disciplina não encontrada";
    }
    // #endregion
}

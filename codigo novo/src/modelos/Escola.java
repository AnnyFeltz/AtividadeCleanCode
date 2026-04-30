package modelos;
import java.util.ArrayList;
import java.util.List;

import funcoes.funcoes_models.FuncoesDisciplina;
import funcoes.funcoes_models.FuncoesPessoa;

public class Escola {
    private String nome;
    private String telefone;
    private List<Aluno> alunos;
    private List<Disciplina> disciplinas;
    private List<Professor> professores;

    public Escola(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
        this.alunos = new ArrayList<>(); 
        this.disciplinas = new ArrayList<>(); 
        this.professores = new ArrayList<>();
    }

    public boolean adicionarAluno(Aluno a) {
        if (FuncoesPessoa.cpfExiste(alunos, a.getCpf())) { return false; }
        if (FuncoesPessoa.cpfExiste(professores, a.getCpf())) { return false; }

        alunos.add(a);
        return true;
    }

    public boolean adicionarDisciplina(Disciplina d) {
        if (FuncoesDisciplina.codigoExiste(disciplinas, d.getCodigo())) { return false; }
    
        disciplinas.add(d);
        return true; 
    }

    public boolean adicionarProfessor(Professor p) {
        if (FuncoesPessoa.cpfExiste(professores, p.getCpf())) { return false; }
        if (FuncoesPessoa.cpfExiste(alunos, p.getCpf())) { return false; }
        
        professores.add(p);
        return true;
    }

    public boolean matricularAluno(String codigo, String cpf) {
        Aluno aluno = FuncoesPessoa.buscarPorCpf(alunos, cpf);
        if (aluno == null) { return false; }

        Disciplina disciplina = FuncoesDisciplina.buscarPorCodigo(disciplinas, codigo);
        if (disciplina == null) { return false; }

        return disciplina.matricularAluno(aluno); 
    }

    public Aluno buscarAluno(String nome) {
        return FuncoesPessoa.buscarPorNome(alunos, nome);
    }

    public Aluno buscarAlunoCpf(String cpf) {
        return FuncoesPessoa.buscarPorCpf(alunos, cpf);
    }

    public Disciplina buscarDisciplina(String codigo) {
        return FuncoesDisciplina.buscarPorCodigo(disciplinas, codigo);
    }

    public Professor buscarProfessor(String nome) {
        return FuncoesPessoa.buscarPorNome(professores, nome);
    }

    public Professor buscarProfessorCpf(String cpf) {
        return FuncoesPessoa.buscarPorCpf(professores, cpf);
    }

    public boolean removerAluno(String cpf) {
        Aluno aluno = FuncoesPessoa.buscarPorCpf(alunos, cpf);
        if (aluno == null) { return false; }

        alunos.remove(aluno);
        return true;
    }

    public boolean removerDisciplina(String codigo) {
        Disciplina disciplina = FuncoesDisciplina.buscarPorCodigo(disciplinas, codigo);
        if (disciplina == null) { return false; }

        disciplinas.remove(disciplina);
        return true;
    }

    public boolean desmatricularAluno(String codigo, String cpf) {
        Disciplina disciplina = FuncoesDisciplina.buscarPorCodigo(disciplinas, codigo);
        if (disciplina == null) { return false; }

        return disciplina.desmatricularAluno(cpf);
    }

    public boolean removerProfessor(String cpf) {
        Professor professor = FuncoesPessoa.buscarPorCpf(professores, cpf);
        if (professor == null) { return false; }

        professores.remove(professor);
        return true;
    }

    public int contarAlunos() {
        return alunos.size();
    }

    public int contarDisciplinas() {
        return disciplinas.size();
    }

    public int contarProfessores() {
        return professores.size(); 
    }

    @Override
    public String toString() {
        return "\n\n\tNome: " + nome + "\n\tTelefone: " + telefone;
    }

    public String listarAlunos() {
        StringBuilder str = new StringBuilder();

        for (Aluno aluno : alunos) { str.append(aluno.imprimir()); }

        return str.toString();
    }

    public String listarDisciplinas() {
        StringBuilder str = new StringBuilder();

        for (Disciplina disciplina : disciplinas) { str.append(disciplina); }

        return str.toString();
    }

    public String listarProfessores() {
        StringBuilder str = new StringBuilder();

        for (Professor professor : professores) { str.append(professor.imprimir()); }
        
        return str.toString();
    }

    public String listarAlunosMatriculados(String codigo) {
        Disciplina disciplina = FuncoesDisciplina.buscarPorCodigo(disciplinas, codigo);
        if (disciplina == null) { return "Disciplina não encontrada."; }

        return disciplina.listarAlunos();
    }
}

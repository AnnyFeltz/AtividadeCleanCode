    package modelos;
    import java.util.ArrayList;
    import java.util.List;

import funcoes.funcoes_models.FuncoesPessoa;

    public class Disciplina {
        private String nome;
        private String codigo;
        private int cargaHoraria;
        private int limiteAlunos;

        private final List<Aluno> alunosMatriculados;

        public Disciplina (String nome, String codigo, int cargaHoraria, int limiteAlunos) {
            this.nome = nome;
            setCodigo(codigo);
            this.cargaHoraria = cargaHoraria;
            this.limiteAlunos = limiteAlunos;
            this.alunosMatriculados = new ArrayList<>();
        }

        boolean matricularAluno(Aluno a) {
            if(alunosMatriculados.size() >= limiteAlunos) { return false; }

            if(FuncoesPessoa.cpfExiste(alunosMatriculados, a.getCpf())) { return false; }

            alunosMatriculados.add(a);
            return true;
        }

        boolean desmatricularAluno(String cpf) {
            return alunosMatriculados.removeIf(aluno -> aluno.getCpf().equals(cpf));
        }

        public String listarAlunos() {
            StringBuilder str = new StringBuilder();

            for (Aluno aluno : alunosMatriculados) { str.append(aluno.imprimir()); }

            return str.toString();
        }

        @Override
        public String toString() {
            String str = "\n\n\tNome: " + this.getNome()
                        + "\n\tCodigo: " + this.getCodigo()
                        + "\n\tCarga Horária: " + this.getCargaHoraria()
                        + "\n\tQuantidade de vagas: " + this.getLimiteAlunos();
            return str;
        }
        
        public String getNome() { return nome; }

        public void setNome(String nome) { this.nome = nome; }

        public String getCodigo() { return codigo; }

        public void setCodigo(String codigo) { 
            if (codigo == null || codigo.isEmpty()) { 
                throw new IllegalArgumentException("O código da disciplina não pode ser nulo ou vazio.");
            }
            this.codigo = codigo; 
        }

        public int getCargaHoraria() { return cargaHoraria; }

        public void setCargaHoraria(int cargaHoraria) { this.cargaHoraria = cargaHoraria; }

        public int getLimiteAlunos() { return limiteAlunos; }

        public void setLimiteAlunos(int limiteAlunos) { this.limiteAlunos = limiteAlunos; }
    }

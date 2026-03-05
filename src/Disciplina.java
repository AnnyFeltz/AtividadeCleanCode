import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    //#region atributos
    private String nome;
    private String codigo;
    private int cargaHoraria;
    private int limiteAlunos;

    private List<Aluno> alunosMatriculados; //List = lista; <objeto> = o tipo de lista que eu quero, ex: uma lista de objetos, e fora o nome da lista
    //#endregion

    //#region contrutores

    public Disciplina (String nome, String codigo, int cargaHoraria, int limiteAlunos) {
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
        this.limiteAlunos = limiteAlunos;
        this.alunosMatriculados = new ArrayList<>();
    }
    //#endregion

    //#region metodo
    boolean matricularAluno(Aluno a){
        if(alunosMatriculados.size() >= limiteAlunos){ //se o tamanho da lista ultrapassar o valor do limiteAlunos
            return false; //retorna falso
        }

        for(Aluno aluno : alunosMatriculados){ // objeto nome - busca - nome da lista = for(Objeto nome : lista){}
            if(aluno.getCpf().equals(a.getCpf())){
                return false;
            }
        }
        alunosMatriculados.add(a); // adiciona o aluno
        return true;
    }

    //desmatriular alunos
    boolean desmatricularAluno(String cpf){
        for(Aluno aluno : alunosMatriculados){
            if(aluno.getCpf().equals(cpf)){
                alunosMatriculados.remove(aluno);
                return true;
            }
        }
        return false;
    }
    //#endregion

    //#region toString

    //listar alunos matriculados
    public String listarAlunos() {
        String str = "";
        
        for(Aluno aluno : alunosMatriculados){
            if(aluno.getCpf() != null){
                str += aluno.imprimir();
            }
        }

        return str;
    }

    @Override

    public String toString() {
        String str = "\n\n\tNome: " + this.getNome()
                    + "\n\tCodigo: " + this.getCodigo()
                    + "\n\tCarga Horária: " + this.getCargaHoraria()
                    + "\n\tQuantidade de vagas: " + this.getLimiteAlunos();

        return str;
    }
    //#endregion

    //#region getters & setters
    
    //nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //codigo

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    //carga horaria
    public int getCargaHoraria(){
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria){
        this.cargaHoraria = cargaHoraria;
    }

    //Quantidade
    public int getLimiteAlunos() {
        return limiteAlunos;
    }

    public void setLimiteAlunos(int limiteAlunos) {
        this.limiteAlunos = limiteAlunos;
    }
    
    //#endregion
}

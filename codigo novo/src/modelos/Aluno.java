package modelos;
public class Aluno extends Pessoa {

    private int anoNascimento;

    public Aluno(String nome, String cpf, String email, int anoNascimento) {
        super(nome, cpf, email);
        this.anoNascimento = anoNascimento;
    }

    @Override 
    public String imprimir() {
        String str = super.imprimir() + "\n\tAno de Nascimeto: " + this.getAnoNascimento();
        return str;
    }
        
    public int getAnoNascimento() { return anoNascimento; }

    public void setAnoNascimento(int anoNascimento) { this.anoNascimento = anoNascimento; }
}

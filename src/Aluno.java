public class Aluno extends Pessoa{

    //#region atributos
    private int anoNascimento;
    //#endregion

    //#region construtores
    public Aluno(String nome, String cpf, String email, int anoNascimento) {
        super(nome, cpf, email);
        this.anoNascimento = anoNascimento;
    }
    //#endregion

    //#region tostring

    @Override

    public String imprimir() {
        String str = super.imprimir() +
                    "\n\tAno de Nascimeto: " + this.getAnoNascimento();

        return str;
    }
    //#endregion

    //#region Getters & Setters

    // ANO de NASCIMENTO
    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }
    //#endregion
}

public class Pessoa {
    //#region atributos
    protected String nome;
    protected String cpf;
    protected String email;
    //#endregion

    //#region construtores
    public Pessoa(String nome, String cpf, String email){
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }
    //#endregion

    //#region getters and setters

    //nome 
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //cpf
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    //email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //#endregion

    //#region toString
    public String imprimir(){
        String str = "\n\n\tNome: " + nome +
                     "\n\tCpf: " + cpf +
                     "\n\tEmail: " + email;

        return str;
    }
    //#endregion
}

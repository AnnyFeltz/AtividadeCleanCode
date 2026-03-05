public class Professores extends Pessoa{
    //#region atributos
    private double salario;
    private double cargaHoraria;
    //#endregion

    //#region construtores 
    public Professores(String nome, String cpf, String email, double salario, double cargaHoraria){
        super(nome, cpf, email);
        this.salario = salario;
        this.cargaHoraria = cargaHoraria;
    }
    //#endregion

    //#region getters and setters

    //salario
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    //carga horaria
    public double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    //#endregion

    //#region toString

    @Override
    
    public String imprimir(){
        String str = super.imprimir() +
                    "\n\tSalario: " + this.salario +
                    "\n\tCarga Horaria: " + this.cargaHoraria;

        return str;
    }
    //#endregion
}

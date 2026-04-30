package modelos;
public class Professor extends Pessoa{
    private double salario;
    private double cargaHoraria;

    public Professor(String nome, String cpf, String email, double salario, double cargaHoraria){
        super(nome, cpf, email);
        this.salario = salario;
        this.cargaHoraria = cargaHoraria;
    }

    public double getSalario() { return salario; }

    public void setSalario(double salario) { this.salario = salario; }

    public double getCargaHoraria() { return cargaHoraria; }

    public void setCargaHoraria(double cargaHoraria) { this.cargaHoraria = cargaHoraria; }

    @Override
    public String imprimir() {
        String str = super.imprimir() +
                    "\n\tSalario: " + this.salario +
                    "\n\tCarga Horaria: " + this.cargaHoraria;
        return str;
    }
}

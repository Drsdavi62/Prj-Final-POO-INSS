package br.gov.sp.fatec.prjfinal;

public class Empregado {

    private int codigoEmpregado;
    private String nomeEmpregado;
    private String setor;
    private double salarioBruto;
    private double recINSS;
    public static int totalEmpregados = 0;

    public Empregado(int codigoEmpregado, String nomeEmpregado, String setor, double salarioBruto) {
        this.codigoEmpregado = codigoEmpregado;
        this.nomeEmpregado = nomeEmpregado;
        this.setor = setor;
        this.salarioBruto = salarioBruto;
    }

    public int getCodigoEmpregado() {
        return codigoEmpregado;
    }

    public void setCodigoEmpregado(int codigoEmpregado) {
        this.codigoEmpregado = codigoEmpregado;
    }

    public String getNomeEmpregado() {
        return nomeEmpregado;
    }

    public void setNomeEmpregado(String nomeEmpregado) {
        this.nomeEmpregado = nomeEmpregado;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public double getRecINSS() {
        return recINSS;
    }

    public void setRecINSS(double recINSS) {
        this.recINSS = recINSS;
    }

    public static void incrementarTotal() {
        totalEmpregados++;
    }
}

package br.gov.sp.fatec.prjfinal.model;

public class ParametroINSS {
    public static final double FAIXA1 = 0.075;
    public static final double LIMITEFAIXA1 = 1100.0;
    public static final double FAIXA2 = 0.09;
    public static final double LIMITEFAIXA2 = 2203.48;
    public static final double FAIXA3 = 0.12;
    public static final double LIMITEFAIXA3 = 3305.22;
    public static final double FAIXA4 = 0.14;
    public static final double LIMITEFAIXA4 = 6433.57;
    private static double[] limites = {LIMITEFAIXA1, LIMITEFAIXA2, LIMITEFAIXA3, LIMITEFAIXA4};
    private static double[] faixas = {FAIXA1, FAIXA2, FAIXA3, FAIXA4};

    public static double calcularINSS(double salarioBruto) {
        int i = 0;
        double valorINSS = 0.0d;
        if (salarioBruto <= LIMITEFAIXA1) {
            return 82.50d;
        }
        while (i < limites.length && salarioBruto >= limites[i]) {
            double atual;
            if (i == 0) {
                atual = limites[i] * faixas[i];
            } else {
                atual = (limites[i] - limites[i - 1]) * faixas[i];
            }
            valorINSS += atual;
            i++;
        }
        double atual = 0;
        if (salarioBruto <= LIMITEFAIXA4) {
            atual = (salarioBruto - limites[i - 1]) * faixas[i < faixas.length ? i : faixas.length - 1];
        }
        valorINSS += atual;
        return valorINSS;
    }
}

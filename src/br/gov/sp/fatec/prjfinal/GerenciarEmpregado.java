package br.gov.sp.fatec.prjfinal;

import java.util.ArrayList;
import java.util.List;

public class GerenciarEmpregado {
    private List<Empregado> listaEmpregado = new ArrayList<>();

    public void adicionarEmpregado(Empregado empregado) {
        listaEmpregado.add(empregado);
    }

    public List<Empregado> listaDeEmpregados() {
        return listaEmpregado;
    }

    public void removerEmpregado(Empregado empregado) {
        listaEmpregado.remove(empregado);
    }

    public boolean verificarExistencia(Empregado empregado) {
        return listaEmpregado.contains(empregado);
    }
}

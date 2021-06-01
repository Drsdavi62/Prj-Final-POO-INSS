package br.gov.sp.fatec.prjfinal;

import javax.swing.*;

public class GerenciarPrograma {

    public static void main(String[] args) {
        JFrame empregadoFrame = new JFrame();
        empregadoFrame.setContentPane(new EmpregadoGUI().getPanelEmpregado());
        empregadoFrame.setSize(500, 500);
        empregadoFrame.setLocationRelativeTo(null);
        empregadoFrame.setTitle("Cadastro de Empregados");
        empregadoFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        empregadoFrame.setVisible(true);
    }
}

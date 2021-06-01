package br.gov.sp.fatec.prjfinal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class GerenciarEmpregadosGUI {
    private JTable jTableEmpregados;
    private JPanel panel;
    private JScrollPane scrollPane;
    private DefaultTableModel modelo = new DefaultTableModel();

    public GerenciarEmpregadosGUI(List<Empregado> empregados) {
        modelo.addColumn("Codigo");
        modelo.addColumn("Nome");
        modelo.addColumn("Setor");
        modelo.addColumn("Salario");
        modelo.addColumn("Recolhimento");

        for (Empregado empregado : empregados) {
            modelo.addRow(new Object[]{empregado.getCodigoEmpregado(),
                    empregado.getNomeEmpregado(),
                    empregado.getSetor(),
                    "R$" + empregado.getSalarioBruto(),
                    "R$" + String.format("%.2f", empregado.getRecINSS())});
        }

        jTableEmpregados.setModel(modelo);
    }

    public JPanel getPanel() {
        return panel;
    }
}

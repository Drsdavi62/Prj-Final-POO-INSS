package br.gov.sp.fatec.prjfinal.view;

import br.gov.sp.fatec.prjfinal.model.GerenciarEmpregado;
import br.gov.sp.fatec.prjfinal.model.ParametroINSS;
import br.gov.sp.fatec.prjfinal.model.Empregado;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EmpregadoGUI {
    private JButton buttonApresentar;
    private JButton buttonCadastrar;
    private JTextField textCodigoEmpregado;
    private JTextField textNomeEmpregado;
    private JTextField textSetor;
    private JTextField textSalario;
    private JButton buttonCalcular;
    private JLabel labelCodigoEmpregado;
    private JLabel labelNomeEmpregado;
    private JLabel labelSetor;
    private JLabel labelSalarioBruto;
    private JPanel panelEmpregado;
    private JLabel labelRecolhimento;
    private JLabel labelValorCalculado;
    private JLabel labelTotal;
    private JLabel labelTotalNumero;
    private GerenciarEmpregado gerenciarEmpregado = new GerenciarEmpregado();
    private double valorCalculado = -1;

    public EmpregadoGUI() {
        panelEmpregado.setBorder(new EmptyBorder(0, 10, 10, 10));
        labelTotalNumero.setText(String.valueOf(Empregado.totalEmpregados));

        buttonCadastrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (valorCalculado == -1) {
                    JOptionPane.showMessageDialog(panelEmpregado, "Calcule o valor do INSS antes de cadastrar");
                    return;
                }

                Empregado empregado = new Empregado(
                        Integer.parseInt(textCodigoEmpregado.getText()),
                        textNomeEmpregado.getText(),
                        textSetor.getText(),
                        Double.parseDouble(textSalario.getText()));

                empregado.setRecINSS(valorCalculado);
                gerenciarEmpregado.adicionarEmpregado(empregado);

                JOptionPane.showMessageDialog(panelEmpregado, "Empregado cadastrado com sucesso");
                Empregado.incrementarTotal();
                labelTotalNumero.setText(String.valueOf(Empregado.totalEmpregados));
                textCodigoEmpregado.setText("");
                textNomeEmpregado.setText("");
                textSetor.setText("");
                textSalario.setText("");
                labelValorCalculado.setText("");
            }
        });
        buttonCalcular.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (textSalario.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(panelEmpregado, "Insira um salário bruto");
                    return;
                }
                valorCalculado = ParametroINSS.calcularINSS(Double.parseDouble(textSalario.getText()));
                labelValorCalculado.setText("R$" + String.format("%.2f", valorCalculado));
            }
        });
        buttonApresentar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame empregadoFrame = new JFrame();
                empregadoFrame.setContentPane(new GerenciarEmpregadosGUI(gerenciarEmpregado.listaDeEmpregados()).getPanel());
                empregadoFrame.setSize(500, 500);
                empregadoFrame.setLocationRelativeTo(null);
                empregadoFrame.setTitle("Gerenciar Empregados");
                empregadoFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                empregadoFrame.setVisible(true);
            }
        });
    }

    public JPanel getPanelEmpregado() {
        return panelEmpregado;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

package com.vigjoaopaulo.laboratorio.exames;

import com.vigjoaopaulo.laboratorio.model.Paciente;
import javax.swing.JOptionPane;

/**
 *
 * @author vigjo
 */
public final class Colesterol extends Exames {

    private double ldl;
    private double hdl;
    private char risco;

    public Colesterol() {
    }

    public Colesterol(Paciente paciente, double hdl, double ldl, char risco) {
        super(paciente);
        this.hdl = hdl;
        this.ldl = ldl;
        this.risco = risco;
       

    }

    public double getLdl() {
        return ldl;
    }

    public void setLdl(double ldl) {
        this.ldl = ldl;
    }

    public double getHdl() {
        return hdl;
    }

    public void setHdl(double hdl) {
        this.hdl = hdl;
    }

    public char getRisco() {
        return risco;
    }

    public void setRisco(char risco) {
        this.risco = risco;
    }

   
    public void mostrarResultado() {
        JOptionPane.showMessageDialog(null,
                "Nome: " + getPaciente().getNome()
                + "\n" + "HDL: " + String.format("%.2f", getHdl()).replace(",", ".")
                + "\n" + "LDL: " + String.format("%.2f", getLdl()).replace(",", ".")
                + "\n" + "Risco: " + verificaRisco(getRisco()) + "\n" + "Classificação: " + classificarColesterol(),
                "Resultado do colesterol", JOptionPane.INFORMATION_MESSAGE);

    }

    String verificaRisco(char risco) {
        String resultado;

        if (risco == 'B' || risco == 'b') {
            resultado = "Risco baixo";
        } else if (risco == 'M' || risco == 'm') {
            resultado = "Risco médio";
        } else if (risco == 'A' || risco == 'a') {
            resultado = "Risco alto";
        } else {
            resultado = "Risco desconhecido";
        }
        return resultado;
    }

    public String classificarColesterol() {
        String hdlClassificacao = "";
        String ldlClassificacao = "";
        if (getPaciente().calcularIdade() <= 19 && getHdl() > 45 || getPaciente().calcularIdade() > 20 && getHdl() > 40) {

            hdlClassificacao = "HDL - BOM";

        } else {

            hdlClassificacao = "HDL - RUIM";
        }

        if (getRisco() == 'B' || getRisco() == 'b' && getLdl() < 100) {

            ldlClassificacao = "LDL - BOM";

        } else if (getRisco() == 'M' || getRisco() == 'm' && getLdl() < 70) {

            ldlClassificacao = "LDL - BOM";

        } else if (getRisco() == 'A' || getRisco() == 'a' && getLdl() < 50) {

            ldlClassificacao = "LDL - BOM";

        } else {
            ldlClassificacao = "LDL - RUIM";
        }
        return hdlClassificacao + " / " + ldlClassificacao;
    }

    @Override
    public void cadastrarExame() {
        super.cadastrarExame();
        
        boolean hdlValido = false;
        String _hdl = null;
        String _ldl = null;
        while (!hdlValido) {
            _hdl = JOptionPane.showInputDialog("Insira qtd HDL:");
            hdl = Integer.parseInt(_hdl);
            if (_hdl.isEmpty()) {
                JOptionPane.showMessageDialog(null, "O campo HDL está vazio. Por favor, insira uma quantidade de HDL.");
            } else {
                hdlValido = true;
                for (int i = 0; i < _hdl.length(); i++) {
                    if (Character.isLetter(_hdl.charAt(i))) {
                        hdlValido = false;
                        JOptionPane.showMessageDialog(null,
                                "O campo HDL contém letras. Por favor, insira apenas números.");
                        break;
                    }
                }
            }
        }

        boolean ldlValido = false;
        while (!ldlValido) {
            _ldl = JOptionPane.showInputDialog("Insira qtd LDL:");
            ldl = Integer.parseInt(_ldl);
            if (_ldl.isEmpty()) {
                JOptionPane.showMessageDialog(null, "O campo LDL está vazio. Por favor, insira uma quantidade de LDL.");
            } else {
                ldlValido = true;
                for (int i = 0; i < _ldl.length(); i++) {
                    if (Character.isLetter(_ldl.charAt(i))) {
                        ldlValido = false;
                        JOptionPane.showMessageDialog(null,
                                "O campo LDL contém letras. Por favor, insira apenas números.");
                        break;
                    }
                }
            }
        }

        boolean riskValido = false;
        String risk = null;
        while (!riskValido) {
            risk = JOptionPane.showInputDialog(null, "Insira [ B - baixo,  M - medio ,  A - alto ]",
                    "Informe grau de risco...", JOptionPane.QUESTION_MESSAGE);

            risco = risco = risk.charAt(0);
            if (risk.length() != 1) {
                JOptionPane.showMessageDialog(null,
                        "O campo risco deve conter apenas um caractere. Por favor, insira apenas um caractere.");
            } else if (!Character.isLetter(risk.charAt(0))) {
                JOptionPane.showMessageDialog(null,
                        "O campo risco contém um número. Por favor, insira apenas uma letra.");
            } else if (Character.toUpperCase(risk.charAt(0)) != 'B' && Character.toUpperCase(risk.charAt(0)) != 'M'
                    && Character.toUpperCase(risk.charAt(0)) != 'A') {
                JOptionPane.showMessageDialog(null,
                        "O valor inserido é inválido. Por favor, \nInsira [ B - baixo,  M - medio ,  A - alto ].");
            } else {
                riskValido = true;
            }
        }

        setHdl(hdl);
        setLdl(ldl);
        setRisco(risco);
        
        mostrarResultado();

    }

}

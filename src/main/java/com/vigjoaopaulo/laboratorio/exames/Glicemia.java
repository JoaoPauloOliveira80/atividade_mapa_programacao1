package com.vigjoaopaulo.laboratorio.exames;

import com.vigjoaopaulo.laboratorio.model.Paciente;
import javax.swing.JOptionPane;

/**
 *
 * @author João Paulo de Oliveira
 */
public final class Glicemia extends Exames {

    private double glicemiaMgl;

    public Glicemia() {
    }

    public Glicemia(Paciente paciente, double glicemiaMgl) {
        super(paciente);
        this.glicemiaMgl = glicemiaMgl;

    }

    public double getGlicemiaMgl() {
        return glicemiaMgl;
    }

    public void setGlicemiaMgl(double glicemiaMgl) {
        this.glicemiaMgl = glicemiaMgl;
    }

    @Override
    public void mostrarResultado() {
        JOptionPane.showMessageDialog(null,
                "Nome: " + getPaciente().getNome()
                + "\n" + "Resultado: " + String.format("%.2f", getGlicemiaMgl()).replace(",", ".")
                + "\n" + "Classificação: " + classificarGlicemia(),
                "Resultado da Glicemia", JOptionPane.INFORMATION_MESSAGE);

    }

    public String classificarGlicemia() {
        String result = "";
        if (getGlicemiaMgl() < 100) {
            result = "Normoglicemia";
        } else if (getGlicemiaMgl() >= 100 && getGlicemiaMgl() < 126) {
            result = "Pré-diabetes";
        } else if (getGlicemiaMgl() >= 126) {
            result = "Diabetes estabelecido";
        }

        return result;
    }

    @Override
    public void cadastrarGlicemia() {

        String glicemia = null;
        boolean glicemiaValida = false;
        while (!glicemiaValida) {
            glicemia = JOptionPane.showInputDialog("Insira qtd Glicemia:");
            if (glicemia == null) {
                // O usuário clicou no botão "Cancelar" ou fechou a caixa de diálogo
                return;
            } else if (glicemia.isEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "O campo glicemia está vazio. Por favor, insira uma quantidade de glicemia.");
            } else if (!glicemia.matches("\\d+")) {
                JOptionPane.showMessageDialog(null,
                        "O campo qtd glicemia contém caracteres inválidos. Por favor, insira apenas números.");
            } else {
                glicemiaValida = true;
                for (int i = 0; i < glicemia.length(); i++) {
                    if (Character.isLetter(glicemia.charAt(i))) {
                        glicemiaValida = false;
                        JOptionPane.showMessageDialog(null,
                                "O campo glicemia contém letras. Por favor, insira apenas números.");
                        break;
                    }
                }
            }
        }

        // Set the value of glicemiaMgl to the entered blood glucose level
        setGlicemiaMgl(Double.parseDouble(glicemia));

        mostrarResultado();
    }

    @Override
    public void cadastrarColesterol() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void cadastrarTrigliceres() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

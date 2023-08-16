package com.vigjoaopaulo.laboratorio.exames;

import com.vigjoaopaulo.laboratorio.model.Paciente;
import javax.swing.JOptionPane;

/**
 *
 * @author vigjo
 */
public final class Triglicerideos extends Exames {

    private double triglicerideoMgl;
    private String jejum;
    private boolean emJejum = false;

    public Triglicerideos(String jejum, Paciente paciente, double triglicerideoMgl) {
        super(paciente);
        this.jejum = jejum;
        this.triglicerideoMgl = triglicerideoMgl;
        
    }

    public double getTriglicerideoMgl() {
        return triglicerideoMgl;
    }

    public void setTriglicerideoMgl(double triglicerideoMgl) {
        this.triglicerideoMgl = triglicerideoMgl;
    }

    public String getJejum() {
        return jejum;
    }

    public void setJejum(String jejum) {
        this.jejum = jejum;
    }

    public boolean isEmJejum() {
        return emJejum;
    }

    public void setEmJejum(boolean emJejum) {
        this.emJejum = emJejum;
    }

    @Override
    public void mostrarResultado() {
        JOptionPane.showMessageDialog(null,
                "Nome: " + getPaciente().getNome() + "\n" + "Triglicerideos: " + String.format("%.2f", getTriglicerideoMgl()) + "\n"
                + "Classificação: " + classificarTriglicerideos(),
                "Resultado do Trigliceres", JOptionPane.INFORMATION_MESSAGE);
    }

    public String classificarTriglicerideos() {
        String classificacao = "";

        int idade = getPaciente().calcularIdade();

        if (idade >= 1 && idade <= 9 && triglicerideoMgl < 75) {
            classificacao = "Triglicerídeos bom";
        } else if (idade >= 10 && idade <= 19 && triglicerideoMgl < 90) {
            classificacao = "Triglicerídeos bom";
        } else if (idade > 20 && triglicerideoMgl < 150) {
            classificacao = "Triglicerídeos bom";
        } else {
            classificacao = "Triglicerídeos ruim";
        }

        return classificacao;
    }

    @Override
    public void cadastrarTrigliceres() {
        String triglicetres = null;
        boolean valido = false;
        while (!valido) {
            triglicetres = JOptionPane.showInputDialog("Insira qtd triglicetres:");
            if (triglicetres == null) {
                // O usuário clicou no botão "Cancelar" ou fechou a caixa de diálogo
                return;
            } else if (triglicetres.isEmpty()) {
                JOptionPane.showMessageDialog(null, "O campo não pode estar vazio. Por favor, insira um número.");
            } else if (!triglicetres.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "O campo deve conter apenas números. Por favor, insira um número válido.");
            } else {
                valido = true;
            }
        }
        setTriglicerideoMgl(Double.parseDouble(triglicetres));
        mostrarResultado();
    }

    @Override
    public void cadastrarGlicemia() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void cadastrarColesterol() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

}

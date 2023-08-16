/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vigjoaopaulo.laboratorio.model;

import javax.swing.JOptionPane;

/**
 *
 * @author vigjo
 */
public final class Paciente {

    private String nome;
    private String tipoSanguineo;
    private int anoNasc;

    public Paciente() {
    }

    public Paciente(String nome, String tipoSanguineo, int anoNasc) {
        this.nome = nome;
        this.tipoSanguineo = tipoSanguineo;
        this.anoNasc = anoNasc;

    }

    public int calcularIdade() {
        int currentYear = java.time.Year.now().getValue();
        return currentYear - this.anoNasc;
    }

    public void mostrarPaciente() {
        String message = "Nome: " + nome + "\n"
                + "Tipo Sanguíneo: " + tipoSanguineo + "\n"
                + "Idade: " + calcularIdade();
        JOptionPane.showMessageDialog(null, message);
    }

    public String getNome() {
        return nome.toUpperCase();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo.toUpperCase();
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo.toUpperCase();
    }

    public int getAnoNasc() {
        return anoNasc;
    }

    public void setAnoNasc(int anoNasc) {
        this.anoNasc = anoNasc;
    }

    public static Paciente inserirPaciente() {
        String nome = null;
        boolean nomeValido = false;
        while (!nomeValido) {
            nome = JOptionPane.showInputDialog("Por favor, insira o nome do paciente:");

            if (nome == null) {
                return null;
            }

            if (nome.isEmpty()) {
                JOptionPane.showMessageDialog(null, "\"O campo nome está vazio.");
            } else if (nome.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "O campo nome contém apenas espaços. Por favor, insira um nome válido.");
            } else {
                nomeValido = true;
                for (int i = 0; i < nome.length(); i++) {
                    if (Character.isDigit(nome.charAt(i))) {
                        nomeValido = false;
                        JOptionPane.showMessageDialog(null,
                                "O campo nome contém números. Por favor, insira apenas letras.");
                        break;
                    }
                }
            }
        }

        String tipoSanguineo = null;
        boolean tipoValido = false;
        while (!tipoValido) {
            tipoSanguineo = JOptionPane.showInputDialog("Por favor, insira o tipo sanguinéo:");
            if (tipoSanguineo == null) {
                // O usuário clicou no botão "Cancelar" ou fechou a caixa de diálogo
                return null;
            } else if (!tipoSanguineo.toUpperCase().matches("^(A|B|AB|O)[+-]$")) {
                JOptionPane.showMessageDialog(null,
                        "O tipo sanguíneo inserido é inválido. Por favor, insira um tipo sanguíneo válido (A+, A-, B+, B-, AB+, AB-, O+ ou O-).");
            } else if (tipoSanguineo.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "O campo tipo sanguíneo está vazio. Por favor, insira um tipo sanguíneo.");
            } else {
                tipoValido = true;
                for (int i = 0; i < tipoSanguineo.length(); i++) {
                    if (Character.isDigit(tipoSanguineo.charAt(i))) {
                        tipoValido = false;
                        JOptionPane.showMessageDialog(null,
                                "O campo tipo sanguíneo contém números. Por favor, insira apenas letras.");
                        break;
                    }
                }
            }
        }

        int anoNasc = 0;
        boolean anoNascValido = false;
        while (!anoNascValido) {
            String anoNascStr = JOptionPane.showInputDialog("Insira ano de nascimento:");

            if (anoNascStr == null) {
                // O usuário clicou no botão "Cancelar" ou fechou a caixa de diálogo
                return null;
            } else if (anoNascStr.isEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "O campo ano de nascimento está vazio. Por favor, insira um ano de nascimento.");
            } else if (!anoNascStr.matches("\\d+")) {
                JOptionPane.showMessageDialog(null,
                        "O campo ano de nascimento contém caracteres inválidos. Por favor, insira apenas números.");
            } else {
                int anoNascInt = Integer.parseInt(anoNascStr);
                if (anoNascInt < 1000 || anoNascInt > 9999) {
                    JOptionPane.showMessageDialog(null,
                            "O ano de nascimento deve ter 4 dígitos. Por favor, insira um ano válido.");
                } else {
                    anoNasc = anoNascInt;
                    anoNascValido = true;
                }
            }
        }

        return new Paciente(nome, tipoSanguineo, anoNasc);
    }
}

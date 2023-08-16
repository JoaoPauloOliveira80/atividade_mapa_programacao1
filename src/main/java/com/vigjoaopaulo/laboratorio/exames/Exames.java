/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vigjoaopaulo.laboratorio.exames;

import com.vigjoaopaulo.laboratorio.model.Paciente;

/**
 *
 * @author vigjo
 */
public abstract class Exames {

    private Paciente paciente;

    public Exames() {
    }

    
    public Exames(Paciente paciente) {
        this.paciente = paciente;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

   public abstract void cadastrarGlicemia();
   public abstract void cadastrarColesterol();
   public abstract void cadastrarTrigliceres();

    public void mostrarResultado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

}

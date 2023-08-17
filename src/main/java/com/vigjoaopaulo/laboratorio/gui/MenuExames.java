package com.vigjoaopaulo.laboratorio.gui;

import com.vigjoaopaulo.laboratorio.exames.Colesterol;
import com.vigjoaopaulo.laboratorio.exames.Exames;
import com.vigjoaopaulo.laboratorio.exames.Glicemia;
import com.vigjoaopaulo.laboratorio.exames.Triglicerideos;
import com.vigjoaopaulo.laboratorio.model.Paciente;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author vigjo
 */
public class MenuExames extends javax.swing.JFrame {

    private Exames exames;
    private MenuExames myFrame;

    public MenuExames() {
        initComponents();

        myFrame = this;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTrigliceres = new javax.swing.JButton();
        btnGlicemia = new javax.swing.JButton();
        btnColesterol = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PRO MEDICAL --- Versão 1.0");
        setBackground(new java.awt.Color(153, 204, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(153, 153, 255));

        btnTrigliceres.setBackground(new java.awt.Color(51, 255, 255));
        btnTrigliceres.setText("Cadastrar Triglicerideos");
        btnTrigliceres.setBorderPainted(false);
        btnTrigliceres.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTrigliceres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarTrigliceres(evt);
            }
        });

        btnGlicemia.setBackground(new java.awt.Color(51, 255, 255));
        btnGlicemia.setText("Cadastrar Glicemia");
        btnGlicemia.setBorderPainted(false);
        btnGlicemia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGlicemia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarGlicemia(evt);
            }
        });

        btnColesterol.setBackground(new java.awt.Color(0, 255, 255));
        btnColesterol.setText("Cadastro Colesterol");
        btnColesterol.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnColesterol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarColesterol(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel1.setText("SEJA BEM VINDO A TELA DE CADASTRO DE EXAMES ");

        btnSair.setBackground(new java.awt.Color(51, 255, 255));
        btnSair.setText("SAIR");
        btnSair.setBorderPainted(false);
        btnSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSair(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(btnGlicemia, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnColesterol, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTrigliceres))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGlicemia, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnColesterol, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTrigliceres, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(btnSair)
                .addGap(24, 24, 24))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarTrigliceres(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarTrigliceres
        myFrame.setVisible(false);
        String emJejum = null;
        boolean validInput = false;
        while (!validInput) {
            emJejum = JOptionPane.showInputDialog("O paciente está em jejum? (S - sim, N - não):");
            if (emJejum != null && emJejum.equalsIgnoreCase("N")) {
                JOptionPane.showMessageDialog(null, "O exame deve ser feito em jejum. Por favor, \nRetorne quando o paciente estiver em jejum.");
                validInput = true;
            } else if (emJejum != null && emJejum.equalsIgnoreCase("S")) {
                Paciente paciente = Paciente.inserirPaciente();
                if (paciente != null) {
                    exames = new Triglicerideos(emJejum, paciente, 0);
                    exames.cadastrarExame();

                }
                validInput = true;
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, digite S para sim ou N para não.");
            }
        }
        myFrame.setVisible(true);

    }//GEN-LAST:event_cadastrarTrigliceres

    private void cadastrarGlicemia(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarGlicemia
        myFrame.setVisible(false);
        Paciente paciente = Paciente.inserirPaciente();
        if (paciente != null) {
            exames = new Glicemia(paciente, 0);
            exames.cadastrarExame();

        }
        myFrame.setVisible(true);


    }//GEN-LAST:event_cadastrarGlicemia

    private void cadastrarColesterol(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarColesterol
        myFrame.setVisible(false);

        Paciente paciente = Paciente.inserirPaciente();

        if (paciente != null) {
            char risk = 0;
            exames = new Colesterol(paciente, 0, 0, risk);
            exames.cadastrarExame();

        }

        // Faz o JFrame reaparecer
        myFrame.setVisible(true);
    }//GEN-LAST:event_cadastrarColesterol


    private void btnSair(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSair
        myFrame.setVisible(false);
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja sair?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            JOptionPane pane = new JOptionPane("Volte sempre!!!", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{});
            // Create the dialog
            final JDialog dialog = pane.createDialog(null, "Title");
            // Set the timer to close the dialog after 5 seconds
            Timer timer = new Timer(2500, e -> dialog.setVisible(false));
            timer.setRepeats(false);
            timer.start();
            // Show the dialog
            dialog.setVisible(true);
            System.exit(0);
        }
        myFrame.setVisible(true);

    }//GEN-LAST:event_btnSair

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MenuExames myFrame = new MenuExames();
                myFrame.pack();
                myFrame.setLocationRelativeTo(null);
                myFrame.setVisible(true);

               
            }
        });

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnColesterol;
    private javax.swing.JButton btnGlicemia;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnTrigliceres;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}

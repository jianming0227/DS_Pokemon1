/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.pokemon;

/**
 *
 * @author User
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoadGamePage extends javax.swing.JFrame {

    public int saveGameButtonClicked;

    public void setSaveGameButtonClicked(int saveGameButtonClicked) {
        this.saveGameButtonClicked = saveGameButtonClicked;
    }

    public int getSaveGameButtonClicked() {
        return saveGameButtonClicked;
    }

    /**
     * Creates new form LoadGamePage
     */
    public LoadGamePage() {
        initComponents();

        //nameTF.setBackground(new Color(255, 236, 78)); // You can customize the color
        // --- combo box ----
        String[] pokemon = {"Bulbasaur [Grass - Level 1]", "Squirtle [Water - Level 1]", "Charmander [Fire - Level 1]"};
        Pokemon.removeAllItems();
        for (String pokemons : pokemon) {
            Pokemon.addItem(pokemons);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NameTextField = new javax.swing.JTextField();
        Pokemon = new javax.swing.JComboBox<>();
        DoneButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(NameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 270, 30));

        Pokemon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Pokemon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PokemonActionPerformed(evt);
            }
        });
        getContentPane().add(Pokemon, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 540, 270, 30));

        DoneButton.setText("Done");
        DoneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoneButtonActionPerformed(evt);
            }
        });
        getContentPane().add(DoneButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 610, 180, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Downloads\\WhatsApp Image 2024-05-12 at 8.34.12 PM.jpeg")); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DoneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoneButtonActionPerformed
        String PlayerName = NameTextField.getText();
        if (PlayerName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "You did not enter your name.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            ConnectDatabase.updateName(saveGameButtonClicked, PlayerName);
            ConnectDatabase.defaultLocation(saveGameButtonClicked);
            String pokemonSelected = (String) Pokemon.getSelectedItem();
            switch (pokemonSelected) {
                case "Bulbasaur [Grass - Level 1]":
                    ConnectDatabase.savePokemon(saveGameButtonClicked, "Bulbasaur");
                    ConnectDatabase.updatePokemonStatsInPlayer(saveGameButtonClicked, "Bulbasaur", 1);
                    ConnectDatabase.updateMove(saveGameButtonClicked, "Bulbasaur", "Tackle", "Vine Whip");
                    ConnectDatabase.updateMoveDamage(saveGameButtonClicked, "Bulbasaur");
                    break;
                case "Squirtle [Water - Level 1]":
                    ConnectDatabase.savePokemon(saveGameButtonClicked, "Squirtle");
                    ConnectDatabase.updatePokemonStatsInPlayer(saveGameButtonClicked, "Squirtle", 1);
                    ConnectDatabase.updateMove(saveGameButtonClicked, "Squirtle", "Tail Whip", "Water Gun");
                    ConnectDatabase.updateMoveDamage(saveGameButtonClicked, "Squirtle");
                    break;
                case "Charmander [Fire - Level 1]":
                    ConnectDatabase.savePokemon(saveGameButtonClicked, "Charmander");
                    ConnectDatabase.updatePokemonStatsInPlayer(saveGameButtonClicked, "Charmander", 1);
                    ConnectDatabase.updateMove(saveGameButtonClicked, "Charmander", "Scratch", "Ember");
                    ConnectDatabase.updateMoveDamage(saveGameButtonClicked, "Charmander");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
            }
            JOptionPane.showMessageDialog(null, "OAK: An amazing choice. Best of luck!", "Result", JOptionPane.INFORMATION_MESSAGE);
            try {
                MainMenuPage mainMenuPageFrame = new MainMenuPage(saveGameButtonClicked);
                this.dispose();
                mainMenuPageFrame.setVisible(true);
                mainMenuPageFrame.pack();
                mainMenuPageFrame.setLocationRelativeTo(null);
            } catch (FontFormatException ex) {
                Logger.getLogger(LoadGamePage.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoadGamePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_DoneButtonActionPerformed

    private void NameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameTextFieldActionPerformed
        
    }//GEN-LAST:event_NameTextFieldActionPerformed

    private void PokemonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PokemonActionPerformed
        String[] pokemon = {"Bulbasaur [Grass - Level 1]", "Squirtle [Water - Level 1]", "Charmander [Fire - Level 1]"};
    }//GEN-LAST:event_PokemonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoadGamePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoadGamePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoadGamePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoadGamePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoadGamePage().setVisible(true);
            }
        });
    }

    public int checkSaveNumber(int saveGameButtonClicked) {
        return saveGameButtonClicked;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DoneButton;
    private javax.swing.JTextField NameTextField;
    private javax.swing.JComboBox<String> Pokemon;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}

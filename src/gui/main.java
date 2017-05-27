/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import compiler.Compiler;

/**
 *
 * @author Saul
 */
public class main extends javax.swing.JFrame {

    private ActionListener myCloseActionHandler;

    /**
     * Creates new form main
     */
    public main() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Compiler");
        setMaximumSize(new java.awt.Dimension(600, 600));
        setMinimumSize(new java.awt.Dimension(600, 600));
        setPreferredSize(new java.awt.Dimension(600, 600));

        jMenu1.setText("File");

        jMenuItem2.setText("New tab");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem5.setText("Open file");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem4.setText("Save as");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Tools");

        jMenuItem3.setText("Compile");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        int tabCount = jTabbedPane1.getTabCount();
        String tabTitle = "New tab "+tabCount;
        ImageIcon icon = new ImageIcon("images/new-tab.png");
        JTextArea textArea = new JTextArea();
        textArea.isEditable();
        jTabbedPane1.addTab(tabTitle, icon, textArea, tabTitle);
        
        int index = jTabbedPane1.indexOfTab(tabTitle);
        
        JPanel pnlTab = new JPanel(new GridBagLayout());
        pnlTab.setOpaque(false);
        JLabel lblTitle = new JLabel(tabTitle);
        JButton btnClose = new JButton("x");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;

        pnlTab.add(lblTitle, gbc);

        gbc.gridx++;
        gbc.weightx = 0;
        pnlTab.add(btnClose, gbc);

        jTabbedPane1.setTabComponentAt(index, pnlTab);

        btnClose.addActionListener(myCloseActionHandler);
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    
    // save file
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        String text;
        if (jTabbedPane1.getSelectedComponent() == null)
            return;
        text = ((JTextArea) jTabbedPane1.getSelectedComponent()).getText();
        FileFilter filter = new FileNameExtensionFilter("C Zero", "c0");
        JFileChooser fileChooser = new JFileChooser();
        
        fileChooser.addChoosableFileFilter(filter);
        int returnVal = fileChooser.showSaveDialog(this);
        
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File savedFile = fileChooser.getSelectedFile();
            String filename = savedFile.toString();
            
            try {
                FileWriter writer = new FileWriter(filename);
                BufferedWriter buffer = new BufferedWriter(writer);
                
                buffer.write(text);
                
                buffer.close();
                writer.close();
                
                int tabIndex = jTabbedPane1.getSelectedIndex();
                jTabbedPane1.setTitleAt(tabIndex, filename);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed
    
    // open file
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        FileFilter filter = new FileNameExtensionFilter("C Zero", "c0");
        JFileChooser fileChooser = new JFileChooser();
        
        fileChooser.addChoosableFileFilter(filter);
        int resultVal = fileChooser.showOpenDialog(this);
        
        if (resultVal == JFileChooser.APPROVE_OPTION) {
            File filename = fileChooser.getSelectedFile();
            try {
                BufferedReader bufferReader = new BufferedReader(new FileReader(filename));
                String text = "";
                String line;
                
                while((line = bufferReader.readLine()) != null) {
                    text += line + '\n';
                }
                
                bufferReader.close();
                
                ImageIcon icon = new ImageIcon("images/new-tab.png");
                JTextArea textArea = new JTextArea();
                textArea.isEditable();
                textArea.setText(text);
                jTabbedPane1.addTab(filename.getName(), icon, textArea, filename.getName());

                int index = jTabbedPane1.indexOfTab(filename.getName());

                JPanel pnlTab = new JPanel(new GridBagLayout());
                pnlTab.setOpaque(false);
                JLabel lblTitle = new JLabel(filename.getName());
                JButton btnClose = new JButton("x");

                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.weightx = 1;

                pnlTab.add(lblTitle, gbc);

                gbc.gridx++;
                gbc.weightx = 0;
                pnlTab.add(btnClose, gbc);

                jTabbedPane1.setTabComponentAt(index, pnlTab);

                btnClose.addActionListener(myCloseActionHandler);
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    // compiler
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        String program;
        if (jTabbedPane1.getSelectedComponent() == null)
            return;
        program = ((JTextArea) jTabbedPane1.getSelectedComponent()).getText();
        
        // aqui van las varas de compilacion
        Compiler comp = new Compiler(program);
        comp.compile();
    }//GEN-LAST:event_jMenuItem3ActionPerformed
    
    public class MyCloseActionHandler implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            Component selected = jTabbedPane1.getSelectedComponent();
            if (selected != null) {
                jTabbedPane1.remove(selected);
            }
        }
    }
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}

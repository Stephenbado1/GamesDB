/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamesdb;

import java.awt.Toolkit;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import utils.GlobalData;

/**
 *
 * @author stephenbadeaux
 */
public class FrmMain extends javax.swing.JFrame {

    /**
     * Creates new form FrmMain
     */
    FrmLogin frmLogin = new FrmLogin();
    FrmAddGame frmAddGame = new FrmAddGame();
    FrmViewGames frmViewGames = new FrmViewGames();
    Map<String, JInternalFrame> forms = new HashMap<>();
    
    public FrmMain() {
        initComponents();
        forms.put("frmLogin", frmLogin);
        forms.put("frmAddGame", frmAddGame);
        forms.put("frmViewGames", frmViewGames);
        //Add all to JDesktopPane
        forms.values().forEach((frm)->{
            jdpContainer.add(frm);
        });
    }
    private void showForm(String frmName){
        showForm(frmName, false);
    }
    private void showForm(String frmName, boolean checkLogin){
        if(checkLogin && GlobalData.stf == null){
            showForm("frmLogin", false);
        }else{
            try {
                //Authorization
                if(forms.get(frmName).isClosed()){
                    try {
                        forms.put(frmName, forms.get(frmName).getClass().newInstance());
                        jdpContainer.add(forms.get(frmName));
                    } catch (InstantiationException ex) {
                        Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                forms.get(frmName).setVisible(true);
                forms.get(frmName).setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
            }
            
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

        jdpContainer = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mniLogin = new javax.swing.JMenuItem();
        mniLogout = new javax.swing.JMenuItem();
        mniExit = new javax.swing.JMenuItem();
        mnuManage = new javax.swing.JMenu();
        mnuGame = new javax.swing.JMenu();
        mniAddGame = new javax.swing.JMenuItem();
        mniUpdateGame = new javax.swing.JMenuItem();
        mniViewGame = new javax.swing.JMenuItem();
        mniDeleteGame = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(jdpContainer, java.awt.BorderLayout.CENTER);

        mnuFile.setText("File");

        mniLogin.setText("Login");
        mniLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniLoginActionPerformed(evt);
            }
        });
        mnuFile.add(mniLogin);

        mniLogout.setText("Logout");
        mnuFile.add(mniLogout);

        mniExit.setText("Exit");
        mniExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniExitActionPerformed(evt);
            }
        });
        mnuFile.add(mniExit);

        jMenuBar1.add(mnuFile);

        mnuManage.setText("Manage");

        mnuGame.setText("Game");

        mniAddGame.setText("Add");
        mniAddGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniAddGameActionPerformed(evt);
            }
        });
        mnuGame.add(mniAddGame);

        mniUpdateGame.setText("Update");
        mnuGame.add(mniUpdateGame);

        mniViewGame.setText("View");
        mniViewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniViewGameActionPerformed(evt);
            }
        });
        mnuGame.add(mniViewGame);

        mniDeleteGame.setText("Delete");
        mniDeleteGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDeleteGameActionPerformed(evt);
            }
        });
        mnuGame.add(mniDeleteGame);

        mnuManage.add(mnuGame);

        jMenuBar1.add(mnuManage);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniLoginActionPerformed
        showForm("frmLogin", false);
    }//GEN-LAST:event_mniLoginActionPerformed

    private void mniExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniExitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mniExitActionPerformed

    private void mniAddGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniAddGameActionPerformed
        showForm("frmAddGame");
    }//GEN-LAST:event_mniAddGameActionPerformed

    private void mniDeleteGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDeleteGameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mniDeleteGameActionPerformed

    private void mniViewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniViewGameActionPerformed
        showForm("frmViewGames");
    }//GEN-LAST:event_mniViewGameActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmMain frmMain = new FrmMain();
                frmMain.setSize(Toolkit.getDefaultToolkit().getScreenSize());
                frmMain.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JDesktopPane jdpContainer;
    private javax.swing.JMenuItem mniAddGame;
    private javax.swing.JMenuItem mniDeleteGame;
    private javax.swing.JMenuItem mniExit;
    private javax.swing.JMenuItem mniLogin;
    private javax.swing.JMenuItem mniLogout;
    private javax.swing.JMenuItem mniUpdateGame;
    private javax.swing.JMenuItem mniViewGame;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenu mnuGame;
    private javax.swing.JMenu mnuManage;
    // End of variables declaration//GEN-END:variables
}

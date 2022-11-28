/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamesdb;

import java.awt.Toolkit;
import java.beans.PropertyVetoException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
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
    FrmAddStaff frmAddStaff = new FrmAddStaff();
    FrmViewStaff frmViewStaff = new FrmViewStaff();

    FrmViewSale frmViewSale = new FrmViewSale();
    FrmAddSale frmAddSale = new FrmAddSale();
    
    Map<String, JInternalFrame> formsAuth2 = new HashMap<>();
    Map<String, JInternalFrame> formsAuth1 = new HashMap<>();
    Map<String, JInternalFrame> formsAuth0 = new HashMap<>();
    
    public FrmMain() {
        initComponents();

        formsAuth0.put("frmViewSale", frmViewSale);
        formsAuth1.put("frmViewSale", frmViewSale);
        formsAuth2.put("frmViewSale", frmViewSale);
        
        formsAuth1.put("frmAddSale", frmAddSale);
        formsAuth2.put("frmAddSale", frmAddSale);

        formsAuth0.put("frmLogin", frmLogin);
        formsAuth1.put("frmLogin", frmLogin);
        formsAuth2.put("frmLogin", frmLogin);
        
        formsAuth1.put("frmAddGame", frmAddGame);
        formsAuth2.put("frmAddGame", frmAddGame);
        
        formsAuth0.put("frmViewGames", frmViewGames);
        formsAuth1.put("frmViewGames", frmViewGames);
        formsAuth2.put("frmViewGames", frmViewGames);
        
        formsAuth2.put("frmAddStaff", frmAddStaff);
        formsAuth2.put("frmViewStaff", frmViewStaff);

        //Add all to JDesktopPane
        formsAuth2.values().forEach((frm)->{
            jdpContainer.add(frm);
        });
    }
    private void showForm(String frmName){
        showForm(frmName, true);
    }
    private void showForm(String frmName, boolean checkLogin){
        if(checkLogin && GlobalData.stf == null){
            showForm("frmLogin", false);
        } else {
            Map<String, JInternalFrame> forms = formsAuth0;
            if(checkLogin) {
                switch(GlobalData.stf.getstfPerms()) {
                    case 1 -> forms = formsAuth1;
                    case 2 -> forms = formsAuth2;
                }
            }
            try {
                //Authorization
                if(forms.containsKey(frmName)) {
                    if(forms.get(frmName).isClosed()){
                        try {
                            forms.put(frmName, forms.get(frmName).getClass().newInstance());
                            jdpContainer.add(forms.get(frmName));
                        } catch (InstantiationException | IllegalAccessException ex) {
                            Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    forms.get(frmName).setVisible(true);
                    forms.get(frmName).setSelected(true);
                } else {
                    JOptionPane.showMessageDialog(this, "You don't have permission to view this form.");
                }
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
        mniViewSaleItems = new javax.swing.JMenu();
        mniAddSale = new javax.swing.JMenuItem();
        mniViewSale = new javax.swing.JMenuItem();
        mniDelete = new javax.swing.JMenuItem();
        mnuStaff = new javax.swing.JMenu();
        mniAddStaff1 = new javax.swing.JMenuItem();
        mniViewStaff1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jdpContainer.setLayout(null);
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
        mniUpdateGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniUpdateGameActionPerformed(evt);
            }
        });
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

        mniViewSaleItems.setText("Sale");

        mniAddSale.setText("Add");
        mniAddSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniAddSaleActionPerformed(evt);
            }
        });
        mniViewSaleItems.add(mniAddSale);

        mniViewSale.setText("View");
        mniViewSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniViewSaleActionPerformed(evt);
            }
        });
        mniViewSaleItems.add(mniViewSale);

        mniDelete.setText("Delete");
        mniDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDeleteActionPerformed(evt);
            }
        });
        mniViewSaleItems.add(mniDelete);

        mnuManage.add(mniViewSaleItems);

        mnuStaff.setText("Staff");

        mniAddStaff1.setText("Add");
        mniAddStaff1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniAddStaff1ActionPerformed(evt);
            }
        });
        mnuStaff.add(mniAddStaff1);

        mniViewStaff1.setText("View");
        mniViewStaff1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniViewStaff1ActionPerformed(evt);
            }
        });
        mnuStaff.add(mniViewStaff1);

        mnuManage.add(mnuStaff);

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
        showForm("frmViewGames");
    }//GEN-LAST:event_mniDeleteGameActionPerformed

    private void mniViewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniViewGameActionPerformed
        showForm("frmViewGames");
    }//GEN-LAST:event_mniViewGameActionPerformed

    private void mniUpdateGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniUpdateGameActionPerformed
        showForm("frmViewGames");
    }//GEN-LAST:event_mniUpdateGameActionPerformed

    private void mniAddStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniAddStaff12ActionPerformed
        showForm("frmAddStaff");
    }//GEN-LAST:event_mniAddStaff12ActionPerformed

    private void mniAddStaff1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniAddStaff1ActionPerformed
        showForm("frmAddStaff");
    }//GEN-LAST:event_mniAddStaff1ActionPerformed

    private void mniViewStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniViewActionPerformed
        showForm("frmViewStaff");
    }//GEN-LAST:event_mniViewActionPerformed

    private void mniViewStaff1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniViewStaff1ActionPerformed
        showForm("frmViewStaff");
    }//GEN-LAST:event_mniViewStaff1ActionPerformed

    private void mniAddSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniAddSaleActionPerformed
        showForm("frmAddSale");
    }//GEN-LAST:event_mniAddSaleActionPerformed

    private void mniViewSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniViewSaleActionPerformed
        showForm("frmViewSale");
    }//GEN-LAST:event_mniViewSaleActionPerformed

    private void mniDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDeleteActionPerformed
        showForm("frmViewSale");
    }//GEN-LAST:event_mniDeleteActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> {
            FrmMain frmMain = new FrmMain();
            frmMain.setSize(Toolkit.getDefaultToolkit().getScreenSize());
            frmMain.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JDesktopPane jdpContainer;
    private javax.swing.JMenuItem mniAddGame;
    private javax.swing.JMenuItem mniAddSale;
    private javax.swing.JMenuItem mniAddStaff1;
    private javax.swing.JMenuItem mniDelete;
    private javax.swing.JMenuItem mniDeleteGame;
    private javax.swing.JMenuItem mniExit;
    private javax.swing.JMenuItem mniLogin;
    private javax.swing.JMenuItem mniLogout;
    private javax.swing.JMenuItem mniUpdateGame;
    private javax.swing.JMenuItem mniViewGame;
    private javax.swing.JMenuItem mniViewSale;
    private javax.swing.JMenu mniViewSaleItems;
    private javax.swing.JMenuItem mniViewStaff1;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenu mnuGame;
    private javax.swing.JMenu mnuManage;
    private javax.swing.JMenu mnuStaff;
    // End of variables declaration//GEN-END:variables
}

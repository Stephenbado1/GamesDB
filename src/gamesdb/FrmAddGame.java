/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamesdb;

import bo.Publisher;
import dao.GameHandler;
import dao.PublisherHandler;
import java.lang.reflect.Member;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import utils.GlobalData;

/**
 *
 * @author stephenbadeaux
 */
public class FrmAddGame extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmAddGame
     */
    private void populatePublishers(){
        List<Publisher> publishers = new PublisherHandler().getPublisher();
        ComboBoxModel cbxModel = new DefaultComboBoxModel(publishers.toArray());
        cbxPublisher.setModel(cbxModel);
        
    }
    private void populateScore(){
        for(int i=0; i<=100; i++){
            chbxScore.addItem(Integer.toString(i));
        }
    }
    public FrmAddGame() {
        initComponents();
        populatePublishers();
        populateScore();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JLName = new javax.swing.JLabel();
        JLPublisher = new javax.swing.JLabel();
        JLScore = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        chbxScore = new java.awt.Choice();
        JLRDate = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        cbxPublisher = new javax.swing.JComboBox<>();
        txtDate = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Add Game");
        setToolTipText("");

        JLName.setText("Name");

        JLPublisher.setText("Publisher");

        JLScore.setText("Game Score");

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        JLRDate.setText("Release Date");

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        cbxPublisher.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtDate.setText("YYYYMMDD");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLPublisher)
                            .addComponent(JLName))
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLScore)
                            .addComponent(JLRDate))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(chbxScore, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(txtDate))
                        .addGap(171, 171, 171)))
                .addContainerGap(85, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancel)
                    .addComponent(btnSubmit))
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLPublisher)
                    .addComponent(cbxPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLScore)
                    .addComponent(chbxScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLRDate)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(btnSubmit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancel))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        //Get input values
        String gameName = txtName.getText();
        Publisher p = (Publisher)cbxPublisher.getSelectedItem();
        String pubName = p.getpName();
        int releaseDate = Integer.parseInt(txtDate.getText());
        int score = chbxScore.getSelectedIndex();
        int stfId = GlobalData.stf.getstfId();
        int ret = new GameHandler().addGame(gameName, pubName, releaseDate, score);
        if (ret == -1){
            JOptionPane.showMessageDialog(this, "Failed to add Game");
        }else{
            JOptionPane.showMessageDialog(this, "Game added successfully");
            //Clear the form
            txtName.setText(null);
            cbxPublisher.setSelectedIndex(0);
            chbxScore.select(0);
            txtDate.setText("YYYYMMDD");
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLName;
    private javax.swing.JLabel JLPublisher;
    private javax.swing.JLabel JLRDate;
    private javax.swing.JLabel JLScore;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> cbxPublisher;
    private java.awt.Choice chbxScore;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.ClientControl;
import Model.User;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/** pul
 *
 * @author nguye
 */
public class ClientView extends javax.swing.JFrame {

    private User user;
//    private ClientControl clientCtrl;
    private DefaultTableModel tmOnline;
    /**
     * Creates new form ClientView
     */
    public ClientView(User user) {
        this.user = user;
    //    this.clientCtrl = clientCtrl;, ClientControl clientCtrl
        initComponents();
        initTable();
        loadOnlineList();
    }
    
    private void initTable() {
        String[] cols1 = {"Username", "Score", "State"};
        tmOnline = new DefaultTableModel(cols1, 0);
        tblOnlineList.setModel(tmOnline);
    }
    
    private void loadOnlineList() {
        ClientControl clientCtrl = new ClientControl();
        clientCtrl.openConnection();
        ArrayList<User> a = clientCtrl.loadOnlineList();
        
        if(a != null)
            tmOnline.setRowCount(0);
        for(User i : a){
            tmOnline.addRow(i.toObject());
        }  
        clientCtrl.closeConnection();
    }
    
    public ArrayList<Integer> getString() {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            list.add(i);
        }
        return list;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblOnlineList = new javax.swing.JTable();
        btnInvite = new javax.swing.JButton();
        btnRanking = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtThoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblOnlineList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblOnlineList);

        btnInvite.setText("Invite");

        btnRanking.setText("Ranking");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("PIKACHU");

        txtThoat.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        txtThoat.setText("Log out");
        txtThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnInvite, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRanking, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtThoat))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(btnInvite)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                        .addComponent(btnRanking)
                        .addGap(168, 168, 168))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(26, 26, 26))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThoatActionPerformed
        //thay đổi state trước
        ClientControl clientCtrl = new ClientControl();
        clientCtrl.openConnection();
        boolean rs = clientCtrl.logOut(user);
        if(rs){
            JOptionPane.showMessageDialog(this, "Đã thoát");
            // đóng kết nối
            new LoginView().setVisible(true);
        }else {
            JOptionPane.showMessageDialog(this, "Chưa thoát được rồi,"
                    + " ở lại chơi thêm với chúng mình!");
        }
        //
        clientCtrl.closeConnection();
        this.dispose();
        new LoginView().setVisible(true);
        
    }//GEN-LAST:event_txtThoatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInvite;
    private javax.swing.JButton btnRanking;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblOnlineList;
    private javax.swing.JButton txtThoat;
    // End of variables declaration//GEN-END:variables
}

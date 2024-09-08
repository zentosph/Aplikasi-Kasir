import com.mysql.jdbc.PreparedStatement;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFileChooser;
public class duser extends javax.swing.JFrame {

    public duser() {
        initComponents();
        load_table();
        this.nbarang = nbarang;
        datacombobox();
         nbarang.addActionListener(e -> getIdBarang());
    }

     public class Item {
        private int id;
        private String name;

        public Item(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return name;
        }
    }
    
      public void datacombobox() {
        try {
            Connection conn = koneksi.configDB(); // Memanggil koneksi
            String query = "SELECT namalevel FROM level";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String namaBarang = rs.getString("namalevel");
                nbarang.addItem(namaBarang);
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

private void getIdBarang() {
    String selectedNamaBarang = (String) nbarang.getSelectedItem();
    if (selectedNamaBarang != null) {
        try {
            Connection conn = koneksi.configDB();
            String query = "SELECT id_level FROM level WHERE namalevel = ?";
            PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(query);
            stmt.setString(1, selectedNamaBarang);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int idBarang = rs.getInt("id_level");
                // You can now use idBarang as needed
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

 private void kosong(){
        nbarang.setSelectedItem(null);
        namauser.setText(null);
        idbarang.setText(null);
        emails.setText(null);
    }
    
    private void load_table(){
    // membuat tampilan model tabel
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Id barang");
    model.addColumn("Nama");
    model.addColumn("Email");
    model.addColumn("Level");
    
    
    try{

        String sql = "select user.id_user, user.username, user.email, level.namalevel FROM user JOIN level ON level.id_level = user.level";
        java.sql.Connection conn=(Connection)koneksi.configDB();
        java.sql.Statement stm=conn.createStatement();
        java.sql.ResultSet res=stm.executeQuery(sql);
        while(res.next()){
            model.addRow(new Object[]{res.getString(1),res.getString(2),
            res.getString(3),res.getString(4)});
        }
        data_barang.setModel(model);
    }catch (Exception e){
}
    
    
}
    private String hashPassword(String password) throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("MD5");
    md.update(password.getBytes());
    byte[] digest = md.digest();
    StringBuilder sb = new StringBuilder();
    for (byte b : digest) {
        sb.append(String.format("%02x", b & 0xff));
    }
    return sb.toString();
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        data_barang = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        nbarang = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        namauser = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        idbarang = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        emails = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        data_barang.setModel(new javax.swing.table.DefaultTableModel(
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
        data_barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                data_barangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(data_barang);

        jLabel2.setText("Nama User");

        nbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nbarangActionPerformed(evt);
            }
        });

        jLabel6.setText("Level");

        namauser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namauserActionPerformed(evt);
            }
        });

        jButton2.setText("Tambah");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Edit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Hapus");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        idbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idbarangActionPerformed(evt);
            }
        });

        jLabel1.setText("Email");

        jLabel3.setText("<-Back");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(idbarang, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(emails, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(namauser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(nbarang, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nbarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namauser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(idbarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void data_barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_data_barangMouseClicked
        int baris = data_barang.rowAtPoint(evt.getPoint());
        String idb =data_barang.getValueAt(baris, 1).toString();
        namauser.setText(idb);
        String namabarang =data_barang.getValueAt(baris, 3).toString();
        nbarang.setSelectedItem(namabarang);
        String email =data_barang.getValueAt(baris, 2).toString();
        emails.setText(email);
        String iddbarang =data_barang.getValueAt(baris, 0).toString();
        idbarang.setText(iddbarang);
    }//GEN-LAST:event_data_barangMouseClicked

    private void nbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nbarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nbarangActionPerformed

    private void namauserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namauserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namauserActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
    // Retrieve the selected nama_barang from the JComboBox
    String selectedNamaBarang = (String) nbarang.getSelectedItem();
    int idLevel = 0;

    if (selectedNamaBarang != null) {
        // Call getIdBarang method to get the id_level based on selected nama_barang
        try {
            Connection conn = koneksi.configDB();
            String query = "SELECT id_level FROM level WHERE namalevel = ?";
            PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(query);
            stmt.setString(1, selectedNamaBarang);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                idLevel = rs.getInt("id_level");
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
        JOptionPane.showMessageDialog(null, "Please select an item.");
        return; // Exit if no item is selected
    }

    // Hash the password using MD5
    String password = "cpp123";
    String hashedPassword = hashPassword(password);

    // Continue with the original process of inserting data
    String sqlAnak = "INSERT INTO user (level, username, email, password) VALUES (?, ?, ?, ?)";
    Connection conn = koneksi.configDB();
    PreparedStatement pstAnak = (PreparedStatement) conn.prepareStatement(sqlAnak);

    // Set the id_level in the PreparedStatement
    pstAnak.setInt(1, idLevel);
    pstAnak.setString(2, namauser.getText());
    pstAnak.setString(3, emails.getText());
    pstAnak.setString(4, hashedPassword);

    // Execute the update
    pstAnak.executeUpdate();
    JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");

} catch (Exception e) {
    JOptionPane.showMessageDialog(this, e.getMessage());
}

kosong();
load_table();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            // Retrieve the selected nama_barang from the JComboBox
            String selectedNamaBarang = (String) nbarang.getSelectedItem();
            int idBarang = 0;

            if (selectedNamaBarang != null) {
                // Call getIdBarang method to get the id_barang based on selected nama_barang
                try {
                    Connection conn = koneksi.configDB();
                    String query = "SELECT id_level FROM level WHERE namalevel = ?";
                    PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(query);
                    stmt.setString(1, selectedNamaBarang);
                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()) {
                        idBarang = rs.getInt("id_level");
                    }

                    rs.close();
                    stmt.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error retrieving id_barang: " + e.getMessage());
                    return; // Exit if there's an error
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please select an item.");
                return; // Exit if no item is selected
            }

            // Update the barangkeluar table using the retrieved id_barang
            String sql = "UPDATE user SET username = ?,  level = ?, email = ? WHERE id_user = ?";
            Connection conn = koneksi.configDB();
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);

            pst.setInt(2, idBarang); // Use the retrieved id_barang
            pst.setString(1, namauser.getText()); // Set the stok value
            pst.setString(4, idbarang.getText()); // Use the existing id_bkeluar
            pst.setString(3, emails.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Update");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Perubahan Data Gagal: " + e.getMessage());
        }

        load_table();
        kosong();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try{
            String sql = "delete from user WHERE id_user='"+idbarang.getText()+"'";
            java.sql.Connection conn=(Connection)koneksi.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "Data Berhasil di Hapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        load_table();
        kosong();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void idbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idbarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idbarangActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.dispose();
        new data().setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

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
            java.util.logging.Logger.getLogger(duser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(duser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(duser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(duser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new duser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable data_barang;
    private javax.swing.JTextField emails;
    private javax.swing.JTextField idbarang;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField namauser;
    private javax.swing.JComboBox<String> nbarang;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kutuphaneotomasyonu.uye;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import kutuphaneotomasyonu.SqlBaglantisi;
import static kutuphaneotomasyonu.personel.Personeller.personeListesi;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author fxd
 */
public class Üyeler extends javax.swing.JFrame {

    /**
     * Creates new form Üyeler
     */
    UyeGoster goster = new UyeGoster();

    public Üyeler() {
        initComponents();
        SqlBaglantisi baglanti = new SqlBaglantisi();
        try {
            baglanti.Baglan(new SqlBaglantisi().getDbUrl(), new SqlBaglantisi().getdbKullanici(), new SqlBaglantisi().getdbSifre());
        } catch (SQLException ex) {
            Logger.getLogger(Üyeler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            uyeListesi.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    try {
                        baglanti.Baglan(new SqlBaglantisi().getDbUrl(), new SqlBaglantisi().getdbKullanici(), new SqlBaglantisi().getdbSifre());
                        int row = uyeListesi.getSelectedRow();
                        String tableClick = (uyeListesi.getModel().getValueAt(row, 0).toString());

                        String sql = "select * from uyeler where id='" + tableClick + "'";

                        SqlBaglantisi.prs = SqlBaglantisi.con.prepareStatement(sql);
                        SqlBaglantisi.rs = SqlBaglantisi.prs.executeQuery();

                        if (SqlBaglantisi.rs.next()) {
                            UyeGoster.tcLabel.setText(SqlBaglantisi.rs.getString("tc"));;
                            UyeGoster.adLabel.setText(SqlBaglantisi.rs.getString("adi"));
                            UyeGoster.soyadLabel.setText(SqlBaglantisi.rs.getString("soyadi"));
                            UyeGoster.telefonLabel.setText(SqlBaglantisi.rs.getString("telefon_no"));
                            UyeGoster.adresLabel.setText(SqlBaglantisi.rs.getString("adres"));
                            UyeGoster.idLabel.setText(SqlBaglantisi.rs.getInt("id") + "");
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        try {
                            SqlBaglantisi.con.close();
                            SqlBaglantisi.prs.close();
                            SqlBaglantisi.rs.close();
                        } catch (SQLException ex1) {
                            Logger.getLogger(Üyeler.class.getName()).log(Level.SEVERE, null, ex1);
                        }

                    }
                }
            });
            UyeTablo();
            üyeEklePanel.add(goster.getContentPane());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Veriler Tabloya Yüklenedi","Veriler Tabloya Yüklenedi",HEIGHT);

        } finally {
            try {
                SqlBaglantisi.con.close();
                SqlBaglantisi.prs.close();
                SqlBaglantisi.rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Üyeler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void UyeTablo() {
        try {
            String sql = "SELECT id,tc,adi,soyadi,telefon_no FROM uyeler";
            SqlBaglantisi.prs = SqlBaglantisi.con.prepareStatement(sql);
            SqlBaglantisi.rs = SqlBaglantisi.prs.executeQuery();
            uyeListesi.setModel(DbUtils.resultSetToTableModel(SqlBaglantisi.rs));
            uyeListesi.getColumnModel().getColumn(0).setMinWidth(0);
            uyeListesi.getColumnModel().getColumn(0).setMaxWidth(0);
            SqlBaglantisi.con.close();

        } catch (Exception ex) {
            try {
                SqlBaglantisi.con.close();
            } catch (SQLException ex1) {
                Logger.getLogger(Üyeler.class.getName()).log(Level.SEVERE, null, ex1);
            }
            ex.printStackTrace();
        } finally {
            try {
                SqlBaglantisi.con.close();
                SqlBaglantisi.prs.close();
                SqlBaglantisi.rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Üyeler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        uyeKayit = new javax.swing.JButton();
        aramaCubugu = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        uyeListesi = new javax.swing.JTable();
        üyeEklePanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Üye İşlemleri");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        uyeKayit.setText("Yeni Üye Kaydı");
        uyeKayit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uyeKayitActionPerformed(evt);
            }
        });

        aramaCubugu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                aramaCubuguKeyPressed(evt);
            }
        });

        uyeListesi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(uyeListesi);

        üyeEklePanel.setBackground(new java.awt.Color(255, 255, 255));
        üyeEklePanel.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout üyeEklePanelLayout = new javax.swing.GroupLayout(üyeEklePanel);
        üyeEklePanel.setLayout(üyeEklePanelLayout);
        üyeEklePanelLayout.setHorizontalGroup(
            üyeEklePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 414, Short.MAX_VALUE)
        );
        üyeEklePanelLayout.setVerticalGroup(
            üyeEklePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(uyeKayit)
                        .addGap(27, 27, 27)
                        .addComponent(aramaCubugu, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(üyeEklePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uyeKayit)
                    .addComponent(aramaCubugu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(üyeEklePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    boolean acikMi = true;
    private void uyeKayitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uyeKayitActionPerformed
        ÜyeEkle uye = new ÜyeEkle();

        if (acikMi) {
            üyeEklePanel.removeAll();
            üyeEklePanel.add(uye.getContentPane());
            üyeEklePanel.validate();
            üyeEklePanel.repaint();
            acikMi = !acikMi;
            uyeKayit.setText("Bilgileri Göster");
        } else {
            üyeEklePanel.removeAll();
            üyeEklePanel.validate();
            üyeEklePanel.repaint();
            acikMi = !acikMi;
            üyeEklePanel.add(goster.getContentPane());
            uyeKayit.setText("Yeni Üye Kaydı");
        }
    }//GEN-LAST:event_uyeKayitActionPerformed

    private void aramaCubuguKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aramaCubuguKeyPressed
        // TODO add your handling code here:
        if (aramaCubugu.getText().length()==1)
            aramaCubugu.setText(aramaCubugu.getText().toUpperCase());
        TableRowSorter<TableModel> sorter=new TableRowSorter<>((DefaultTableModel) uyeListesi.getModel());
        sorter.setRowFilter(RowFilter.regexFilter(this.aramaCubugu.getText()));
        uyeListesi.setRowSorter(sorter);
    }//GEN-LAST:event_aramaCubuguKeyPressed

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
            java.util.logging.Logger.getLogger(Üyeler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Üyeler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Üyeler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Üyeler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Üyeler().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aramaCubugu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton uyeKayit;
    public static javax.swing.JTable uyeListesi;
    private javax.swing.JPanel üyeEklePanel;
    // End of variables declaration//GEN-END:variables
}

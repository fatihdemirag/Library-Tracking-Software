/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kutuphaneotomasyonu.personel;

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
import kutuphaneotomasyonu.uye.Üyeler;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author fxd
 */
public class Personeller extends javax.swing.JFrame {

    /**
     * Creates new form Personeller
     */
    SqlBaglantisi baglanti = new SqlBaglantisi();
    PersonelGoster personelGoster=new PersonelGoster();
    public Personeller() {
        initComponents();
        try {
            baglanti.Baglan(new SqlBaglantisi().getDbUrl(), new SqlBaglantisi().getdbKullanici(), new SqlBaglantisi().getdbSifre());
        } catch (SQLException ex) {
            Logger.getLogger(Üyeler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            personeListesi.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    try {
                        baglanti.Baglan(new SqlBaglantisi().getDbUrl(), new SqlBaglantisi().getdbKullanici(), new SqlBaglantisi().getdbSifre());
                        int row = personeListesi.getSelectedRow();
                        String tableClick = (personeListesi.getModel().getValueAt(row, 0).toString());

                        String sql = "select * from personel where id='" + tableClick + "'";

                        SqlBaglantisi.prs = SqlBaglantisi.con.prepareStatement(sql);
                        SqlBaglantisi.rs = SqlBaglantisi.prs.executeQuery();

                        if (SqlBaglantisi.rs.next()) {
                            PersonelGoster.personelAdi.setText(SqlBaglantisi.rs.getString("adi"));
                            PersonelGoster.personelSoyadi.setText(SqlBaglantisi.rs.getString("soyadi"));
                            PersonelGoster.personelNo.setText(SqlBaglantisi.rs.getString("personel_no"));
                            PersonelGoster.id=SqlBaglantisi.rs.getInt("id");
                        }
                        SqlBaglantisi.con.close();
                    } catch (Exception ex) {
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
        } catch (Exception e) {
        }
        sagPanel.add(personelGoster.getContentPane());
        PersonelTablo();
    }
    public static void PersonelTablo() {
        try {
            String sql = "SELECT id,adi,soyadi,personel_no FROM personel";
            SqlBaglantisi.prs = SqlBaglantisi.con.prepareStatement(sql);
            SqlBaglantisi.rs = SqlBaglantisi.prs.executeQuery();
            
            personeListesi.setModel(DbUtils.resultSetToTableModel(SqlBaglantisi.rs));
            personeListesi.getColumnModel().getColumn(0).setMinWidth(0);
            personeListesi.getColumnModel().getColumn(0).setMaxWidth(0);   
            
            SqlBaglantisi.con.close();
        } catch (Exception ex) {
            try {
                SqlBaglantisi.con.close();
            } catch (SQLException ex1) {
                Logger.getLogger(Üyeler.class.getName()).log(Level.SEVERE, null, ex1);
            }
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Personel Listesi Yüklenemedi","Personel Listesi Yüklenemedi",ERROR);
        }
        finally
        {
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
        ekleGosterButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        personeListesi = new javax.swing.JTable();
        sagPanel = new javax.swing.JPanel();
        aramaCubugu = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        ekleGosterButton.setText("Yeni Personel Kaydı");
        ekleGosterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ekleGosterButtonActionPerformed(evt);
            }
        });

        personeListesi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(personeListesi);

        sagPanel.setBackground(new java.awt.Color(255, 255, 255));
        sagPanel.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout sagPanelLayout = new javax.swing.GroupLayout(sagPanel);
        sagPanel.setLayout(sagPanelLayout);
        sagPanelLayout.setHorizontalGroup(
            sagPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 371, Short.MAX_VALUE)
        );
        sagPanelLayout.setVerticalGroup(
            sagPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        aramaCubugu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                aramaCubuguKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ekleGosterButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aramaCubugu, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sagPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ekleGosterButton)
                    .addComponent(aramaCubugu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sagPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    boolean acikMi=true;
    private void ekleGosterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ekleGosterButtonActionPerformed
        // TODO add your handling code here:
        PersonelEkle personelEkle = new PersonelEkle();
        PersonelGoster goster=new PersonelGoster();

        if (acikMi) {
            sagPanel.removeAll();
            sagPanel.add(personelEkle.getContentPane());
            sagPanel.validate();
            sagPanel.repaint();
            acikMi = !acikMi;
            ekleGosterButton.setText("Bilgileri Göster");
        } else {
            sagPanel.removeAll();
            sagPanel.validate();
            sagPanel.repaint();
            acikMi = !acikMi;
            sagPanel.add(goster.getContentPane());
            ekleGosterButton.setText("Yeni Personel Kaydı");
        }
    }//GEN-LAST:event_ekleGosterButtonActionPerformed

    private void aramaCubuguKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aramaCubuguKeyPressed
        // TODO add your handling code here:
        if (aramaCubugu.getText().length()==1)
            aramaCubugu.setText(aramaCubugu.getText().toUpperCase());
        TableRowSorter<TableModel> sorter=new TableRowSorter<>((DefaultTableModel) personeListesi.getModel());
        sorter.setRowFilter(RowFilter.regexFilter(this.aramaCubugu.getText()));
        personeListesi.setRowSorter(sorter);
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
            java.util.logging.Logger.getLogger(Personeller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Personeller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Personeller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Personeller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Personeller().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aramaCubugu;
    private javax.swing.JButton ekleGosterButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable personeListesi;
    private javax.swing.JPanel sagPanel;
    // End of variables declaration//GEN-END:variables
}

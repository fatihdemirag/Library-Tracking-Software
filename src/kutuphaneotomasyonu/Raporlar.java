/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kutuphaneotomasyonu;

import java.awt.BorderLayout;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author fxd
 */
public class Raporlar extends javax.swing.JFrame {

    /**
     * Creates new form Raporlar
     */
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Calendar cal = Calendar.getInstance();

    public Raporlar() {
        initComponents();
        StoguBitenKitaplar();
        TeslimTarihiGeciktirenler();
        BugunKitapAlanlar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        stoguBitenKitaplarListesi = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        teslimTarihiGeciktirenlerListesi = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jTabbedPane5.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane5.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        stoguBitenKitaplarListesi.setMinimumSize(new java.awt.Dimension(0, 253));
        jScrollPane1.setViewportView(stoguBitenKitaplarListesi);

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Stoğu Biten Kitaplar");

        teslimTarihiGeciktirenlerListesi.setLayoutOrientation(javax.swing.JList.VERTICAL_WRAP);
        jScrollPane4.setViewportView(teslimTarihiGeciktirenlerListesi);

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Teslim Tarihini Geciktirenler");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(517, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addGap(10, 10, 10))
        );

        jTabbedPane5.addTab("Genel Raporlar", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Kitaplar Alanlar");

        jScrollPane3.setViewportView(jList3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(759, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Günlük Raporlar", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    SqlBaglantisi baglanti = new SqlBaglantisi();

    private void StoguBitenKitaplar() {
        try {

            baglanti.Baglan(new SqlBaglantisi().getDbUrl(), new SqlBaglantisi().getdbKullanici(), new SqlBaglantisi().getdbSifre());
            SqlBaglantisi.prs = SqlBaglantisi.con.prepareStatement("select * from kitaplar where stok_miktari=0");
            SqlBaglantisi.rs = SqlBaglantisi.prs.executeQuery();
            DefaultListModel model = new DefaultListModel();
            while (SqlBaglantisi.rs.next()) {
                model.addElement(SqlBaglantisi.rs.getString("adi"));
            }
            stoguBitenKitaplarListesi.setModel(model);

            SqlBaglantisi.rs.close();
            SqlBaglantisi.prs.close();
            SqlBaglantisi.con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void TeslimTarihiGeciktirenler() {
        try {
            baglanti.Baglan(new SqlBaglantisi().getDbUrl(), new SqlBaglantisi().getdbKullanici(), new SqlBaglantisi().getdbSifre());

            Date bugun = Date.valueOf(dateFormat.format(cal.getTime()));
            SqlBaglantisi.prs = SqlBaglantisi.con.prepareStatement("SELECT distinct kitap_alis.teslim_tarihi,uyeler.adi,uyeler.soyadi FROM kitap_alis join uyeler on kitap_alis.uye=uyeler.id");
            SqlBaglantisi.rs = SqlBaglantisi.prs.executeQuery();
            DefaultListModel model = new DefaultListModel();
            while (SqlBaglantisi.rs.next()) {
                if (SqlBaglantisi.rs.getDate("teslim_tarihi").after(bugun)) {
                    model.addElement(SqlBaglantisi.rs.getString("uyeler.adi")+" "+SqlBaglantisi.rs.getString("uyeler.soyadi"));
                }
                teslimTarihiGeciktirenlerListesi.setModel(model);

            }

        } catch (Exception e) {
            e.printStackTrace();
            try {
                SqlBaglantisi.rs.close();

                SqlBaglantisi.prs.close();
                SqlBaglantisi.con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Raporlar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private void BugunKitapAlanlar() {
        try {
            baglanti.Baglan(new SqlBaglantisi().getDbUrl(), new SqlBaglantisi().getdbKullanici(), new SqlBaglantisi().getdbSifre());

            Date bugun = Date.valueOf(dateFormat.format(cal.getTime()));
            SqlBaglantisi.prs = SqlBaglantisi.con.prepareStatement("SELECT kitap_alis.teslim_tarihi,uyeler.adi,uyeler.soyadi FROM kitap_alis join uyeler on kitap_alis.uye=uyeler.id");
            SqlBaglantisi.rs = SqlBaglantisi.prs.executeQuery();
            DefaultListModel model = new DefaultListModel();
            while (SqlBaglantisi.rs.next()) {
                if (SqlBaglantisi.rs.getDate("teslim_tarihi").equals(bugun)) {
                    model.addElement(SqlBaglantisi.rs.getString("uyeler.adi")+" "+SqlBaglantisi.rs.getString("uyeler.soyadi"));
                }
                teslimTarihiGeciktirenlerListesi.setModel(model);

            }

        } catch (Exception e) {
            e.printStackTrace();
            try {
                SqlBaglantisi.rs.close();

                SqlBaglantisi.prs.close();
                SqlBaglantisi.con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Raporlar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

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
            java.util.logging.Logger.getLogger(Raporlar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Raporlar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Raporlar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Raporlar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Raporlar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jList3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JList<String> stoguBitenKitaplarListesi;
    private javax.swing.JList<String> teslimTarihiGeciktirenlerListesi;
    // End of variables declaration//GEN-END:variables
}

package kutuphaneotomasyonu.kitap;

import kutuphaneotomasyonu.siniflar.Kitap;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import kutuphaneotomasyonu.SqlBaglantisi;
import kutuphaneotomasyonu.uye.Üyeler;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author fxd
 *
 */
public class Kitaplar extends javax.swing.JFrame {

    SqlBaglantisi baglanti = new SqlBaglantisi();
    Kitap kitap = new Kitap();

    public Kitaplar() {
        initComponents();
        idLabel.setVisible(false);
        this.pack();
        this.setLocationRelativeTo(null);
        try {
            baglanti.Baglan(new SqlBaglantisi().getDbUrl(), new SqlBaglantisi().getdbKullanici(), new SqlBaglantisi().getdbSifre());

            try {
                /*
                    tablonun modelinin alıp seçme olayı ekledim.
                 */
                jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        try {

                            int row = jTable1.getSelectedRow();
                            String tableClick = (jTable1.getModel().getValueAt(row, 0).toString());

                            String sql = "select * from kitaplar where id='" + tableClick + "'";

                            SqlBaglantisi.prs = SqlBaglantisi.con.prepareStatement(sql);
                            SqlBaglantisi.rs = SqlBaglantisi.prs.executeQuery();

                            if (SqlBaglantisi.rs.next()) {
                                kitapAdi.setText(SqlBaglantisi.rs.getString("adi"));
                                basimYili.setText(SqlBaglantisi.rs.getString("basim_yili"));
                                stokMiktari.setText(SqlBaglantisi.rs.getInt("stok_miktari") + "");
                                idLabel.setText(SqlBaglantisi.rs.getInt("id") + "");

                                /*
                                    //InputStream ile gelen  veriyi yazdırıp is değişkenine aktardım.Gelen veri dosya veya resim gibi ikilik değerler olabilir.
                                    //BufferedImage ile inputStream dan gelen veriyi byte byte okudum.
                                    //Daha sonra okuduğum veriyi image değişkeni oluşturup onun içine attım.
                                 */
                                InputStream is = SqlBaglantisi.rs.getBinaryStream("on_kapak_resmi");
                                // Decode the inputstream as BufferedImage
                                BufferedImage bufImg = null;
                                bufImg = ImageIO.read(is);
                                Image image = bufImg;
                                ImageIcon icon = new ImageIcon(image);

                                //Resim Ölçeklendirme
                                Image r = icon.getImage();
                                Image asilResim = r.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
                                ImageIcon yeniResim = new ImageIcon(asilResim);
                                resimLabel.setIcon(yeniResim);

                            }
                            String sql2 = "select * from kitaplar join yazarlar on kitaplar.yazari=yazarlar.id where kitaplar.id='" + tableClick + "'";

                            SqlBaglantisi.prs = SqlBaglantisi.con.prepareStatement(sql2);
                            SqlBaglantisi.rs = SqlBaglantisi.prs.executeQuery();
                            if (SqlBaglantisi.rs.next()) {
                                yazari.setText(SqlBaglantisi.rs.getString("yazarlar.adi") + " " + SqlBaglantisi.rs.getString("yazarlar.soyadi"));
                            }

                            String sql3 = "select * from kitaplar join yayinevi on kitaplar.yayinevi=yayinevi.id where kitaplar.id='" + tableClick + "'";
                            SqlBaglantisi.prs = SqlBaglantisi.con.prepareStatement(sql3);
                            SqlBaglantisi.rs = SqlBaglantisi.prs.executeQuery();
                            if (SqlBaglantisi.rs.next()) {
                                yayinevi.setText(SqlBaglantisi.rs.getString("yayinevi.adi"));
                            }

                            String sql4 = "select * from kategoriler join kitaplar on kitaplar.kategori=kategoriler.id where kitaplar.id='" + tableClick + "'";
                            SqlBaglantisi.prs = SqlBaglantisi.con.prepareStatement(sql4);
                            SqlBaglantisi.rs = SqlBaglantisi.prs.executeQuery();
                            if (SqlBaglantisi.rs.next()) {
                                kategorisi.setText(SqlBaglantisi.rs.getString("kategoriler.kategori"));
                            }

                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                SqlBaglantisi.con.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Veritabanı Bağlantısında Hata Oluştu", "Veritabanı Bağlantısında Hata Oluştu", HEIGHT);
                e.printStackTrace();
                try {
                    SqlBaglantisi.con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Kitaplar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                SqlBaglantisi.con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Kitaplar.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        KitapTablo();
    }

    private void KitapTablo() {
        try {
            //Veritabanı bağlantısı
            baglanti.Baglan(new SqlBaglantisi().getDbUrl(), new SqlBaglantisi().getdbKullanici(), new SqlBaglantisi().getdbSifre());

            //String sql="select id,adi,basim_yili,kategori,stok_miktari from kitaplar";
            String sql = "SELECT kitaplar.id,adi,basim_yili,stok_miktari,kategoriler.kategori FROM kitaplar join kategoriler on kitaplar.kategori=kategoriler.id";
            SqlBaglantisi.prs = SqlBaglantisi.con.prepareStatement(sql);
            SqlBaglantisi.rs = SqlBaglantisi.prs.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(SqlBaglantisi.rs));
            jTable1.getColumnModel().getColumn(0).setMinWidth(0);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(0);

        } catch (Exception ex) {
            try {
                SqlBaglantisi.prs.close();
                SqlBaglantisi.rs.close();
                SqlBaglantisi.con.close();
            } catch (SQLException ex1) {
                Logger.getLogger(Kitaplar.class.getName()).log(Level.SEVERE, null, ex1);
            }
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        kitapAdi = new javax.swing.JLabel();
        yazari = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        yayinevi = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        basimYili = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        kategorisi = new javax.swing.JLabel();
        stokMiktari = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        resimLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        kitapSilButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kitaplar");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setRowHeight(14);
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("Kitap Adı");

        kitapAdi.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        kitapAdi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kitapAdi.setText("-");

        yazari.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        yazari.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        yazari.setText("-");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setText("Yazarı");

        yayinevi.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        yayinevi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        yayinevi.setText("-");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel6.setText("Basım Yılı");

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel7.setText("Yayınevi");

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel8.setText("Kategorisi");

        basimYili.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        basimYili.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        basimYili.setText("-");

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel10.setText("Stok Miktarı");

        kategorisi.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        kategorisi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kategorisi.setText("-");

        stokMiktari.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        stokMiktari.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        stokMiktari.setText("-");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(resimLabel)
                .addContainerGap(365, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(resimLabel)
                .addContainerGap(302, Short.MAX_VALUE))
        );

        idLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        idLabel.setText("idLabel");

        kitapSilButton.setBackground(new java.awt.Color(255, 255, 255));
        kitapSilButton.setText("Kitabı Sil");
        kitapSilButton.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kitapSilButton.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        kitapSilButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kitapSilButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kitapSilButton, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idLabel)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel1))
                                .addGap(60, 60, 60)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(kitapAdi)
                                    .addComponent(yayinevi)
                                    .addComponent(stokMiktari)
                                    .addComponent(kategorisi)
                                    .addComponent(yazari)
                                    .addComponent(basimYili))))))
                .addGap(0, 178, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kitapSilButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(kitapAdi, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(yayinevi))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(yazari)
                        .addGap(47, 47, 47)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(basimYili))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(kategorisi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(stokMiktari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kitapSilButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kitapSilButtonActionPerformed
        // TODO add your handling code here:
        SqlBaglantisi baglanti = new SqlBaglantisi();
        try {
            baglanti.Baglan(new SqlBaglantisi().getDbUrl(), new SqlBaglantisi().getdbKullanici(), new SqlBaglantisi().getdbSifre());
            SqlBaglantisi.prs = SqlBaglantisi.con.prepareStatement("delete from kitaplar where id='" + idLabel.getText() + "'");
            SqlBaglantisi.prs.executeUpdate();
            JOptionPane.showMessageDialog(null, "Kitap Silindi","Kitap Silindi",WIDTH);

            KitapTablo();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Kitap Silinemedi","Kitap Silinemedi",HEIGHT);
            e.printStackTrace();
        } finally {
            try {
                SqlBaglantisi.con.close();
                SqlBaglantisi.prs.close();
                SqlBaglantisi.rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Üyeler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_kitapSilButtonActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Kitaplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kitaplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kitaplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kitaplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kitaplar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel basimYili;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel kategorisi;
    private javax.swing.JLabel kitapAdi;
    private javax.swing.JButton kitapSilButton;
    private javax.swing.JLabel resimLabel;
    private javax.swing.JLabel stokMiktari;
    private javax.swing.JLabel yayinevi;
    private javax.swing.JLabel yazari;
    // End of variables declaration//GEN-END:variables
}

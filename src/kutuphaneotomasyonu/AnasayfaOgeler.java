/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//---->>>>> 5.734 Satır Kod <<<<<<------
package kutuphaneotomasyonu;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import kutuphaneotomasyonu.kitap.Kitaplar;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author fxd
 */
public class AnasayfaOgeler extends javax.swing.JFrame {
    
    /**
     * Creates new form AnasayfaOgeler
     */
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Calendar cal = Calendar.getInstance();

    SqlBaglantisi baglanti = new SqlBaglantisi();
    int uyeId = 0;
    int kitapId = 0;

    public AnasayfaOgeler() {
        initComponents();
        Calendar c = Calendar.getInstance();
        teslimTarihiDate.setMinSelectableDate(c.getTime());
        PersonelNoAl();
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
                                InputStream is = SqlBaglantisi.rs.getBinaryStream("on_kapak_resmi");
                                // Decode the inputstream as BufferedImage
                                BufferedImage bufImg = null;
                                bufImg = ImageIO.read(is);
                                Image image = bufImg;
                                ImageIcon icon = new ImageIcon(image);

                                //Resim Ölçeklendirme
                                Image r = icon.getImage();
                                Image asilResim = r.getScaledInstance(200, 250, Image.SCALE_SMOOTH);
                                ImageIcon yeniResim = new ImageIcon(asilResim);
                                resimLabel.setIcon(yeniResim);
                                kitapAdıLabel.setText(SqlBaglantisi.rs.getString("adi"));
                                kitapId = SqlBaglantisi.rs.getInt("id");
                                stokLabel.setText(SqlBaglantisi.rs.getInt("stok_miktari") + "");

                            }

                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                SqlBaglantisi.con.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Veritabanı Bağlantısında Hata Oluştu");
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
        KitapTablo("adi");
    }

    private void PersonelNoAl() {
        try {
            FileReader fileReader = new FileReader("personel_no.txt");
            String line;

            BufferedReader br = new BufferedReader(fileReader);

            while ((line = br.readLine()) != null) {
                personelLabel.setText(line);

            }

            br.close();
        } catch (FileNotFoundException f) {
            Logger.getLogger(AnasayfaOgeler.class.getName()).log(Level.SEVERE, null, f);
        } catch (IOException ex) {
            Logger.getLogger(AnasayfaOgeler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        kitapAdıLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        teslimTarihiDate = new com.toedter.calendar.JDateChooser();
        teslimButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        stokLabel = new javax.swing.JLabel();
        personelLabel = new javax.swing.JLabel();
        uyeBul = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        araTextBox = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        filtrele = new javax.swing.JComboBox<>();
        resimLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Kitap Alış");

        jLabel2.setText("Kitap Adı : ");

        kitapAdıLabel.setText("-");

        jLabel4.setText("Üye TC");

        jLabel6.setText("Personel :");

        jLabel8.setText("Teslim Tarihi");

        teslimTarihiDate.setBackground(new java.awt.Color(255, 255, 255));
        teslimTarihiDate.setForeground(new java.awt.Color(255, 255, 255));
        teslimTarihiDate.setMinSelectableDate(new java.util.Date(-62135776682000L));

        teslimButton.setBackground(new java.awt.Color(255, 255, 255));
        teslimButton.setText("Teslim Et");
        teslimButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teslimButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Stok Miktarı :");

        stokLabel.setText("-");

        personelLabel.setText("-");

        uyeBul.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                uyeBulKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                uyeBulKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(teslimTarihiDate, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(teslimButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(11, 11, 11)))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(kitapAdıLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                        .addComponent(stokLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(uyeBul, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(personelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(kitapAdıLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(stokLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uyeBul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(personelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(teslimTarihiDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(teslimButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel7.setText("Kitap Ara");

        araTextBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                araTextBoxKeyPressed(evt);
            }
        });

        jLabel10.setText("Filtrele");

        filtrele.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kitap Adına Göre Sırala", "Stok Miktarına Göre Sırala" }));
        filtrele.setToolTipText("");
        filtrele.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filtreleİtemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(araTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(filtrele, 0, 246, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(170, 170, 170)
                                .addComponent(jLabel10)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(araTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filtrele, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101)
                .addComponent(resimLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 374, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(resimLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void filtreleİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filtreleİtemStateChanged
        // TODO add your handling code here:
        try {
            switch (filtrele.getSelectedItem().toString()) {
                case "Kitap İsmine Göre Sırala":
                    KitapTablo("adi");
                    break;
                case "Stok Miktarına Göre Sırala":
                    KitapTablo("stok_miktari");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_filtreleİtemStateChanged

    private void araTextBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_araTextBoxKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            try {
                SqlBaglantisi.prs = SqlBaglantisi.con.prepareStatement("select * from kitaplar where adi in('" + araTextBox.getText() + "')");
                SqlBaglantisi.rs = SqlBaglantisi.prs.executeQuery();
                if (SqlBaglantisi.rs.next()) {
                    JOptionPane.showMessageDialog(null, "Kayıt Bulundu");
                    kitapAdıLabel.setText(SqlBaglantisi.rs.getString("adi"));
                    stokLabel.setText(SqlBaglantisi.rs.getInt("stok_miktari") + "");

                } else {
                    JOptionPane.showMessageDialog(null, "Kayıt Bulunamadı");
                }

            } catch (SQLException ex) {
                Logger.getLogger(AnasayfaOgeler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_araTextBoxKeyPressed

    private void uyeBulKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_uyeBulKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            try {
                SqlBaglantisi.prs = SqlBaglantisi.con.prepareStatement("select * from uyeler where tc in('" + uyeBul.getText() + "')");
                SqlBaglantisi.rs = SqlBaglantisi.prs.executeQuery();
                if (!SqlBaglantisi.rs.next()) {
                    JOptionPane.showMessageDialog(null, "Üye Bulunamadı");
                } else {
                    uyeId = SqlBaglantisi.rs.getInt("id");
                }
            } catch (SQLException ex) {
                Logger.getLogger(AnasayfaOgeler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_uyeBulKeyPressed

    private void teslimButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teslimButtonActionPerformed
        // TODO add your handling code here:
        try {
            int personelId = 0;
            if (!stokLabel.getText().equals("0")) {

                SqlBaglantisi.prs = SqlBaglantisi.con.prepareStatement("select * from uyeler where tc in('" + uyeBul.getText() + "')");
                SqlBaglantisi.rs = SqlBaglantisi.prs.executeQuery();
                if (!SqlBaglantisi.rs.next()) {
                    JOptionPane.showMessageDialog(null, "Üye Bulunamadı","Üye Bulunamadı",WIDTH);
                } else {
                    uyeId = SqlBaglantisi.rs.getInt("id");
                }

                SqlBaglantisi.prs = SqlBaglantisi.con.prepareStatement("select * from personel where personel_no='" + personelLabel.getText() + "'");
                SqlBaglantisi.rs = SqlBaglantisi.prs.executeQuery();

                while (SqlBaglantisi.rs.next()) {
                    personelId = SqlBaglantisi.rs.getInt("id");
                }

                if (!kitapAdıLabel.getText().equals("") && !teslimTarihiDate.getDate().toString().equals("")) {
                    SqlBaglantisi.prs = SqlBaglantisi.con.prepareStatement("insert into kitap_alis(uye,personel,kitap,alis_tarihi,teslim_tarihi) values(?,?,?,?,?)");

                    SqlBaglantisi.prs.setInt(1, uyeId);
                    SqlBaglantisi.prs.setInt(2, personelId);
                    SqlBaglantisi.prs.setInt(3, kitapId);
                    SqlBaglantisi.prs.setDate(4, Date.valueOf(dateFormat.format(cal.getTime())));
                    SqlBaglantisi.prs.setDate(5, new Date(teslimTarihiDate.getDate().getTime()));
                    SqlBaglantisi.prs.executeUpdate();

                    int yeniStok = Integer.parseInt(stokLabel.getText()) - 1;
                    SqlBaglantisi.prs = SqlBaglantisi.con.prepareStatement("update kitaplar set stok_miktari='" + yeniStok + "' where id='" + kitapId + "'");

                    SqlBaglantisi.prs.executeUpdate();

                    SqlBaglantisi.prs = SqlBaglantisi.con.prepareStatement("select * from kitaplar where id='" + kitapId + "'");
                    SqlBaglantisi.rs = SqlBaglantisi.prs.executeQuery();

                    while (SqlBaglantisi.rs.next()) {
                        stokLabel.setText(SqlBaglantisi.rs.getInt("stok_miktari") + "");
                    }

                    JOptionPane.showMessageDialog(null, "Kitap Teslim Edildi", "Kitap Teslim Edildi", WIDTH);

                } else {
                    JOptionPane.showMessageDialog(null, "Teslim Tarihi Alış Tarihinden Önce Olamaz", "Hatalı Tarih", WIDTH);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Kitap Stokta Yok", "Stok Miktarı Yetersiz", WIDTH);
            }
        } catch (SQLException s) {
            JOptionPane.showMessageDialog(null, "Kitap Teslim Edilemedi", "Kitap Teslim Edilemedi", WIDTH);
            s.printStackTrace();
        } catch (NullPointerException n) {
            JOptionPane.showMessageDialog(null, "Lütfen Tüm Bilgileri Eksiksiz Giriniz", "Eksik Bilgi Girildi", WIDTH);
            n.printStackTrace();
        } catch (NumberFormatException ne) {
            JOptionPane.showMessageDialog(null, "Lütfen Kitap Seçiniz", "Lütfen Kitap Seçiniz", WIDTH);
            ne.printStackTrace();
        }

    }//GEN-LAST:event_teslimButtonActionPerformed

    private void uyeBulKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_uyeBulKeyTyped
        // TODO add your handling code here:
        if (uyeBul.getText().length() == 11) {
            evt.consume();
        }
    }//GEN-LAST:event_uyeBulKeyTyped

    /**
     * @param args the command line arguments
     */
    private void KitapTablo(String sirala) {
        try {
            //Veritabanı bağlantısı
            baglanti.Baglan(new SqlBaglantisi().getDbUrl(), new SqlBaglantisi().getdbKullanici(), new SqlBaglantisi().getdbSifre());
            String sql = "select id,adi from kitaplar order by '" + sirala + "' asc";
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
            java.util.logging.Logger.getLogger(AnasayfaOgeler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnasayfaOgeler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnasayfaOgeler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnasayfaOgeler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnasayfaOgeler().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField araTextBox;
    private javax.swing.JComboBox<String> filtrele;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel kitapAdıLabel;
    private javax.swing.JLabel personelLabel;
    private javax.swing.JLabel resimLabel;
    private javax.swing.JLabel stokLabel;
    private javax.swing.JButton teslimButton;
    private com.toedter.calendar.JDateChooser teslimTarihiDate;
    private javax.swing.JTextField uyeBul;
    // End of variables declaration//GEN-END:variables
}

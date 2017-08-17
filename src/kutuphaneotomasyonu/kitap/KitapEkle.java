package kutuphaneotomasyonu.kitap;

import kutuphaneotomasyonu.siniflar.Kitap;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import kutuphaneotomasyonu.Anasayfa;
import kutuphaneotomasyonu.SqlBaglantisi;

/**
 *
 * @author fxd
 */
public class KitapEkle extends javax.swing.JFrame {

    /**
     * Creates new form KitapEkle
     */
    SqlBaglantisi baglanti = new SqlBaglantisi();

    public KitapEkle() {
        initComponents();

        Calendar c = Calendar.getInstance();
        basimYili.setMaxSelectableDate(c.getTime());

        this.pack();
        this.setLocationRelativeTo(null);
        try {
            baglanti.Baglan(new SqlBaglantisi().getDbUrl(), new SqlBaglantisi().getdbKullanici(), new SqlBaglantisi().getdbSifre());
            ComboBoxYukle();
        } catch (SQLException ex) {
            Logger.getLogger(KitapEkle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    static int kategoriId = 0;
    static int yayineviId = 0;
    static int yazarId = 0;

    public static void ComboBoxYukle() {
        try {
            kategoriComboBox.removeAllItems();
            yayineviComboBox.removeAll();
            yazarComboBox.removeAllItems();

            //<editor-fold defaultstate="collapsed" desc="Kategorilerin ComboBoxa yüklenmesi">
            SqlBaglantisi.prs = SqlBaglantisi.con.prepareStatement("select * from kategoriler order by kategori");
            SqlBaglantisi.rs = SqlBaglantisi.prs.executeQuery();
            while (SqlBaglantisi.rs.next()) {
                kategoriId = SqlBaglantisi.rs.getInt("id");
                kategoriComboBox.addItem(SqlBaglantisi.rs.getString("kategori"));
            }
            //</editor-fold>  
            //<editor-fold defaultstate="collapsed" desc="Yayınevlerinin ComboBoxa yüklenmesi">
            SqlBaglantisi.prs = SqlBaglantisi.con.prepareStatement("select * from yayinevi order by adi");
            SqlBaglantisi.rs = SqlBaglantisi.prs.executeQuery();
            while (SqlBaglantisi.rs.next()) {
                yayineviId = SqlBaglantisi.rs.getInt("id");
                yayineviComboBox.addItem(SqlBaglantisi.rs.getString("adi"));
            }
            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="Yazarların ComboBoxa yüklenmesi">
            SqlBaglantisi.prs = SqlBaglantisi.con.prepareStatement("select * from yazarlar order by adi");
            SqlBaglantisi.rs = SqlBaglantisi.prs.executeQuery();
            while (SqlBaglantisi.rs.next()) {
                yazarId = SqlBaglantisi.rs.getInt("id");
                yazarComboBox.addItem(SqlBaglantisi.rs.getString("adi") + " " + SqlBaglantisi.rs.getString("soyadi"));
            }
            //</editor-fold>
        } catch (SQLException s) {
            s.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        kitapAdi = new javax.swing.JTextField();
        basimYili = new com.toedter.calendar.JDateChooser();
        kategoriComboBox = new javax.swing.JComboBox<>();
        stokMiktari = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        gozat = new javax.swing.JButton();
        ekleButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        yazarComboBox = new javax.swing.JComboBox<>();
        yayineviComboBox = new javax.swing.JComboBox<>();
        kategoriEkle = new javax.swing.JLabel();
        yazarEkle = new javax.swing.JLabel();
        yayineviEkle = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        geriButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        resimLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kitap Ekle");
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(java.awt.Color.white);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        kitapAdi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                kitapAdiKeyTyped(evt);
            }
        });

        basimYili.setBackground(new java.awt.Color(255, 255, 255));
        basimYili.setForeground(new java.awt.Color(255, 255, 255));
        basimYili.setDateFormatString("yyyy-M-dd");
        basimYili.setMaxSelectableDate(new java.util.Date(253370757696000L));
        basimYili.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                basimYiliKeyTyped(evt);
            }
        });

        stokMiktari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                stokMiktariKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Kitap Adı");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Basım Yılı");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Kategori");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Stok Miktarı");

        gozat.setText("Resim Ekle");
        gozat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gozatActionPerformed(evt);
            }
        });

        ekleButton.setText("Kaydet");
        ekleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ekleButtonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Yazarı");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Yayınevi");

        kategoriEkle.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        kategoriEkle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/plus.png"))); // NOI18N
        kategoriEkle.setText("Kategori Ekle");
        kategoriEkle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        kategoriEkle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kategoriEkleMouseClicked(evt);
            }
        });

        yazarEkle.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        yazarEkle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/plus.png"))); // NOI18N
        yazarEkle.setText("Yazar Ekle");
        yazarEkle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        yazarEkle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                yazarEkleMouseClicked(evt);
            }
        });

        yayineviEkle.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        yayineviEkle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/plus.png"))); // NOI18N
        yayineviEkle.setText("Yayınevi Ekle");
        yayineviEkle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        yayineviEkle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                yayineviEkleMouseClicked(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 284, Short.MAX_VALUE)
        );

        geriButton.setBackground(new java.awt.Color(0, 0, 0));
        geriButton.setForeground(new java.awt.Color(255, 255, 255));
        geriButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/back.png"))); // NOI18N
        geriButton.setText("Kitap Listesine Geri Dön");
        geriButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                geriButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(geriButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(46, 46, 46)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(yayineviComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(yazarComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(stokMiktari)
                                    .addComponent(kategoriComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(kitapAdi)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(basimYili, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(gozat)
                                                .addGap(18, 18, 18)
                                                .addComponent(ekleButton)))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(yazarEkle)
                            .addComponent(yayineviEkle)
                            .addComponent(kategoriEkle))
                        .addGap(364, 364, 364))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kitapAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(basimYili, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kategoriComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kategoriEkle))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(stokMiktari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(yazarComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(yazarEkle)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(yayineviComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(yayineviEkle)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gozat)
                    .addComponent(ekleButton))
                .addGap(18, 18, 18)
                .addComponent(geriButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(resimLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(resimLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    String resimYolu;
    private void gozatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gozatActionPerformed
        // TODO add your handling code here:
        jPanel2.repaint();
        jPanel2.validate();
        try {
            //Seçim işlemi
            JFileChooser file = new JFileChooser();
            //Gozat butonuna basılınca açılacak olan dosya yeri
            file.setCurrentDirectory(new File(System.getProperty("user.home")));
            //Uzantıyı belirleme
            FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("*.Images", "jpg", "png");
            file.addChoosableFileFilter(extensionFilter);

            //Secilen dosyayı tutma
            int sonuc = file.showSaveDialog(null);
            if (sonuc == JFileChooser.APPROVE_OPTION) {
                File secilenDosya = file.getSelectedFile();
                String yol = secilenDosya.getAbsolutePath();
                resimYolu = yol;
                //resimLabel.setIcon(new ImageIcon(ImageIO.read(secilenDosya)));
                //Resim Ölçeklendirme
                ImageIcon resim = new ImageIcon(ImageIO.read(secilenDosya));
                Image r = resim.getImage();
                Image asilResim = r.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
                ImageIcon yeniResim = new ImageIcon(asilResim);
                resimLabel.setIcon(yeniResim);
            }
        } catch (Exception e) {
            try {
                throw new Exception("Hata oluştu");
            } catch (Exception ex) {
                Logger.getLogger(KitapEkle.class.getName()).log(Level.SEVERE, null, ex);
                try {
                    SqlBaglantisi.prs.close();
                    SqlBaglantisi.rs.close();
                } catch (SQLException ex1) {
                    Logger.getLogger(KitapEkle.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        }
    }//GEN-LAST:event_gozatActionPerformed

    private void ekleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ekleButtonActionPerformed
        if (resimYolu != null) {
            if (!kitapAdi.getText().equals("") && !stokMiktari.getText().equals("") && !stokMiktari.getText().equals("0")) {
                try {
                    baglanti.Baglan(new SqlBaglantisi().getDbUrl(), new SqlBaglantisi().getdbKullanici(), new SqlBaglantisi().getdbSifre());

                    SqlBaglantisi.prs = SqlBaglantisi.con.prepareStatement("insert into kitaplar(adi,basim_yili,stok_miktari,on_kapak_resmi,kategori,yazari,yayinevi) values(?,?,?,?,?,?,?)");

                    InputStream inputStream = new FileInputStream(resimYolu);
                    Kitap kitap = new Kitap();
                    kitap.setAdi(kitapAdi.getText());
                    kitap.setBasimYili(new Date(basimYili.getDate().getTime()));
                    kitap.setStok_miktari(Integer.valueOf(stokMiktari.getText()));

                    SqlBaglantisi.prs.setString(1, kitap.getAdi());
                    SqlBaglantisi.prs.setDate(2, kitap.getBasimYili());
                    SqlBaglantisi.prs.setInt(3, kitap.getStok_miktari());
                    SqlBaglantisi.prs.setBlob(4, inputStream);

                    //<-- Kategori İd'si alındı-->
                    SqlBaglantisi.prs.setInt(5, kategoriId);
                    //<-------------------------->

                    //<-- Yazar İd'si alındı-->
                    SqlBaglantisi.prs.setInt(6, yazarId);
                    //<-------------------------->

                    //<-- Yayınevi İd'si alındı-->
                    SqlBaglantisi.prs.setInt(7, yayineviId);
                    //<-------------------------->

                    //Kategoriye ve yazara tıklanınıca kaydın id sini alıp veriyi öyle ekle.
                    SqlBaglantisi.prs.executeUpdate();

                    try {
                        SqlBaglantisi.prs = SqlBaglantisi.con.prepareStatement("select * from kitaplar");
                        SqlBaglantisi.rs = SqlBaglantisi.prs.executeQuery();

                        int stok = 0;
                        while (SqlBaglantisi.rs.next()) {
                            stok = SqlBaglantisi.rs.getInt("stok_miktari");
                            if (kitapAdi.getText() == SqlBaglantisi.rs.getString("adi")) {
                                stok++;
                            }
                        }
                        int yeniStok = stok;
                        SqlBaglantisi.prs = SqlBaglantisi.con.prepareStatement("update kitaplar set stok_miktari='" + yeniStok + "' where id='" + kitapAdi.getText() + "'");
                        SqlBaglantisi.prs.executeUpdate();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    JOptionPane.showMessageDialog(null, "Kitap Eklendi", "Kitap Eklendi", WIDTH);
                    SqlBaglantisi.con.close();
                    kitapAdi.setText("");
                    stokMiktari.setText("");

                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Kitap Eklenemedi Lütfen Bilgileri Kontrol Edin", "Kitap Eklenemedi Lütfen Bilgileri Kontrol Edin", HEIGHT);

                }
            } else {
                JOptionPane.showMessageDialog(null, "Eksik Bilgi Girdiniz Lütfen Bilgileri Kontrol Edin !", "Eksik Bilgi Girdiniz Lütfen Bilgileri Kontrol Edin !", HEIGHT);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Lütfen Kapak Resmi Ekleyiniz !", "Lütfen Kapak Resmi Ekleyiniz !", HEIGHT);
        }

    }//GEN-LAST:event_ekleButtonActionPerformed
    String kategoriItemString;
    String yazarItemString;
    String yayineviItemString;
    private void geriButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_geriButtonActionPerformed
        Anasayfa.anasayfaPanel.removeAll();
        Kitaplar kitaplar = new Kitaplar();
        Anasayfa.anasayfaPanel.add(kitaplar.getContentPane());
        Anasayfa.anasayfaPanel.repaint();
        Anasayfa.anasayfaPanel.validate();
    }//GEN-LAST:event_geriButtonActionPerformed

    private void kategoriEkleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kategoriEkleMouseClicked
        KategoriEkle kategori = new KategoriEkle();

        if (acikMi) {
            jPanel3.repaint();
            jPanel3.revalidate();
            jPanel3.add(kategori.getContentPane());
            acikMi = !acikMi;
        } else {
            acikMi = !acikMi;
            jPanel3.removeAll();
            jPanel3.repaint();
            jPanel3.revalidate();
        }
    }//GEN-LAST:event_kategoriEkleMouseClicked
    boolean acikMi = true;
    private void yazarEkleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yazarEkleMouseClicked
        YazarEkle yazar = new YazarEkle();

        if (acikMi) {
            jPanel3.repaint();
            jPanel3.revalidate();
            jPanel3.add(yazar.getContentPane());
            acikMi = !acikMi;
        } else {
            acikMi = !acikMi;
            jPanel3.removeAll();
            jPanel3.repaint();
            jPanel3.revalidate();
        }
    }//GEN-LAST:event_yazarEkleMouseClicked

    private void stokMiktariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stokMiktariKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)) || stokMiktari.getText().length() == 3) {
            evt.consume();
        }
        if (stokMiktari.getText() == "0") {
            JOptionPane.showMessageDialog(null, "Stok Miktarı 0 Olamaz");
        } else if (stokMiktari.getText().length() < 0) {
            JOptionPane.showMessageDialog(null, "Stok Miktarı Sıfırdan Küçük Olamaz");
        }
    }//GEN-LAST:event_stokMiktariKeyTyped

    private void yayineviEkleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yayineviEkleMouseClicked
        YayineviEkle yayinevi = new YayineviEkle();
        if (acikMi) {
            jPanel3.repaint();
            jPanel3.revalidate();
            jPanel3.add(yayinevi.getContentPane());
            acikMi = !acikMi;
        } else {
            acikMi = !acikMi;
            jPanel3.removeAll();
            jPanel3.repaint();
            jPanel3.revalidate();
        }
    }//GEN-LAST:event_yayineviEkleMouseClicked

    private void kitapAdiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kitapAdiKeyTyped
        char c = evt.getKeyChar();
        if (kitapAdi.getText().length() == 30) {
            evt.consume();
        }
    }//GEN-LAST:event_kitapAdiKeyTyped

    private void basimYiliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_basimYiliKeyTyped
        char c = evt.getKeyChar();
        if (Character.isAlphabetic(c) || Character.isDigit(c) || c == KeyEvent.VK_SPACE) {
            evt.consume();
        }
    }//GEN-LAST:event_basimYiliKeyTyped

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
            java.util.logging.Logger.getLogger(KitapEkle.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KitapEkle.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KitapEkle.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KitapEkle.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KitapEkle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser basimYili;
    private javax.swing.JButton ekleButton;
    private javax.swing.JButton geriButton;
    private javax.swing.JButton gozat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JComboBox<String> kategoriComboBox;
    private javax.swing.JLabel kategoriEkle;
    private javax.swing.JTextField kitapAdi;
    private javax.swing.JLabel resimLabel;
    private javax.swing.JTextField stokMiktari;
    public static javax.swing.JComboBox<String> yayineviComboBox;
    private javax.swing.JLabel yayineviEkle;
    public static javax.swing.JComboBox<String> yazarComboBox;
    private javax.swing.JLabel yazarEkle;
    // End of variables declaration//GEN-END:variables
}

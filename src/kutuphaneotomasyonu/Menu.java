package kutuphaneotomasyonu;

import javax.swing.JOptionPane;
import kutuphaneotomasyonu.kitap.KitapEkle;
import kutuphaneotomasyonu.kitap.KitapGuncelle;
import kutuphaneotomasyonu.kitap.Kitaplar;
import kutuphaneotomasyonu.personel.Personeller;
import kutuphaneotomasyonu.uye.Üyeler;

/**
 *
 * @author fxd
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public Menu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JMenuBar();
        anasayfa = new javax.swing.JMenu();
        kitaplar = new javax.swing.JMenu();
        kitaplarSayfasi = new javax.swing.JMenuItem();
        kitapEkle = new javax.swing.JMenuItem();
        kitapGuncelle = new javax.swing.JMenuItem();
        personel = new javax.swing.JMenu();
        uye = new javax.swing.JMenu();
        raporlar = new javax.swing.JMenu();
        cikis = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menu.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        menu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menu.setPreferredSize(new java.awt.Dimension(1177, 44));

        anasayfa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/reading.png"))); // NOI18N
        anasayfa.setText("Anasayfa");
        anasayfa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        anasayfa.setDelay(100);
        anasayfa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                anasayfaMouseClicked(evt);
            }
        });
        menu.add(anasayfa);

        kitaplar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/open-book.png"))); // NOI18N
        kitaplar.setText("Kitaplar");
        kitaplar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        kitaplar.setDelay(100);
        kitaplar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kitaplarMouseClicked(evt);
            }
        });

        kitaplarSayfasi.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
        kitaplarSayfasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/books.png"))); // NOI18N
        kitaplarSayfasi.setText("Kitaplar");
        kitaplarSayfasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kitaplarSayfasiActionPerformed(evt);
            }
        });
        kitaplar.add(kitaplarSayfasi);

        kitapEkle.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        kitapEkle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/scholarship.png"))); // NOI18N
        kitapEkle.setText("Kitap Ekle");
        kitapEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kitapEkleActionPerformed(evt);
            }
        });
        kitaplar.add(kitapEkle);

        kitapGuncelle.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        kitapGuncelle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/update.png"))); // NOI18N
        kitapGuncelle.setText("Kitap Güncelle");
        kitapGuncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kitapGuncelleActionPerformed(evt);
            }
        });
        kitaplar.add(kitapGuncelle);

        menu.add(kitaplar);

        personel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/team.png"))); // NOI18N
        personel.setText("Personel İşlemleri");
        personel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        personel.setDelay(100);
        personel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                personelMouseClicked(evt);
            }
        });
        menu.add(personel);

        uye.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/user.png"))); // NOI18N
        uye.setText("Üye İşlemleri");
        uye.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uye.setDelay(100);
        uye.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uyeMouseClicked(evt);
            }
        });
        menu.add(uye);

        raporlar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/clipboard.png"))); // NOI18N
        raporlar.setText("Raporlar");
        raporlar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        raporlar.setDelay(100);
        raporlar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                raporlarMouseClicked(evt);
            }
        });
        menu.add(raporlar);

        cikis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/power.png"))); // NOI18N
        cikis.setText("ÇIKIŞ");
        cikis.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cikis.setDelay(100);
        cikis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cikisMouseClicked(evt);
            }
        });
        menu.add(cikis);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1299, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kitaplarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kitaplarMouseClicked
        Anasayfa.anasayfaPanel.removeAll();
        Kitaplar kitap = new Kitaplar();
        Anasayfa.anasayfaPanel.add(kitap.getContentPane());
        Anasayfa.anasayfaPanel.repaint();
        Anasayfa.anasayfaPanel.validate();

    }//GEN-LAST:event_kitaplarMouseClicked

    private void anasayfaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_anasayfaMouseClicked
        Anasayfa.anasayfaPanel.removeAll();
        AnasayfaOgeler anasayfa = new AnasayfaOgeler();
        Anasayfa.anasayfaPanel.add(anasayfa.getContentPane());
        Anasayfa.anasayfaPanel.repaint();
        Anasayfa.anasayfaPanel.validate();
    }//GEN-LAST:event_anasayfaMouseClicked

    private void cikisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cikisMouseClicked
        int secim = JOptionPane.showConfirmDialog(null, "Çıkış Yapmak İstediğinize Emin Misiniz ?", "Çıkış",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (secim == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_cikisMouseClicked

    private void kitapEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kitapEkleActionPerformed
        Anasayfa.anasayfaPanel.removeAll();
        KitapEkle kitapEkle = new KitapEkle();
        Anasayfa.anasayfaPanel.add(kitapEkle.getContentPane());
        Anasayfa.anasayfaPanel.repaint();
        Anasayfa.anasayfaPanel.validate();
    }//GEN-LAST:event_kitapEkleActionPerformed

    private void kitaplarSayfasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kitaplarSayfasiActionPerformed
        Anasayfa.anasayfaPanel.removeAll();
        Kitaplar kitaplar = new Kitaplar();
        Anasayfa.anasayfaPanel.add(kitaplar.getContentPane());
        Anasayfa.anasayfaPanel.repaint();
        Anasayfa.anasayfaPanel.validate();
    }//GEN-LAST:event_kitaplarSayfasiActionPerformed

    private void personelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_personelMouseClicked
        Anasayfa.anasayfaPanel.removeAll();
        Personeller personel = new Personeller();
        Anasayfa.anasayfaPanel.add(personel.getContentPane());
        Anasayfa.anasayfaPanel.repaint();
        Anasayfa.anasayfaPanel.validate();
    }//GEN-LAST:event_personelMouseClicked

    private void uyeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uyeMouseClicked
        Anasayfa.anasayfaPanel.removeAll();
        Üyeler uye = new Üyeler();
        Anasayfa.anasayfaPanel.add(uye.getContentPane());
        Anasayfa.anasayfaPanel.repaint();
        Anasayfa.anasayfaPanel.validate();
    }//GEN-LAST:event_uyeMouseClicked

    private void raporlarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_raporlarMouseClicked
        // TODO add your handling code here:
        Anasayfa.anasayfaPanel.removeAll();
        Raporlar rapor = new Raporlar();
        Anasayfa.anasayfaPanel.add(rapor.getContentPane());
        Anasayfa.anasayfaPanel.repaint();
        Anasayfa.anasayfaPanel.validate();
    }//GEN-LAST:event_raporlarMouseClicked

    private void kitapGuncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kitapGuncelleActionPerformed
        // TODO add your handling code here:
        Anasayfa.anasayfaPanel.removeAll();
        KitapGuncelle guncelle = new KitapGuncelle();
        Anasayfa.anasayfaPanel.add(guncelle.getContentPane());
        Anasayfa.anasayfaPanel.repaint();
        Anasayfa.anasayfaPanel.validate();
    }//GEN-LAST:event_kitapGuncelleActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenu anasayfa;
    public javax.swing.JMenu cikis;
    public javax.swing.JMenuItem kitapEkle;
    public javax.swing.JMenuItem kitapGuncelle;
    public javax.swing.JMenu kitaplar;
    public javax.swing.JMenuItem kitaplarSayfasi;
    public javax.swing.JMenuBar menu;
    public javax.swing.JMenu personel;
    public javax.swing.JMenu raporlar;
    public javax.swing.JMenu uye;
    // End of variables declaration//GEN-END:variables
}

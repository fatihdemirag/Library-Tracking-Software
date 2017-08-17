//developer~fxd

package kutuphaneotomasyonu.siniflar;

import java.sql.Date;

public class Kitap {
    
    private String adi;
    private Date basimYili;
    private int stok_miktari;
    
    /**
     * @return the adi
     */
    public String getAdi() {
        return adi;
    }

    /**
     * @param adi the adi to set
     */
    public void setAdi(String adi) {
        this.adi = adi;
    }

    /**
     * @return the basimYili
     */
    public Date getBasimYili() {
        return basimYili;
    }

    /**
     * @param basimYili the basimYili to set
     */
    public void setBasimYili(Date basimYili) {
        this.basimYili = basimYili;
    }

 
    /**
     * @return the stok_miktari
     */
    public int getStok_miktari() {
        return stok_miktari;
    }

    /**
     * @param stok_miktari the stok_miktari to set
     */
    public void setStok_miktari(int stok_miktari) {
        this.stok_miktari = stok_miktari;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kutuphaneotomasyonu.siniflar;

/**
 *
 * @author fxd
 */
public class Personel {
    private String adi;
    private String soyadi;
    private int personelNo;
    private String personeSifre;

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
     * @return the soyadi
     */
    public String getSoyadi() {
        return soyadi;
    }

    /**
     * @param soyadi the soyadi to set
     */
    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    /**
     * @return the personelNo
     */
    public int getPersonelNo() {
        return personelNo;
    }

    /**
     * @param personelNo the personelNo to set
     */
    public void setPersonelNo(int personelNo) {
        this.personelNo = personelNo;
    }

    /**
     * @return the personeSifre
     */
    public String getPersoneSifre() {
        return personeSifre;
    }

    /**
     * @param personeSifre the personeSifre to set
     */
    public void setPersoneSifre(String personeSifre) {
        this.personeSifre = personeSifre;
    }
}

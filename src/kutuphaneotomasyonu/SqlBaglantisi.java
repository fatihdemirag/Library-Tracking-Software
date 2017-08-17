/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kutuphaneotomasyonu;

//developer fatihdemirag/fxd

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class SqlBaglantisi {
    private String dbUrl="jdbc:mysql://localhost:3306/kutuphane?useUnicode=&characterEncoding=utf-8";
    private String dbKullanici="root";
    private String dbSifre="root";

    //Veritabanı bağlantısı açmamıza yarar.
    public static Connection con;
    //Result set sorgudan dönen sonuçları içerir.
    public static ResultSet rs;
    //Prs sql sorguları çalıştırmamıza yarar.
    public static PreparedStatement prs;
    
    //<editor-fold defaultstate="collapsed" desc=" Getter-Setter ">

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getdbKullanici() {
        return dbKullanici;
    }

    public void setdbKullanici(String dbKullanici) {
        this.dbKullanici = dbKullanici;
    }

    public String getdbSifre() {
        return dbSifre;
    }

    public void setdbSifre(String dbSifre) {
        this.dbSifre = dbSifre;
    }
    // </editor-fold>
    
    public void Baglan(String dbUrl,String dbKullanici,String dbSifre) throws SQLException
    {
        try {
            //JDBC = Java Database Connection
            con=(com.mysql.jdbc.Connection)DriverManager.getConnection(dbUrl,dbKullanici,dbSifre);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Veritabanı Bağlantısında Hata Oluştu");
            con.close();
        }
    }
}

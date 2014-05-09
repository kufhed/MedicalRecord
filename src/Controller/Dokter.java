/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Modul.DataBase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author ROOT_AKAR
 */
public class Dokter {
    private String id;
    private String nama;
    private String pass;
    private String keahlian;
    private String jenisKelamin;
    
    public Dokter(){}
    public Dokter(String id, String nama, String pass, String keahlian, String jenisKelamin)
    {
        this.id=id;
        this.nama=nama;
        this.pass=pass;
        this.keahlian=keahlian;
        this.jenisKelamin=jenisKelamin;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the keahlian
     */
    public String getKeahlian() {
        return keahlian;
    }

    /**
     * @param keahlian the keahlian to set
     */
    public void setKeahlian(String keahlian) {
        this.keahlian = keahlian;
    }
    
    public String getQuote(String masuk)
    {
        return "'"+masuk+"'";
    }
    
    public boolean loginDokter(String id, String pass)
    {
        boolean hasil=false;
        DataBase db=new DataBase();
        ResultSet rs=null;
        String query="Select idDokter, passDokter from dokter where idDokter="+getQuote(id)+" and passDokter="+getQuote(pass)+" ;";
        rs=db.getData(query);
        if(rs!=null)
        {
            hasil=true;
        }
        return hasil;
    }
    public String getIdTabPenyakit(String idPasien) throws SQLException
    {
        DataBase db=new DataBase();
        String query="Select count(id) from penyakit where id LIKE '%"+idPasien+"%' ;";
        ResultSet rs=db.getData(query);
        int a=0;
        while(rs.next())
        {
            a=rs.getInt(1);
        }
        return "tp"+idPasien+Integer.toString(a);
    }
    public boolean saveDataPenyakitPasien(Penyakit p, String id, String nama)
    {
        boolean hasil=false;
        DataBase db=new DataBase();
        String idPenyakit=null;
        ResultSet rs=null;
        System.out.println("Penyakit: "+p.getNamaPenyakit());
        String query="Select idPenyakit from jenisPenyakit where namaPenyakit="+getQuote(p.getNamaPenyakit())+";";
        System.out.println(query);
        rs=db.getData(query);
        try{
        while(rs.next())
        {
            idPenyakit=rs.getString(1);
            System.out.println(idPenyakit);
            query = "insert into penyakit values("+ getQuote(getIdTabPenyakit(id)) +","+getQuote(id)+" , "+getQuote(idPenyakit)+" , "+getQuote(p.getTanggal())+" , "+getQuote(this.id)+" , "+getQuote(p.getStatus())+" , "+getQuote(p.getKeterangan())+");";
            db.query(query);
            hasil=true;
            System.out.println(query);
        }
        }catch(SQLException e)
        {
            //JOptionPane.showMessageDialog(null, e.getStackTrace());
        }
        return hasil;
    }
    public void saveDataPasien(Pasien pas)
    {
        DataBase db=new DataBase();
        String query = "insert into pasien values("+getQuote(pas.getId())+" , "+getQuote(pas.getPass())+" , "+getQuote(pas.getNama())+" , "+getQuote(pas.getAlamat())+ " , "+getQuote(pas.getJenisKelamin())+");";
        System.out.println(query);
        db.query(query);
    }

    /**
     * @return the jenisKelamin
     */
    public String getJenisKelamin() {
        return jenisKelamin;
    }

    /**
     * @param jenisKelamin the jenisKelamin to set
     */
    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }
    public void setResetDokter()
    {
        this.setId(null);
        this.setJenisKelamin(null);
        this.setNama(null);
        this.setKeahlian(null);
        this.setPass(null);
    }
    public String getNamaById(String id) throws SQLException
    {
        DataBase db=new DataBase();
        String query="Select nama from dokter where idDokter='"+id+"';";
        ResultSet rs=db.getData(query);
        query=null;
        while(rs.next())
        {
            query=rs.getString(1);
        }
        return query;
    }
}

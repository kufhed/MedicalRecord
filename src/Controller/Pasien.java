/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Modul.DataBase;
import View.Frame;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ROOT_AKAR
 */
public class Pasien {
    private String id;
    private String nama;
    private String pass;
    private Penyakit penyakit[];
    private String alamat;
    private String jenisKelamin;
    int nPenyakit;
    
    public Pasien(String id, String nama, String pass,  String alamat, String jenisKelamin)
    {
        this.id=id;
        this.nama=nama;
        this.pass=pass;
        this.alamat=alamat;
        this.jenisKelamin=jenisKelamin;
        this.penyakit=new Penyakit[250];
        this.nPenyakit=0;
    }
    public Pasien()
    {
        this.penyakit=new Penyakit[250];
        this.nPenyakit=0;
    };

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
     * @return the penyakit
     */
    public Penyakit[] getPenyakit() {
        return penyakit;
    }

    /**
     * @param penyakit the penyakit to set
     */
    public void setPenyakit(String idPenyakit, String penyakit, String keterangan, String status, String tanggal, String dokter) {
        this.penyakit[nPenyakit].setIdPenyakit(idPenyakit);
        this.penyakit[nPenyakit].setKeterangan(keterangan);
        this.penyakit[nPenyakit].setNamaPenyakit(penyakit);
        this.penyakit[nPenyakit].setStatus(status);
        this.penyakit[nPenyakit].setTanggal(tanggal);
        this.penyakit[nPenyakit].setDokter(dokter);
        nPenyakit++;
        
    }

    /**
     * @return the alamat
     */
    public String getAlamat() {
        return alamat;
    }

    /**
     * @param alamat the alamat to set
     */
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public String getQuote(String masuk)
    {
        return "'"+masuk+"'";
    }
    public void viewPenyakit()
    {
        DataBase db=new DataBase();
        String query="Select * from penyakit where idPasien="+getQuote(this.id)+");";
        ResultSet rs=null;
        rs=db.getData(query);
    }
    public boolean login(String id, String pass) throws SQLException
    {
        DataBase db=new DataBase();
        String query="Select * from pasien where idPasien="+getQuote(id)+" And passPasien="+getQuote(pass) +";";
        ResultSet rs=null;
        rs=db.getData(query);
        boolean hasil=false;
        
        if(rs!=null)
        {
            while(rs.next())
            {
                this.id=rs.getString(1);
                this.nama=rs.getString(2);
                hasil=true;  
            }         
        }
        return hasil;
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
    
    public void setResetPasien()
    {
        this.setAlamat(null);
        this.setId(null);
        this.setJenisKelamin(null);
        this.setNama(null);
        this.setPass(null);
        
    }
   
    public ResultSet viewMedRec()
    {
        DataBase db=new DataBase();
        String query="select * from penyakit where idPasien='"+this.id+"';";
        ResultSet rs=null;
        return rs=db.getData(query);
        
    }
    
    public ResultSet getPasien(String id)
    {
        DataBase db=new DataBase();
        String query="select * from pasien where idPasien='"+this.id+"';";
        ResultSet rs=null;
        return rs=db.getData(query);
    }
    public ResultSet getPasienByNama(String nama)
    {
        DataBase db=new DataBase();
        String query="SELECT * FROM pasien WHERE UPPER( nama ) LIKE UPPER(  '%"+nama+"%' );"; 
        ResultSet rs=null;
        return rs=db.getData(query);
    }
}

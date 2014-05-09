/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Modul.DataBase;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ROOT_AKAR
 */
public class Penyakit {
    private String idPenyakit;
    private String namaPenyakit;
    private String keterangan;
    private String tanggal;
    private String status;
    private String dokter;
    public Penyakit(String idPenyakit, String namaPenyakit, String keterangan, String tanggal, String status, String dokter)
    {
        this.idPenyakit=idPenyakit;
        this.namaPenyakit=namaPenyakit;
        this.keterangan=keterangan;
        this.tanggal=tanggal;
        this.status=status;
        this.dokter=dokter;
    }
    public Penyakit(){}

    /**
     * @return the idPenyakit
     */
    public String getIdPenyakit() {
        return idPenyakit;
    }

    /**
     * @param idPenyakit the idPenyakit to set
     */
    public void setIdPenyakit(String idPenyakit) {
        this.idPenyakit = idPenyakit;
    }

    /**
     * @return the namaPenyakit
     */
    public String getNamaPenyakit() {
        return namaPenyakit;
    }

    /**
     * @param namaPenyakit the namaPenyakit to set
     */
    public void setNamaPenyakit(String namaPenyakit) {
        this.namaPenyakit = namaPenyakit;
    }

    /**
     * @return the keterangan
     */
    public String getKeterangan() {
        return keterangan;
    }

    /**
     * @param keterangan the keterangan to set
     */
    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    /**
     * @return the tanggal
     */
    public String getTanggal() {
        return tanggal;
    }

    /**
     * @param tanggal the tanggal to set
     */
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    public ResultSet getPenyakitNama(String nama)
    {
        DataBase db=new DataBase();
        ResultSet rs=null;
        String query="Select * from penyakit where id LIKE '%"+nama+"%';";
        return rs=db.getData(query);
    }
    
    public ResultSet getPenyakit(String id)
    {
        DataBase db=new DataBase();
        ResultSet rs=null;
        String query="Select * from penyakit where id='"+id+"';";
        return rs=db.getData(query);
    }
    
    public String getPenyakitById(String id) throws SQLException
    {
        DataBase db=new DataBase();
        ResultSet rs=null;
        String query="Select * from jenispenyakit where idPenyakit='"+id+"';";
        rs=db.getData(query);
        query=null;
        while(rs.next())
        {
           query=rs.getString(2);
        }
        return query;
    }

    /**
     * @return the dokter
     */
    public String getDokter() {
        return dokter;
    }

    /**
     * @param dokter the dokter to set
     */
    public void setDokter(String dokter) {
        this.dokter = dokter;
    }
}

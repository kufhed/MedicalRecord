/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Modul.DataBase;
import java.sql.ResultSet;

/**
 *
 * @author ROOT_AKAR
 */
public class Admin {
    private String id;
    private String pass;
    
    public Admin(){}
    public Admin(String id, String pass)
    {
        this.id=id;
        this.pass=pass;
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
    
    
    public boolean loginAdmin(String username, String pass)
    {
        DataBase db=new DataBase();
        String query="Select * from admin where userAdmin='"+username+"' AND passAdmin='"+pass+"';";
        ResultSet rs=null;
        rs=db.getData(query);
        boolean hasil=false;
        if(rs!=null)
        {
            hasil=true;
        }
        return hasil;
    }
    public boolean saveDokter(Dokter d)
    {
        DataBase db=new DataBase();
        boolean hasil=false;
        String query="insert into dokter values('"+d.getId()+"','"+d.getPass()+"','"+d.getNama()+"','"+d.getKeahlian()+"','"+d.getJenisKelamin()+"');";
        try
        {
           db.query(query);
           hasil=true;
           
        }catch(Exception e)
        {
            hasil=false;
        }
        return hasil;
    }
    
}

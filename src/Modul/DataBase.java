/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modul;

/**
 *
 * @author hardwarelab
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hardwarelab
 */
public class DataBase {
    private Statement stmt=null;
    private Connection kon=null;
    private ResultSet rs=null;
    
    public DataBase()
    {
        try
        {
            kon=DriverManager.getConnection("jdbc:mysql://localhost/medicalrecord", "root", "");
            stmt=kon.createStatement();
            System.out.println("Berhasil");
        }catch(SQLException e)
        {
             javax.swing.JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
    }
    public ResultSet getData(String SQLString)
    {
        try
        {
            rs=stmt.executeQuery(SQLString);
            
        }catch(SQLException e)
        {
            javax.swing.JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
        return rs;
    }
    public void query(String SqlString)
    {
        try
        {
            stmt.executeUpdate(SqlString);
        }catch(Exception e)
        {
             javax.swing.JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
    }

   
}
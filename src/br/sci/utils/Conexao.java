/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.sci.utils;

import java.sql.*;
import javax.swing.JOptionPane;
import java.util.ResourceBundle;
import java.util.MissingResourceException;

public class Conexao {	
    private static Conexao conexao = null;
    private Connection conn;
		
    private Conexao() {	
        try  {
            ResourceBundle prop = ResourceBundle.getBundle("br.sci.utils.bdPostGreSQL");

            String driver = prop.getString("driver");				
            String bd = prop.getString("bd");
            String usuario = prop.getString("usuario");
            String senha = prop.getString("senha");

            Class.forName(driver); 
            conn = DriverManager.getConnection(bd,usuario,senha);
        } catch (SQLException | ClassNotFoundException | MissingResourceException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }                
    }

    public static Connection getConnection() {	
        if (conexao == null) {	
            conexao = new Conexao();
        }
        
        return conexao.conn;		
    }

    public void close() {
        try {	
            conn.close();
        } catch(SQLException e) { 
            
        }
    }		
}

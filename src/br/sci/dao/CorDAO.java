package br.sci.dao;

import java.sql.*;
import java.util.List;
import br.sci.model.Cor;
import java.util.ArrayList;
import br.sci.utils.Conexao;
import javax.swing.JOptionPane;


/**
 * Sistema para Concessionária Integrado 1.0
 * VeiculoDAO.java
 * Função: Controlar fluxo de informações da tabela Cor no banco de dados.
 * 
 * @version A0.1
 * @since 2018-03-25
 * @author GabrielRuneScape
 */
public class CorDAO {    
    /**
     * Lista e captura todos os valores existentes da tabela Cor.
     * 
     * @return ArrayList com todos objetos Cor.
     */
    public List<Cor> getAll() {
        List<Cor> cor = new ArrayList<>();
        
        try {
            Connection db = Conexao.getConnection();
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Cor ORDER BY Nome");
            
            while (rs.next()) {
                if (rs.getString("Hex").isEmpty()) {
                    cor.add(new Cor(rs.getInt("ID"), rs.getString("Nome")));
                } else {
                    cor.add(new Cor(rs.getInt("ID"), rs.getString("Nome"), rs.getString("Hex")));
                }
            }
            
            rs.close();
            st.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Erro ao listar as Cores", JOptionPane.ERROR_MESSAGE);
        }
        
        return cor;
    }
    
    /**
     * Obtém através de uma Cor com um código específico.
     * 
     * @param id Código da Cor.
     * @return Cor com tal código.
     */
    public Cor getCor(int id) {
        Cor cor = null;
        
        try {
            Connection db = Conexao.getConnection();
            PreparedStatement st = db.prepareStatement("SELECT * FROM Cor WHERE ID = ?");
        
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                if (rs.getString("Hex").isEmpty()) {
                    cor = new Cor(rs.getInt("ID"), rs.getString("Nome"));
                } else {
                    cor = new Cor(rs.getInt("ID"), rs.getString("Nome"), rs.getString("Hex"));
                } 
            }
            
            rs.close();
            st.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Erro ao listar cores", JOptionPane.ERROR_MESSAGE);
        } 
        
        return cor;
    }
}

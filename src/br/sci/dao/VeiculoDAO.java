package br.sci.dao;

import java.sql.*;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import br.sci.model.Veiculo;
import br.sci.utils.Conexao;
import br.sci.utils.ExcecaoSCA;
import javax.swing.JOptionPane;

/**
 * Sistema para Concessionária Integrado 1.0
 * VeiculoDAO.java
 * Função: Controlar fluxo de informações da tabela Veiculo no banco de dados.
 * 
 * @version 1.0
 * @since 2018-03-25
 * @author GabrielRuneScape
 */
public class VeiculoDAO {    
    /**
     * Lista e captura todos os valores existentes da tabela Veiculo.
     * 
     * @return ArrayList com todos objetos Veiculo.
     */
    public List<Veiculo> getAll() {
        List<Veiculo> veiculo = new ArrayList<>();
        
        try {
            Connection db = Conexao.getConnection();
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Veiculo ORDER BY ID");
            
            while (rs.next()) {
                Veiculo v = new Veiculo();
                
                v.setID(rs.getInt("ID"));
                v.setChassi(rs.getString("Chassi"));
                v.setModelo(rs.getString("Modelo"));
                v.setAnoModelo(rs.getInt("AnoModelo"));
                v.setDataCadastro(rs.getDate("DataCadastro").toLocalDate());
                v.setAnoFabricacao(rs.getInt("AnoFabricacao"));
                v.setCor(new CorDAO().getCor(rs.getInt("Cor")));
                
                veiculo.add(v);
            }
            
            rs.close();
            st.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Erro ao listar as veiculos", JOptionPane.ERROR_MESSAGE);
        }
        
        return veiculo;
    }
    
    /**
     * Obtém através de um código um Veiculo específico.
     * 
     * @param id Código do Veiculo.
     * @return Veiculo com tal código.
     */
    public Veiculo getVeiculo(int id) {
        Veiculo v = new Veiculo();
        
        try {
            Connection db = Conexao.getConnection();
            PreparedStatement st = db.prepareStatement("SELECT * FROM Veiculo WHERE ID = ?");
        
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                v.setID(rs.getInt("ID"));
                v.setChassi(rs.getString("Chassi"));
                v.setModelo(rs.getString("Modelo"));
                v.setAnoModelo(rs.getInt("AnoModelo"));
                v.setDataCadastro(rs.getDate("DataCadastro"));
                v.setAnoFabricacao(rs.getInt("AnoFabricacao"));
                v.setCor(new CorDAO().getCor(rs.getInt("Cor")));
            }
            
            rs.close();
            st.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Erro ao listar veiculos", JOptionPane.ERROR_MESSAGE);
        } 
        
        return v;
    }
    
    /**
     * Obtém através de um código um Veiculo específico.
     * 
     * @param v Objeto Veiculo.
     * @return Veiculo com tal código.
     */
    public Veiculo getVeiculo(Veiculo v) {
        try {
            Connection db = Conexao.getConnection();
            PreparedStatement st = db.prepareStatement("SELECT * FROM Veiculo WHERE ID = ?");
        
            st.setInt(1, v.getID());
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                v.setID(rs.getInt("ID"));
                v.setChassi(rs.getString("Chassi"));
                v.setModelo(rs.getString("Modelo"));
                v.setAnoModelo(rs.getInt("AnoModelo"));
                v.setDataCadastro(rs.getDate("DataCadastro"));
                v.setAnoFabricacao(rs.getInt("AnoFabricacao"));
                v.setCor(new CorDAO().getCor(rs.getInt("Cor")));
            }
            
            rs.close();
            st.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Erro ao listar veiculos", JOptionPane.ERROR_MESSAGE);
        } 
        
        return v;
    }
    
    /**
     * Obtém através de um código um Veiculo específico.
     * 
     * @param column a ser usada ocmo filtro.
     * @param value Valor a ser procurado.
     * @return Veiculos com tais propriedades.
     */
    public List<Veiculo> getVeiculos(int column, String value) {
        List<Veiculo> veiculo = new ArrayList<>();
        
        try {
            ResultSet rs;
            Connection db = Conexao.getConnection();
            Statement st = db.createStatement();
            
            if (column == 0) {
                rs = st.executeQuery("SELECT * FROM Veiculo WHERE CAST(ID AS TEXT) LIKE \'%" + value + "%\' ORDER BY ID");
            } else {
                rs = st.executeQuery("SELECT * FROM Veiculo WHERE Modelo ~* \'" + value + "\' ORDER BY Modelo");
            }
            
            while (rs.next()) {
                Veiculo v = new Veiculo();
                
                v.setID(rs.getInt("ID"));
                v.setChassi(rs.getString("Chassi"));
                v.setModelo(rs.getString("Modelo"));
                v.setAnoModelo(rs.getInt("AnoModelo"));
                v.setDataCadastro(rs.getDate("DataCadastro").toLocalDate());
                v.setAnoFabricacao(rs.getInt("AnoFabricacao"));
                v.setCor(new CorDAO().getCor(rs.getInt("Cor")));
                
                veiculo.add(v);
            }
            
            rs.close();
            st.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Erro ao listar as veiculos", JOptionPane.ERROR_MESSAGE);
        }
        
        return veiculo;
    }
    
    /**
     * Insere um Veiculo no banco de dados.
     * @param veiculo Valores a serem criados um novo objeto.
     * @throws ExcecaoSCA mensagem de erro caso algo dê errado.
     */
    public void insert(Veiculo veiculo) throws ExcecaoSCA {
        try {        
            Connection db = Conexao.getConnection();
            PreparedStatement st = db.prepareStatement("INSERT INTO Veiculo (Chassi, Modelo, Cor, AnoFabricacao, AnoModelo, DataCadastro) VALUES (?, ?, ?, ?, ?, ?)");
         
            st.setString(1, veiculo.getChassi());
            st.setString(2, veiculo.getModelo());
            st.setInt(3, veiculo.getCor().getID());
            st.setInt(4, veiculo.getAnoFabricacao());
            st.setInt(5, veiculo.getAnoModelo());
            st.setDate(6, Date.valueOf(LocalDate.now()));
            
            st.executeUpdate();
            st.close();
        } catch (SQLException ex) {     
            if (ex.getSQLState().equals("23505")) {
                throw new ExcecaoSCA("Veiculo duplicado duplicado.");
            } else {
                throw new ExcecaoSCA("Erro na inclusão do veículo. Código " + ex.getSQLState() + "\nDescrição " + ex.getMessage());
            }
        }

    }
    
    /**
     * Altera um Veiculo existente no banco de dados.
     * @param veiculo Propriedades a serem substituídas.
     * @throws ExcecaoSCA Mensagem de erro caso algo dê errado.
     */
    public void update(Veiculo veiculo) throws ExcecaoSCA {
        try {
            Connection db = Conexao.getConnection();
            PreparedStatement st = db.prepareStatement("UPDATE Veiculo SET Chassi = ?, Modelo = ?, Cor = ?, AnoFabricacao = ?, AnoModelo = ? WHERE ID = ?");
            
            st.setString(1, veiculo.getChassi());
            st.setString(2, veiculo.getModelo());
            st.setInt(3, veiculo.getCor().getID());
            st.setInt(4, veiculo.getAnoFabricacao());
            st.setInt(5, veiculo.getAnoModelo());
            st.setInt(6, veiculo.getID());
            
            st.executeUpdate();
            st.close();
        } catch (SQLException ex) {
            throw new ExcecaoSCA("Erro na alteração do veiculo.  Código " + ex.getSQLState() + "\nDescrição " + ex.getMessage());
        }
    }
    
    /**
     * Exclui um Veiculo do banco de dados.
     * @param veiculo Veiculo a ser excluído.
     * @throws ExcecaoSCA Mensagem de erro caso algo dê errado.
     */
    public void delete(Veiculo veiculo) throws ExcecaoSCA {
        try {
            Connection db = Conexao.getConnection();
            PreparedStatement st = db.prepareStatement("DELETE FROM Veiculo WHERE ID = ? ");
            st.setInt(1, veiculo.getID());
            
            st.executeUpdate();
            st.close();
        } catch (SQLException ex) {
           if (ex.getSQLState().equals("23503")) {
                throw new ExcecaoSCA("Veiculo dependente de outra relação.");
            }   else{    
                   throw new ExcecaoSCA("Erro na exclusão do veiculo. Código " + ex.getSQLState() + "\nDescrição " + ex.getMessage());
            }
        }
    }
}

package br.sci.controller;

import br.sci.dao.*;
import java.util.List;
import java.util.ArrayList;
import br.sci.model.Veiculo;
import br.sci.utils.ExcecaoSCA;

/**
 * Sistema para Concessionária Integrado 1.0
 * CtrCadastroVeiculo.java
 * Função: Camada Controladora do objeto Veiculo
 * 
 * @version 1.0
 * @since 2018-03-26
 * @author GabrielRuneScape
 */
public class CtrCadastroVeiculo {
    private VeiculoDAO dao;
    private static CtrCadastroVeiculo umCtrCadastroVeiculo;
    
    /**
     * Construtor padrão iniciando a conexão com banco de dados.
     */
    private CtrCadastroVeiculo(){
        dao = new VeiculoDAO();
    }
    
    /**
     * Cria uma instância do objecto com conexão com o banco de dados.
     * @return Controlador instânciado.
     */
    public static CtrCadastroVeiculo getInstance(){
        if (umCtrCadastroVeiculo == null){
            umCtrCadastroVeiculo = new CtrCadastroVeiculo();
        }
        
        return umCtrCadastroVeiculo;
    }    
    
    /**
     * Obtém lista de todos os Veiculos.
     * @return Veiculos registrados no banco de dados.
     * @throws ExcecaoSCA Mensagem de erro caso algo dê errado.
     */
    public List <Veiculo> listarTodos() throws ExcecaoSCA{
        List <Veiculo>lista = new ArrayList<Veiculo>();        
        lista = dao.getAll();
        
        return lista;
    }
    
    /**
     * Obtém alguns Veiculos cujo encontram-se no filtro.
     * @param column Coluna o qual será realizado o filtro.
     * @param value Valor a ser procurado.
     * @return Veiculos encontrados.
     * @throws ExcecaoSCA mensagem de erro caso algo dê errado.
     */
    public List<Veiculo> listarVeiculos(int column, String value) throws ExcecaoSCA {
        List<Veiculo> lista = new ArrayList<Veiculo>();        
        lista = dao.getVeiculos(column, value);
        
        return lista;
    }
    
    /**
     * Valida através da camada controladora possíveis erros de usuário.
     * @param veiculo Veiculo a ser validado.
     * @return Verdadeiro caso tudo estiver safo.
     * @throws ExcecaoSCA Mensagem de erro caso algo dê errado.
     */
    private boolean validar(Veiculo veiculo) throws ExcecaoSCA {        
        if ((veiculo.getAnoFabricacao() - veiculo.getAnoModelo()) > 1 || (veiculo.getAnoFabricacao() - veiculo.getAnoFabricacao()) < -1) {
            throw new ExcecaoSCA("O ano de fabricação e do modelo diferem em mais de um ano.");
        }     
        if ((veiculo.getAnoModelo() - veiculo.getAnoFabricacao()) > 1 || (veiculo.getAnoModelo() - veiculo.getAnoFabricacao()) < -1) {
            throw new ExcecaoSCA("O ano do modelo e de fabricante diferem em mais de um ano.");
        }
        if (veiculo.getChassi().isEmpty()) {
            throw new ExcecaoSCA("É necessário o número de série do chassi.");
        }
        if (veiculo.getModelo().isEmpty()) {
            throw new ExcecaoSCA("A descrição do modelo é obrigatória.");
        }
            
        return true ;
    }

    /**
     * Inclui um novo Veiculo no banco de dados.
     * @param veiculo Objeto a ser incluído.
     * @throws ExcecaoSCA Mensagem de erro caso algo dê errado.
     */
    public void incluir(Veiculo veiculo) throws ExcecaoSCA {
        try {
            if (validar(veiculo))
              dao.insert(veiculo);
        } catch (ExcecaoSCA ex)  {
            throw new ExcecaoSCA(ex.getMsg());
        }
    }
    
    /**
     * Altera um Veiculo já existente no banco de dados.
     * @param veiculo Objeto a ser alterado.
     * @throws ExcecaoSCA Mensagem de erro caso algo dê errado.
     */
    public void alterar(Veiculo veiculo) throws ExcecaoSCA {
        try {
            if (validar(veiculo))
                dao.update(veiculo);
        } catch (ExcecaoSCA ex)  {
            throw new ExcecaoSCA(ex.getMsg());
        }
    }

    /**
     * Exclui um registro do banco de dados.
     * @param veiculo Objeto a ser excluído.
     * @throws ExcecaoSCA Mensagem de erro caso algo dê errado.
     */
    public void apagar(Veiculo veiculo) throws ExcecaoSCA {
        dao.delete(veiculo);
        
    }

    /**
     * Obtém um Veiculo através do banco de dados.
     * @param veiculo Objeto a ser recebido.
     * @throws ExcecaoSCA Mensagem de erro caso algo dê errado.
     */
    public void carregar(Veiculo veiculo) throws ExcecaoSCA {
        dao.getVeiculo(veiculo);
    } 
}
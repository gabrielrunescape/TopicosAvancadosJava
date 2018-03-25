package br.sci.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Sistema para Concessionária Integrado 1.0
 * Cor.java
 * Função: Objeto Veiculo do banco de dados.
 * 
 * @version 1.0
 * @since 2018-03-25
 * @author GabrielRuneScape
 */
public class Veiculo {
    private int ID;
    private String chassi;
    private String modelo;
    private Cor cor;
    private int anoFabricacao;
    private int anoModelo;
    private LocalDate dataCadastro;

    /**
     * @return Código identificador do Veiculo.
     */
    public int getID() {
        return ID;
    }

    /**
     * Define código identificador para o Veiculo.
     * @param ID  Código identificador.
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return Número do Chassi.
     */
    public String getChassi() {
        return chassi;
    }

    /**
     * Define número de série do chassi.
     * @param chassi Número de série do Veiculo.
     */
    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    /**
     * @return Nome do modelo.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Define nome para o modelo para o Veiculo.
     * @param modelo Modelo do Veiculo.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return Cor do Veiculo.
     */
    public Cor getCor() {
        return cor;
    }

    /**
     * Define Cor para Veiculo.
     * @param cor Cor do Veículo.
     */
    public void setCor(Cor cor) {
        this.cor = cor;
    }

    /**
     * @return Ano da Fabricação do Veiculo.
     */
    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    /**
     * Define ano de Fabricação do Veiculo.
     * @param anoFabricacao Fabricação do Veiculo.
     */
    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    /**
     * @return Ano do Modelo do Veiculo.
     */
    public int getAnoModelo() {
        return anoModelo;
    }

    /**
     * Define ano do Modelo do Veiculo.
     * @param anoModelo Ano de Modelo do Veiculo.
     */
    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }

    /**
     * @return Data de Cadastro do Veiculo.
     */
    public LocalDate getDataCadastro() {
        return dataCadastro;
    }
    
    /**
     * @return Data em formato ISO.
     */
    public String getDataCadastroString() {
        return dataCadastro.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    /**
     * Define data de cadastro do Veiculo.
     * @param dataCadastro Data.
     */
    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }    
}

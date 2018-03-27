package br.sci.model;

/**
 * Sistema para Concessionária Integrado 1.0
 * Cor.java
 * Função: Objeto Cor do banco de dados.
 * 
 * @version 1.0
 * @since 2018-03-25
 * @author GabrielRuneScape
 */
public class Cor {
    private int ID;
    private String hex;
    private String nome;
    
    /**
     * Define os paramêtros iniciais para Cor.
     * @param ID Código identificador.
     */
    public Cor(int ID) {
        this.ID = ID;
    }

    /**
     * Define paramêtros iniciais para Cor.
     * @param ID Código identificador.
     * @param nome Cor.
     */
    public Cor(int ID, String nome) {
        this.ID = ID;
        this.nome = nome;
    }
    
    /**
     * Define paramêtros iniciais para Cor.
     * @param ID Código identificador.
     * @param hex Código em hexadecimal.
     * @param nome Cor.
     */
    public Cor(int ID, String nome, String hex) {
        this.ID = ID;
        this.hex = hex;
        this.nome = nome;
    }
    
    /**
     * @return Código identificador da Cor.
     */
    public int getID() {
        return ID;
    }

    /**
     * Define código identificador para Cor.
     * @param ID Código identificador.
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return Código da Cor em hexadecimal.
     */
    public String getHex() {
        return hex;
    }

    /**
     * Define código em hexadecimal para Cor.
     * @param hex 
     */
    public void setHex(String hex) {
        this.hex = hex;
    }

    /**
     * @return Nome da Cor.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define nome para Cor.
     * @param nome Cor.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Advan
 */
public class ModelEndereco {

    private int id_ende;
    private String endereco;
    private String numero;
    private String bairro;
    private String complemento;
    private String cidade;
    private String uf;
    private String cep;
    private int cliente_id_cliente;
    
    
    /**
     * @return the id_ende
     */
    public int getId_ende() {
        return id_ende;
    }

    /**
     * @param id_ende the id_ende to set
     */
    public void setId_ende(int id_ende) {
        this.id_ende = id_ende;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the uf
     */
    public String getUf() {
        return uf;
    }

    /**
     * @param uf the uf to set
     */
    public void setUf(String uf) {
        this.uf = uf;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the cliente_id_cliente
     */
    public int getCliente_id_cliente() {
        return cliente_id_cliente;
    }

    /**
     * @param cliente_id_cliente the cliente_id_cliente to set
     */
    public void setCliente_id_cliente(int cliente_id_cliente) {
        this.cliente_id_cliente = cliente_id_cliente;
    }
   
    
}

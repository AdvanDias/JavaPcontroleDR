/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author 
 */
public class ModelConta {
    
    private int id_conta;
    private String conta;
    private String agencia;
    private String nomeconta;
    private int cliente_id_cliente;

    /**
     * @return the id_conta
     */
    public int getId_conta() {
        return id_conta;
    }

    /**
     * @param id_conta the id_conta to set
     */
    public void setId_conta(int id_conta) {
        this.id_conta = id_conta;
    }

    /**
     * @return the conta
     */
    public String getConta() {
        return conta;
    }

    /**
     * @param conta the conta to set
     */
    public void setConta(String conta) {
        this.conta = conta;
    }

    /**
     * @return the agencia
     */
    public String getAgencia() {
        return agencia;
    }

    /**
     * @param agencia the agencia to set
     */
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    /**
     * @return the nome
     */
    public String getNomeconta() {
        return nomeconta;
    }

    /**
     * @param nomeconta the nome to set
     */
    public void setNomeconta(String nomeconta) {
        this.nomeconta = nomeconta;
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

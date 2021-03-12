/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Advan
 */
public class ModelCliente {

   

  
    private int id;
    private String nome;
    private String cpf;
    private String cnpj;
    private String status_cli;
    private Date data_cadastro;
    private Date data_alteracao;
    private String sexo;
    private String inscricao_estadual;
    private String classe_cli;
    private String razao_social;
    private String nome_fantasia;
    private String telefone;
    private String email;

    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the inscricao_estadual
     */
    public String getInscricao_estadual() {
        return inscricao_estadual;
    }

    /**
     * @param inscricao_estadual the inscricao_estadual to set
     */
    public void setInscricao_estadual(String inscricao_estadual) {
        this.inscricao_estadual = inscricao_estadual;
    }

    /**
     * @return the classe_cli
     */
    public String getClasse_cli() {
        return classe_cli;
    }

    /**
     * @param classe_cli the classe_cli to set
     */
    public void setclasse_cli(String classe_cli) {
        this.classe_cli = classe_cli;
    }

    /**
     * @return the razao_social
     */
    public String getRazao_social() {
        return razao_social;
    }

    /**
     * @param razao_social the razao_social to set
     */
    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    /**
     * @return the nome_fantasia
     */
    public String getNome_fantasia() {
        return nome_fantasia;
    }

    /**
     * @param nome_fantasia the nome_fantasia to set
     */
    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the status_cli
     */
    public String getStatus_cli() {
        return status_cli;
    }

    /**
     * @param status_cli the status_cli to set
     */
    public void setStatus_cli(String status_cli) {
        this.status_cli = status_cli;
    }

    /**
     * @return the data_cadastro
     */
    public Date getData_cadastro() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
        return data_cadastro;
    }

    /**
     * @param data_cadastro the data_cadastro to set
     */
    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }
    
     /**
     * @return the data_alteracao
     */
    public Date getData_alteracao() {
        return data_alteracao;
    }

    /**
     * @param data_alteracao the data_alteracao to set
     */
    public void setData_alteracao(Date data_alteracao) {
        this.data_alteracao = data_alteracao;
    }

   
}

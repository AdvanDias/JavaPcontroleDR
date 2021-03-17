/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ModelConta;
import util.ConexaoDb;

/**
 *
 * @author Advan
 */
public class DAOConta extends ConexaoDb {
    
    
     /**
     * SALVAR ENDERECO NO BANCO
     * @param pModelEndereco
     * @return 
     */
    public boolean SalvarConta(ModelConta pModelConta){
    conectar();
    String sql = "INSERT INTO CONTA (ID_CONTA, CONTA, AGENCIA, NOME, CLIENTE_ID_CLIENTE, TIPO, DATA_MOVI, VALOR) "
            + "VALUES (SEQ_CONTA.nextval,?,?,?,?,?,?,?)";
    PreparedStatement preparedStatement = criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
        try {
            preparedStatement.setString(1, pModelConta.getConta());
            preparedStatement.setString(2, pModelConta.getAgencia());
            preparedStatement.setString(3, pModelConta.getNomeconta());
            preparedStatement.setInt(4, pModelConta.getCliente_id_cliente());
            preparedStatement.setString(5, pModelConta.getTipo());
            preparedStatement.setString(6, pModelConta.getData());
            preparedStatement.setFloat(7, pModelConta.getValor());
                 
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOConta.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    desconectar(); 
    return true;
    }
    
    
    
    
    public ModelConta getContaDAO(int pIdConta){
            ModelConta modelConta = new ModelConta();
             conectar();
             ResultSet resultSet = null;
             PreparedStatement preparedStatement = null;
             
             String sql = "SELECT "
                     + "ID_CONTA, "
                     + "CONTA, "
                     + "AGENCIA, "
                     + "NOME, "
                     + "CLIENTE_ID_CLIENTE "
                     + "FROM CONTA "
                     + "WHERE ID_CONTA = '"+pIdConta+"'";
             
             preparedStatement = criarPreparedStatement(sql);
             
         try {
             resultSet = preparedStatement.executeQuery();
             
             while(resultSet.next()){
                modelConta = new ModelConta();
                modelConta.setId_conta(resultSet.getInt("ID_CONTA"));
                modelConta.setConta(resultSet.getString("CONTA"));
                modelConta.setAgencia(resultSet.getString("AGENCIA"));
                modelConta.setNomeconta(resultSet.getString("NOME"));
                modelConta.setCliente_id_cliente(resultSet.getInt("CLIENTE_ID_CLIENTE"));
              
              
             }
         } catch (SQLException ex) {
             Logger.getLogger(DAOConta.class.getName()).log(Level.SEVERE, null, ex);
         }catch (Exception e) {
             System.out.println(e);
         }
         desconectar();
         return modelConta;
     }
    
    
    
    
    
    
     /**
     * LISTAR DADOS NA TELA
     * @return 
     */
     public List<ModelConta> getListContaDAO(){
        List<ModelConta> listaConta = new ArrayList<>();
        ModelConta modelConta = new ModelConta();
        conectar();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        
        String sql = "SELECT ID_CONTA, CONTA, AGENCIA, NOME, CLIENTE_ID_CLIENTE FROM CONTA";
        
        try{
            preparedStatement = criarPreparedStatement(sql);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                modelConta = new ModelConta();
                modelConta.setId_conta(resultSet.getInt("ID_CONTA"));
                modelConta.setConta(resultSet.getString("CONTA"));
                modelConta.setAgencia(resultSet.getString("AGENCIA"));
                modelConta.setNomeconta(resultSet.getString("NOME"));
                modelConta.setCliente_id_cliente(resultSet.getInt("CLIENTE_ID_CLIENTE"));

                listaConta.add(modelConta);

            }
        }catch(Exception e){
            System.out.println(e);
        }
        desconectar();
         return listaConta;
     }
    
    
     
      /**
      * Atualizar cliente
      * @param pmodelCliente
      * @return 
      */
    public boolean atualizarEndereco(ModelConta pmodelConta) {
      
         conectar();
         PreparedStatement preparedStatement;
         String sql = "UPDATE CONTA SET "
                 + "CONTA =?,"
                 + "AGENCIA =?,"
                 + "NOME =?,"
                 + "CLIENTE_ID_CLIENTE =? "
                 + "WHERE ID_CONTA = '"+pmodelConta.getId_conta()+"'";
         preparedStatement = this.criarPreparedStatement(sql);
         try {
             preparedStatement.setString(1, pmodelConta.getConta());
             preparedStatement.setString(2, pmodelConta.getAgencia());
             preparedStatement.setString(3, pmodelConta.getNomeconta());
             preparedStatement.setInt(4, pmodelConta.getCliente_id_cliente());
             


             preparedStatement.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(DAOConta.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
             return false;
         }finally{
             if(preparedStatement != null){
                 try {
                     preparedStatement.close();
                 } catch (SQLException ex) {
                     ex.printStackTrace();
                     Logger.getLogger(DAOConta.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
         }
         this.desconectar();
        return true;
    }
    
    
    
     /**
      * Excluir endereço pelo codigo
      * @param pCodigo
      * @return 
      */
     public boolean excluirContaDAO(int pCodigo){
         conectar();
         PreparedStatement preparedStatement;
         String sql = "DELETE FROM CONTA WHERE ID_CONTA = '"+pCodigo+"'";
         preparedStatement = this.criarPreparedStatement(sql);
         try {
             preparedStatement.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(DAOConta.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
             return false;
         }finally{
             if(preparedStatement != null){
                 try {
                     preparedStatement.close();
                 } catch (SQLException ex) {
                     ex.printStackTrace();
                     Logger.getLogger(DAOConta.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
         }
         this.desconectar();
        return true;
     }
    
    
}

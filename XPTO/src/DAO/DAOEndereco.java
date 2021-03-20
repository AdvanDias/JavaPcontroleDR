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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ModelEndereco;
import util.ConexaoDb;

/**
 *
 * @author Advan
 */
public class DAOEndereco extends ConexaoDb {
    
    /**
     * SALVAR ENDERECO NO BANCO
     * @param pModelEndereco
     * @return 
     */
    public boolean SalvarEndereco(ModelEndereco pModelEndereco){
    conectar();
    String sql = "INSERT INTO ENDERECO (ID_ENDERECO, ENDERECO, NUMERO, BAIRRO, COMPLEMENTO, CIDADE, UF, CEP, CLIENTE_ID_CLIENTE) "
            + "VALUES (SEQ_ENDERECO.nextval,?,?,?,?,?,?,?,?)";
    PreparedStatement preparedStatement = criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
        try {
            preparedStatement.setString(1, pModelEndereco.getEndereco());
            preparedStatement.setString(2, pModelEndereco.getNumero());
            preparedStatement.setString(3, pModelEndereco.getBairro());
            preparedStatement.setString(4, pModelEndereco.getComplemento());
            preparedStatement.setString(5, pModelEndereco.getCidade());
            preparedStatement.setString(6, pModelEndereco.getUf());
            preparedStatement.setString(7, pModelEndereco.getCep());
            preparedStatement.setInt(8, pModelEndereco.getCliente_id_cliente());
            
            
            
           
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOEndereco.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    desconectar(); 
    return true;
    }
     
    /**
     * LISTAR DADOS NA TELA
     * @return 
     */
     public List<ModelEndereco> getListEnderecoDAO(){
        List<ModelEndereco> listaEndereco = new ArrayList<>();
        ModelEndereco modelEndereco = new ModelEndereco();
        conectar();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        
        String sql = "SELECT ID_ENDERECO, ENDERECO, NUMERO, BAIRRO, COMPLEMENTO, CIDADE, UF, CEP, CLIENTE_ID_CLIENTE FROM ENDERECO";
        
        try{
            preparedStatement = criarPreparedStatement(sql);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                modelEndereco = new ModelEndereco();
                modelEndereco.setId_ende(resultSet.getInt(1));
                modelEndereco.setEndereco(resultSet.getString(2));
                modelEndereco.setNumero(resultSet.getString(3));
                modelEndereco.setBairro(resultSet.getString(4));
                modelEndereco.setComplemento(resultSet.getString(5));
                modelEndereco.setCidade(resultSet.getString(6));
                modelEndereco.setUf(resultSet.getString(7));
                modelEndereco.setCep(resultSet.getString(8));
                modelEndereco.setCliente_id_cliente(resultSet.getInt(9));
        
                listaEndereco.add(modelEndereco);

            }
        }catch(Exception e){
            System.out.println(e);
        }
        desconectar();
         return listaEndereco;
     }
     
     /**
      * Excluir endereço pelo codigo
      * @param pCodigo
      * @return 
      */
     public boolean excluirEnderecoDAO(int pCodigo){
         conectar();
         PreparedStatement preparedStatement;
         String sql = "DELETE FROM ENDERECO WHERE ID_ENDERECO = '"+pCodigo+"'";
         preparedStatement = this.criarPreparedStatement(sql);
         try {
             preparedStatement.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(DAOEndereco.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
             return false;
         }finally{
             if(preparedStatement != null){
                 try {
                     preparedStatement.close();
                 } catch (SQLException ex) {
                     ex.printStackTrace();
                     Logger.getLogger(DAOEndereco.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
         }
         this.desconectar();
        return true;
     }
     
     
    
     
     public ModelEndereco getEnderecoDAO(int pIdEndere){
            ModelEndereco modelEndereco = new ModelEndereco();
             conectar();
             ResultSet resultSet = null;
             PreparedStatement preparedStatement = null;
             
             String sql = "SELECT "
                     + "ID_ENDERECO, "
                     + "ENDERECO, "
                     + "NUMERO, "
                     + "BAIRRO, "
                     + "COMPLEMENTO, "
                     + "CIDADE, "
                     + "UF, "
                     + "CEP, "
                     + "CLIENTE_ID_CLIENTE "
                     + "FROM ENDERECO WHERE ID_ENDERECO = '"+pIdEndere+"'";
             
             preparedStatement = criarPreparedStatement(sql);
             
         try {
             resultSet = preparedStatement.executeQuery();
             
             while(resultSet.next()){
                modelEndereco = new ModelEndereco();
                modelEndereco.setId_ende(resultSet.getInt("ID_ENDERECO"));
                modelEndereco.setEndereco(resultSet.getString("ENDERECO"));
                modelEndereco.setNumero(resultSet.getString("NUMERO"));
                modelEndereco.setBairro(resultSet.getString("BAIRRO"));
                modelEndereco.setComplemento(resultSet.getString("COMPLEMENTO"));
                modelEndereco.setCidade(resultSet.getString("CIDADE"));
                modelEndereco.setUf(resultSet.getString("UF"));
                modelEndereco.setCep(resultSet.getString("CEP"));
                modelEndereco.setCliente_id_cliente(resultSet.getInt("CLIENTE_ID_CLIENTE"));
              
             }
         } catch (SQLException ex) {
             Logger.getLogger(DAOEndereco.class.getName()).log(Level.SEVERE, null, ex);
         }catch (Exception e) {
             System.out.println(e);
         }
         desconectar();
         return modelEndereco;
     }

     /**
      * Atualizar cliente
      * @param pmodelCliente
      * @return 
      */
    public boolean atualizarEndereco(ModelEndereco pmodelEndereco) {
      
         conectar();
         PreparedStatement preparedStatement;
         String sql = "UPDATE ENDERECO SET "
                 + "ENDERECO =?,"
                 + "NUMERO =?,"
                 + "BAIRRO =?,"
                 + "COMPLEMENTO =?,"
                 + "CIDADE =?,"
                 + "UF =?,"
                 + "CEP =? "
                 + "WHERE ID_ENDERECO = '"+pmodelEndereco.getId_ende()+"'";
         preparedStatement = this.criarPreparedStatement(sql);
         try {
             preparedStatement.setString(1, pmodelEndereco.getEndereco());
             preparedStatement.setString(2, pmodelEndereco.getNumero());
             preparedStatement.setString(3, pmodelEndereco.getBairro());
             preparedStatement.setString(4, pmodelEndereco.getComplemento());
             preparedStatement.setString(5, pmodelEndereco.getCidade());
             preparedStatement.setString(6, pmodelEndereco.getUf());
             preparedStatement.setString(7, pmodelEndereco.getCep());
           

             preparedStatement.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(DAOEndereco.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
             return false;
         }finally{
             if(preparedStatement != null){
                 try {
                     preparedStatement.close();
                 } catch (SQLException ex) {
                     ex.printStackTrace();
                     Logger.getLogger(DAOEndereco.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
         }
         this.desconectar();
        return true;
    }
    
    
    
}

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
import model.ModelCliente;
import util.ConexaoDb;

/**
 *
 * @author Advan
 */
public class DAOCliente extends ConexaoDb{
    public boolean SalvarCliente(ModelCliente pModelCliente){
    conectar();
    String sql = "INSERT INTO CLIENTE "
            + "(ID_CLIENTE, "
            + "NOME, "
            + "CPF, "
            + "CNPJ, "
            + "SEXO, "
            + "INSCRICAO_ESTADUAL, "
            + "CLASSE, "
            + "RAZAO_SOCIAL, "
            + "NOME_FANTASIA, "
            + "TELEFONE, "
            + "EMAIL, "
            + "CAPITAL)"
            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    PreparedStatement preparedStatement = criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
        try {
            preparedStatement.setInt(1, pModelCliente.getId());
            preparedStatement.setString(2, pModelCliente.getNome());
            preparedStatement.setString(3, pModelCliente.getCpf());
            preparedStatement.setString(4, pModelCliente.getCnpj());
            preparedStatement.setString(5, pModelCliente.getSexo());
            preparedStatement.setString(6, pModelCliente.getInscricao_estadual());
            preparedStatement.setString(7, pModelCliente.getClasse_cli());
            preparedStatement.setString(8, pModelCliente.getRazao_social());
            preparedStatement.setString(9, pModelCliente.getNome_fantasia());
            preparedStatement.setString(10, pModelCliente.getTelefone());
            preparedStatement.setString(11, pModelCliente.getEmail());
            preparedStatement.setFloat(12, pModelCliente.getCapital());
            
           
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    desconectar(); 
    return true;
    }
     
     public List<ModelCliente> getListClienteDAO(){
        List<ModelCliente> listaCliente = new ArrayList<>();
        ModelCliente modelCliente = new ModelCliente();
        conectar();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        
        String sql = "SELECT ID_CLIENTE, "
                + "NOME, "
                + "CPF, "
                + "CNPJ, "
                + "STATUS_CLIENTE, "
                + "DATA_CADASTRO, "
                + "SEXO, "
                + "INSCRICAO_ESTADUAL, "
                + "CLASSE, "
                + "RAZAO_SOCIAL, "
                + "NOME_FANTASIA, "
                + "TELEFONE, "
                + "EMAIL, "
                + "CAPITAL "
                + "FROM CLIENTE";
        
        try{
            preparedStatement = criarPreparedStatement(sql);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                modelCliente = new ModelCliente();
                modelCliente.setId(resultSet.getInt(1));
                modelCliente.setNome(resultSet.getString(2));
                modelCliente.setCpf(resultSet.getString(3));
                modelCliente.setCnpj(resultSet.getString(4));
                modelCliente.setStatus_cli(resultSet.getString(5));
                modelCliente.setData_cadastro(resultSet.getDate(6));
                modelCliente.setSexo(resultSet.getString(7));
                modelCliente.setInscricao_estadual(resultSet.getString(8));
                modelCliente.setclasse_cli(resultSet.getString(9));
                modelCliente.setRazao_social(resultSet.getString(10));
                modelCliente.setNome_fantasia(resultSet.getString(11));
                modelCliente.setTelefone(resultSet.getString(12));
                modelCliente.setEmail(resultSet.getString(13));
                modelCliente.setCapital(resultSet.getFloat(14));
                listaCliente.add(modelCliente);
                

            }
        }catch(Exception e){
            System.out.println(e);
        }
        desconectar();
         return listaCliente;
     }
     
     /**
      * Excluir um cliente pelo codigo
      * @param pCodigo
      * @return 
      */
     public boolean excluirClienteDAO(int pCodigo){
         conectar();
         PreparedStatement preparedStatement;
         String sql = "DELETE FROM CLIENTE WHERE ID_CLIENTE = '"+pCodigo+"'";
         preparedStatement = this.criarPreparedStatement(sql);
         try {
             preparedStatement.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
             return false;
         }finally{
             if(preparedStatement != null){
                 try {
                     preparedStatement.close();
                 } catch (SQLException ex) {
                     ex.printStackTrace();
                     Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
         }
         this.desconectar();
        return true;
     }
     
     
     public int retornaCodigoDAO( int recebe){
        conectar();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        
        String sql = "SELECT SEQ_CLIENTE.nextval FROM DUAL";
        
        try{
            preparedStatement = criarPreparedStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                recebe = resultSet.getInt(1);
            }else{
                System.out.println("NENHUM REGISTRO ENCONTRADO");
            }
            
            
        }catch(Exception e){
            System.out.println(e);
        }
        desconectar();
         return recebe;
     }
     
     public ModelCliente getClienteDAO(int pIdCliente){
            ModelCliente modelCliente = new ModelCliente();
             conectar();
             ResultSet resultSet = null;
             PreparedStatement preparedStatement = null;
             
             String sql = "SELECT ID_CLIENTE, "
                     + "NOME, "
                     + "CPF, "
                     + "CNPJ, "
                     + "STATUS_CLIENTE, "
                     + "DATA_ALTERACAO, "
                     + "SEXO, "
                     + "INSCRICAO_ESTADUAL, "
                     + "CLASSE, "
                     + "RAZAO_SOCIAL, "
                     + "NOME_FANTASIA, "
                     + "TELEFONE, "
                     + "EMAIL, "
                     + "CAPITAL "
                     + "FROM CLIENTE WHERE ID_CLIENTE = '"+pIdCliente+"'";
             
             preparedStatement = criarPreparedStatement(sql);
             
         try {
             resultSet = preparedStatement.executeQuery();
             
             while(resultSet.next()){
                modelCliente = new ModelCliente();
                modelCliente.setId(resultSet.getInt("ID_CLIENTE"));
                modelCliente.setNome(resultSet.getString("NOME"));
                modelCliente.setCpf(resultSet.getString("CPF"));
                modelCliente.setCnpj(resultSet.getString("CNPJ"));
                modelCliente.setStatus_cli(resultSet.getString("STATUS_CLIENTE"));
                modelCliente.setData_alteracao(resultSet.getDate("DATA_ALTERACAO"));
                modelCliente.setSexo(resultSet.getString("SEXO"));
                modelCliente.setInscricao_estadual(resultSet.getString("INSCRICAO_ESTADUAL"));
                modelCliente.setclasse_cli(resultSet.getString("CLASSE"));
                modelCliente.setRazao_social(resultSet.getString("RAZAO_SOCIAL"));
                modelCliente.setNome_fantasia(resultSet.getString("NOME_FANTASIA"));
                modelCliente.setTelefone(resultSet.getString("TELEFONE"));
                modelCliente.setEmail(resultSet.getString("EMAIL"));
                modelCliente.setCapital(resultSet.getFloat("CAPITAL"));
               
                 
             }
         } catch (SQLException ex) {
             Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
         }catch (Exception e) {
             System.out.println(e);
         }
         desconectar();
         return modelCliente;
     }

     /**
      * Atualizar cliente
      * @param pmodelCliente
      * @return 
      */
    public boolean atualizarCliente(ModelCliente pmodelCliente) {
      
         conectar();
         PreparedStatement preparedStatement;
         String sql = "UPDATE CLIENTE SET "
                 + "NOME =?,"
                 + "CPF =?,"
                 + "CNPJ =?,"
                 + "SEXO =?,"
                 + "INSCRICAO_ESTADUAL =?,"
                 + "CLASSE =?,"
                 + "RAZAO_SOCIAL =?,"
                 + "NOME_FANTASIA =?,"
                 + "TELEFONE =?,"
                 + "EMAIL =?, "
                 + "CAPITAL=? "
                 + "WHERE ID_CLIENTE = '"+pmodelCliente.getId()+"'";
         preparedStatement = this.criarPreparedStatement(sql);
         try {
             preparedStatement.setString(1, pmodelCliente.getNome());
             preparedStatement.setString(2, pmodelCliente.getCpf());
             preparedStatement.setString(3, pmodelCliente.getCnpj());
             preparedStatement.setString(4, pmodelCliente.getSexo());
             preparedStatement.setString(5, pmodelCliente.getInscricao_estadual());
             preparedStatement.setString(6, pmodelCliente.getClasse_cli());
             preparedStatement.setString(7, pmodelCliente.getRazao_social());
             preparedStatement.setString(8, pmodelCliente.getNome_fantasia());
             preparedStatement.setString(9, pmodelCliente.getTelefone());
             preparedStatement.setString(10, pmodelCliente.getEmail());
             preparedStatement.setFloat(11, pmodelCliente.getCapital());
             
            
             preparedStatement.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
             return false;
         }finally{
             if(preparedStatement != null){
                 try {
                     preparedStatement.close();
                 } catch (SQLException ex) {
                     ex.printStackTrace();
                     Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
         }
         this.desconectar();
        return true;
    }
     
}

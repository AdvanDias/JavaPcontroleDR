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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ModelCliente;
import model.ModelIntegracao;
import util.ConexaoDb;

/**
 *
 * @author Advan
 */
public class DAOIntegracao extends ConexaoDb{
    
     public boolean SalvarIntegracao(ModelIntegracao pModelIntegracao){
    conectar();
    String sql = "INSERT INTO INTEGRACAO ("
            + "ID_INTEGRACAO,"
            + "NOME_CLIENTE,"
            + "NOME_CONTA, "
            + "TIPO, "
            + "VALOR, "
            + "DATA_MOVI, "
            + "AG, "
            + "CONTA) "
            + "VALUES (SEQ_INTEGRACAO.nextval,?,?,?,?,?,?,?)";
    PreparedStatement preparedStatement = criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
        try {
            preparedStatement.setString(1, pModelIntegracao.getNome_clinte());
            preparedStatement.setString(2, pModelIntegracao.getNome_conta());
            preparedStatement.setString(3, pModelIntegracao.getTipo());
            preparedStatement.setFloat(4, pModelIntegracao.getValor());
            preparedStatement.setString(5, pModelIntegracao.getData_movi());
            preparedStatement.setString(6, pModelIntegracao.getAg());
            preparedStatement.setString(7, pModelIntegracao.getConta());

            
           
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOIntegracao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    desconectar(); 
    return true;
    }
     
     
     
      public boolean validaStatusIntegracao(){
        conectar();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        
        String sql = "SELECT STA_INTE FROM INTEGRACAO WHERE STA_INTE = 'E' AND "
                + "id_integracao = (select MAX(id_integracao) from integracao)";
        
        try{
            preparedStatement = criarPreparedStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                System.out.println("CLIENTE NÃO CADASTRADO");
                return false;
            }else{
                System.out.println("ESTATUS OK");
            }
            
            
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
        desconectar();
         return true;
     }
    
}

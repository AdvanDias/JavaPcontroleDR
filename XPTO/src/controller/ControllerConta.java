/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOConta;
import java.util.List;
import model.ModelConta;

/**
 *
 * @author Advan
 */
public class ControllerConta {

    DAOConta dAOConta = new DAOConta();
    
    public boolean salvarContaController(ModelConta modelConta) {
        return this.dAOConta.SalvarConta(modelConta);
    }

    public ModelConta getContaController(int idConta) {
        return this.dAOConta.getContaDAO(idConta);
    }

    public boolean atualizarContaController(ModelConta modelConta) {
        return this.dAOConta.atualizarEndereco(modelConta);
    }

    public boolean excluirContaController(int codigo) {
        return this.dAOConta.excluirContaDAO(codigo);
    }

    public List<ModelConta> getListaContaController() {
       return this.dAOConta.getListContaDAO();
    }
    
}

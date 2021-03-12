/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOEndereco;
import java.util.List;
import model.ModelEndereco;

/**
 *
 * @author Advan
 */
public class ControllerEndereco {
    
    DAOEndereco dAOEndereco = new DAOEndereco();

    public boolean salvarEnderecoController(ModelEndereco modelEndereco) {
        return this.dAOEndereco.SalvarEndereco(modelEndereco);
    }

    public List<ModelEndereco> getListaEnderecoController() {
        return this.dAOEndereco.getListEnderecoDAO();
    }

    public boolean excluirEnderecoController(int pcodigo) {
       return this.dAOEndereco.excluirEnderecoDAO(pcodigo);
    }

    public ModelEndereco getEnderecoController(int pidEndere) {
        return this.dAOEndereco.getEnderecoDAO(pidEndere);
    }

    public boolean atualizarEnderecoController(ModelEndereco modelEndereco) {
        return this.dAOEndereco.atualizarEndereco(modelEndereco);
    }
    
    
}

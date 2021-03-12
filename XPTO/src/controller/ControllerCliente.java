/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOCliente;
import java.util.List;
import model.ModelCliente;

/**
 *
 * @author Advan
 */
public class ControllerCliente {
    
    DAOCliente dAOCliente = new DAOCliente();

    /*
    
    */
    public boolean salvarUsuarioController(ModelCliente modelCliente) {
       return this.dAOCliente.SalvarCliente(modelCliente);
    }

    public List<ModelCliente> getListaClienteController() {
       return this.dAOCliente.getListClienteDAO();
    }

    public boolean excluirClienteController(int pcodigo) {
       return this.dAOCliente.excluirClienteDAO(pcodigo);
    }

    public int carregaCodigoController(int pi) {
        return this.dAOCliente.retornaCodigoDAO(pi);
    }

    public ModelCliente getClienteController(int pidCliente) {
        return this.dAOCliente.getClienteDAO(pidCliente);
    }

    public boolean atualizarUsuarioController(ModelCliente modelCliente) {
      return this.dAOCliente.atualizarCliente(modelCliente);
    }
    
}

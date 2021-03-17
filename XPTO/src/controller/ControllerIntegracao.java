/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOIntegracao;
import model.ModelIntegracao;

/**
 *
 * @author Advan
 */
public class ControllerIntegracao {
    
    DAOIntegracao dAOIntegracao = new DAOIntegracao();

    public boolean salvarIntegracaoController(ModelIntegracao modelIntegracao) {
        return this.dAOIntegracao.SalvarIntegracao(modelIntegracao);
    }

    public boolean validaStatusController() {
        return this.dAOIntegracao.validaStatusIntegracao();
    }
    
    
}

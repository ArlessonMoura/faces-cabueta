/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers;

import br.edu.ifpe.recife.model.dao.ManagerDao;
import br.edu.ifpe.recife.model.entities.MetodoFila;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author jeron
 */

@ManagedBean(name = "metController")
@SessionScoped
public class MetodoFilaController {
    
    private MetodoFila cadastro;
    private MetodoFila selecionado;
    
    @PostConstruct
    public void init(){
        this.cadastro = new MetodoFila();
    }
    
    public String cadastrar(){
        ManagerDao.getCurrentInstance().insert(this.cadastro);
                
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Método de fila cadastrado com sucesso!"));
      
        this.cadastro = new MetodoFila();
        
        return "apresentametodofila.xhtml";
    }
    
    public List<MetodoFila> resgatar(){
        
        String query = "select m from MetodoFila m";
        
        return ManagerDao.getCurrentInstance().read(query, MetodoFila.class);
    }
    
    public String editar(){
        
        ManagerDao.getCurrentInstance().update(this.getSelecionado());
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O método de fila foi editado com sucesso!"));
        
        return "apresentametodofila.xhtml";
    }
    
    public void excluir(){
    
        ManagerDao.getCurrentInstance().delete(this.selecionado);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O método de fila foi excluído com sucesso!"));
    }
    
    public void resetarCamposCadastro(){

        init();
    }
    
    public MetodoFila getCadastro() {
        return cadastro;
    }

    /**
     * @param cadastro the metodofila to set
     */
    public void setCadastro(MetodoFila cadastro) {
        this.cadastro = cadastro;
    }

    /**
     * @return the selecionado
     */
    public MetodoFila getSelecionado() {
        return selecionado;
    }

    /**
     * @param selecionado the selecionado to set
     */
    public void setSelecionado(MetodoFila selecionado) {
        this.selecionado = selecionado;
    }
    
}

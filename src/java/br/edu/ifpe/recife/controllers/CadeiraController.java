/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers;

import br.edu.ifpe.recife.model.dao.ManagerDao;
import br.edu.ifpe.recife.model.entities.Cadeira;
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

@ManagedBean(name = "cadController")
@SessionScoped
public class CadeiraController {

    
    private Cadeira cadastro;
    private Cadeira selecionada;
    
    @PostConstruct
    public void init(){
        this.cadastro = new Cadeira();
    }
    
    public String cadastrar(){
        ManagerDao.getCurrentInstance().insert(this.cadastro);
                
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadeira " + this.cadastro.getNome() +" cadastrado com sucesso!"));
      
        this.cadastro = new Cadeira();
        
        return "cadastrocadeira.xhtml";
    }
    
    public List<Cadeira> resgatar(){
        
        String query = "select c from Cadeira c";
        
        return ManagerDao.getCurrentInstance().read(query, Cadeira.class);
    }
    
    public String editar(){
        
        ManagerDao.getCurrentInstance().update(this.getSelecionada());
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("A cadeira foi editada com sucesso!"));
        
        return "apresentacadeira.xhtml";
    }
    
    public void excluir(){
    
        ManagerDao.getCurrentInstance().delete(this.getSelecionada());
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("A cadeira foi excluída com sucesso!"));
    }
    
    public void resetarCamposCadastro(){

        init();
    }
    
    public Cadeira getCadastro() {
        return cadastro;
    }

    /**
     * @param cadastro the cadeira to set
     */
    public void setCadastro(Cadeira cadastro) {
        this.cadastro = cadastro;
    }

    /**
     * @return the selecionada
     */
    public Cadeira getSelecionada() {
        return selecionada;
    }

    /**
     * @param selecionada the selecionada to set
     */
    public void setSelecionada(Cadeira selecionada) {
        this.selecionada = selecionada;
    }
    
}

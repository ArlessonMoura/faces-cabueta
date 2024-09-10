/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers;

import br.edu.ifpe.recife.model.dao.ManagerDao;
import br.edu.ifpe.recife.model.entities.Cadeira;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="cControllerBF")
@ViewScoped
public class CadeiraControllerBF {
    private Cadeira cadastro;
    private Cadeira selecionado;
    
    public CadeiraControllerBF(){
        this.cadastro = new Cadeira();
        this.selecionado = new Cadeira();
    }
    
    public List<Cadeira> readAll(){
        return ManagerDao.getCurrentInstance().read("SELECT c FROM Cadeira C", Cadeira.class);
    }
    
    public void insert(){
        
        ManagerDao.getCurrentInstance().insert(this.getCadastro());
        
        this.setCadastro(new Cadeira());
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("A cadeira foi cadastrada!"));
    }
    
    public void update(){
        
        ManagerDao.getCurrentInstance().update(this.getSelecionado());
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Os dados da cadeira foram alterados!"));
    }
    
    public void delete(){
        
        ManagerDao.getCurrentInstance().delete(this.getSelecionado());
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("A cadeira foi excluída!"));
    }

    /**
     * @return the cadastro
     */
    public Cadeira getCadastro() {
        return cadastro;
    }

    /**
     * @param cadastro the cadastro to set
     */
    public void setCadastro(Cadeira cadastro) {
        this.cadastro = cadastro;
    }

    /**
     * @return the selecionado
     */
    public Cadeira getSelecionado() {
        return selecionado;
    }

    /**
     * @param selecionado the selecionado to set
     */
    public void setSelecionado(Cadeira selecionado) {
        this.selecionado = selecionado;
    }
}
